package Test.test01;

import Test.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSourceTest_01t {
    public static void main(String[] args) {
        DataSourceTest_01 dt=null;
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            dt=new DataSourceTest_01();
            System.out.println("连接之前的数量为"+dt.getSize());
            con = dt.getConnection();
            String sql="SELECT * FROM student";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t"+rs.getInt("age")+"\t"+rs.getDate("birthday"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con,ps);
            System.out.println("连接之后的数量为:"+dt.getSize());
        }

    }
}
