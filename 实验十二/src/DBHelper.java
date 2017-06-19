import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Created by benjaminzhang on 18/06/2017.
 * Copyright © benjaminzhang 2017.
 */
public class DBHelper {

    Connection con = null ;
    PreparedStatement ps = null ;
    ResultSet rs = null ;
    String url = "jdbc:mysql://127.0.0.1:3306/Java_Experiment_12_Database?characterEncoding=utf8&useSSL=true" ;
    String user = "root";
    String password = "mysqltest";

    static{
        try {
            Class.forName("com.mysql.jdbc.Driver") ;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * 得到连接
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws SQLException
     */

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, user, password) ;
    }

    /**
     * 查询数据库
     * @param sql
     * @return
     * @throws SQLException
     */
    public ResultSet query(String sql,String[] paras){
        try {
            con = this.getConnection() ;
            ps = con.prepareStatement(sql) ;
            //为问号赋值
            for (int i = 0; i < paras.length; i++) {
                ps.setString(i+1, paras[i]) ;
            }
            rs = ps.executeQuery() ;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs ;

    }
    /**
     * 是查询数据库  没有条件 情况
     * @param sql
     * @return
     */
    public ResultSet query(String sql){
        try {
            con = this.getConnection() ;
            ps = con.prepareStatement(sql) ;
            rs = ps.executeQuery() ;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs ;
    }
    /**
     * 更新操作 增 删 改
     * @throws SQLException
     */
    public boolean update(String sql ,String[] paras){

        boolean b = false ;
        try {
            con = this.getConnection() ;
            ps = con.prepareStatement(sql) ;
            for (int i = 0; i < paras.length; i++) {
                ps.setString(i+1, paras[i]) ;
            }
            System.out.println(sql);
            System.out.println(Arrays.toString(paras));
            //查询
            if(ps.executeUpdate()==1){
                b = true ;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            this.close() ;
        }
        return b ;
    }
    /**
     * 更新操作 增 删 改
     * @throws SQLException
     */
    public boolean update(String sql){

        boolean b = false ;
        try {
            con = this.getConnection() ;
            ps = con.prepareStatement(sql) ;
            //查询
            /*if(ps.executeUpdate()==1){
                b = true ;
            }*/
            ps.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            this.close() ;
        }
        return b ;
    }
    /**
     * 关闭数据库
     */
    public void close(){

        try {
            if(rs!=null)
                rs.close() ;
            if(ps!=null)
                ps.close() ;
            if(con!=null)
                con.close() ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
