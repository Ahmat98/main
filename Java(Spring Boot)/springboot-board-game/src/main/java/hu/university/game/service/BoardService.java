package hu.university.game.service;

import hu.university.game.model.BoardEntity;
import hu.university.game.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service for handling persistence of game boards.
 */
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository repository;

    /**
     * Saves the serialized board into the database.
     *
     * @param boardData the board as a String (serialized 3x3 grid)
     */
    public void saveBoard(String boardData) {
        BoardEntity board = new BoardEntity(boardData);
        repository.save(board);
    }
}
