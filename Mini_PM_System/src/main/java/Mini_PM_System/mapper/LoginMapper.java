package Mini_PM_System.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Mini_PM_System.domain.AuthInfoDTO;
import Mini_PM_System.domain.UserDTO;

@Mapper
public interface LoginMapper {

	public Integer empEmailCheck(@Param("empEmail") String empEmail);

	public Integer idCheck(String userId);

	public Integer userInsert(UserDTO dto);

	public Integer empNumCheck(String empNum);

	public AuthInfoDTO loginSelect(String userId);


	

	


}
