package top.huhuiyu.springbootmybatisbase.service;

import top.huhuiyu.springbootmybatisbase.utils.JsonMessage;
import top.huhuiyu.springbootmybatisbase.utils.PageBean;

/**
 * - 测试服务
 *
 * @author DarkKnight
 *
 */
public interface TestService {

  /**
   * -分页查询token
   *
   * @param page
   * @return
   * @throws Exception
   */
  JsonMessage queryTokens(PageBean page) throws Exception;

}
