package Mini_PM_System.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Mini_PM_System.domain.AuthInfoDTO;
import Mini_PM_System.domain.LoginDTO;

@Mapper
public interface LoginMapper {

	public Integer empEmailCheck(@Param("empEmail") String empEmail);

	public void userRegist(LoginDTO dto);

	public Integer idCheck(String userId);

	public Integer userInsert(LoginDTO dto);

	

	


}
