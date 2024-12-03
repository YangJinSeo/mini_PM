package Mini_PM_System.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FindMapper {

	public String findId(@Param("empNum") String empNum
						,@Param("userName") String userName);

	public String findPw(@Param("empNum") String empNum
						,@Param("userName") String userName
						,@Param("userJumin") String userJumin);

}
