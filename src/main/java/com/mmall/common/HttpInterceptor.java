package com.mmall.common;

import com.mmall.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by easom on 2017/12/2.
 */
@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter{

    private static final String START_TIME="requestStartTime";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url=request.getRequestURI().toString();
        Map parameterMap = request.getParameterMap();
        log.info("request start. url:{},params:{}",url, JsonMapper.object2String(parameterMap));
        long start=System.currentTimeMillis();
        request.setAttribute(START_TIME,start);
        return true;
    }

    @Override//正常返回
    public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
      //  super.postHandle(request, response, handler, modelAndView);
    }

    @Override//完成后一定触发
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String url = request.getRequestURI().toString();
        long start = (Long) request.getAttribute(START_TIME);
        long end = System.currentTimeMillis();
        log.info("request completed. url:{}, cost:{}", url, end - start);

      //  removeThreadLocalInfo();
    }

/*    public void removeThreadLocalInfo() {
        RequestHolder.remove();
    }*/
}
