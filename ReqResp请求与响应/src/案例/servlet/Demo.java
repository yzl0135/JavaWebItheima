package 案例.servlet;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        AAA aaa = new AAA();
        aaa.setAge(18);
        aaa.setName("廖天浩");
        aaa.setGender("男");
        System.out.println(aaa);
        BBB bbb = new BBB();
        System.out.println(bbb);

        BeanUtils.copyProperties(bbb,aaa);
        System.out.println(bbb);
    }
}

class BBB{
    String name;
    int age;
    String gender;
    String country;

    @Override
    public String toString() {
        return "BBB{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

class AAA{
    String name;
    int age;
    String gender;

    @Override
    public String toString() {
        return "AAA{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}