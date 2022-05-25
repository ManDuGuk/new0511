package egovframework.let.board.service.impl;


import egovframework.let.board.service.BoardService;
import egovframework.let.board.service.BoardVO;
import egovframework.let.crud.service.CrudService;
import egovframework.let.crud.service.CrudVO;
import egovframework.let.temp2.service.Temp2Service;
import egovframework.let.temp2.service.Temp2VO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


@Service("boardService")
public class BoardServiceImpl extends EgovAbstractServiceImpl implements BoardService {

    @Resource(name="boardMapper")
	private BoardMapper boardMapper;
    
    @Resource(name = "egovBoardIdGnrService")
    private EgovIdGnrService idgenService;
    
//    @Resource(name = "egovBoardIdGnrService")
//    private EgovIdGnrService ;
    
	//board 목록 가져오기
	public List<EgovMap> selectBoardList(BoardVO vo) throws Exception {
		return boardMapper.selectBoardList(vo);
	}
	
	//board 목록 수
	public int selectBoardListCnt(BoardVO vo) throws Exception {
		return boardMapper.selectBoardListCnt(vo);
	}
	
	//board 게시물 가져오기
	public BoardVO selectBoard(BoardVO vo) throws Exception{
		return null;
	}
	
	//board 게시물 등록하기
	@Override
	public String insertBoard(BoardVO vo) throws Exception{
		String id=idgenService.getNextStringId();
		vo.setBoardId(id);
		boardMapper.insertBoard(vo);
		
		return id;
	}
	
	//CRUD 등록하기
//	public String insertCrud(CrudVO vo) throws Exception{
//		String id = idgenService.getNextStringId();
//		vo.setCrudId(id);
//		crudMapper.insertCrud(vo);
//		
//		return id;
//	}
//	
//	//CRUD 가져오기
//	public CrudVO selectCrud(CrudVO vo) throws Exception{
//		return crudMapper.selectCrud(vo);
//	}
//	
//	//CRUD 수정하기
//	public void updateCrud(CrudVO vo) throws Exception{
//		crudMapper.updateCrud(vo);
//	}
//	
//	//CRUD 삭제하기
//	public void deleteCrud(CrudVO vo) throws Exception{
//		crudMapper.deleteCrud(vo);
//	}
	
	
}
