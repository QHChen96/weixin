package com.chenqinhao.core.web.demo;

import com.chenqinhao.core.entity.demo.TextDemo;
import com.chenqinhao.core.service.demo.TextDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/4/24.
 */
@Controller
@RequestMapping("demo")
public class TextDemoController {

    @Autowired
    private TextDemoService textDemoService;

    @RequestMapping("findAllTextDemo")
    @ResponseBody
    public List<TextDemo> findAllTextDemo(){
        return textDemoService.findAllTextDemo();
    }

}
