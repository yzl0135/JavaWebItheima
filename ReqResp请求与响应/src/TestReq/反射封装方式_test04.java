package TestReq;

import 案例.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

@WebServlet("/fs")
public class 反射封装方式_test04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        Student s=new Student();
        for (String s1 : parameterMap.keySet()) {
            String[] value = parameterMap.get(s1);
            //2.2获取Student对象的属性描述器
            try {
                PropertyDescriptor pd = new PropertyDescriptor(s1, s.getClass());
                //2.3获取对应的setXxx方法
                Method writeMethod = pd.getWriteMethod();
                if(value.length > 1) {
                    writeMethod.invoke(s,value);
                }else {
                    writeMethod.invoke(s,value);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(s);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
