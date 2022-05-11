package egovframework.let.temp.service.impl;
import java.util.Iterator;
import java.util.List;

import egovframework.let.cop.bbs.service.Board;
import egovframework.let.cop.bbs.service.BoardVO;
import egovframework.let.temp.service.TempVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

import org.springframework.stereotype.Repository;


@Mapper("tempMapper")
public interface TempMapper {
	//임시데이터 가져오기
	TempVO selectTemp(TempVO vo)throws Exception;
	//임시데이터 목록 가져오기
	List<EgovMap> selectTempList(TempVO vo) throws Exception;
	
	void insertTemp(TempVO vo) throws Exception;
	
	void updateTemp(TempVO vo) throws Exception;
	
	void deleteTemp(TempVO vo) throws Exception;
	
	int selectTempListCnt(TempVO vo) throws Exception;
}

