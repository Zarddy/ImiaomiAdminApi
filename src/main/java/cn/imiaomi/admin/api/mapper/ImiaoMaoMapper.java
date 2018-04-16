package cn.imiaomi.admin.api.mapper;

import cn.imiaomi.admin.api.pojo.ImiaoMao;
import cn.imiaomi.admin.api.util.ImiaoMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ImiaoMaoMapper extends ImiaoMapper<ImiaoMao> {

    String TABLE_NAME = "`imiao_db`.`imiao_mao`";
    String MAO_FIELDS = "*";

    /**
     * 获取不同状态的图片列表
     * @param state 状态
     * @return 图片列表
     */
    @Select("SELECT " + MAO_FIELDS + " FROM " + TABLE_NAME + " WHERE state=#{state} ORDER BY id DESC")
    List<ImiaoMao> listCatsByState(@Param("state") int state);

    /**
     * 根据id获取图片详情
     * @param id 图片id
     * @return 图片详情
     */
    @Select("SELECT " + MAO_FIELDS + " FROM " + TABLE_NAME + " WHERE id=#{id}")
    ImiaoMao getCatById(@Param("id") String id);

    /**
     * 根据ids和state修改记录
     * @param ids 需要修改状态的id数组
     * @param state 状态
     * @return 修改成功的记录数
     */
    @Update("UPDATE " + TABLE_NAME + " SET state=#{state} WHERE id IN ${ids}")
    int updateStateByIds(@Param("ids") String ids, @Param("state") int state);
}