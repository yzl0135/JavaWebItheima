package Test.test04;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.itheima.utils.DataSourceUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/*
    1.通过Properties集合，加载配置文件
    2.通过Druid连接池工厂类获取数据库连接池对象
    3.通过连接池对象获取数据库连接进行使用
 */
public class DruidTest01 {
    public static void main(String[] args) throws Exception {
        InputStream is = DruidTest01.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties prop=new Properties();
        prop.load(is);
        DataSource ds = DruidDataSourceFactory.createDataSource(prop);
        Connection con = ds.getConnection();
        String sql="SELECT * FROM student";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getInt("age") + "\t" + rs.getDate("birthday"));
        }
        DataSourceUtils.close(con,ps,rs);
    }
}
