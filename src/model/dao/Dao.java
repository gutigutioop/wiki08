package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import constants.Const;

/**
 * Daoクラス - 各daoの基底クラス
 * データベースへの接続、切断、クエリ実行など各dao共通の機能を実装する
 * @author　Say Consulting Group
 * @version　1.0.0
 */
public class Dao {

  /** DB接続オブジェクト */
  protected Connection con;
  /** SQL実行用オブジェクト */
  protected PreparedStatement stm;
  /** 対象テーブル物理名 */
  protected String table; 
  
  /**
   * コンストラクタ
   * DB接続用のフィールドを初期化する
   */
  public Dao() {
    this.con = null;
    this.stm = null;
  }

  /**
   * データベースへの接続を開始する
   */
  public void open() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      this.con = DriverManager.getConnection(Const.DB_URI, Const.DB_USER, Const.DB_PASS);
      System.out.println("データベースへの接続に成功しました。");
    } catch (SQLException e) {
      System.err.println("データベースへの接続に失敗しました。");
      System.err.println(e);
    } catch (ClassNotFoundException e) {
      System.err.println(e);
    }
  }

  /**
   * DBとの接続を切断する
   * 各オブジェクトを再初期化する
   */
  public void close() {
    try {
      if (this.stm != null) {
        this.stm.close();
        this.stm = null;
      }
      if (this.con != null) {
        this.con.close();
        this.con = null;
      }
      System.out.println("データベース接続の切断に成功しました。");
    } catch (SQLException e) {
      System.err.println("データベース接続の切断に失敗しました。");
      System.err.println(e);
    }
  }
}
