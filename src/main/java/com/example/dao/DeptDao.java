package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.po.MyDept;

@Component
@Mapper
public interface DeptDao {

	@Select("select * from departments")
	//@ResultType("com.example.po.MyDept")
	public List<MyDept> selectDepts();

	@Select("select * from departments where department_id=#{id}")
	public MyDept selectDeptByDeptid(@Param("id") String deptid);


	@Insert("insert into departments(department_id,department_name,manager_id,location_id)" +
			" values(#{department_id},#{department_name},#{manager_id},#{location_id})")
	public int insertDept(MyDept dept) throws SQLException;
}
/*
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!-- com.dao.UserDao对应Dao接口 -->
<mapper namespace="com.example.dao.DeptDao">
	<!-- 查询用户信息 -->
	<select id="selectDepts"  resultType="com.example.po.MyDept" >
		select * from departments
	</select>


	<select id="selectDeptByDeptid" parameterType="java.lang.String" resultType="com.example.po.MyDept" >
		select * from departments where department_id = #{id}
		@Select("select * from departments where department_id = #{id}")

	</select>

	<insert id="insertDept" parameterType="com.example.po.MyDept" >
	    insert into departments(department_id,department_name,manager_id,location_id) values(#{department_id},#{department_name},#{manager_id},#{location_id})
	</insert>
<!--
	<update id="">
	</update>

	<delete id="">
	</delete> -->
</mapper>
* */
