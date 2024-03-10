package com.yunbocheng.springcloud.entities;

import com.yunbocheng.springcloud.enums.ResultEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.HashMap;
import java.util.Map;


@Data
@Schema(description = "统一结果集封装")
public class R {

    @Schema(description = "成功状态")
    private Boolean success ;
    @Schema(description = "状态码")
    private Integer code;
    @Schema(description = "提示信息")
    private String message;
    @Schema(description = "数据")
    private Map<String, Object> data = new HashMap<>();

    public static R ok() {
        R r = new R();
        r.setSuccess(true);
        r.setCode(200);
        r.setMessage("成功");
        return r;
    }

    public static R error() {
        R r = new R();
        r.setSuccess(false);
        r.setCode(500);
        r.setMessage("失败");
        return r;
    }

    public static R error(String message) {
        R r = new R();
        r.setSuccess(false);
        r.setCode(500);
        r.setMessage(message);
        return r;
    }

    public static R error(Integer code, String message) {
        R r = new R();
        r.setSuccess(false);
        r.setCode(code);
        r.setMessage(message);
        return r;
    }

    public static R error(ResultEnum resultEnum) {
        R r = new R();
        r.setSuccess(false);
        r.setCode(resultEnum.getCode());
        r.setMessage(resultEnum.getMessage());
        return r;
    }

    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public R onlyList(Object value) {
        this.data.put("list", value);
        return this;
    }

    public R data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }
}
