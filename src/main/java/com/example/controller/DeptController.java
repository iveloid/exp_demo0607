package com.example.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.po.MyDept;
import com.example.service.DeptService;
@Transactional
@Controller
public class DeptController {

	@Autowired
	private DeptService deptService;

	Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping("select.action")
	public String select(HttpServletRequest req,Map<String, Object> map) {
		List<MyDept> deptlist = deptService.selectDepts();
		map.put("deptlist", deptlist);
		System.out.println(deptlist);
		return "success";
	}
	
	
	@RequestMapping("select1.action")
	public String select1(HttpServletRequest req,Map<String, Object> map) {
		String deptid = req.getParameter("deptid");
		MyDept dept = deptService.selectDept(deptid);

		System.out.println(dept);
		map.put("dept", dept);
		return "success";
	}
	
	@RequestMapping("/log.action")
	@ResponseBody
	public String log() {
		// 日志的级别：由低到高，trace<debug<info<warn<error
		// 可以调整输出的日志级别，日志就只会在这个级别及以后的高级别生效
		logger.trace("这是trace日志...");
		logger.debug("这是debug日志...");
		// SpringBoot默认使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别：root级别
		logger.info("这是info日志...");
		logger.warn("这是warn日志...");
		logger.error("这是error日志...");
		
		return "hello";
	}
	
	
	@RequestMapping("insert.action")
	public String insert(HttpServletRequest req,Map<String, Object> map) {
		MyDept dept = new MyDept();
		dept.setDepartment_id(req.getParameter("deptid"));
		dept.setDepartment_name(req.getParameter("deptname"));
		dept.setManager_id(req.getParameter("managerid"));
		dept.setLocation_id(req.getParameter("locationid"));
		int i;
		try {
			System.out.println(dept.getDepartment_id());
			i = deptService.insertDept(dept);
			if (i > 0) {
				map.put("msg", "insert success");
			} else {
				map.put("msg", "insert error");	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("msg", "insert error");
			return "index";
		}
		
		return "index";
	}
}
