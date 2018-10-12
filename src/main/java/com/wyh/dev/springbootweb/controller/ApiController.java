package com.wyh.dev.springbootweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wyh on 2017/3/1.
 */
@RestController
@RequestMapping("api")
public class ApiController {
    private static final Logger LOG = LoggerFactory.getLogger(ApiController.class);

    @RequestMapping("/hellWord")
    public String hellWord(){
        if (LOG.isDebugEnabled())
            LOG.debug("welcome hellWord");
        return "hell word";
    }
}
