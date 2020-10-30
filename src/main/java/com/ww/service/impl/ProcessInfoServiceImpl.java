package com.ww.service.impl;

import com.ww.dao.ProcessMapper;
import com.ww.service.ProcessInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @Auther: lixin
 * @Date: 2020/10/17 16:55
 */
@Service
public class ProcessInfoServiceImpl implements ProcessInfoService {

    @Autowired
    private ProcessMapper processMapper;

    @Override
    public List<Map<String, Object>> models() {
        return processMapper.selectModels();
    }

    @Override
    public List<Map<String, Object>> process() {
        return processMapper.selectProcess();
    }

}
