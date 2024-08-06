package kosa.mapper;

import java.util.List;
import java.util.Map;

import kosa.model.Board;

public interface BoardMapper {

	List<Board> listBoard();
	
	// 상세보기 메소드 id값(내가 가져오고 싶은값)
    Board detailBoard(int seq);
    
    //글 쓰기
    int insertBoard(Board board);
    
    //글 수정
    int updateBoard(Board board);
    
    //글 삭제
    int deleteBoard(int seq);
}
