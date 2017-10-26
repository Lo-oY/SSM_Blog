package com.ly.util;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Created by cilu on 2017/10/26.
 */
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@XStreamAlias("response")
public class ResponseDto {

    @XStreamAsAttribute
    private int code;
    @XStreamAsAttribute
    private String msg;
    @XStreamAsAttribute
    private Object item;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }
}
