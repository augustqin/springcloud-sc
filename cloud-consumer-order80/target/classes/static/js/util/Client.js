'use strict';

var loginPage = document.querySelector('#loginPage');  
var chatPage = document.querySelector('#chatPage');   
var usernameForm = document.querySelector('#usernameForm'); 
var messageArea = document.querySelector('#messageArea');  
var url = "http://192.168.0.106:3000";        // 服务器网址 
var transPrivate = document.querySelector('#transPrivate');
var roomInput = document.querySelector('#roomid');
var otherInput = document.querySelector('#otherid');
var roomMember = document.querySelector('#roomMember');

var stompClient = null;
var userid = null;
var password = null;
var flag = true;     //true: group chat;   false: private chat
var roomid = null;

usernameForm.addEventListener('submit', connect, true);
transPrivate.addEventListener('click',setprivate,true);

function setprivate(){
	console.log("laila=============");
	transPrivate.classList.add('hidden');
	roomInput.classList.add('hidden');
	otherInput.classList.remove('hidden');
	flag = false;
}

function connect(event) {
    userid = document.querySelector('#name').value.trim(); 
    password = document.querySelector('#password').value.trim();
    if(flag == true)  roomid = roomInput.value.trim();
    else             roomid = otherInput.value.trim();
    if(userid.length <5){
    	usernameForm.reset();
    }
    else{
        var socket = new SockJS('/ws');   //绑定服务器配置的endpoint断点
        stompClient = Stomp.over(socket);  //创建Stomp客户端
        stompClient.connect({userid:userid,password:password,roomid:roomid}, onConnected, onError);  
    
        event.preventDefault();  //通知web浏览器不要执行与事件关联的默认操作（如果有的话）
    }
}

// 连接成功，查看服务端返回的信息
function onConnected(payloa) {
	console.log(payloa);
	var info = payloa.headers['user-name'];
	console.log(info);
	if(info==null){
		loginPage.classList.add('hidden');
	    chatPage.classList.remove('hidden');	   
	    document.querySelector("#text3").innerHTML = '消 息   （  连接到: ' + roomid + ' )' + '   我：' + userid; 
	    if(flag){
	       stompClient.subscribe('/topic/'+roomid, onMessageReceived);  //订阅消息 
	       stompClient.subscribe('/member/'+roomid, onMessageReceivedThree);  //订阅消息   连接成功时，服务器发送的群在线成员消息
	       stompClient.send('/app/add/'+roomid, {},JSON.stringify({sender:userid,type:'E'}));  
	    }
	    else{
	       stompClient.subscribe('/user/'+userid+'/'+roomid, onMessageReceived);  //订阅消息
	       stompClient.send('/app/invite/'+roomid, {},JSON.stringify({sender:userid,type:'I'})); 
	       stompClient.send('/app/user/'+userid+'/'+ roomid, {},JSON.stringify({sender:userid,type:'E'})); 
	       var a=document.createElement('li');
	       a.classList.add('pp');   a.innerHTML = '等待对方连接';
	       messageArea.appendChild(a);   
	    }
	    stompClient.subscribe('/invite/'+userid, onMessageReceivedTwo);  //订阅消息  	(接收他人的私聊请求）
	}
	else{
		stompClient.disconnect();
	  	usernameForm.reset();
	    //密码错误
	    if (info=='FP'){
		   alert('Wrong password');
	    }
	    else if(info == 'DC'){
		   alert("已在其他窗口打开该聊天");
	    }
	    else if(info == 'OD'){
		   alert('对方不在线，稍后再发起私聊。或对方id不存在，请查正');
	    }
	}
}

//连接失败，返回错误信息
function onError(error) {
	alert("404.Failed to connect to the server.")
}

