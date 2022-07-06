package com.ex.test.entity;

import com.ex.test.dto.BoardDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


    @Entity
    @Getter@Setter
    @Table(name = "board_test_table")
    public class BoardEntity  {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "board_id")
        private Long id;

        @Column(length =30,nullable = false )
        private String boardWriter;
        @Column(length =50,nullable = false)
        private String boardTitle;
        @Column(length =500 )
        private String boardContents;

        @Column
        private int boardHits;



        @CreationTimestamp
        @Column(updatable = false)
        private LocalDateTime board_created_time;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "member_id")
        private  MemberEntity memberEntity;


        public  static  BoardEntity bs(BoardDTO boardDTO){
            BoardEntity boardEntity = new BoardEntity();
            boardEntity.setBoardTitle(boardDTO.getBoardTitle());
            boardEntity.setBoardWriter(boardDTO.getBoardWriter());

            boardEntity.setBoardHits(boardDTO.getBoardHits());
            boardEntity.setBoardContents(boardDTO.getBoardContents());
            boardEntity.setBoardHits(0);
            return boardEntity;

        }

}
