package io.github.supercube.common;

import io.github.supercube.enums.HttpCodeEnum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ResultMap extends HashMap<String, Object> {

    private HashMap<String, Object> header;

    private int code = HttpCodeEnum.OK.getCode();

    public ResultMap() {
    }

    public static ResultMap newInstance() {
        return new ResultMap();
    }

    public ResultMap success() {
        this.code = HttpCodeEnum.OK.getCode();
        this.header = new HashMap<>();
        this.header.put("code", this.code);
        this.header.put("msg", "Success");
        this.put("header", header);
        this.put("payload", "");
        return this;
    }

    public ResultMap fail() {
        this.code = HttpCodeEnum.FAIL.getCode();
        this.header = new HashMap<>();
        this.header.put("code", code);
        this.put("header", header);
        this.put("payload", "");
        return this;
    }

    public ResultMap fail(int code) {
        this.code = code;
        this.header = new HashMap<>();
        this.header.put("code", code);
        this.put("header", header);
        this.put("payload", "");
        return this;
    }

    public ResultMap message(String message) {
        this.header.put("msg", message);
        this.put("header", header);
        return this;
    }

    public ResultMap payload(Object object) {
        this.put("payload", null == object ? "" : object);
        return this;
    }

    public ResultMap payloads(Collection list) {
        this.put("payload", null == list ? new ArrayList() : list);
        return this;
    }

    public int getCode() {
        return code;
    }

    public boolean isSuccess() {
        return this.code == HttpCodeEnum.OK.getCode();
    }
}
