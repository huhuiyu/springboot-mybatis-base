package top.huhuiyu.springbootmybatisbase.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import top.huhuiyu.springbootmybatisbase.service.ScheduleTaskService;

/**
 * -计划任务
 *
 * @author DarkKnight
 *
 */
@Component
public class ScheduleTask {

  private static final Logger log = LoggerFactory.getLogger(ScheduleTask.class);

  @Autowired
  private ScheduleTaskService scheduleTaskService;

  /**
   * 定时删除过期token
   */
  @Scheduled(initialDelay = 3 * 1000, fixedDelay = 5 * 60 * 1000)
  public void deleteTokens() {
    log.debug("删除过期token");
    try {
      // TODO 需要删除token相关信息
      int result = scheduleTaskService.deleteTokens();
      log.debug("删除过期token数量：" + result);
    } catch (Exception ex) {
      log.error("删除过期token发生错误。", ex);
    }
  }

}
