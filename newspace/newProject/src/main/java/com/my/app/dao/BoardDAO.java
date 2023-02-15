package com.my.app.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

	@Inject
	private SqlSession sqlSession;
	
	public List<HashMap<String, String>> selectStudentList(HashMap<String, String> paramMap) throws Exception {
		return sqlSession.selectList("board.selectStudentList", paramMap);
	}
	
	public List<HashMap<String, String>> selectEnrolmentList(HashMap<String, String> paramMap) throws Exception {
		return sqlSession.selectList("board.selectEnrolmentList", paramMap);
	}
	
	public List<HashMap<String, String>> selectLectureList(HashMap<String, String> paramMap) throws Exception {
		return sqlSession.selectList("board.selectLectureList", paramMap);
	}
	
	public String insertEnrolment(HashMap<String, String> paramMap) throws Exception {
		return sqlSession.insert("board.insertEnrolment", paramMap)  + "";
	}
}
