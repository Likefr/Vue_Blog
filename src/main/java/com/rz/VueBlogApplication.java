package com.rz;

import cn.licoy.encryptbody.annotation.EnableEncryptBody;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableEncryptBody
@SpringBootApplication
public class VueBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueBlogApplication.class, args);
    }

}
