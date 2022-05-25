package egovframework.let.board.service;

import java.util.List;
import java.util.Map;

import egovframework.let.temp2.service.Temp2VO;
import egovframework.rte.psl.dataaccess.util.EgovMap;


public interface BoardService {
	
	//CRUD 목록 가져오기
//	public List<EgovMap> selectCrudList(BoardVO vo) throws Exception;
//	
//	//CRUD 목록 수
//	public int selectCrudListCnt(BoardVO vo) throws Exception;
//	
//	//CRUD 등록하기
//	public String insertCrud(BoardVO vo) throws Exception;
//	
//	//CRUD 가져오기
//	public BoardVO selectCrud(BoardVO vo) throws Exception;
//	
//	//CRUD 수정하기
//	public void updateCrud(BoardVO vo) throws Exception;
//	
//	//CRUD 삭제하기
//	public void deleteCrud(BoardVO vo) throws Exception;
	
	//board 리스트 목록 가져오기
	public List<EgovMap> selectBoardList(BoardVO vo)throws Exception;
	
	//board 가져오기
	public BoardVO selectBoard(BoardVO vo) throws Exception;
	
	//board 카운트 게시물 목록수
	public int selectBoardListCnt(BoardVO vo)throws Exception;
	
	//board 게시물 등록하기
	public String insertBoard(BoardVO vo) throws Exception;
	
	
	
	
	
	
	
	
	
	
}