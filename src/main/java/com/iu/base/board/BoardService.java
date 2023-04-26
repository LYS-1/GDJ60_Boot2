package com.iu.base.board;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.base.board.qna.QnaVO;
import com.iu.base.util.Pager;

@Service
public interface BoardService {
//	//글리스트
	public  List<BoardVO> getList(Pager pager) throws Exception;
//
//	//글하나 
	public BoardVO getDetail (BoardVO boardVO) throws Exception;

//    //글쓰기
	public int setBoard(BoardVO boardVO) throws Exception;
//	
//	//글작성
	public int setUpdate(BoardVO boardVO) throws Exception;
	
	//글작성
	public int setInsert(BoardVO boardVO, MultipartFile[] multipartFiles) throws Exception;
	
//	//글삭제
	public int setDelete(BoardVO boardVO) throws Exception;
	
	public BoardFileVO getFileDetail (BoardFileVO boardFileVO) throws Exception;
	

	
	
	
	
	
}