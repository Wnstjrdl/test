package com.ex.test;

import com.ex.test.dto.BoardDTO;
import com.ex.test.entity.BoardEntity;
import com.ex.test.entity.MemberEntity;
import com.ex.test.service.BoardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BoardTest {
    public BoardService boardService;


    public BoardDTO newBoard(int i) {
        BoardDTO board =
                new BoardDTO("테스트제목"+i, "테스트작성자"+i,  "테스트내용"+i);
        return board;
    }

    @Test
    @Transactional //자동 롤백
    @Rollback(value = true)  //테이블을 새롭게 만드는 역할을함
    @DisplayName("작성자 테스트")
    public void boardSaveTest(){
        Long saveId = boardService.save(newBoard(1));
        BoardDTO  boardDTO = boardService.findById(saveId);
        assertThat(newBoard(1).getBoardWriter()).isEqualTo(boardDTO.getBoardWriter());
    }
}
