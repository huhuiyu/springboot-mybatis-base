package top.huhuiyu.springbootmybatisbase.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import top.huhuiyu.springbootmybatisbase.entity.JsonMessage;
import top.huhuiyu.springbootmybatisbase.entity.TbToken;
import top.huhuiyu.springbootmybatisbase.model.BaseModel;
import top.huhuiyu.springbootmybatisbase.service.AopService;

/**
 * 控制器token处理
 * 
 * @author DarkKnight
 *
 */
@Aspect
@Component
public class ControllerToken extends BaseAop {
  @Autowired
  private AopService aopService;

  @Around("controllerPointcut()")
  public Object token(ProceedingJoinPoint pjp) throws Throwable {
    TbToken token = null;
    BaseModel model = null;
    Object result = null;
    // 校验是否存在BaseModel参数
    boolean haveBaseModel = false;
    Object[] args = pjp.getArgs();
    for (Object arg : args) {
      if (arg instanceof BaseModel) {
        // 获取客户端token
        haveBaseModel = true;
        model = (BaseModel) arg;
        token = model.makeTokenInfo();
        break;
      }
    }
    // 处理token信息更新
    token = aopService.createOrUpdateToken(token);
    if (haveBaseModel) {
      // 更新model中的token信息
      model.setToken(token.getToken());
    }
    // 处理业务逻辑
    result = pjp.proceed();
    // 回发token信息
    if (result instanceof JsonMessage) {
      JsonMessage json = (JsonMessage) result;
      json.setToken(token.getToken());
    }
    return result;
  }

}
