package egovframework.let.temp2.service;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.util.EgovMap;


public interface Temp2Service {

	public Temp2VO selectTemp(Temp2VO vo) throws Exception;
	
	public List<EgovMap> selectTempList(Temp2VO vo) throws Exception;
	
	public String insertTemp(Temp2VO vo) throws Exception;

	public void updateTemp(Temp2VO vo) throws Exception;
	
	public void deleteTemp(Temp2VO vo) throws Exception;
	
	public int selectTempListCnt(Temp2VO vo) throws Exception;
}