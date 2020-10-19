package com.example.activityplatform.pojo.entity.chat;
import java.security.Principal;
/*暂时没啥用的*/

public class FastPrincipal implements Principal {
	private final String name;

    public FastPrincipal(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
