package com.ex.test.service;


import com.ex.test.dto.BoardDTO;
import com.ex.test.entity.BoardEntity;
import com.ex.test.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private BoardRepository boardRepository;
    public Long save(BoardDTO boardDTO) {

        BoardEntity boardEntity=BoardEntity.bs(boardDTO);
        Long savedId= boardRepository.save(boardEntity).getId();
           return  savedId;
    }

    public BoardDTO findById(Long id) {
        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id);
        if (optionalBoardEntity.isPresent()) {
           return BoardDTO.toBoardDTO(optionalBoardEntity.get());
        } else {
            return null;
        }
    }
}
