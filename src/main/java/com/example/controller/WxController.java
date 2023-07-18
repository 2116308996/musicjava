
package com.example.controller;

import ch.qos.logback.core.net.server.Client;
import cn.hutool.core.convert.ConvertException;
import cn.hutool.http.HttpException;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.common.lang.Result;
import com.example.entity.TextMessage;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@RestController
public class WxController extends BaseController{
    @GetMapping("/")
    public Result getwx(){
        System.out.println("getwx");
        return Result.succ("getwx");
    }
    @PostMapping("/")
    public Result postwx(HttpServletRequest request) throws IOException {
        ServletInputStream inputSteam=request.getInputStream();
        byte[] b=new byte[1024];
        int len=0;
        while((len=inputSteam.read(b))!=-1){
            System.out.println(new String(b,0,len));
        }
        System.out.println("postwx");
        return Result.succ("postwx");
    }
    @GetMapping("/check")
    public String handleWxCheckSignature ( HttpServletRequest request) throws Exception {
        System.out.println("===========>checkSign");
        //获取微信请求参数
        String signature = request.getParameter ("signature");
        String timestamp = request.getParameter ("timestamp");
        String nonce = request.getParameter ("nonce");
        String echostr = request.getParameter ("echostr");

        System.out.println("开始校验此次消息是否来自微信服务器，param->signature:{},timestamp:{},nonce:{},echostr:{}"+
                signature+timestamp+nonce+ echostr);

        boolean checkFlag = this.checkSignature(signature, timestamp, nonce);
        System.out.println("校验是否成功结果:{}"+checkFlag);

        if (checkFlag) {

           return echostr;
        }
        return "error";
    }

    @PostMapping("/check")
    public String receiveMessage(HttpServletRequest request) throws IOException, DocumentException {
        System.out.println("收到用户消息");
        ServletInputStream inputStream=request.getInputStream();
        /*byte[] b=new byte[1024];
        int len=0;
        while ((len=inputStream.read(b))!=-1){
            System.out.println(new String(b,0,len));
        }*/
        Map<String,String> map=new HashMap<>();
        SAXReader reader=new SAXReader();
        try{
            Document document=reader.read(inputStream);
            Element root=document.getRootElement();
            List<Element> elements=root.elements();
            for(Element element : elements){
                map.put(element.getName(),element.getStringValue());
            }
        }catch (DocumentException e){
            e.printStackTrace();
        }
        System.out.println(map);
        //回复消息
        System.out.println(map.get("MsgType"));
        if(map.get("MsgType").equals("event")){
            System.out.println("关注");
            String message= getReplyMessage(map,"感谢您的关注，我们现在可以聊天啦!");
            return message;
        }
        String message= getReplyMessage(map,map.get("Content"));
        System.out.println(message);
        return message;
    }

    public String getopenai(){

        return "";
    }


    private String getReplyMessage(Map<String,String> map,String string){
        TextMessage textMessage=new TextMessage();
        textMessage.setToUserName(map.get("FromUserName"));
        textMessage.setFromUserName(map.get("ToUserName"));
        //textMessage.setMsgType(map.get("MsgType"));
        textMessage.setMsgType("text");
        textMessage.setContent(string);
        textMessage.setCreateTime(System.currentTimeMillis()/1000);
        System.out.println(textMessage);
        //将java对象转换成xml字符串
        XStream xStream=new XStream();
        xStream.processAnnotations(TextMessage.class);
        String xml = xStream.toXML(textMessage);
        return xml;
    }

    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        String[] arr = {"zhuhui", timestamp, nonce};
        Arrays.sort(arr);
        StringBuilder stringBuilder = new StringBuilder();
        for (String param : arr) {
            stringBuilder.append(param);
        }

        String hexString = SHA1(stringBuilder.toString());
        return signature.equals(hexString);
    }

    private static String SHA1(String str) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(str.getBytes());
            return toHexString(digest);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("校验令牌Token出现错误：{}"+e.getMessage());
        }
        return "";
    }

    /**
     * 字节数组转化为十六进制
     *
     * @param digest 字节数组
     * @return String
     */
    private static String toHexString(byte[] digest) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : digest) {
            String shaHex = Integer.toHexString(b & 0xff);
            if (shaHex.length() < 2) {
                hexString.append(0);
            }
            hexString.append(shaHex);
        }
        return hexString.toString();
    }
}
