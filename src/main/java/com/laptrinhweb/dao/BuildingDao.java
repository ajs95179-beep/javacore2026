package com.laptrinhweb.dao;

import java.util.List;

import com.laptrinhweb.buildingInput.BuildingSearchInput;
import com.laptrinhweb.buildinganhyeuem.BuildingDaoAnhyeuem;

public interface BuildingDao {
//sau khi tao đã liệt kê xong model bây giờ đến bước model được lưu ở đâu.ở dưới database.vậy có nghĩa 
//là tao phải đi viết tầng dao để truy xuất dữ liêu.trong để bài này tao muốn tìm toà nhà.với các
//tiêu chí sau tên,đường ,quận,loại tòa nhà.dữ liệu trả về tao sẽ để là kiểu buildingdaoanhyeuem.
	
List<BuildingDaoAnhyeuem> findBuilding(String name,String street,String district,String type);
//List<BuildingDaoAnhyeuem>findBuilding(BuildingSearchInput buildingSearch);
//Long insert(BuildingDaoAnhyeuem buildingDaoAnhyeuem);
Long insert(BuildingDaoAnhyeuem buildingDaoAnhyeuem,String rentAreas);
}
