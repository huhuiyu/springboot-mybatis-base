package top.huhuiyu.springbootmybatisbase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.huhuiyu.springbootmybatisbase.dao.TbTokenInfoDAO;
import top.huhuiyu.springbootmybatisbase.dao.TbUserDAO;
import top.huhuiyu.springbootmybatisbase.entity.TbTokenInfo;
import top.huhuiyu.springbootmybatisbase.entity.TbUser;
import top.huhuiyu.springbootmybatisbase.exception.AppException;
import top.huhuiyu.springbootmybatisbase.model.UserModel;
import top.huhuiyu.springbootmybatisbase.service.UserService;
import top.huhuiyu.springbootmybatisbase.utils.JsonMessage;
import top.huhuiyu.springbootmybatisbase.utils.MyUtils;

/**
 *
 * @author DarkKnight
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
  @Autowired
  private TbUserDAO tbUserDAO;
  @Autowired
  private TbTokenInfoDAO tbTokenInfoDAO;

  @Override
  public JsonMessage login(UserModel model) throws Exception {
    TbUser user = model.getUser();
    if (MyUtils.isEmpty(user.getUsername())) {
      return JsonMessage.getFail("用户名必须填写");
    }
    if (MyUtils.isEmpty(user.getPassword())) {
      return JsonMessage.getFail("密码必须填写");
    }
    TbUser suser = tbUserDAO.queryByName(user);
    if (suser == null) {
      return JsonMessage.getFail("用户不存在");
    }
    if (!suser.getPassword().equalsIgnoreCase(user.getPassword())) {
      return JsonMessage.getFail("密码不正确");
    }
    TbTokenInfo info = tbTokenInfoDAO.queryUserByToken(model.makeTbTokenInfo());
    int result;
    if (info == null) {
      info = model.makeTbTokenInfo();
      info.setInfo(suser.getUid() + "");
      result = tbTokenInfoDAO.addUser(info);
    } else {
      info.setInfo(suser.getUid() + "");
      result = tbTokenInfoDAO.updateUser(info);
    }
    if (result != 1) {
      throw AppException.getAppException(500, "登录异常，请稍后重试");
    }
    return JsonMessage.getSuccess("登录成功");
  }

  @Override
  public JsonMessage logout(UserModel model) throws Exception {
    tbTokenInfoDAO.deleteUser(model.makeTbTokenInfo());
    return JsonMessage.getSuccess("安全退出成功");
  }

  @Override
  public JsonMessage queryUserInfo(UserModel model) throws Exception {
    TbUser user = tbUserDAO.queryByToken(model.makeTbToken());
    if (user != null) {
      user.setUid(null);
    }
    JsonMessage message = JsonMessage.getSuccess("");
    message.getDatas().put("user", user);
    return message;
  }
}
