package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.Board;
import model.User;

@Getter @Setter @AllArgsConstructor @ToString
public class UserDTO {
    private Integer uId;
    private String uUsername;
    private String uEmail;
}
