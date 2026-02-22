package com.laptrinhweb.dao;

import java.util.List;

import com.laptrinhweb.buildingInput.BuildingSearchInput;
import com.laptrinhweb.buildinganhyeuem.BuildingDaoAnhyeuem;

public interface BuildingDao {
List<BuildingDaoAnhyeuem> findBuilding(String name,String street,String district,String type	)
//Long insert(BuildingDaoAnhyeuem buildingDaoAnhyeuem);
Long insert(BuildingDaoAnhyeuem buildingDaoAnhyeuem,String rentAreas);
}
