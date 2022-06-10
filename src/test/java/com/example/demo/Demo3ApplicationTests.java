package com.example.demo;

import com.example.dao.DeptDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo3ApplicationTests {

    @Autowired
    public DeptDao deptDao;

    @Test
    void contextLoads() {
        System.out.println(deptDao.selectDeptByDeptid("190"));
    }

}
