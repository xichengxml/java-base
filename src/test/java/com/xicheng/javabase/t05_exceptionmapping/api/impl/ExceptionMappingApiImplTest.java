package com.xicheng.javabase.t05_exceptionmapping.api.impl;

import com.xicheng.javabase.JavaBaseApplication;
import com.xicheng.javabase.t05_exceptionmapping.api.ExceptionMappingApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-07-19 09:05
 */
@SpringBootTest(classes = JavaBaseApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ExceptionMappingApiImplTest {

    @Autowired
    private ExceptionMappingApi exceptionMappingApi;

    @Test
    public void apiTest() {
        exceptionMappingApi.api();
    }
}
