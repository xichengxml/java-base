package com.xicheng.javabase.t02_idempotence.interceptor;

import com.xicheng.javabase.t02_idempotence.annotation.AutoIdempotent;
import com.xicheng.javabase.t02_idempotence.config.SpringApplicationContext;
import com.xicheng.javabase.t02_idempotence.service.TokenService;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * description
 *
 * @author xichengxml
 * @date 2020-05-16 22:50
 */
public class AutoIdempotentInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return false;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        AutoIdempotent autoIdempotent = method.getAnnotation(AutoIdempotent.class);
        if (autoIdempotent != null) {
            TokenService tokenService = SpringApplicationContext.getBean(TokenService.class);
            boolean result = tokenService.checkToken(request);
            if (result) {
                writeReturnJson(response, "重复请求");
            } else {
                writeReturnJson(response, "请求成功");
            }
            return !result;
        }
        return true;
    }

    /**
     * 返回的json值
     *
     * @param response
     * @param json
     * @throws Exception
     */
    private void writeReturnJson(HttpServletResponse response, String json) {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}