function sendMessage(event) {
	var textInput = document.querySelector('#textInput');   
    var messageContent = textInput.value.trim();    //trim:去掉字符串首尾空格
    console.log(messageContent); 
   
    if(messageContent && stompClient) {
        var chatMessage = {
        	//mid:'',
        	//time:'',
            sender: userid,
            type: 'T',
            content: messageContent
        };
        if(flag) stompClient.send('/app/send/'+roomid, {}, JSON.stringify(chatMessage));
        else     stompClient.send('/app/user/'+userid+'/'+roomid, {}, JSON.stringify(chatMessage));
        textInput.value = '';
    }
}
function sendPicture(event){
	var files = document.querySelector("#pictureSubmit").files[0];
    var fileReader = new FileReader();
    fileReader.readAsDataURL(files);
    if (files.size > 1900 *1024){   //看WebSocketConfig里的缓存大小
    	alert("图片太大，无法上传");
    }
    else{
        fileReader.onload=function (e) {
            var  s = JSON.stringify({sender:userid,type:'P', content:e.target.result}) ;     
            if(flag)  stompClient.send('/app/send/'+roomid, {}, s);
            else      stompClient.send('/app/user/'+userid+'/'+roomid, {}, s);
        }
    }
}

function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);
    var sender = message.sender;
    var type = message.type;
    var a=document.createElement('li');
    if(type=='E'){  //有人加入
    	a.classList.add('pp');
    	a.innerHTML = sender + ' enter the chat . ';
    	if(sender != userid) {  
    		var l = document.createElement('li');
    		l.innerHTML = sender; 
    		l.id = sender;
    		roomMember.appendChild(l);
    	}
    }
    
    else if(type=='W'){  //撤回消息
        //var obj = document.getElementById(message.content);
    	var l = messageArea.childNodes;
    	for(var i=0;i < l.length;i++){
    		if (l[i].id == message.content){
    			l[i].parentNode.removeChild(l[i]);
    			a.classList.add('pp');
    	        a.innerHTML = sender + ' withdraws a message .';
    		}
    	}
    }
    else if(type=='L'){  //有成员离开
    	a.classList.add('pp');
    	a.innerHTML = sender + ' leaves the chat . ';
    	var l = document.querySelector('#roomMember').childNodes;
    	for(var i=0; i<l.length;i++){
    		if(l[i].id == sender){
    			l[i].parentNode.removeChild(l[i]);
    		}
    	}
    }
    else{   //图片、文本
    	a.id = message.mid;
    	if(sender==userid){ a.classList.add('my');}
    	else{   a.classList.add('other');  }
        var image=document.createElement('span');
        image.classList.add('image');
        image.innerHTML=sender.slice(0,2);

        var head=document.createElement('span');
        head.classList.add('head');
        head.innerHTML=sender + '     (' + message.time + ') ';

        if (type=='T'){   //文本
            var content=document.createElement('span');
            content.classList.add('content');
            content.innerHTML=message.content;
        }
        else if (type=='P'){   //图片
        	var content = document.createElement("img");
            content.src = message.content;
        }
        a.appendChild(image);
        a.appendChild(head);
        a.appendChild(content);
        //自己发的，可以撤回
        if(sender == userid){
        	var withdraw = document.createElement('button');
            withdraw.innerHTML = '撤回';
            withdraw.onclick = function() {
                var id = this.parentNode.id;
                if(flag) stompClient.send('/app/withdraw/'+roomid, {}, JSON.stringify({sender:userid, type:'W',content:id}));  
                else  stompClient.send('/app/user/'+userid+'/'+roomid, {}, JSON.stringify({sender:userid, type:'W',content:id})); 
            }
            a.appendChild(withdraw);
            setTimeout( function(){ withdraw.style.display = 'none'; } , 30000) ;     // 30s 内，可撤回消息
        }
    }
    messageArea.appendChild(a);   
    messageArea.scrollTop = messageArea.scrollHeight;  //自动滚动到底部
}

function onMessageReceivedTwo(payload){
	var message = JSON.parse(payload.body);
	var a = document.createElement('div');
	a.classList.add('inviteinfo');
	a.innerHTML = message.sender + '想与你私聊.打开新窗口进行私聊';
	var button = document.createElement('button');
	button.innerHTML = '确定';
	a.appendChild(button);
	document.body.appendChild(a);
	button.onclick = function(){
		a.classList.add('hidden');
		window.open(url);
	}
}
function onMessageReceivedThree(payload){
	var message = JSON.parse(payload.body);
    var sender = message.sender;
    var type = message.type;
    var a=document.createElement('li');
	if(type=='M' && sender==userid){   //服务器发送的在线成员消息
    	var groupmembers = message.content.split(' ');
    	for (var i=0;i<groupmembers.length;i++){
    		var l = document.createElement('li');
    		l.innerHTML = groupmembers[i]; 
            l.id = groupmembers[i];
    		roomMember.appendChild(l);
    	}
    }
}