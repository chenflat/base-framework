package io.github.supercube.domain;

import io.github.supercube.config.FrameworkConstants;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;

/**
 * @author chenping
 */
public class UserInfo {

    @ApiModelProperty(value = "ID")
    private String id;

    @ApiModelProperty(value = "用户名", required = true)
    @Pattern(regexp = FrameworkConstants.LOGIN_REGEX)
    @Size(min = 1, max = 50)
    private String username;

    @ApiModelProperty(value = "显示名称")
    private String name;

    @ApiModelProperty(value = "邮件地址", example = "xxx@mail.com")
    @NotNull
    private String email;

    @ApiModelProperty(value = "头像地址")
    @Size(max = 256)
    private String avatar;

    @ApiModelProperty(value = "是否激活")
    private boolean activated = false;

    @ApiModelProperty(value = "激活键")
    private String activationKey;

    @ApiModelProperty(value = "语言", example = "zh,en")
    @Size(min = 2, max = 6)
    private String langKey;

    @ApiModelProperty(value = "密码在第一次登录后失效")
    private Boolean forceExpiration;

    @ApiModelProperty(value = "密码过期日期")
    private LocalDate pwExpiration;

    @ApiModelProperty(value = "连续登录失败尝试次数")
    private Integer failedLogins = 0;

    @ApiModelProperty(value = "要与用户名相关联的新人员")
    private String newUsername;

    @ApiModelProperty(value = "系统账号，指定是否删除用户标识")
    private Boolean sysuser = false;

    @ApiModelProperty(value = "人员类型", example = "企业用户USER, 甲方客户CUSTOMER, 供应商VENDOR, 第三方接入OPENID")
    private String type;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "移动电话")
    private String mobile;

    @ApiModelProperty(value = "工作电话")
    private String workPhone;

    @ApiModelProperty(value = "QQ或微信号")
    private String imId;

    @ApiModelProperty(value = "主要 SMS 地址")
    private String primarySMS;

    @ApiModelProperty(value = "vip,指示该人员是否为 VIP。该字段显示一个值，表明该 VIP 的重要级别")
    private Integer vip;

    @ApiModelProperty(value = "主要日历，与该人员相关的主要日历记录")
    private String calendarNum;

    @ApiModelProperty(value = "日历类型")
    private String caltype;

    @ApiModelProperty(value = "是否启用交接班")
    private Boolean enabledShift;

    @ApiModelProperty(value = "班次编号")
    private String shiftNum;

    @ApiModelProperty(value = "用户状态")
    private String status;

    @ApiModelProperty(value = "状态变更日期")
    private LocalDate statusDate;

    @ApiModelProperty(value = "部门ID")
    private String departmentId;

    @ApiModelProperty(value = "部门名称")
    private String departmentName;

    @ApiModelProperty(value = "头衔")
    private String title;

    @ApiModelProperty(value = "职务代码")
    private String jobcode;

    @ApiModelProperty(value = "该人员的主管姓名")
    private String supervisor;

    @ApiModelProperty(value = "工作类型，例如紧急维护、安全工作等")
    private String laborType;

    @ApiModelProperty(value = "该人员所属项目")
    private String locationSite;

    @ApiModelProperty(value = "人员的位置,该人员所在的项目位置。")
    private String location;

    @ApiModelProperty(value = "该人员所属的客户ID。")
    private String company;

    @ApiModelProperty(value = "该人员所属的客户名称。")
    private String companyName;


    private String locale;

    private String timezone;

    private LocalDate birthdate;

    private LocalDate hiredate;

    private LocalDate terminationDate;

    private LocalDate nextEvalDate;

    private LocalDate lastEvalDate;

    private Boolean locToServReq = true;

    private String delegate;

    private LocalDate delegateFromDate;

    private LocalDate delegateToDate;

    private String memo;

    private String accountType;

    private String createdBy;

    private Instant createdDate;

    private String lastModifiedBy;

    private Instant lastModifiedDate;

    private Set<String> authorities;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

    public Boolean getForceExpiration() {
        return forceExpiration;
    }

    public void setForceExpiration(Boolean forceExpiration) {
        this.forceExpiration = forceExpiration;
    }

    public LocalDate getPwExpiration() {
        return pwExpiration;
    }

    public void setPwExpiration(LocalDate pwExpiration) {
        this.pwExpiration = pwExpiration;
    }

    public Integer getFailedLogins() {
        return failedLogins;
    }

    public void setFailedLogins(Integer failedLogins) {
        this.failedLogins = failedLogins;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    public Boolean getSysuser() {
        return sysuser;
    }

    public void setSysuser(Boolean sysuser) {
        this.sysuser = sysuser;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getImId() {
        return imId;
    }

    public void setImId(String imId) {
        this.imId = imId;
    }

    public String getPrimarySMS() {
        return primarySMS;
    }

    public void setPrimarySMS(String primarySMS) {
        this.primarySMS = primarySMS;
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public String getCalendarNum() {
        return calendarNum;
    }

    public void setCalendarNum(String calendarNum) {
        this.calendarNum = calendarNum;
    }

    public String getCaltype() {
        return caltype;
    }

    public void setCaltype(String caltype) {
        this.caltype = caltype;
    }

    public Boolean getEnabledShift() {
        return enabledShift;
    }

    public void setEnabledShift(Boolean enabledShift) {
        this.enabledShift = enabledShift;
    }

    public String getShiftNum() {
        return shiftNum;
    }

    public void setShiftNum(String shiftNum) {
        this.shiftNum = shiftNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(LocalDate statusDate) {
        this.statusDate = statusDate;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJobcode() {
        return jobcode;
    }

    public void setJobcode(String jobcode) {
        this.jobcode = jobcode;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getLaborType() {
        return laborType;
    }

    public void setLaborType(String laborType) {
        this.laborType = laborType;
    }

    public String getLocationSite() {
        return locationSite;
    }

    public void setLocationSite(String locationSite) {
        this.locationSite = locationSite;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public LocalDate getHiredate() {
        return hiredate;
    }

    public void setHiredate(LocalDate hiredate) {
        this.hiredate = hiredate;
    }

    public LocalDate getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(LocalDate terminationDate) {
        this.terminationDate = terminationDate;
    }

    public LocalDate getNextEvalDate() {
        return nextEvalDate;
    }

    public void setNextEvalDate(LocalDate nextEvalDate) {
        this.nextEvalDate = nextEvalDate;
    }

    public LocalDate getLastEvalDate() {
        return lastEvalDate;
    }

    public void setLastEvalDate(LocalDate lastEvalDate) {
        this.lastEvalDate = lastEvalDate;
    }

    public Boolean getLocToServReq() {
        return locToServReq;
    }

    public void setLocToServReq(Boolean locToServReq) {
        this.locToServReq = locToServReq;
    }

    public String getDelegate() {
        return delegate;
    }

    public void setDelegate(String delegate) {
        this.delegate = delegate;
    }

    public LocalDate getDelegateFromDate() {
        return delegateFromDate;
    }

    public void setDelegateFromDate(LocalDate delegateFromDate) {
        this.delegateFromDate = delegateFromDate;
    }

    public LocalDate getDelegateToDate() {
        return delegateToDate;
    }

    public void setDelegateToDate(LocalDate delegateToDate) {
        this.delegateToDate = delegateToDate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }
}
