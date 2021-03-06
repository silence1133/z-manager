package cn.zxy.zmanager.dao.dataobject;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ZPaidFeeDetail {
	
    public static final int RENT_FEE = 0;

	public static final int PROPERTY_FEE = 1;

	public static final int WATER_FEE = 2;

	public static final int ELECTRIC_FEE = 3;

	public static final Integer VALID_STATUS = 1;

	/**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_paid_fee_detail.id
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_paid_fee_detail.receipt_code
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    private Integer receiptCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_paid_fee_detail.contract_code
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    private String contractCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_paid_fee_detail.company
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    private String company;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_paid_fee_detail.coporate_body
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    private String coporateBody;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_paid_fee_detail.contract_id
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    private Integer contractId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_paid_fee_detail.paid_fee
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    private Integer paidFee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_paid_fee_detail.paid_time
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date paidTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_paid_fee_detail.paid_method
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    private Byte paidMethod;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_paid_fee_detail.electric_meter_code
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    private String electricMeterCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_paid_fee_detail.electric
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    private Integer electric;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_paid_fee_detail.paid_man
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    private String paidMan;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_paid_fee_detail.charge_man
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    private String chargeMan;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_paid_fee_detail.remarks
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    private String remarks;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_paid_fee_detail.fee_type
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    private Integer feeType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_paid_fee_detail.status
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_paid_fee_detail.create_emp_id
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    private Integer createEmpId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_paid_fee_detail.create_emp
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    private String createEmp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_paid_fee_detail.create_time
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_paid_fee_detail.modify_emp_id
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    private Integer modifyEmpId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_paid_fee_detail.modify_emp
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    private String modifyEmp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column z_paid_fee_detail.modify_time
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_paid_fee_detail.id
     *
     * @return the value of z_paid_fee_detail.id
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_paid_fee_detail.id
     *
     * @param id the value for z_paid_fee_detail.id
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_paid_fee_detail.receipt_code
     *
     * @return the value of z_paid_fee_detail.receipt_code
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public Integer getReceiptCode() {
        return receiptCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_paid_fee_detail.receipt_code
     *
     * @param receiptCode the value for z_paid_fee_detail.receipt_code
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public void setReceiptCode(Integer receiptCode) {
        this.receiptCode = receiptCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_paid_fee_detail.contract_code
     *
     * @return the value of z_paid_fee_detail.contract_code
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public String getContractCode() {
        return contractCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_paid_fee_detail.contract_code
     *
     * @param contractCode the value for z_paid_fee_detail.contract_code
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_paid_fee_detail.company
     *
     * @return the value of z_paid_fee_detail.company
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public String getCompany() {
        return company;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_paid_fee_detail.company
     *
     * @param company the value for z_paid_fee_detail.company
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_paid_fee_detail.coporate_body
     *
     * @return the value of z_paid_fee_detail.coporate_body
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public String getCoporateBody() {
        return coporateBody;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_paid_fee_detail.coporate_body
     *
     * @param coporateBody the value for z_paid_fee_detail.coporate_body
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public void setCoporateBody(String coporateBody) {
        this.coporateBody = coporateBody;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_paid_fee_detail.contract_id
     *
     * @return the value of z_paid_fee_detail.contract_id
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public Integer getContractId() {
        return contractId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_paid_fee_detail.contract_id
     *
     * @param contractId the value for z_paid_fee_detail.contract_id
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_paid_fee_detail.paid_fee
     *
     * @return the value of z_paid_fee_detail.paid_fee
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public Integer getPaidFee() {
        return paidFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_paid_fee_detail.paid_fee
     *
     * @param paidFee the value for z_paid_fee_detail.paid_fee
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public void setPaidFee(Integer paidFee) {
        this.paidFee = paidFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_paid_fee_detail.paid_time
     *
     * @return the value of z_paid_fee_detail.paid_time
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public Date getPaidTime() {
        return paidTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_paid_fee_detail.paid_time
     *
     * @param paidTime the value for z_paid_fee_detail.paid_time
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_paid_fee_detail.paid_method
     *
     * @return the value of z_paid_fee_detail.paid_method
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public Byte getPaidMethod() {
        return paidMethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_paid_fee_detail.paid_method
     *
     * @param paidMethod the value for z_paid_fee_detail.paid_method
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public void setPaidMethod(Byte paidMethod) {
        this.paidMethod = paidMethod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_paid_fee_detail.electric_meter_code
     *
     * @return the value of z_paid_fee_detail.electric_meter_code
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public String getElectricMeterCode() {
        return electricMeterCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_paid_fee_detail.electric_meter_code
     *
     * @param electricMeterCode the value for z_paid_fee_detail.electric_meter_code
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public void setElectricMeterCode(String electricMeterCode) {
        this.electricMeterCode = electricMeterCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_paid_fee_detail.electric
     *
     * @return the value of z_paid_fee_detail.electric
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public Integer getElectric() {
        return electric;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_paid_fee_detail.electric
     *
     * @param electric the value for z_paid_fee_detail.electric
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public void setElectric(Integer electric) {
        this.electric = electric;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_paid_fee_detail.paid_man
     *
     * @return the value of z_paid_fee_detail.paid_man
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public String getPaidMan() {
        return paidMan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_paid_fee_detail.paid_man
     *
     * @param paidMan the value for z_paid_fee_detail.paid_man
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public void setPaidMan(String paidMan) {
        this.paidMan = paidMan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_paid_fee_detail.charge_man
     *
     * @return the value of z_paid_fee_detail.charge_man
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public String getChargeMan() {
        return chargeMan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_paid_fee_detail.charge_man
     *
     * @param chargeMan the value for z_paid_fee_detail.charge_man
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public void setChargeMan(String chargeMan) {
        this.chargeMan = chargeMan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_paid_fee_detail.remarks
     *
     * @return the value of z_paid_fee_detail.remarks
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_paid_fee_detail.remarks
     *
     * @param remarks the value for z_paid_fee_detail.remarks
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_paid_fee_detail.fee_type
     *
     * @return the value of z_paid_fee_detail.fee_type
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public Integer getFeeType() {
        return feeType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_paid_fee_detail.fee_type
     *
     * @param feeType the value for z_paid_fee_detail.fee_type
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public void setFeeType(Integer feeType) {
        this.feeType = feeType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_paid_fee_detail.status
     *
     * @return the value of z_paid_fee_detail.status
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_paid_fee_detail.status
     *
     * @param status the value for z_paid_fee_detail.status
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_paid_fee_detail.create_emp_id
     *
     * @return the value of z_paid_fee_detail.create_emp_id
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public Integer getCreateEmpId() {
        return createEmpId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_paid_fee_detail.create_emp_id
     *
     * @param createEmpId the value for z_paid_fee_detail.create_emp_id
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public void setCreateEmpId(Integer createEmpId) {
        this.createEmpId = createEmpId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_paid_fee_detail.create_emp
     *
     * @return the value of z_paid_fee_detail.create_emp
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public String getCreateEmp() {
        return createEmp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_paid_fee_detail.create_emp
     *
     * @param createEmp the value for z_paid_fee_detail.create_emp
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public void setCreateEmp(String createEmp) {
        this.createEmp = createEmp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_paid_fee_detail.create_time
     *
     * @return the value of z_paid_fee_detail.create_time
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_paid_fee_detail.create_time
     *
     * @param createTime the value for z_paid_fee_detail.create_time
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_paid_fee_detail.modify_emp_id
     *
     * @return the value of z_paid_fee_detail.modify_emp_id
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public Integer getModifyEmpId() {
        return modifyEmpId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_paid_fee_detail.modify_emp_id
     *
     * @param modifyEmpId the value for z_paid_fee_detail.modify_emp_id
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public void setModifyEmpId(Integer modifyEmpId) {
        this.modifyEmpId = modifyEmpId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_paid_fee_detail.modify_emp
     *
     * @return the value of z_paid_fee_detail.modify_emp
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public String getModifyEmp() {
        return modifyEmp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_paid_fee_detail.modify_emp
     *
     * @param modifyEmp the value for z_paid_fee_detail.modify_emp
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public void setModifyEmp(String modifyEmp) {
        this.modifyEmp = modifyEmp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column z_paid_fee_detail.modify_time
     *
     * @return the value of z_paid_fee_detail.modify_time
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column z_paid_fee_detail.modify_time
     *
     * @param modifyTime the value for z_paid_fee_detail.modify_time
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}