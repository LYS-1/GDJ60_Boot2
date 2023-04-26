package com.iu.base.board.qna;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.iu.base.board.BoardFileVO;
import com.iu.base.board.BoardService;
import com.iu.base.board.BoardVO;
import com.iu.base.util.FileManager;
import com.iu.base.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class QnaService implements BoardService{
	
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Value("${app.upload.qna}")
	private String path;
	
	@Autowired
	private FileManager fileManager;
	
	@Override
	public int setUpdate(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	public int setInsert(QnaVO qnaVO ,MultipartFile[] multipartFiles) throws Exception {
		// TODO Auto-generated method stub
		
		int result = qnaDAO.setInsert(qnaVO);
        result = qnaDAO.setInsertUp(qnaVO);
		if(multipartFiles != null) {
			for(MultipartFile multipartFile : multipartFiles) {
				//비어있다면 
				// multipartFile.getSize() !=0
				if(!multipartFile.isEmpty()) {
					String fileName = fileManager.saveFile(path, multipartFile);
					BoardFileVO boardFileVO = new BoardFileVO();
					boardFileVO.setFileName(fileName);
					boardFileVO.setOriName(multipartFile.getOriginalFilename());
					boardFileVO.setNum(qnaVO.getNum());
					log.error("fileName : {}",fileName);
					
					result = qnaDAO.setFileInsert(boardFileVO);
					
				}
			}
		}
		
		return result; //noticeDAO.setInsert(boardVO);
	}

	@Override
	public int setDelete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	

	
	public List<BoardVO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		pager.makeStartRow();
		pager.makeNum(qnaDAO.getTotalCount(pager));
		return qnaDAO.getList(pager);
	}

	
	public BoardVO getDetail(QnaVO qnaVO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getDetail(qnaVO);
	}

	@Override
	public int setBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardFileVO getFileDetail(BoardFileVO boardFileVO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.getFileDetail(boardFileVO);
	}

	@Override
	public int setInsert(BoardVO boardVO, MultipartFile[] multipartFiles) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardVO getDetail(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}




}