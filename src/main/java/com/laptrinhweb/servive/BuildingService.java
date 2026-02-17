package com.laptrinhweb.servive;

import java.util.List;

import com.laptrinhweb.buildingInput.BuildingSearchInput;
import com.laptrinhweb.buildingoutput.BuildingSearchOutput;
import com.laptrinhweb.dto.BuildingDTO;
//tiếp tục đến thằng service nơi sử lý logic.nó sẽ gọi thằng dao.và chuyền dữ liệu xuống dao và lấy dữ liệu
//từ dao gửi lên.dữ liệu của dao gửi lên sẽ được convert sang buildingsearchoutput và được thằng controller
//lấy ra và đẩy lên view
public interface BuildingService {
	List<BuildingSearchOutput>  findBuilding(BuildingSearchInput buildingSearch);
	void save(BuildingDTO buildingDTO);

}

