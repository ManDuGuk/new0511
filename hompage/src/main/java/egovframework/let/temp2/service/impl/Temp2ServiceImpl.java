package egovframework.let.temp2.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import egovframework.com.cmm.service.EgovFileMngService;
import egovframework.com.cmm.service.FileVO;
import egovframework.let.cop.bbs.service.Board;
import egovframework.let.cop.bbs.service.BoardVO;
import egovframework.let.cop.bbs.service.EgovBBSManageService;

import egovframework.let.temp2.service.Temp2Service;
import egovframework.let.temp2.service.Temp2VO;
import egovframework.let.utl.fcc.service.EgovDateUtil;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


@Service("temp2Service")
public class Temp2ServiceImpl extends EgovAbstractServiceImpl
implements Temp2Service {

	@Resource(name ="temp2Mapper")
	private Temp2Mapper temp2Mapper;
//	context-idgen에 정의되있는 정보를 연결해준다.
	@Resource(name ="egovTempIdGnrService")
	private EgovIdGnrService idgenService;
	
	@Override
	public Temp2VO selectTemp(Temp2VO vo)	throws Exception{
		return temp2Mapper.selectTemp(vo);
	}
	
	public List<EgovMap> selectTempList(Temp2VO vo) throws Exception{
		return temp2Mapper.selectTempList(vo);
	}
	
	//임플에서 만들어준 이유는 정보의 처리중 에러가 났을 때 해당 과정을 임플전으로 롤백 해주기 때문에 그렇다.
	//컨트롤러에서 이 작업을 할시 과정이 그대로 정지가 되기때문에 다시 정보를 받아오게 되면 중복이 되어 오류가 나버린다.
	public String insertTemp(Temp2VO vo) throws Exception{
		String id=idgenService.getNextStringId();
		vo.setTempId(id);
		temp2Mapper.insertTemp(vo);
		return id;
	}
	
	public void updateTemp(Temp2VO vo) throws Exception{
		temp2Mapper.updateTemp(vo);
		
	}
	
	public void deleteTemp(Temp2VO vo) throws Exception{
		temp2Mapper.deleteTemp(vo);
		
	}
	
	public int selectTempListCnt(Temp2VO vo) throws Exception{
		return temp2Mapper.selectTempListCnt(vo);
		
	}
	
//	@Override
//	public TempVO selectTemp(TempVO vo)	throws Exception{
//		return tempDAO.selectTemp(vo);
//	}
	
	
   
}
