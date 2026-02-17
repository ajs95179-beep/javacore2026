package com.laptrinhweb.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.laptrinhweb.constant.BuildingTypeConstant;
import com.laptrinhweb.enums.BuildingTypeEnum;

public class BuildingTypeUtil {
//tạo lớp buildingtype để sử lý .và dùng phươmg thức gettype để sử lý logic.
	//tạo một mảng để lưu giá trị type đã qua sử lý là newtypes.
	//cách sử lý như sau.nếu cái oldtype khác null .sẽ vào vòng lặp for và tao sử dụng hàm split để
	//chia nhỏ cái chuỗi lớn đó ra thành từng mảng gía trị nhỏ.
	public static String getType(String oldType){
		List<String> newTypes =new ArrayList<>();
		//Map<String, String>mapType = initBuildingType();
	if( oldType !=null) {
		//thang split này nó sẽ tách chuôi thanh mang chuoi nho cach nhau boi nhau phẩy
		//trong ví dụ này có 3 chuỗi.và item nó sẽ chạy 3 lần để so sánh với 3 cái case.
		//ok đến đây là hiểu rồi nhá.
	 for (String item:oldType.split(",")) {
		   // String code =mapType.get(item);
			//newTypes.add(code);
	 	
			
			//newTypes.add(BuildingTypeEnum.valueOf(item).getValue());
		switch(item) {
		 case BuildingTypeConstant.NGUYEN_CAN_CODE:{
		 	newTypes.add(BuildingTypeConstant.NGUYEN_CAN_NAME);
		 	break;
		 	}
		 case BuildingTypeConstant.NOI_THAT_CODE:{
		 	newTypes.add(BuildingTypeConstant.NOI_THAT_NAME);
		 	break;
		 }
		 case BuildingTypeConstant.TANG_TRET_CODE:{
		 	newTypes.add(BuildingTypeConstant.TANG_TRET_NAME);
		 }
		 }
			}
	return String.join(",", newTypes);
	//hàm join này sẽ nối chuỗi lại cách nhau bằng dấu phẩy.
	}
	return null;
	}
	
	
/*public static Map<String ,String> initBuildingType(){
	Map<String,String> results=new HashMap<>();
	results.put(BuildingTypeConstant.NGUYEN_CAN_CODE, BuildingTypeConstant.NGUYEN_CAN_NAME);
	results.put(BuildingTypeConstant.NOI_THAT_CODE, BuildingTypeConstant.NOI_THAT_NAME);
	results.put(BuildingTypeConstant.TANG_TRET_CODE, BuildingTypeConstant.TANG_TRET_NAME);
		return results;
	}*/
	
}






