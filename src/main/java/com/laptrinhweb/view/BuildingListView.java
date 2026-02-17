package com.laptrinhweb.view;

import java.util.List;

import com.laptrinhweb.buildingInput.BuildingSearchInput;
import com.laptrinhweb.buildingoutput.BuildingSearchOutput;
import com.laptrinhweb.controller.BuildingController;

public class BuildingListView {
	public static void main(String[] args) {
		String name="toa2";
		String street =null;
		String district =null;
		BuildingSearchInput buildingSearch=new BuildingSearchInput();
		buildingSearch.setName(name);
		buildingSearch.setStreet(street);
		buildingSearch.setDistrict(district);
		BuildingController buildingController= new BuildingController();
		List<BuildingSearchOutput> buildings=buildingController.findBuilding(buildingSearch);
		for(BuildingSearchOutput b: buildings) {
			System.out.print(b.getName());
			System.out.println(b.getAddress());
		System.out.println(b.getType());
			

		}
		
		
		
	}
	
	

}
