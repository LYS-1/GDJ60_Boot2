package com.iu.base.board;

import java.util.List;

import com.iu.base.board.qna.QnaVO;
import com.iu.base.util.Pager;

public interface BoardDAO {
	
//		//글개수
		public Long getTotalCount(Pager pager) throws Exception;
	
//글리스트
		public  List<BoardVO> getList(Pager pager) throws Exception;
	
//		//글하나 
		public BoardVO getDetail (BoardVO boardVO) throws Exception;
	
//	    //글쓰기
		public int setBoard(BoardVO boardVO) throws Exception;
//		
//		//글작성
		public int setUpdate(BoardVO boardVO) throws Exception;
		
		//글작성
		public int setInsert(BoardVO boardVO) throws Exception;
		
		//글삭제
		public int setDelete(BoardVO boardVO) throws Exception;
		
		public BoardFileVO getFileDetail (BoardFileVO boarFileVO) throws Exception;
		
		public int setFileInsert(BoardFileVO boardFileVO) throws Exception;
		
		
		
		
}