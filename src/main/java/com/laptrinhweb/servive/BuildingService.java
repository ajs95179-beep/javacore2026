package com.laptrinhweb.servive;

import java.util.List;

import com.laptrinhweb.buildingInput.BuildingSearchInput;
import com.laptrinhweb.buildingoutput.BuildingSearchOutput;
import com.laptrinhweb.dto.BuildingDTO;

public interface BuildingService {
	List<BuildingSearchOutput>  findBuilding(BuildingSearchInput buildingSearch);
	void save(BuildingDTO buildingDTO);

}

