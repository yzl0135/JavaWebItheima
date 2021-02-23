package Test.dao.daoimpl;

import Test.dao.StudentDao;
import Test.domain.Student;
import Test.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StudentDaoImpl implements StudentDao {
    @Override
    public ArrayList<Student> findAll() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        ArrayList<Student> arr = new ArrayList<>();
        try {
            con = JDBCUtils.getConnection();
            st = con.createStatement();
            String sql = "SELECT * FROM student";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Student s = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getDate("birthday"));
                arr.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, st, rs);
        }
        return arr;
    }

    @Override
    public Student findById(Integer id) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        Student s=new Student();
        ArrayList<Student> arr = new ArrayList<>();
        try {
            con = JDBCUtils.getConnection();
            st = con.createStatement();
            String sql = "SELECT * FROM student where id='"+id+"'";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                s.setSid(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAge(rs.getInt("age"));
                s.setBirthday(rs.getDate("birthday"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, st, rs);
        }
        return s;
        }

        @Override
        public int insert (Student stu){
            Connection con = null;
            Statement st = null;
            int num=0;
            try {
                con= Test.utils.JDBCUtils.getConnection();
                st = con.createStatement();
                Integer sid = stu.getSid();
                String name = stu.getName();
                Integer age = stu.getAge();
                Date d = stu.getBirthday();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String birthday = sdf.format(d);
                String sql="insert into student values('"+sid+"','"+name+"','"+age+"','"+birthday+"')";
                num = st.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCUtils.close(con,st);
            }
            return num;
        }

        @Override
        public int update (Student stu){
            Connection con = null;
            Statement st = null;
            int num=0;
            try {
                con= Test.utils.JDBCUtils.getConnection();
                st = con.createStatement();
                Integer sid = stu.getSid();
                String name = stu.getName();
                Integer age = stu.getAge();
                Date birthday = stu.getBirthday();
                String sql="update student set name='"+name+"',age='"+age+"',birthday='"+birthday+"' where id='"+sid+"'";
                num = st.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCUtils.close(con,st);
            }
            return num;
        }

        @Override
        public int delete (Integer id){
            Connection con = null;
            Statement st = null;
            int num=0;
            try {
                con= Test.utils.JDBCUtils.getConnection();
                st = con.createStatement();
                String sql="delete from student where id='"+id+"'";
                num = st.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                JDBCUtils.close(con,st);
            }
            return num;
        }
    }
