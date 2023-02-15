package com.my.app.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.my.app.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Resource
	private BoardDAO boardDAO;
	
	@Override
	public List<HashMap<String, String>> selectBoardList(HashMap<String, String> paramMap) throws Exception {
		
		return boardDAO.selectStudentList(paramMap);
	}

	@Override
	public List<HashMap<String, String>> selectEnrolmentList(HashMap<String, String> paramMap) throws Exception {
		
		return boardDAO.selectEnrolmentList(paramMap);
	}
	
	@Override
	public List<HashMap<String, String>> selectLectureList(HashMap<String, String> paramMap) throws Exception {
		
		return boardDAO.selectLectureList(paramMap);
	}

	@Override
	public String insertEnrolment(HashMap<String, String> paramMap) throws Exception {
		return boardDAO.insertEnrolment(paramMap);
	}

}
