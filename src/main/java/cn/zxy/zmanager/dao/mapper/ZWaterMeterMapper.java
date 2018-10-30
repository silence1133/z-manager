package cn.zxy.zmanager.dao.mapper;

import cn.zxy.zmanager.dao.dataobject.ZWaterMeter;
import cn.zxy.zmanager.dao.dataobject.ZWaterMeterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZWaterMeterMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_water_meter
     *
     * @mbg.generated Sat Oct 27 15:59:09 CST 2018
     */
    long countByExample(ZWaterMeterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_water_meter
     *
     * @mbg.generated Sat Oct 27 15:59:09 CST 2018
     */
    int deleteByExample(ZWaterMeterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_water_meter
     *
     * @mbg.generated Sat Oct 27 15:59:09 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_water_meter
     *
     * @mbg.generated Sat Oct 27 15:59:09 CST 2018
     */
    int insert(ZWaterMeter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_water_meter
     *
     * @mbg.generated Sat Oct 27 15:59:09 CST 2018
     */
    int insertSelective(ZWaterMeter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_water_meter
     *
     * @mbg.generated Sat Oct 27 15:59:09 CST 2018
     */
    List<ZWaterMeter> selectByExample(ZWaterMeterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_water_meter
     *
     * @mbg.generated Sat Oct 27 15:59:09 CST 2018
     */
    ZWaterMeter selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_water_meter
     *
     * @mbg.generated Sat Oct 27 15:59:09 CST 2018
     */
    int updateByExampleSelective(@Param("record") ZWaterMeter record, @Param("example") ZWaterMeterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_water_meter
     *
     * @mbg.generated Sat Oct 27 15:59:09 CST 2018
     */
    int updateByExample(@Param("record") ZWaterMeter record, @Param("example") ZWaterMeterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_water_meter
     *
     * @mbg.generated Sat Oct 27 15:59:09 CST 2018
     */
    int updateByPrimaryKeySelective(ZWaterMeter record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_water_meter
     *
     * @mbg.generated Sat Oct 27 15:59:09 CST 2018
     */
    int updateByPrimaryKey(ZWaterMeter record);

	List<ZWaterMeter> selectByContractIdList(@Param("list") List<Integer> contractIdList);
}