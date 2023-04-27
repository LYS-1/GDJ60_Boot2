package com.iu.base.member;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAO {
	
	public MemberVO getLogin(MemberVO memberVO) throws Exception;
	
	public String getCheckId(MemberVO memberVO) throws Exception;
	
	public int setJoin(MemberVO memberVO) throws Exception;
	
	public int setMemberRole(Map<String, Object> map) throws Exception;

	public List<MemberVO> getIdList() throws Exception;

	public int setMemberInsert(MemberVO memberVO)throws Exception;
	   
	public int setRoleInsert(MemberVO memberVO)throws Exception;
	
	public Long getCheckIdDup(MemberVO memberVO)throws Exception;
	
	public int setLogout(MemberVO memberVO) throws Exception;
	
	public Long checkLastDate(MemberVO memberVO) throws Exception;
	
	public int setEnable(MemberVO memberVO) throws Exception;
	public int setEnable1() throws Exception;
	public List<MemberVO> getBirthDayMember() throws Exception;
}