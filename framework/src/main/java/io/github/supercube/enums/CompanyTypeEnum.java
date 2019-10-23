package io.github.supercube.enums;

/**
 * 客户类型
 *
 * @author chenping
 */
public enum CompanyTypeEnum {

    CUSTOMER("客户"), VENDOR("供应商"), MANUFACTURER("制造商");

    private String description;

    CompanyTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
