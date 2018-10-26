package top.huhuiyu.springbootmybatisbase.model;

import top.huhuiyu.springbootmybatisbase.base.BaseModel;

/**
 * -首页model
 *
 * @author DarkKnight
 *
 */
public class IndexModel extends BaseModel {
  private static final long serialVersionUID = 7552454824988006531L;

  private String echo;

  public IndexModel() {
  }

  public String getEcho() {
    return echo;
  }

  public void setEcho(String echo) {
    this.echo = echo;
  }

}
