package cn.zxy.zmanager.dao.dataobject;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ZMerchant {
	/** 状态：上线 */
	public static final int ON_LINE = 1;
	
	/** 状态：下线 */
	public static final int OFF_LINE = 0;
	
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_merchant.id
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_merchant.merchant_code
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    private String merchantCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_merchant.company
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    private String company;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_merchant.corporate_body
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    private String corporateBody;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_merchant.id_card
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    private String idCard;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_merchant.link_man
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    private String linkMan;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_merchant.link_phone
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    private String linkPhone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_merchant.brand
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    private String brand;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_merchant.address
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_merchant.remarks
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    private String remarks;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_merchant.entering_time
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    private String enteringTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_merchant.status
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_merchant.create_time
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_merchant.create_emp_id
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    private Integer createEmpId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_merchant.create_emp
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    private String createEmp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_merchant.modify_time
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_merchant.modify_emp_id
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    private Integer modifyEmpId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_merchant.modify_emp
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    private String modifyEmp;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_merchant.id
     *
     * @return the value of z_merchant.id
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_merchant.id
     *
     * @param id the value for z_merchant.id
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_merchant.merchant_code
     *
     * @return the value of z_merchant.merchant_code
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public String getMerchantCode() {
        return merchantCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_merchant.merchant_code
     *
     * @param merchantCode the value for z_merchant.merchant_code
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_merchant.company
     *
     * @return the value of z_merchant.company
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public String getCompany() {
        return company;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_merchant.company
     *
     * @param company the value for z_merchant.company
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_merchant.corporate_body
     *
     * @return the value of z_merchant.corporate_body
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public String getCorporateBody() {
        return corporateBody;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_merchant.corporate_body
     *
     * @param corporateBody the value for z_merchant.corporate_body
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public void setCorporateBody(String corporateBody) {
        this.corporateBody = corporateBody;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_merchant.id_card
     *
     * @return the value of z_merchant.id_card
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_merchant.id_card
     *
     * @param idCard the value for z_merchant.id_card
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_merchant.link_man
     *
     * @return the value of z_merchant.link_man
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public String getLinkMan() {
        return linkMan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_merchant.link_man
     *
     * @param linkMan the value for z_merchant.link_man
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_merchant.link_phone
     *
     * @return the value of z_merchant.link_phone
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public String getLinkPhone() {
        return linkPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_merchant.link_phone
     *
     * @param linkPhone the value for z_merchant.link_phone
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_merchant.brand
     *
     * @return the value of z_merchant.brand
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public String getBrand() {
        return brand;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_merchant.brand
     *
     * @param brand the value for z_merchant.brand
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_merchant.address
     *
     * @return the value of z_merchant.address
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_merchant.address
     *
     * @param address the value for z_merchant.address
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_merchant.remarks
     *
     * @return the value of z_merchant.remarks
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_merchant.remarks
     *
     * @param remarks the value for z_merchant.remarks
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_merchant.entering_time
     *
     * @return the value of z_merchant.entering_time
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public String getEnteringTime() {
        return enteringTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_merchant.entering_time
     *
     * @param enteringTime the value for z_merchant.entering_time
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public void setEnteringTime(String enteringTime) {
        this.enteringTime = enteringTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_merchant.status
     *
     * @return the value of z_merchant.status
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_merchant.status
     *
     * @param status the value for z_merchant.status
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_merchant.create_time
     *
     * @return the value of z_merchant.create_time
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_merchant.create_time
     *
     * @param createTime the value for z_merchant.create_time
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_merchant.create_emp_id
     *
     * @return the value of z_merchant.create_emp_id
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public Integer getCreateEmpId() {
        return createEmpId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_merchant.create_emp_id
     *
     * @param createEmpId the value for z_merchant.create_emp_id
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public void setCreateEmpId(Integer createEmpId) {
        this.createEmpId = createEmpId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_merchant.create_emp
     *
     * @return the value of z_merchant.create_emp
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public String getCreateEmp() {
        return createEmp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_merchant.create_emp
     *
     * @param createEmp the value for z_merchant.create_emp
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public void setCreateEmp(String createEmp) {
        this.createEmp = createEmp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_merchant.modify_time
     *
     * @return the value of z_merchant.modify_time
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_merchant.modify_time
     *
     * @param modifyTime the value for z_merchant.modify_time
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_merchant.modify_emp_id
     *
     * @return the value of z_merchant.modify_emp_id
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public Integer getModifyEmpId() {
        return modifyEmpId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_merchant.modify_emp_id
     *
     * @param modifyEmpId the value for z_merchant.modify_emp_id
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public void setModifyEmpId(Integer modifyEmpId) {
        this.modifyEmpId = modifyEmpId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_merchant.modify_emp
     *
     * @return the value of z_merchant.modify_emp
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public String getModifyEmp() {
        return modifyEmp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_merchant.modify_emp
     *
     * @param modifyEmp the value for z_merchant.modify_emp
     *
     * @mbg.generated Sat Oct 06 17:31:50 CST 2018
     */
    public void setModifyEmp(String modifyEmp) {
        this.modifyEmp = modifyEmp;
    }
}