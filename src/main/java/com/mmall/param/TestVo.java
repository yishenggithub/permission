package com.mmall.param;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

public class TestVo {

    @NotBlank
    private String msg;

    
    private Integer id;

    @NotEmpty
    private List<String> str;

}
