package com.ss.service;

import com.ss.Dao.VocationDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class StudentServiceTest {

    @Resource
    StudentService stuService;
    @Resource
    VocationDao vocationDao;
    @Test
    public void getSize() {
        //int size =studentService.getSize();
        //System.out.println(size);
    }

    @Test
    public void findById() {


        //System.out.println(studentService.findById(2));
    }

    @Test
    public void onWorkSize() {
        System.out.println(stuService.onWorkSize());
    }


    @Test
    public void findByIdVoca() {

        System.out.println(vocationDao.findById(2));
    }


}