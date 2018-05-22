package com.ss.service.Impl;

import com.ss.Dao.StudentDao;
import com.ss.pojo.Student;
import com.ss.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *  @Service 注解是标注在实现类上的，因为@Service是把spring容器中的bean进行实例化，
 * 也就是等同于new操作，只有实现类是可以进行new实例化的，而接口则不能，所以是加在实现类上的。
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    /** @Resource 默认By name
     *
     * @Autowired   默认 By type, 可以加下面的注解来实现 By name.
     * @Qualifier("studentDao")
     */

    @Resource
    StudentDao studentDao;

    @Override
    public int getSize() {
        return  studentDao.getSize();
    }

    @Override
    public Student findById(int l) {

        return studentDao.findById(l);
    }


    @Override
    public int onWorkSize() {
        return studentDao.onWorkSize();
    }

    @Override
    public int countByVocation(int i) {
        return studentDao.countByVocation(i);
    }
}
