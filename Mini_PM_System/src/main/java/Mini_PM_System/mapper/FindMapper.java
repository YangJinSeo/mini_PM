package Mini_PM_System.mapper;

import java.util.List;

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

	public List<AuthInfoDTO> adminList();

	public List<AuthInfoDTO> unauthList();

	public AuthInfoDTO adminInfo(String id);

	public Integer changeY(String userId);

	public Integer changeH(String userId);

	public void adminDelete(String id);

}
