package top.huhuiyu.springbootmybatisbase.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.huhuiyu.springbootmybatisbase.entity.TbToken;
import top.huhuiyu.springbootmybatisbase.service.UtilService;
import top.huhuiyu.springbootmybatisbase.utils.ImageCode;

/**
 * 
 * @author DarkKnight
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UtilServiceImpl implements UtilService {

  @Override
  public String imageCode(TbToken token) throws Exception {
    String code = ImageCode.makeCode();
    return code;
  }

}
