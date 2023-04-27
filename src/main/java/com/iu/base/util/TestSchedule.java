package com.iu.base.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.iu.base.board.BoardVO;
import com.iu.base.board.notice.NoticeDAO;
import com.iu.base.member.MemberDAO;
import com.iu.base.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TestSchedule {
	
	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private SendMail sm;
	
	private int ch = 0;
	
	@Scheduled(cron = "*/10 * * * * *")
	public void test() throws Exception{
		
		memberDAO.setEnable1();
		log.error("cheked");
		
		List<MemberVO> birthList = memberDAO.getBirthDayMember();
		
		String NameList = "";
		
		for(int i = 0; i < birthList.size(); i ++) {
			if(i == 0) {
				NameList = NameList + birthList.get(i).getName();
			}else {				
				NameList = NameList + ", " + birthList.get(i).getName();
			}
		}
		
		long birthCount = noticeDAO.getBirthDayCount();
		
		if(birthCount == 0) {			
			BoardVO boardVO = new BoardVO();
			boardVO.setContents("Happy Birth Day <br><br>" + NameList);
			boardVO.setWriter("Manager");
			boardVO.setTitle("Happy BirthDay");
			
			noticeDAO.setInsert(boardVO);
		}
		
		if(ch == 0) {
			ch = sm.sendMail(birthList, ch);
		}
		
		
//		List<MemberVO> mv = memberDAO.getIdList();
		
//		for(MemberVO m : mv) {
//			
//			long checkDate = memberDAO.checkLastDate(m);
//			
//			if(checkDate >= 3l) {
//				log.error("CHECK DATE = {}", checkDate);
//				memberDAO.setEnable(m);
//			}
//			log.error("cheked");
//		}
		
	}
}