package Mini_PM_System.domain;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("users")
public class UsersDTO {
    String userId; 
    String userPw; 
    String userName; 
    Date userBirth;
    String user_approval;
    String PM_emp_num;
}
