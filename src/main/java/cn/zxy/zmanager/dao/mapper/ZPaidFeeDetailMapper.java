package cn.zxy.zmanager.dao.mapper;

import cn.zxy.zmanager.dao.dataobject.ZPaidFeeDetail;
import cn.zxy.zmanager.dao.dataobject.ZPaidFeeDetailExample;
import cn.zxy.zmanager.dto.PaidFeeDetailSearchDTO;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZPaidFeeDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_paid_fee_detail
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    long countByExample(ZPaidFeeDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_paid_fee_detail
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    int deleteByExample(ZPaidFeeDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_paid_fee_detail
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_paid_fee_detail
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    int insert(ZPaidFeeDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_paid_fee_detail
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    int insertSelective(ZPaidFeeDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_paid_fee_detail
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    List<ZPaidFeeDetail> selectByExample(ZPaidFeeDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_paid_fee_detail
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    ZPaidFeeDetail selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_paid_fee_detail
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    int updateByExampleSelective(@Param("record") ZPaidFeeDetail record, @Param("example") ZPaidFeeDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_paid_fee_detail
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    int updateByExample(@Param("record") ZPaidFeeDetail record, @Param("example") ZPaidFeeDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_paid_fee_detail
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    int updateByPrimaryKeySelective(ZPaidFeeDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_paid_fee_detail
     *
     * @mbg.generated Tue Nov 20 23:34:53 CST 2018
     */
    int updateByPrimaryKey(ZPaidFeeDetail record);

	List<ZPaidFeeDetail> selectByPaidFeeDetailSearchDTO(PaidFeeDetailSearchDTO searchDTO);
}