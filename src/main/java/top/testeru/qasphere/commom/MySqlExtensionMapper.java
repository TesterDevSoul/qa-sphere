package top.testeru.qasphere.dao;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author testeru.top
 * @version 1.0.0
 * @Project autosphere
 * @Description
 * @createTime 2022年10月31日 12:06:00
 */
public interface MySqlExtensionMapper<T> extends Mapper<T>, MySqlMapper<T>, IdsMapper<T> {
}
