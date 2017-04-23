package com.chenqinhao.core.service.demo.impl;

import com.chenqinhao.core.dao.demo.TextDemoDao;
import com.chenqinhao.core.entity.demo.TextDemo;
import com.chenqinhao.core.service.demo.TextDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/24.
 */
@Service("textDemoService")
public class TextDemoServiceImpl implements TextDemoService {

    @Autowired
    private TextDemoDao textDemoDao;

    @Override
    public List<TextDemo> findAllTextDemo() {
        return textDemoDao.findAllTextDemo();
    }
}
