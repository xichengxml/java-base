package com.xicheng.javabase.t02_idempotence.web;

import com.xicheng.javabase.t02_idempotence.annotation.AutoIdempotent;
import com.xicheng.javabase.t02_idempotence.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-05-16 23:04
 */
@RestController
@RequestMapping("/token")
public class BusinessController {

    @Autowired
    private TokenService tokenService;

    @RequestMapping("/get")
    public String getToken() {
        return tokenService.createToken();
    }

    @PostMapping("/request")
    @AutoIdempotent
    public String businessRequest() {
        return "success";
    }
}
