package cn.zxy.zmanager.dao.mapper;

import cn.zxy.zmanager.dao.dataobject.ZElectricRecord;
import cn.zxy.zmanager.dao.dataobject.ZElectricRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZElectricRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_electric_record
     *
     * @mbg.generated Sat Oct 27 16:38:21 CST 2018
     */
    long countByExample(ZElectricRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_electric_record
     *
     * @mbg.generated Sat Oct 27 16:38:21 CST 2018
     */
    int deleteByExample(ZElectricRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_electric_record
     *
     * @mbg.generated Sat Oct 27 16:38:21 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_electric_record
     *
     * @mbg.generated Sat Oct 27 16:38:21 CST 2018
     */
    int insert(ZElectricRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_electric_record
     *
     * @mbg.generated Sat Oct 27 16:38:21 CST 2018
     */
    int insertSelective(ZElectricRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_electric_record
     *
     * @mbg.generated Sat Oct 27 16:38:21 CST 2018
     */
    List<ZElectricRecord> selectByExample(ZElectricRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_electric_record
     *
     * @mbg.generated Sat Oct 27 16:38:21 CST 2018
     */
    ZElectricRecord selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_electric_record
     *
     * @mbg.generated Sat Oct 27 16:38:21 CST 2018
     */
    int updateByExampleSelective(@Param("record") ZElectricRecord record, @Param("example") ZElectricRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_electric_record
     *
     * @mbg.generated Sat Oct 27 16:38:21 CST 2018
     */
    int updateByExample(@Param("record") ZElectricRecord record, @Param("example") ZElectricRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_electric_record
     *
     * @mbg.generated Sat Oct 27 16:38:21 CST 2018
     */
    int updateByPrimaryKeySelective(ZElectricRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_electric_record
     *
     * @mbg.generated Sat Oct 27 16:38:21 CST 2018
     */
    int updateByPrimaryKey(ZElectricRecord record);
}