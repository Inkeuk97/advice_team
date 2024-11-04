package advice.teamproject.member;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Member {

    private String username;
    private String password;
    private String email;

    public Member(String username, String password,String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
