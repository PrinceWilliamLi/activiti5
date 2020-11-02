package com.ww.activiti.config;

import org.activiti.engine.impl.cfg.IdGenerator;

import java.util.UUID;

/**
 * @Auther: lixin
 * @Date: 2020/10/11 16:05
 */
public class MyIdGenerator  implements IdGenerator {
    @Override
    public String getNextId() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }
}