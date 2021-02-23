package Test.service.serviceimpl;

import Test.dao.StudentDao;
import Test.dao.daoimpl.StudentDaoImpl;
import Test.domain.Student;
import Test.service.StudentService;

import java.util.ArrayList;

public class StudentServiceImpl implements StudentService {
    private StudentDao sd=new StudentDaoImpl();
    @Override
    public ArrayList<Student> findAll() {
        return sd.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return sd.findById(id);
    }

    @Override
    public int insert(Student stu) {
        return sd.insert(stu);
    }

    @Override
    public int update(Student stu) {
        return sd.update(stu);
    }

    @Override
    public int delete(Integer id) {
        return sd.delete(id);
    }
}
