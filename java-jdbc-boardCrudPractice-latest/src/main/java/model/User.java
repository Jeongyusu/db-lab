package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @AllArgsConstructor @ToString
public class User {
    private Integer uId;
    private String uUsername;
    private String uPassword;
    private String uEmail;
}
