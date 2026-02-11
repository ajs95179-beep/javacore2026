package com.laptrinhweb.servive;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhweb.buildingInput.BuildingSearchInput;
import com.laptrinhweb.buildinganhyeuem.BuildingDaoAnhyeuem;
import com.laptrinhweb.buildinganhyeuem.RentAreaAnhyeuem;
import com.laptrinhweb.buildingoutput.BuildingSearchOutput;
import com.laptrinhweb.converter.BuildingConverter;
import com.laptrinhweb.dao.BuildingDao;
import com.laptrinhweb.dao.BuildingDaoImpl;
import com.laptrinhweb.dao.RentAreaDao;
import com.laptrinhweb.dao.RentAreaDaoImpl;
import com.laptrinhweb.dto.BuildingDTO;
import com.mysql.cj.xdevapi.AddResult;

public class BuildingServiceImpl implements BuildingService {
    private BuildingDao buildingDao=new BuildingDaoImpl();
    private BuildingConverter buildingConverter=new BuildingConverter();
    private RentAreaDao rentAreaDao=new RentAreaDaoImpl();
    @Override
	public List <BuildingSearchOutput> findBuilding( BuildingSearchInput buildingSearch) {
		List<BuildingSearchOutput> outputs = new ArrayList<>();
		List<BuildingDaoAnhyeuem> anhyeuems=buildingDao.findBuilding(buildingSearch.getName(), 
				buildingSearch.getStreet(),buildingSearch.getDistrict(),buildingSearch.getType());
		for(BuildingDaoAnhyeuem item : anhyeuems) {
			BuildingSearchOutput buildingOutput =buildingConverter.convertFromAnhyeuemToOutput(item);
			/*if (item.getType()!= null && !item.getType().isEmpty()) {
				String oldType = item.getType();
				buildingOutput.setType(BuildingTypeUtil.getType(oldType));
				buildingOutput.setName(item.getName());
			   	buildingOutput.setAddress(item.getStreet()+"-"+item.getDistrict());*/
				outputs.add(buildingOutput);
				}
				return outputs;
	}
	@Override
	public void save(BuildingDTO buildingDTO) {
		//List<BuildingDTO> buildings=new ArrayList<>();
		if(buildingDTO.getId()==null) {
			BuildingDaoAnhyeuem buildingDaoAnhyeuem=buildingConverter.converterFromDtoToAnhyeuem(buildingDTO);
			/*Long buildingId =buildingDao.insert(buildingDaoAnhyeuem);
			if(buildingDTO.getRentAreas().length()>0) {
				for(String item:buildingDTO.getRentAreas().split(",")) {
					RentAreaAnhyeuem rentAreaAnhyeuem= new RentAreaAnhyeuem();
					rentAreaAnhyeuem.setValue(Integer.parseInt(item));
					rentAreaAnhyeuem.setBuildingId(buildingId);
					rentAreaDao.insert(rentAreaAnhyeuem);
				}
			}*/
			 buildingDao.insert(buildingDaoAnhyeuem,buildingDTO.getRentAreas());
			 }else {
			//update
		}
	}
};