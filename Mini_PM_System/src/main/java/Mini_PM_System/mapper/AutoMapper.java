package Mini_PM_System.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Mini_PM_System.domain.DropDownDTO;

@Mapper
public interface AutoMapper {

	public String autoNum(@Param("tag") String tag
						 ,@Param("tag_len") int tag_len
						 ,@Param("column_name") String column_name
						 ,@Param("table_name") String table_name);

	public List<DropDownDTO> dropDown(@Param("table_name") String table_name
								,@Param("col_name1") String col_name1
								,@Param("col_name2") String col_name2);
	
}
