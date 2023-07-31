package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @AllArgsConstructor @ToString
public class BoardDetailDTO {
    private Integer bId;
    private Integer uId;
    private String username;
    private String title;
    private String content;
}
