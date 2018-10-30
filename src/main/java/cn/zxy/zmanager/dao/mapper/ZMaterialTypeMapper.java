package cn.zxy.zmanager.dao.mapper;

import cn.zxy.zmanager.dao.dataobject.ZMaterialType;
import cn.zxy.zmanager.dao.dataobject.ZMaterialTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZMaterialTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_material_type
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    long countByExample(ZMaterialTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_material_type
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    int deleteByExample(ZMaterialTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_material_type
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_material_type
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    int insert(ZMaterialType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_material_type
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    int insertSelective(ZMaterialType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_material_type
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    List<ZMaterialType> selectByExample(ZMaterialTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_material_type
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    ZMaterialType selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_material_type
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    int updateByExampleSelective(@Param("record") ZMaterialType record, @Param("example") ZMaterialTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_material_type
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    int updateByExample(@Param("record") ZMaterialType record, @Param("example") ZMaterialTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_material_type
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    int updateByPrimaryKeySelective(ZMaterialType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table z_material_type
     *
     * @mbg.generated Sun Oct 28 19:20:19 CST 2018
     */
    int updateByPrimaryKey(ZMaterialType record);
}