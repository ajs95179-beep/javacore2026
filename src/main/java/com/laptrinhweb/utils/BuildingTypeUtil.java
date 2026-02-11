package com.laptrinhweb.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.laptrinhweb.constant.BuildingTypeConstant;
import com.laptrinhweb.enums.BuildingTypeEnum;

public class BuildingTypeUtil {
	public static String getType(String oldType){
		List<String> newTypes =new ArrayList<>();
		//Map<String, String>mapType = initBuildingType();
	if( oldType !=null) {
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






