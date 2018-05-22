package com.ss.service;

import com.ss.pojo.Student;

import java.util.List;

public interface StudentService {

  /*  public void add(Student student);

    public List<Student> findAll();

    public void update(Student student) ;

    public void delete(Student student);

    void findByName(String name) ;
*/

    int getSize();

    //注意这里只有一个参数，则#{}中的标识符可以任意取
    public Student findById(int l);

    int onWorkSize() ;

    int countByVocation(int i);
}
