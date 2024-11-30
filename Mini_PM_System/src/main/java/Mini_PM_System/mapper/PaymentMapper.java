package Mini_PM_System.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import Mini_PM_System.domain.PaymentDTO;
import Mini_PM_System.domain.StartEndPageDTO;

@Mapper
public interface PaymentMapper {
	public int paymentInsert(PaymentDTO dto);
	public List<PaymentDTO> salSelectList(
			@Param(value="startRow") int startRow
			,@Param(value="endRow")  int endRow
			,@Param(value="searchWord") String searchWord);
	public int salSelectListCount(String searchWord);
	public List<PaymentDTO> paymentSelectList(StartEndPageDTO sepDTO);
	public int paymentCount(String searchWord);
}
