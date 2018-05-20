package com.ss.Dao;

import com.ss.pojo.PageBean;
import com.ss.pojo.Person;

import java.util.HashMap;
import java.util.List;

//@Repository  在SPRING.XML中通过MapperScannerConfigurer已经将dao接口扫描了进来，所以这里不需要在添加注解了。
public interface PersonDao {


    int addPerson(Person person);//boolean

    int updatePerson(Person user);

    int deletePerson(int id);

    List<Person> findByPage(HashMap<String, Object> map);

    List<Person> getAll();

    Person getPersonById(int id);

    int seleteCount();
}






