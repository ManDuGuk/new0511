package egovframework.let.board.web;

import java.util.List;
import java.util.Map;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.let.board.service.BoardService;
import egovframework.let.board.service.BoardVO;
import egovframework.let.crud.service.CrudService;
import egovframework.let.crud.service.CrudVO;
import egovframework.let.temp.service.TempService;
import egovframework.let.temp.service.TempVO;
import egovframework.let.temp2.service.Temp2Service;
import egovframework.let.temp2.service.Temp2VO;
import egovframework.let.utl.fcc.service.EgovStringUtil;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
public class BoardController {

	
	@Resource(name = "boardService")
    private BoardService boardService;
	
	//게시물 목록 가져오기
	@RequestMapping(value = "/board/selectList.do")
	public String selectList(@ModelAttribute("searchVO") BoardVO searchVO,  
			HttpServletRequest request, ModelMap model) throws Exception{
		
		//공지 게시글
		searchVO.setNoticeAt("Y");
		List<EgovMap> noticeResultList = boardService.selectBoardList(searchVO);
		model.addAttribute("noticeResultList", noticeResultList);
		
		//페이지 네이션		
		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		//여기추가됨
		searchVO.setNoticeAt("N");
		List<EgovMap> resultList = boardService.selectBoardList(searchVO);
		model.addAttribute("resultList", resultList);
		//
		
		int totCnt = boardService.selectBoardListCnt(searchVO);
		
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		//페이지 네이션
		
		//여기추가됨
		LoginVO user=(LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		model.addAttribute("USER_INFO", user);
		//
		
		
		
		
		return "board/BoardSelectList";
	}
	
//	//CRUD 등록/수정
//	@RequestMapping(value = "/crud/crudRegist.do")
//	public String crudRegist(@ModelAttribute("searchVO") CrudVO crudVO, 
//		HttpServletRequest request, ModelMap model) throws Exception{
//		
//		CrudVO result = new CrudVO();
//		if(!EgovStringUtil.isEmpty(crudVO.getCrudId())) {
//			result = crudService.selectCrud(crudVO);
//		}
//		model.addAttribute("result", result);
//		
//		return "crud/CrudRegist";
//	}
//	
//	//CRUD 등록하기
//	@RequestMapping(value = "/crud/insert.do")
//	public String insert(@ModelAttribute("searchVO") CrudVO searchVO, 
//		HttpServletRequest request, ModelMap model) throws Exception{
//		
//		crudService.insertCrud(searchVO);
//		return "forward:/crud/selectList.do";
//	}
//	
//	//CRUD 가져오기
//	@RequestMapping(value = "/crud/select.do")
//	public String select(@ModelAttribute("searchVO") CrudVO searchVO, HttpServletRequest request, ModelMap model) throws Exception{
//		CrudVO result = crudService.selectCrud(searchVO);
//		model.addAttribute("result", result);
//		return "crud/CrudSelect";
//	}
//	
//	//CRUD 수정하기
//	@RequestMapping(value = "/crud/update.do")
//	public String update(@ModelAttribute("searchVO") CrudVO searchVO, 
//			HttpServletRequest request, ModelMap model) throws Exception{
//		
//		crudService.updateCrud(searchVO);
//		return "forward:/crud/selectList.do";
//	}
//	
//	//CRUD 삭제하기
//	@RequestMapping(value = "/crud/delete.do")
//	public String delete(@ModelAttribute("searchVO") CrudVO searchVO, 
//		HttpServletRequest request, ModelMap model) throws Exception{
//		crudService.deleteCrud(searchVO);
//		return "forward:/crud/selectList.do";
//	}
	
	
	
	
	
	
	
}