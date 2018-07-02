package com.mmall.common;

import com.mmall.exception.ParamException;
import com.mmall.exception.PermissionException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by easom on 2017/12/3.
 */
public class SpringExceptionResolver implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        
        String url=request.getRequestURL().toString();
        ModelAndView modelAndView;
        String defaultMsg="System error";

        //.json .page
        if(url.endsWith(".json")){
            if(ex instanceof PermissionException||ex instanceof ParamException){
                JsonData result=JsonData.fail(ex.getMessage());
                modelAndView=new ModelAndView("jsonView",result.toMap());
            }else {
                JsonData result=JsonData.fail(defaultMsg);
                modelAndView=new ModelAndView("jsonView",result.toMap());
            }
        }else if(url.endsWith(".page")){
            JsonData result=JsonData.fail(defaultMsg);
            modelAndView =new ModelAndView("exception",result.toMap());
        }else {
            JsonData result=JsonData.fail(defaultMsg);
            modelAndView=new ModelAndView("jsonView",result.toMap());
        }
        return modelAndView ;
    }
}
