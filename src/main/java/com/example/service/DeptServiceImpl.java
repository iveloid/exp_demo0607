package com.example.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.DeptDao;
import com.example.po.MyDept;
import org.springframework.transaction.annotation.Transactional;

@Service("deptService")
//@Transactional
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDao deptDao;

	public List<MyDept> selectDepts() {
		// TODO Auto-generated method stub
		return deptDao.selectDepts();
	}

	@Override
	public MyDept selectDept(String deptid) {
		// TODO Auto-generated method stub
		return deptDao.selectDeptByDeptid(deptid);
	}
	
	public int insertDept(MyDept dept) throws SQLException {
		return deptDao.insertDept(dept);		
	}

}
