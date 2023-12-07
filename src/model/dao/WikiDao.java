package model.dao;

public class WikiDao extends Dao {
  
  /** このDaoが担当するテーブル物理名 */
  private static final String MY_TABLE = "wikis";
  
  /**
   * コンストラクタ
   * 自身が担当するテーブル物理名を設定
   */
  public WikiDao() {
    super();
    this.table = MY_TABLE;
  }
}
