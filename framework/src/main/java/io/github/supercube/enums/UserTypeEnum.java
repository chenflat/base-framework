package io.github.supercube.enums;


import java.util.Arrays;

/**
 * 用户类型
 *
 * @author chenping
 */

public enum UserTypeEnum {

    /**
     * 平台用户
     */
    USER("平台用户"),
    /**
     * 客户用户
     */
    CUSTOMER("客户用户"),
    /**
     * 供应商用户
     */
    VENDOR("供应商用户"),
    /**
     * 制造商用户
     */
    MANUFACTURER("制造商用户"),
    /**
     * 第三方接入
     */
    OPENID("第三方接入");

    private String description;

    UserTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static UserTypeEnum fromName(String name) {
        return Arrays.stream(values())
                .filter(bl -> bl.name().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

}
