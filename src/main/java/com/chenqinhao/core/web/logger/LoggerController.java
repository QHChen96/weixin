package com.chenqinhao.core.web.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/4/23.
 */
@Controller
public class LoggerController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("log")
    @ResponseBody
    public String log(HttpServletRequest request, HttpServletResponse response) {
        logger.trace("日志输出 trace");
        logger.debug("日志输出 debug");
        logger.info("日志输出 info");
        logger.warn("日志输出 warn");
        logger.error("日志输出 error");
        return "logging...";
    }
}
