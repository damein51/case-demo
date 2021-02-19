package com.zlsd.damein.config;

import com.zlsd.damein.controller.AccessLimit;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;


/**
 * @program: damein
 * @description:
 * @author: lidongmin
 * @create: 2021-02-19 14:59
 */
@Component
public class FangshuaInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断请求是否属于方法的请求
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            //获取方法中的注解,看是否有该注解
            AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
            if (accessLimit == null) {
                return true;
            }
            int seconds = accessLimit.seconds();
            int maxCount = accessLimit.maxCount();
            String key = request.getRequestURI();


            if (maxCount > 0) {
                //超出访问次数
                render(response, "失败了");
                return false;
            } else {
                return true;
            }


        }
        return true;
    }

    private void render(HttpServletResponse response, String cm) throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        out.write(cm.getBytes("UTF-8"));
        out.flush();
        out.close();
    }

}