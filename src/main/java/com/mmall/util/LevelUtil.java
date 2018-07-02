package com.mmall.util;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by easom on 2017/12/5.
 */
public class LevelUtil {

    public final static String SEPARATOR=".";

    public final static String ROOT="0";

    //0
    //0.1
    //0.1.1
    public static String calculateLevel(String parentLevel,int parentId){
        if(StringUtils.isBlank(parentLevel)){
            return ROOT;
        } else {
            return StringUtils.join(parentLevel,SEPARATOR,parentId);
        }
    }
}
