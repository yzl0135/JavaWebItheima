package Test;

import Test.utils.JDBCUtils;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
//① 定义一个类，实现DataSource 接口。
//② 定义一个容器，用于保存多个Connection 连接对象。
//③ 定义静态代码块，通过JDBC 工具类获取 10 个连接保存到容器中。
//④ 重写 getConnection 方法，从容器中获取一个连接并返回。
//⑤ 定义 getSize 方法，用于获取容器的大小并返回。

public class DataSource_Test implements DataSource {
    private static List<Connection> pool=Collections.synchronizedList(new ArrayList<>());

    static{
        for (int i = 0; i < 10; i++) {
            Connection con = JDBCUtils.getConnection();
            pool.add(con);
        }
    }
    @Override
    public Connection getConnection() throws SQLException {
        if(pool.size()>0){
            Connection con = pool.remove(0);
            return con;
        }else{
            return null;
        }

    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
