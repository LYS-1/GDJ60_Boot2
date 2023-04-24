package com.iu.base.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	//패스워드가 일치하는지 검증하는 메서드
		public boolean pwCheck(MemberVO memberVO, BindingResult bindingResult) throws Exception{
			boolean result = false;
			//false: 에러가 없음(검증 성공)
			//true: 에러가 존재(검증 실패)
			//1. annotation 검증 결과
			result = bindingResult.hasErrors();
			
			//2. pw가 일치하는지 검증
			if(!memberVO.getPassword().equals(memberVO.getPasswordCheck())) {
				result = true;
				bindingResult.rejectValue("passwordCheck", "member.password.notEqual");
			}
			
			//3. id 중복 검사
			long dup = memberDAO.getCheckIdDup(memberVO);
			if(dup > 0) {
				result = true;
				bindingResult.rejectValue("userName", "member.userName.duplication");
			}
			
			
			return result;
		}
	
	public MemberVO getLogin(MemberVO memberVO) throws Exception{
//		MemberVO loginDTO = MemberDAO.getMemberLogin(memberVO);
//		if(loginDTO!=null &&loginDTO.getUserName().equals(memberVO.getPassword())) {
//			memberVO.setRoleDTO(loginDTO.getRoleDTO());
//			memberVO.setPw(null);
//			return memberVO;
//
//		}
		return memberDAO.getLogin(memberVO);
			
	}
	public long getCheckId(MemberVO memberVO) throws Exception{
		
		String s = memberDAO.getCheckId(memberVO);
		long s1 = Long.parseLong(s);
		
		return s1;
	}
	public int setJoin(MemberVO memberVO) throws Exception{
		int result = memberDAO.setJoin(memberVO);
		Map<String, Object> map = new HashMap<>();
		map.put("userName", memberVO.getUserName());
		map.put("num", 3);
		result = memberDAO.setMemberRole(map);

		return result;
	}
}