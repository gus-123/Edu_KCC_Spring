package kosa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kosa.model.Board;
import kosa.model.BoardDao;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDao dao;
	
	//board_insert => insert_form.jsp 출력
	
	@GetMapping("/board_insert")
	public String board() {
		
		return "insert_form";
	}
	
//	@PostMapping("/board_insert")
//	public String board_insert() {
//		System.out.println("호출");
//		return "redirect:board_list";
//	}
	
	//글 등록버튼 누를시
	//post는 데이터를 받기 위한 방법 중 커맨드 객체로 받음.
	//list의 input안의 name과 변수명 일치해야 됨.
	@PostMapping("/board_insert")
	public String board_insert(Board board) {
//		System.out.println(board);
		dao.insertBoard(board);  //mybatis가 하는 일
		
		return "redirect:board_list";  // 글을 강제적으로 중복한 글을 발생시키지 않기 위해 필요(insert,update,delete시 리다이렉션) -> dispatcher -> controller에 있는지 확인할꺼임
	}
	
	@GetMapping("/board_list")
	public String board_list(Model model) {
		List<Board> list = dao.listBoard();
		model.addAttribute("list", list); // list.jsp의 이이템의 list, board의 list
		
		return "list"; //list.jsp의 list
	}
	
	@GetMapping("/board_detail{seq}")
	public String board_detail(@PathVariable int seq, Model model) {
		Board board = dao.detailBoard(seq);
		model.addAttribute("detail", board); //$의 이름
		return "detail";  //jsp 이름
	}
	
//	@GetMapping("/board_detail")
//	public String board_detail(@RequestParam("seq") int seq, Model model) {
//		Board board = dao.detailBoard(seq);
//		model.addAttribute("detail", board);
//		return "detail";
//	}
	
//	@GetMapping("/board_detail")
//	public ModelAndView board_detail(@RequestParam int seq) {
//		ModelAndView mav = new ModelAndView();
//	    Board board = dao.detailBoard(seq);
//	    mav.addObject("board", board);
//	    mav.setViewName("detail");
//	    return mav;
//	}
	
	// 글 수정
	@GetMapping("/board_update")
	public String board_update(@RequestParam int seq, Model model) {
		Board board = dao.detailBoard(seq);
		model.addAttribute("update", board);
		
		return "updateForm";
	}
	
	@PostMapping("/board_update")
	public String board_update(Board board) {
		dao.updateBoard(board);  
		
		return "redirect:board_list";
	}
	
	// 글 삭제
	@PostMapping("/board_delete")
	public String delete_board(@RequestParam int seq) {
		dao.deleteBoard(seq);
		return "redirect:board_list";	
	}
	
}
