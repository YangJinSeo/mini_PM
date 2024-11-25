package Mini_PM_System.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AutoMapper {

	public String autoNum(@Param("tag") String tag
						 ,@Param("tag_len") int tag_len
						 ,@Param("column_name") String column_name
						 ,@Param("table_name") String table_name);
	
}
