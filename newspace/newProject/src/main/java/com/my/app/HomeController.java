package com.my.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.my.app.service.BoardService;
import com.my.app.service.FileService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource
	private BoardService boardService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		request.getParameter("sdfs");
		logger.info("sdfs="+ request.getParameter("sdfs"));
		logger.info("sdfs="+ model.getAttribute("sdfs"));
		logger.info("aa="+ request.getParameter("aa"));
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
			
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@Resource(name = "fileService")
	FileService fileService;
	
	@ResponseBody
	@RequestMapping(value = "/register/action", method = RequestMethod.POST)
	public String boardRegisterAction(MultipartHttpServletRequest multiRequest) {
		
		try {
			fileService.uploadFile(multiRequest);
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("#Exception Message : {}", e.getMessage());
			}
		}
		return "ok";
	}
	
	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(HttpServletRequest request, Locale locale, Model model) {
		
		return "login";
	}
	
	@ResponseBody
	@RequestMapping(value = "/loginProc", method = {RequestMethod.GET, RequestMethod.POST})
	public String loginProc(HttpServletRequest request, HttpSession session, Model model) {
		
		String studentId = request.getParameter("STUDENT_ID");
		//HttpSession session = request.getSession();
		session.setAttribute("STUDENT_ID", studentId);
		return "ok";
	}
	
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public String boardList(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
			
		model.addAttribute("serverTime", formattedDate );
		List<HashMap<String, String>> boardList = null;
		try {
			boardList = boardService.selectBoardList(null);
			logger.info("boardList : " + boardList);
			for(HashMap<String, String> object : boardList) {
				logger.info("object : "+ object);
				logger.info("object STUDENT_NM : "+ object.get("STUDENT_NM"));
				logger.info("object STUDENT_ID: "+ String.valueOf(object.get("STUDENT_ID")));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return "home";
	}
	
	@RequestMapping(value = "/boardListById", method = RequestMethod.GET)
	public String boardListById(HttpServletRequest request, Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		String studentId = request.getParameter("STUDENT_ID");
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
			
		model.addAttribute("serverTime", formattedDate );
		List<HashMap<String, String>> boardList = null;
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("STUDENT_ID", studentId);
		try {
			boardList = boardService.selectBoardList(paramMap);
			model.addAttribute("boardList", boardList);
			logger.info("boardList : " + boardList);
			for(HashMap<String, String> object : boardList) {
				logger.info("object : "+ object);
				logger.info("object STUDENT_NM : "+ object.get("STUDENT_NM"));
				logger.info("object STUDENT_ID: "+ String.valueOf(object.get("STUDENT_ID")));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "home";
	}
	
	@RequestMapping(value = "/enrolmentList", method = RequestMethod.GET)
	public String selectEnrolmentList(HttpServletRequest request, Model model, HttpSession session) {
		
		String studentId = request.getParameter("STUDENT_ID");
		List<HashMap<String, String>> enrolmentList = null;
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("STUDENT_ID", studentId);
		try {
			enrolmentList = boardService.selectEnrolmentList(paramMap);
			model.addAttribute("enrolmentList", enrolmentList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("session", session);
		return "enrolmentList";
	}
	
	@RequestMapping(value = "/enrolmentForm", method = {RequestMethod.GET, RequestMethod.POST})
	public String enrolmentForm(HttpServletRequest request, Model model) {
		
		String studentId = request.getParameter("STUDENT_ID");
		List<HashMap<String, String>> lectureList = null;
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("STUDENT_ID", studentId);
		try {
			lectureList = boardService.selectLectureList(paramMap);
			model.addAttribute("lectureList", lectureList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "enrolmentForm";
	}
	
	@ResponseBody
	@RequestMapping(value = "/enrolmentJson", method = {RequestMethod.GET, RequestMethod.POST})
	public Object enrolmentJson(HttpServletRequest request, Model model) {
		
		String studentId = request.getParameter("STUDENT_ID");
		List<HashMap<String, String>> lectureList = null;
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("STUDENT_ID", studentId);
		try {
			lectureList = boardService.selectLectureList(paramMap);
			//model.addAttribute("lectureList", lectureList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lectureList;
	}
	
	@ResponseBody
	@RequestMapping(value = "/insertEnrolment", method = {RequestMethod.GET, RequestMethod.POST})
	public Object insertEnrolment(HttpServletRequest request, Model model) {
		
		String studentId = request.getParameter("STUDENT_ID");
		String psId = request.getParameter("PS_ID");
		String lectureCnt = "";
		HashMap<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("STUDENT_ID", studentId);
		paramMap.put("PS_ID", psId);
		try {
			lectureCnt = boardService.insertEnrolment(paramMap);
			//model.addAttribute("lectureList", lectureList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lectureCnt;
	}
	
}
