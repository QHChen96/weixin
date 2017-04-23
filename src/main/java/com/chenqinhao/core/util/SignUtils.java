package com.chenqinhao.core.util;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/4/24.
 */
@Component
public class SignUtils {
    @Value("${wechat.security.token}")
    private static String tokenProp;

    private static String token;

    @PostConstruct
    public void init() {
        if (token == null) {
            this.token = tokenProp;
        }
    }

    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        String[] arr = new String[]{token, timestamp, nonce};
        // 将 token、timestamp、nonce 三个参数进行字典序排序
        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        MessageDigest md = null;
        String tmpStr = null;
        byte[] digest = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行 sha1 加密
            digest = DigestUtils.sha1(content.toString());
            tmpStr = Hex.encodeHexString(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md = null;
        content = null;
        digest = null;
        // 将 sha1 加密后的字符串可与 signature 对比，标识该请求来源于微信
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }
}
