package com.laptrinhweb.converter;

import com.laptrinhweb.buildinganhyeuem.BuildingDaoAnhyeuem;
import com.laptrinhweb.buildingoutput.BuildingSearchOutput;
import com.laptrinhweb.dto.BuildingDTO;
import com.laptrinhweb.utils.BuildingTypeUtil;

public class BuildingConverter {
	//tao tạo rao một lơp riêng để chuyên sử lý những những cái liên quan đến converter.
	//phân tích phương thức sau sẽ hiểu rõ hơn chuyển từ anhyeuem snag output vay len tham so chuyền vào
	//phải la buildingdaoanhyeuem.để lưu vào lớp output thì tao cần tạo biến tham chiếu đển lớp đó
	//ở đây là result.day là lúc tao có thể sử lý logic trong này .
	public BuildingSearchOutput convertFromAnhyeuemToOutput(BuildingDaoAnhyeuem buildingDaoAnhyeuem) {
		BuildingSearchOutput result=new BuildingSearchOutput();
	//ở đay tao phải sử lý thằng type.phương pháp làm là gì.đầu tiên tao kiểm tra xem thằng type có null 
//và isempty không.nếu có giá trị thì tao lất giá trị đó rồi lưu vào biến tham chiếu oldtype có kiểu string.
//bây giờ tao mang cái biến oldtype này đi  xử lý .ở nơi khác.cho nó dễ		
		if (buildingDaoAnhyeuem.getType()!= null && !buildingDaoAnhyeuem.getType().isEmpty()) {
			String oldType = buildingDaoAnhyeuem.getType();
		result.setType(BuildingTypeUtil.getType(oldType));
		}
		result.setName(buildingDaoAnhyeuem.getName());
	   	result.setAddress(buildingDaoAnhyeuem.getStreet()+"-"+buildingDaoAnhyeuem.getDistrict());
	   	return result;
	}
	public BuildingDaoAnhyeuem converterFromDtoToAnhyeuem(BuildingDTO buildingDTO) {
		BuildingDaoAnhyeuem result =new BuildingDaoAnhyeuem();
		result.setName(buildingDTO.getName());
		result.setStreet(buildingDTO.getStreet());
		return result;
	}

}
	
