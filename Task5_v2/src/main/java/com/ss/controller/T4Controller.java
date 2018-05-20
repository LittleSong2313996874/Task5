package com.ss.controller;


import com.ss.Dao.VocationDao;
import com.ss.pojo.Student;
import com.ss.pojo.Vocation;
import com.ss.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.*;

@Controller

public class T4Controller {




    public T4Controller() {
       logger.info("创建了UserController对象");
    }

    Logger logger = LoggerFactory.getLogger(T4Controller.class);

    @Resource
    StudentService stuService; //这个名字要和刚才注入式给的一样

    @Resource
    VocationDao vocationDao;


    @RequestMapping(value = "/u/thehome", method = RequestMethod.GET)
    public String getHome( Model model)throws Exception{

        List<Student> list = new ArrayList<Student>();
        int workSize = stuService.onWorkSize();
        int count = stuService.getSize();

        for (int i = 0; i < 4; i++) {
            int randomStu = (int) ( ( Math.random() * (count-1) ) + 1 );
            Student student = stuService.findById(randomStu);
            list.add(student);
        }

        model.addAttribute("listBean",list);
        model.addAttribute("workSize",workSize);
        model.addAttribute("allCount",count);

        return "home";

    }
    @RequestMapping(value = "/allvocation", method = RequestMethod.GET)
    public String getVocation( Model model)throws Exception{

        List<Vocation> list = new ArrayList<Vocation>();

        for (int i = 1; i < 6; i++) {
            Vocation vocation = vocationDao.findById(i);
            int sum = stuService.countByVocation(i);
            vocation.setNumber(sum);
            //logger.info(vocation+"");
            list.add(vocation);
        }

        model.addAttribute("vocationList",list);

        return "home.vocation";

    }

    @RequestMapping(value = "/co-company", method = RequestMethod.GET)
    public String getCompany( Model model)throws Exception{

        return "home.company";

    }

    // 这个是任务二 人员列表的入口
    @RequestMapping(value = "/taskUser", method = RequestMethod.GET)
    public String welcome( Model model)throws Exception{

        return "welcome";
    }


}
