package taifex.model.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import taifex.model.entity.TbOpHis;
import taifex.model.entity.TbOpHisExample;
import taifex.model.entity.TbOpHisKey;

public interface TbOpHisMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_OP_HIS
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int countByExample(TbOpHisExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_OP_HIS
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int deleteByExample(TbOpHisExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_OP_HIS
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int deleteByPrimaryKey(TbOpHisKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_OP_HIS
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int insert(TbOpHis record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_OP_HIS
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int insertSelective(TbOpHis record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_OP_HIS
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    List<TbOpHis> selectByExample(TbOpHisExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_OP_HIS
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    TbOpHis selectByPrimaryKey(TbOpHisKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_OP_HIS
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int updateByExampleSelective(@Param("record") TbOpHis record, @Param("example") TbOpHisExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_OP_HIS
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int updateByExample(@Param("record") TbOpHis record, @Param("example") TbOpHisExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_OP_HIS
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int updateByPrimaryKeySelective(TbOpHis record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_OP_HIS
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int updateByPrimaryKey(TbOpHis record);
}