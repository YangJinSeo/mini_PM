package Mini_PM_System.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Mini_PM_System.domain.AuthInfoDTO;

@Mapper
public interface FindMapper {

	public String findId(@Param("empNum") String empNum
						,@Param("userName") String userName);

	public String findPw(@Param("empNum") String empNum
						,@Param("userId") String userId
						,@Param("userJumin") String userJumin);

	public Integer chagePw(@Param("encodeNewPw") String encodeNewPw
						, @Param("userId") String userId);

	public void userUpdate(@Param("userName") String userName
						,@Param("empNum") String empNum);

	public AuthInfoDTO userOne(String empNum);

}
