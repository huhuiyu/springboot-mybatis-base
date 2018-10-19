package top.huhuiyu.springbootmybatisbase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.huhuiyu.springbootmybatisbase.dao.TbTokenDAO;
import top.huhuiyu.springbootmybatisbase.service.ScheduleTaskService;

/**
 * 
 * @author DarkKnight
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ScheduleTaskServiceImpl implements ScheduleTaskService {
  @Autowired
  private TbTokenDAO tbTokenDAO;

  @Override
  public int deleteTokens() throws Exception {
    return tbTokenDAO.deleteTokens();
  }

}
