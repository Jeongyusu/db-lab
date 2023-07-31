package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.Board;
import model.User;

@Getter @Setter @AllArgsConstructor @ToString
public class UserBoardDTO {
    private User user;
    private Board board;
}
