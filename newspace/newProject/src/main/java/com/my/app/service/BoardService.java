package com.my.app.service;

import java.util.HashMap;
import java.util.List;

public interface BoardService {

	List<HashMap<String, String>> selectBoardList(HashMap<String, String> paramMap) throws Exception;
	List<HashMap<String, String>> selectEnrolmentList(HashMap<String, String> paramMap) throws Exception;
	List<HashMap<String, String>> selectLectureList(HashMap<String, String> paramMap) throws Exception;
	String insertEnrolment(HashMap<String, String> paramMap) throws Exception;
}
