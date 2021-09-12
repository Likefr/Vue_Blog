package com.rz.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @version 1.0
 * @date 2021/09/09
 * @outhor Likefr
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult implements Serializable {
    private int code;
    private String msg;
    private Object data;

    /*
     * code 状态码
     * msg 返回消息
     * data json数据
     */
    public static JsonResult success(Object data) {
        return success(200, "成功", data);
    }

    public static JsonResult success(String msg, Object data) {
        return success(200, msg, data);
    }


    public static JsonResult success(int code, String msg, Object data) {
        JsonResult result = new JsonResult();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static JsonResult err(String msg) {
        return err(400, msg, null);
    }

    public static JsonResult err(String msg, Object data) {
        return err(400, msg, data);
    }

    public static JsonResult err(int code, String msg, Object data) {
        JsonResult result = new JsonResult();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
