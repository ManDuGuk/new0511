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

	
	//board 게시물 등록하기
	@Override
	public String insertBoard(BoardVO vo) throws Exception{
		String id=idgenService.getNextStringId();
		vo.setBoardId(id);
		boardMapper.insertBoard(vo);
		
		return id;
	}
	
	//board 게시물 가져오기
	@Override
	public BoardVO selectBoard(BoardVO vo) throws Exception{
		//조회수 업
		//컨트롤에다가 않넣고 여기다가 넣은이유
		//임플을 쓰는 이유를 생각해봐야한다.
		//트랜젝션처리-->임플
		//필기참고
		//컨트롤러에서 구현하면 에러가 날시 롤백이 되지 않는다.
		//임플에서 해당 코드를 구현하면 에러가 날씨 롤백이 되도록 만들어졌기 때문에 롤백되도록 하기 위해 여기에다가 해당 기능을 구현한것이다.
		//특히 이런구조는 쇼핑몰같은 곳에서 자주쓰인다. 에러났는데 주문을 발주되어버리는 대형사고 같은게 나버리면 안되자너
		boardMapper.updateViewCnt(vo);
		
		return boardMapper.selectBoard(vo);
	}

	//board 게시물 수정하기
	@Override
	public void updateBoard(BoardVO vo) throws Exception {
		boardMapper.updateBoard(vo);
		
	}

	//board 게시물 삭제하기
	@Override
	public void deleteBoard(BoardVO vo) throws Exception {
		boardMapper.deleteBoard(vo);
		
	}
	

	
}
