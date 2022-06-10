package com.example.service;

import java.sql.SQLException;
import java.util.List;

import com.example.po.MyDept;

public interface DeptService {
	public List<MyDept> selectDepts();
	
	public MyDept selectDept(String deptid);
	
	public int insertDept(MyDept dept) throws SQLException;
}
