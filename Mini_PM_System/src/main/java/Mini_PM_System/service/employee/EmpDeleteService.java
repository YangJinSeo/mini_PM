package Mini_PM_System.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Mini_PM_System.domain.EmployeeDTO;
import Mini_PM_System.mapper.RetireMapper;


@Service
public class EmpDeleteService {
	
	@Autowired
	RetireMapper retireMapper;
	
	public void execute(String num) {
		// 퇴사테이블에 정보 넣기
		/// 퇴사자 정보 가져오기
		EmployeeDTO dto = retireMapper.selectEmpOne(num);
		/// 퇴사자 정보 넣기
		int i = retireMapper.empChangeRetire(dto);
		System.out.println(i);
		
		if (i == 1) {
			retireMapper.empDelete(num);
		}
		//
	}
		
}


