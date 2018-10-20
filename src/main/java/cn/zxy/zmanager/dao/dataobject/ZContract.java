package cn.zxy.zmanager.dao.dataobject;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ZContract {
	
	/** 合同状态：无效 */
	public static final Byte INVALID_STATUS = 0;
	
	/** 合同状态：有效 */
	public static final Byte VALID_STATUS = 1;
	
	/** 合同状态：终止合同 */
	public static final Byte FINISH_STATUS = 2;
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_contract.id
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_contract.contract_code
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    private String contractCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_contract.merchant_id
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    private Integer merchantId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_contract.merchant_code
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    private String merchantCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_contract.coporate_body
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    private String coporateBody;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_contract.company
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    private String company;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_contract.business
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    private String business;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_contract.cash_bledge
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    private Integer cashBledge;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_contract.start_date
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_contract.end_date
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_contract.rent_year
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    private Integer rentYear;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_contract.house_ids
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    private String houseIds;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_contract.water_fee
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    private Integer waterFee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_contract.electric_fee
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    private Integer electricFee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_contract.remarks
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    private String remarks;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_contract.status
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    private Byte status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_contract.contract_time
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date contractTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_contract.create_time
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_contract.create_emp_id
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    private Integer createEmpId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_contract.create_emp
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    private String createEmp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_contract.modify_time
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_contract.modify_emp_id
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    private Integer modifyEmpId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_contract.modify_emp
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    private String modifyEmp;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_contract.id
     *
     * @return the value of z_contract.id
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_contract.id
     *
     * @param id the value for z_contract.id
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_contract.contract_code
     *
     * @return the value of z_contract.contract_code
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public String getContractCode() {
        return contractCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_contract.contract_code
     *
     * @param contractCode the value for z_contract.contract_code
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_contract.merchant_id
     *
     * @return the value of z_contract.merchant_id
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public Integer getMerchantId() {
        return merchantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_contract.merchant_id
     *
     * @param merchantId the value for z_contract.merchant_id
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_contract.merchant_code
     *
     * @return the value of z_contract.merchant_code
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public String getMerchantCode() {
        return merchantCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_contract.merchant_code
     *
     * @param merchantCode the value for z_contract.merchant_code
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_contract.coporate_body
     *
     * @return the value of z_contract.coporate_body
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public String getCoporateBody() {
        return coporateBody;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_contract.coporate_body
     *
     * @param coporateBody the value for z_contract.coporate_body
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public void setCoporateBody(String coporateBody) {
        this.coporateBody = coporateBody;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_contract.company
     *
     * @return the value of z_contract.company
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public String getCompany() {
        return company;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_contract.company
     *
     * @param company the value for z_contract.company
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_contract.business
     *
     * @return the value of z_contract.business
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public String getBusiness() {
        return business;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_contract.business
     *
     * @param business the value for z_contract.business
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public void setBusiness(String business) {
        this.business = business;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_contract.cash_bledge
     *
     * @return the value of z_contract.cash_bledge
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public Integer getCashBledge() {
        return cashBledge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_contract.cash_bledge
     *
     * @param cashBledge the value for z_contract.cash_bledge
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public void setCashBledge(Integer cashBledge) {
        this.cashBledge = cashBledge;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_contract.start_date
     *
     * @return the value of z_contract.start_date
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_contract.start_date
     *
     * @param startDate the value for z_contract.start_date
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_contract.end_date
     *
     * @return the value of z_contract.end_date
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_contract.end_date
     *
     * @param endDate the value for z_contract.end_date
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_contract.rent_year
     *
     * @return the value of z_contract.rent_year
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public Integer getRentYear() {
        return rentYear;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_contract.rent_year
     *
     * @param rentYear the value for z_contract.rent_year
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public void setRentYear(Integer rentYear) {
        this.rentYear = rentYear;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_contract.house_ids
     *
     * @return the value of z_contract.house_ids
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public String getHouseIds() {
        return houseIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_contract.house_ids
     *
     * @param houseIds the value for z_contract.house_ids
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public void setHouseIds(String houseIds) {
        this.houseIds = houseIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_contract.water_fee
     *
     * @return the value of z_contract.water_fee
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public Integer getWaterFee() {
        return waterFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_contract.water_fee
     *
     * @param waterFee the value for z_contract.water_fee
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public void setWaterFee(Integer waterFee) {
        this.waterFee = waterFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_contract.electric_fee
     *
     * @return the value of z_contract.electric_fee
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public Integer getElectricFee() {
        return electricFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_contract.electric_fee
     *
     * @param electricFee the value for z_contract.electric_fee
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public void setElectricFee(Integer electricFee) {
        this.electricFee = electricFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_contract.remarks
     *
     * @return the value of z_contract.remarks
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_contract.remarks
     *
     * @param remarks the value for z_contract.remarks
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_contract.status
     *
     * @return the value of z_contract.status
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_contract.status
     *
     * @param status the value for z_contract.status
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_contract.contract_time
     *
     * @return the value of z_contract.contract_time
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public Date getContractTime() {
        return contractTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_contract.contract_time
     *
     * @param contractTime the value for z_contract.contract_time
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public void setContractTime(Date contractTime) {
        this.contractTime = contractTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_contract.create_time
     *
     * @return the value of z_contract.create_time
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_contract.create_time
     *
     * @param createTime the value for z_contract.create_time
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_contract.create_emp_id
     *
     * @return the value of z_contract.create_emp_id
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public Integer getCreateEmpId() {
        return createEmpId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_contract.create_emp_id
     *
     * @param createEmpId the value for z_contract.create_emp_id
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public void setCreateEmpId(Integer createEmpId) {
        this.createEmpId = createEmpId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_contract.create_emp
     *
     * @return the value of z_contract.create_emp
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public String getCreateEmp() {
        return createEmp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_contract.create_emp
     *
     * @param createEmp the value for z_contract.create_emp
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public void setCreateEmp(String createEmp) {
        this.createEmp = createEmp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_contract.modify_time
     *
     * @return the value of z_contract.modify_time
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_contract.modify_time
     *
     * @param modifyTime the value for z_contract.modify_time
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_contract.modify_emp_id
     *
     * @return the value of z_contract.modify_emp_id
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public Integer getModifyEmpId() {
        return modifyEmpId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_contract.modify_emp_id
     *
     * @param modifyEmpId the value for z_contract.modify_emp_id
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public void setModifyEmpId(Integer modifyEmpId) {
        this.modifyEmpId = modifyEmpId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_contract.modify_emp
     *
     * @return the value of z_contract.modify_emp
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public String getModifyEmp() {
        return modifyEmp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_contract.modify_emp
     *
     * @param modifyEmp the value for z_contract.modify_emp
     *
     * @mbg.generated Mon Oct 15 20:13:35 CST 2018
     */
    public void setModifyEmp(String modifyEmp) {
        this.modifyEmp = modifyEmp;
    }
}