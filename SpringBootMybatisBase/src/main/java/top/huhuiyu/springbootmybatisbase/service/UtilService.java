package top.huhuiyu.springbootmybatisbase.service;

import top.huhuiyu.springbootmybatisbase.entity.TbToken;

/**
 * 工具服务
 * 
 * @author DarkKnight
 *
 */
public interface UtilService {

  /**
   * 获取图片校验码
   * 
   * @param token
   * @return
   * @throws Exception
   */
  String imageCode(TbToken token) throws Exception;

}
