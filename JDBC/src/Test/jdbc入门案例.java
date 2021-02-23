package Test;

import Test.utils.JDBCUtils;

import java.sql.*;

//① 导入jar包
//② 注册驱动
//③ 获取数据库连接
//④ 获取执行者对象
//⑤ 执行sql语句并返回结果
//⑥ 处理结果
//⑦ 释放资源
public class jdbc入门案例 {
    public static void main(String[] args) {
        Connection con=null;
        Statement st=null;
        ResultSet rs=null;
        try {
            con = JDBCUtils.getConnection();
            st = con.createStatement();
            String sql="SELECT * FROM user";
            rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getInt("id")+"---"+rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con,st,rs);
        }
    }
}
