package Test;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/ServletDemo6")
public class ServletDemo6 extends HttpServlet
{
    /*通过反射的方式动态地获取用户输入地值并进行封装*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student stu = new Student();
        //获取name与用户输入值，并通过反射进行封装
        Map<String, String[]> map = req.getParameterMap();

        for (String name : map.keySet()) {
            String[] value = map.get(name);
            System.out.println(name);
            System.out.println(Arrays.toString(value));
            System.out.println(value);
            System.out.println("length:"+value.length);
            try {
//                [name=hobby; propertyType=class
//                [Ljava.lang.String;; readMethod=public java.lang.String[] Test.Student.getHobby();
//                writeMethod=public void Test.Student.setHobby(java.lang.String[])]
//                [name=hobby; propertyType=class
//                [Ljava.lang.String;; readMethod=public java.lang.String[] Test.Student.getHobby();
//                writeMethod=public void Test.Student.setHobby(java.lang.String[])]
                PropertyDescriptor pd = new PropertyDescriptor(name,stu.getClass());
                System.out.println(pd);
                Method method = pd.getWriteMethod();
                System.out.println(method);
                System.out.println("----------");
                if(value.length>1)
                {
                    method.invoke(stu,(Object) value);
                }
                else
                {
                    method.invoke(stu, value);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //将封装后的数据进行打印
        System.out.println(stu);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}