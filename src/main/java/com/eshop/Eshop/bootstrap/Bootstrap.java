package com.eshop.Eshop.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
@Service
@Slf4j
public class Bootstrap implements InitializingBean {

    @Autowired
    private SecurityBootstrap securityBootstrap;

    @Override
    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        log.info("Initiating Bootstrap of Data ..........");
        securityBootstrap.createData();
        log.info("Bootstrapping of data completed !!!!!!!!!!!!");
    }
}
