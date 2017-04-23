package com.chenqinhao.wechat.web;

import com.chenqinhao.core.util.SignUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/4/24.
 */
@Controller
public class WechatController {

    @RequestMapping(value = "security", method = RequestMethod.GET)
    @ResponseBody
    public boolean doGet(String signature, String timestamp, String nonce) {
        return SignUtils.checkSignature(signature, timestamp, nonce);
    }

    @RequestMapping(value = "security", method = RequestMethod.POST)
    @ResponseBody
    public String doPost() {
        return "OK";
    }

}
