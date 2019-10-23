package io.github.supercube.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 地址抽像类
 *
 * @author chenping
 */
@MappedSuperclass
public abstract class AbstractAddressEntity extends AbstractAuditingEntity {

    /**
     * 国家或地区, 地址中的国家或地区。
     */
    @Column(name = "country", length = 50)
    private String country;

    /**
     * 省/直辖市/自治区
     */
    @Column(name = "province", length = 50)
    private String province;

    /**
     * 城市
     */
    @Column(name = "city", length = 50)
    private String city;

    /**
     * 地区
     */
    @Column(name = "area", length = 50)
    private String area;


    /**
     * 街道地址
     */
    @Column(name = "address", length = 50)
    private String address;

    /**
     * 邮政编码, 地址的邮政编码。
     */
    @Column(name = "postcode", length = 50)
    private String postcode;

    /**
     *  地区编码。
     */
    @Column(name = "area_code", length = 50)
    private String areaCode;

    /**
     * 经度
     */
    @Column(name = "longitude")
    private String longitude;

    /**
     * 纬度
     */
    @Column(name = "latitude")
    private String latitude;


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
