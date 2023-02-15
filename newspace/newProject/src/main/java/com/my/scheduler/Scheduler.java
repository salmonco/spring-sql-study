package com.my.scheduler;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
	
	private static final Logger logger = LoggerFactory.getLogger(Scheduler.class);
	  
	// 10초마다 date를 출력하는 스케쥴러
	@Scheduled(cron = "0 0 * * * ?")
	public void autoUpdate() throws Exception {
		logger.info(new Date() + "스케쥴러 실행");
	}
  
	// 5초마다 date를 출력하는 스케쥴러
//	@Scheduled(cron = "0/5 * * * * ?")
//	public void autoUpdate2() throws Exception {
//		logger.info(new Date() + "스케쥴러 실행2");
//	}
}
