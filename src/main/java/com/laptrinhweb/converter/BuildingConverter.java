package com.laptrinhweb.converter;

import com.laptrinhweb.buildinganhyeuem.BuildingDaoAnhyeuem;
import com.laptrinhweb.buildingoutput.BuildingSearchOutput;
import com.laptrinhweb.dto.BuildingDTO;
import com.laptrinhweb.utils.BuildingTypeUtil;

public class BuildingConverter {
	public BuildingSearchOutput convertFromAnhyeuemToOutput(BuildingDaoAnhyeuem buildingDaoAnhyeuem) {
		BuildingSearchOutput result=new BuildingSearchOutput();
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
	
