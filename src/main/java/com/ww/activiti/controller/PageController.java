package com.ww.activiti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 打开activiti编辑器
 *
 * @Auther: lixin
 * @date: 2020/10/17 20:15
 */
@Controller
public class PageController {
    @GetMapping("editor")
    public String modelOpen(){
        return "/modeler";
    }
}
