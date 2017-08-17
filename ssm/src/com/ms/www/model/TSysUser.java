package com.ms.www.model;

import java.util.Date;

public class TSysUser {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.id
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.name
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.user_name
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.user_password
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private String userPassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.user_real_password
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private String userRealPassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.phone
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.mobile
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.email
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.fk_channel_id
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private Integer fkChannelId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.channel_type
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private Integer channelType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.create_time
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.update_time
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sys_user.is_dele
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    private Integer isDele;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.id
     *
     * @return the value of t_sys_user.id
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.id
     *
     * @param id the value for t_sys_user.id
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.name
     *
     * @return the value of t_sys_user.name
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.name
     *
     * @param name the value for t_sys_user.name
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.user_name
     *
     * @return the value of t_sys_user.user_name
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.user_name
     *
     * @param userName the value for t_sys_user.user_name
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.user_password
     *
     * @return the value of t_sys_user.user_password
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.user_password
     *
     * @param userPassword the value for t_sys_user.user_password
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.user_real_password
     *
     * @return the value of t_sys_user.user_real_password
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public String getUserRealPassword() {
        return userRealPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.user_real_password
     *
     * @param userRealPassword the value for t_sys_user.user_real_password
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setUserRealPassword(String userRealPassword) {
        this.userRealPassword = userRealPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.phone
     *
     * @return the value of t_sys_user.phone
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.phone
     *
     * @param phone the value for t_sys_user.phone
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.mobile
     *
     * @return the value of t_sys_user.mobile
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.mobile
     *
     * @param mobile the value for t_sys_user.mobile
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.email
     *
     * @return the value of t_sys_user.email
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.email
     *
     * @param email the value for t_sys_user.email
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.fk_channel_id
     *
     * @return the value of t_sys_user.fk_channel_id
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public Integer getFkChannelId() {
        return fkChannelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.fk_channel_id
     *
     * @param fkChannelId the value for t_sys_user.fk_channel_id
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setFkChannelId(Integer fkChannelId) {
        this.fkChannelId = fkChannelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.channel_type
     *
     * @return the value of t_sys_user.channel_type
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public Integer getChannelType() {
        return channelType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.channel_type
     *
     * @param channelType the value for t_sys_user.channel_type
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setChannelType(Integer channelType) {
        this.channelType = channelType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.create_time
     *
     * @return the value of t_sys_user.create_time
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.create_time
     *
     * @param createTime the value for t_sys_user.create_time
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.update_time
     *
     * @return the value of t_sys_user.update_time
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.update_time
     *
     * @param updateTime the value for t_sys_user.update_time
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sys_user.is_dele
     *
     * @return the value of t_sys_user.is_dele
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public Integer getIsDele() {
        return isDele;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sys_user.is_dele
     *
     * @param isDele the value for t_sys_user.is_dele
     *
     * @mbggenerated Wed Jul 19 08:55:06 CST 2017
     */
    public void setIsDele(Integer isDele) {
        this.isDele = isDele;
    }
}