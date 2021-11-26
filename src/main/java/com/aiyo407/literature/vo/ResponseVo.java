package com.aiyo407.literature.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseVo implements Serializable {

    private Integer code;

    private Object data;

    private ResponseVo(Integer code,Object data){
        this.data=data;
        this.code=code;
    }
    public static ResponseVo success(Object data){

        return new ResponseVo(200,data);
    }
    public static ResponseVo fail(){

        return new ResponseVo(100,null);
    }
}
