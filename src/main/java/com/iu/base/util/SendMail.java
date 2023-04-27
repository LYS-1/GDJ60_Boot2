package com.iu.base.util;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.MimeMessage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.iu.base.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SendMail {
     
    @Autowired
    private JavaMailSender javaMailSender;

    public int sendMail(List<MemberVO> memberList, int ch) {
        
        // 수신 대상을 담을 ArrayList 생성
//		ArrayList<String> toUserList = new ArrayList<>();
//        
//		toUserList.add("gdaduql@gmail.com");
		
        // 수신 대상 추가
        for(MemberVO vo : memberList) {
        	MimeMessage message = javaMailSender.createMimeMessage();

            try{
                MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
                
                // 1. 메일 수신자 설정
                messageHelper.setTo("gdaduql@gmail.com");
                

                // 2. 메일 제목 설정
                messageHelper.setSubject("Happy Birthday! " + vo.getName());

                // 3. 메일 내용 설정
                // HTML 적용됨
                String content = "Happy Birthday! " + vo.getName() + "<b>Happy Birthday!</b>";
                messageHelper.setText(content,true);

                // 4. 메일 전송
                javaMailSender.send(message);
            } catch(Exception e){
                log.error(e.toString());
            }
        }
        
//        // 수신 대상 개수
//        int toUserSize = toUserList.size();
//        
//        // SimpleMailMessage (단순 텍스트 구성 메일 메시지 생성할 때 이용)
//        SimpleMailMessage simpleMessage = new SimpleMailMessage();
//        
//        // 수신자 설정
//        simpleMessage.setTo((String[]) toUserList.toArray(new String[toUserSize]));
//        
//        // 메일 제목
//        simpleMessage.setSubject("Happy Birthday");
//        
//        // 메일 내용
//        simpleMessage.setText("Text Sample");
//        
//        // 메일 발송
//        javaMailSender.send(simpleMessage);
        
        return 1;
    }
}