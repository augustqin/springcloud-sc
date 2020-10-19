package com.example.activityplatform.config.alipay;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.example.activityplatform.config.wxpay.WxConfig;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016102400748698";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCxC+TnWUQNXIB3uG5C6poAR5e/K9jriBGcgZxChtA4JVVNZN3t4/Qq+5kNCJB/5uIIz0k0+kYs7Ame2Mo+8YfQDNiV/4MChUOvoHriCbF1xbNgA84LfbcDP5mTBSXs6JkTSWzuAPV0PPw0LyJtwyn7s/Uxi48dhr+e7gOtALEMcs155jZYIrSNGLjClYVrkRwIvbGx8bBL5/c7XPQ3w8rFpTT246cKJ+ZRxf0+bgCa51IHEq2bQtZBfzzRt2TGU8UOb6ViN1ncrqg6atmMXmhsxvHmEDLDlvRqmXLEKYFeAhJO9K6KJQsSFHmNIRXcqPBIjwV8zdVuJnMPi/7vygTFAgMBAAECggEBAIe9rc/use1omZqwzeECS/ag7WiGLrdOyOnsuaiMAkK55PAEwN7uojr+UfcbNObLV0wX2XID3R/+DNY8MrwVpOJPpxNCJukc0atq6Cw78FJytLeN00EeLt4PuihtjwlXwF14M0s7cvWe+GLuLIBpXNv9uqU08hJaSLqKlEjlOdlnNpWBoqsCnTUmvXzBGz7Swx0h8P5r20FT0FrndXSaG+qL/QIwUSqStzjiOpXMhxG3azNrGnU1aR70thF0a98YNvnkO9mwWgsALB5LILmoS62OESLrFjhLL0l+B7Yt8M3MZw+Yr8fu0ppNw4X+MliMkSdAHZozLvHpaZsgS9LHJ9UCgYEA8i2fXze33Ge9z+p7gpV/3oB35i+0IVA7IZedJsEASf2yCdvgpYz2oFKfLI77AAicLu/QyOpAnLpBgs9YrdQV4+OFeZVf49sfStvDRgLsnKlqXmPd8fUXDmF5+ACS3BwB45KBCYSxh/yDesujYmdMna88N2dkWlMYQt0g1W52DbsCgYEAuyanxhIpHBTjjgVqx4muNRSdVW3Yu8QHbrSBz9uxy745banal4B2xeeLgxswZe6QQlKv4uLjRE/qzZFFvPSdj2Uh3n3YYm4Rkp5ZUx/Ai4iJummsejqCCmDzfqz/73ciN30zYGFs1chsdgMEXveQiTdo3H1+1SQcue2Jd2jtz38CgYEAsZSyoGeC8qM/lA4kswRc1xLs2GVyeFsUgPVjzt8HDzpwKrqIZ9yNm9H51fqiIswtel1vg2QCLOqGzxyrsgsqYgib/yOBRNuQfpvW/Kd4SQgRb1VbkeheF7VycmA5UB1ZZT4wUIJ0i3qmDoz0KVwF2jp8tUOjWnhD+gOb5+Uvu7ECgYAaiZ+usXKM3dVqlRAQHVDLjBHHRF1AOsrHAueJXuC2QFIKX9R0OS4eX/fjbl6NhaeFEA6KwJtzW1WzMo9N/O2+oJuN3hBp3Ku3O6b054K5BnJpMYTYjCVWbWr5onRkM2NxtNotJ4N0SQhAL6tWAArJukavRUhP1uAP6UPd384g5wKBgQDrCc+dESON46mzrPAQPQ8qXeVLrP2GgujUMCRqRxZYhdgeceeSZElRNq/0F35R8BNXEnZ4gI87/yk5gU/dcjAN9O6IjAcJFhYrDI3aWagXdtpePUTTVnRmcnzyUTWO9MRqnrDgkqHA0dYSIladu2yB5hPiC5wLednBlC2aDh+R+Q==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsQvk51lEDVyAd7huQuqaAEeXvyvY64gRnIGcQobQOCVVTWTd7eP0KvuZDQiQf+biCM9JNPpGLOwJntjKPvGH0AzYlf+DAoVDr6B64gmxdcWzYAPOC323Az+ZkwUl7OiZE0ls7gD1dDz8NC8ibcMp+7P1MYuPHYa/nu4DrQCxDHLNeeY2WCK0jRi4wpWFa5EcCL2xsfGwS+f3O1z0N8PKxaU09uOnCifmUcX9Pm4AmudSBxKtm0LWQX880bdkxlPFDm+lYjdZ3K6oOmrZjF5obMbx5hAyw5b0aplyxCmBXgISTvSuiiULEhR5jSEV3KjwSI8FfM3VbiZzD4v+78oExQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问

    public static String notify_url = WxConfig.DOM_URL + "/pages/front/pay/aliPayResYb";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = WxConfig.DOM_URL + "/pages/front/pay/aliPayResTb";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String server_url = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";
    // 支付宝网关
    public static String getAlipay_public_key = "C:\\";

    private static AlipayClient alipayClient;

    public static AlipayClient getAlipayClient() {
        if (alipayClient == null) {
            alipayClient = new DefaultAlipayClient(server_url, app_id,
                    merchant_private_key, "json", charset, alipay_public_key, "RSA2");
        }
        return alipayClient;
    }

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


