package Mini_PM_System.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Mini_PM_System.mapper.AutoMapper;

@Service
public class AutoService {
	
	@Autowired
	AutoMapper autoMapper;
	public String autoNum(String tag
							, int tag_len
							, String column_name
							, String table_name) {
		
		String autoNum = autoMapper.autoNum(tag, tag_len, column_name, table_name);
		
		return autoNum;
	}

}
