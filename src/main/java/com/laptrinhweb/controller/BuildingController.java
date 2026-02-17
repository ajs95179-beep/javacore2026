package com.laptrinhweb.controller;

import java.util.List;

import com.laptrinhweb.buildingInput.BuildingSearchInput;
import com.laptrinhweb.buildingoutput.BuildingSearchOutput;
import com.laptrinhweb.dto.BuildingDTO;
import com.laptrinhweb.servive.BuildingService;
import com.laptrinhweb.servive.BuildingServiceImpl;

public class BuildingController {
	//thang controller goi service.
	private  BuildingService buildingService =new BuildingServiceImpl();
	public List< BuildingSearchOutput> findBuilding(BuildingSearchInput buildingSearch){
		
		
		List<BuildingSearchOutput> results=buildingService.findBuilding(buildingSearch);
        return results;
        }
    public void addBuilding(BuildingDTO newBuilding) {
    buildingService.save(newBuilding);

	}
		
			
			
			
			
	 }

		 
	 
 

