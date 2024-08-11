package cc.niushuai.projects.misportchange.stepchange.controller;

import cc.niushuai.projects.misportchange.stepchange.bean.WxOpenData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }


    @GetMapping(produces = "text/plain;charset=utf-8")
    public String fromWxOpenData(WxOpenData wxOpenData){

        System.out.println("signature:"+wxOpenData.getSignature());
        System.out.println("nonce:"+wxOpenData.getNonce());
        System.out.println("timestamp:"+wxOpenData.getTimestamp());
        System.out.println("echostr:"+wxOpenData.getEchostr());

        Map<String, String> resMap = new HashMap<>();
        resMap.put("echostr", wxOpenData.getEchostr());
        return wxOpenData.getEchostr();
    }
}
