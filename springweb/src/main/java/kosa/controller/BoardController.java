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
	
	//board_insert => insert_form.jsp ���
	
	@GetMapping("/board_insert")
	public String board() {
		
		return "insert_form";
	}
	
//	@PostMapping("/board_insert")
//	public String board_insert() {
//		System.out.println("ȣ��");
//		return "redirect:board_list";
//	}
	
	//�� ��Ϲ�ư ������
	//post�� �����͸� �ޱ� ���� ��� �� Ŀ�ǵ� ��ü�� ����.
	//list�� input���� name�� ������ ��ġ�ؾ� ��.
	@PostMapping("/board_insert")
	public String board_insert(Board board) {
//		System.out.println(board);
		dao.insertBoard(board);  //mybatis�� �ϴ� ��
		
		return "redirect:board_list";  // ���� ���������� �ߺ��� ���� �߻���Ű�� �ʱ� ���� �ʿ�(insert,update,delete�� �����̷���) -> dispatcher -> controller�� �ִ��� Ȯ���Ҳ���
	}
	
	@GetMapping("/board_list")
	public String board_list(Model model) {
		List<Board> list = dao.listBoard();
		model.addAttribute("list", list); // list.jsp�� �������� list, board�� list
		
		return "list"; //list.jsp�� list
	}
	
	@GetMapping("/board_detail{seq}")
	public String board_detail(@PathVariable int seq, Model model) {
		Board board = dao.detailBoard(seq);
		model.addAttribute("detail", board); //$�� �̸�
		return "detail";  //jsp �̸�
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
	
	// �� ����
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
	
	// �� ����
	@PostMapping("/board_delete")
	public String delete_board(@RequestParam int seq) {
		dao.deleteBoard(seq);
		return "redirect:board_list";	
	}
	
}
