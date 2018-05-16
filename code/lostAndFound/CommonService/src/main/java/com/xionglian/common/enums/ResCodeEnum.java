package com.xionglian.common.enums;

/**
 * Created by lenovo on 2018/3/31.
 */
public enum ResCodeEnum
{
    SUCCESS("000000", "成功"),
    ERROR99("LostAndFound99999999", "系统内部错误："),
    ERROR01("TEA00000001", "查询商品列表失败"),

    ;
    /**
     * 错误码
     */
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     *错误信息
     */

    private String desc;

    ResCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}

