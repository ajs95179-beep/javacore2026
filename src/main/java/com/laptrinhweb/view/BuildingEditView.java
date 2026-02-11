
package com.laptrinhweb.view;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhweb.buildingoutput.BuildingSearchOutput;
import com.laptrinhweb.controller.BuildingController;
import com.laptrinhweb.dto.BuildingDTO;

public class BuildingEditView {
	public static void main(String[] args) {
		String name ="toa 16";
		String street="duong so 16";
		String district=null;
		String rentAreas="100,200,3";
		BuildingDTO newBuilding=new BuildingDTO();
		newBuilding.setName(name);
		newBuilding.setStreet(street);
		newBuilding.setDistrict(district);
		newBuilding.setRentAreas(rentAreas);
		BuildingController buildingController=new BuildingController();
		buildingController.addBuilding(newBuilding);

	
		}
		
		
		
		
		
	
	}
	


