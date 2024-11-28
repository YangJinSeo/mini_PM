package Mini_PM_System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Mini_PM_System.domain.DropDownDTO;
import Mini_PM_System.mapper.AutoMapper;


@Service
public class DropDownService {
	
	@Autowired
	AutoMapper autoMapper; 
	public List<DropDownDTO> execute(String table_name, String col_name1, String col_name2) {
		
		List<DropDownDTO> drop 
		= autoMapper.dropDown(table_name, col_name1, col_name2);
		
		return drop;
	}

}
