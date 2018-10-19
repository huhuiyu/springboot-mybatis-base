package top.huhuiyu.springbootmybatisbase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import top.huhuiyu.springbootmybatisbase.dao.TestDAO;
import top.huhuiyu.springbootmybatisbase.entity.JsonMessage;
import top.huhuiyu.springbootmybatisbase.entity.PageBean;
import top.huhuiyu.springbootmybatisbase.entity.TbToken;
import top.huhuiyu.springbootmybatisbase.service.TestService;

/**
 * 
 * @author DarkKnight
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TestServiceImpl implements TestService {
  @Autowired
  private TestDAO testDAO;

  @Override
  public JsonMessage queryTokens(PageBean page) throws Exception {
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbToken> list = (Page<TbToken>) testDAO.queryTokens();
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.put("page", page);
    message.put("list", list);
    return message;
  }

}
