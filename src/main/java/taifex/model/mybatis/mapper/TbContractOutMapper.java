package taifex.model.mybatis.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import taifex.model.entity.TbContractOut;
import taifex.model.entity.TbContractOutExample;
import taifex.model.entity.TbContractOutKey;

public interface TbContractOutMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_CONTRACT_OUT
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int countByExample(TbContractOutExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_CONTRACT_OUT
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int deleteByExample(TbContractOutExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_CONTRACT_OUT
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int deleteByPrimaryKey(TbContractOutKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_CONTRACT_OUT
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int insert(TbContractOut record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_CONTRACT_OUT
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int insertSelective(TbContractOut record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_CONTRACT_OUT
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    List<TbContractOut> selectByExample(TbContractOutExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_CONTRACT_OUT
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    TbContractOut selectByPrimaryKey(TbContractOutKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_CONTRACT_OUT
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int updateByExampleSelective(@Param("record") TbContractOut record, @Param("example") TbContractOutExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_CONTRACT_OUT
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int updateByExample(@Param("record") TbContractOut record, @Param("example") TbContractOutExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_CONTRACT_OUT
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int updateByPrimaryKeySelective(TbContractOut record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table APP.TB_CONTRACT_OUT
     *
     * @mbggenerated Wed Mar 04 17:46:10 CST 2015
     */
    int updateByPrimaryKey(TbContractOut record);
}