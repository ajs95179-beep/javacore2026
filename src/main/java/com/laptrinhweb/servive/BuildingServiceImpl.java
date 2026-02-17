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
	//thằng service sẽ gọi dao để chuyền dữ liệu xuống dao thông qua biên tham chiếu.
    private BuildingDao buildingDao=new BuildingDaoImpl();
    private BuildingConverter buildingConverter=new BuildingConverter();
    private RentAreaDao rentAreaDao=new RentAreaDaoImpl();
    @Override
	public List <BuildingSearchOutput> findBuilding( BuildingSearchInput buildingSearch) {
    	//tạo một mảng để lưu giá trị trả về của thằng dao .mảng này đã được service làm đẹp rồi.
    	//thông qua biến tham chiếu outputs.
		List<BuildingSearchOutput> outputs = new ArrayList<>();
		//ở đây để sử lý logic và đưa ra ý muốn của mình là tao muốn tìm kiếm tòa nhà theo các điều kiện sau.
		//name,Street,district,type.những điều kiện này sẽ được chuyển xuống dao.phần còn lại thằng dao sẽ sử lý .và kết qua
		// là sẽ được gán vào biến tham chiếu anhyeuems.vì sao lại co kiểu buildingdaoanhyeuem,vì đay là lop chứa dữ lieu
		//trả về từ database của dao.trong này có rất nhiều giá trị mà có thể tao không tim nó vẫn có như age,..trong truong 
		//hợp này tao chỉ tim theo 5 điều kiện thôi.
		List<BuildingDaoAnhyeuem> anhyeuems=buildingDao.findBuilding(buildingSearch.getName(), 
				buildingSearch.getStreet(),buildingSearch.getDistrict(),buildingSearch.getType());
		//ok lúc này trong biến tham chiêu anhyeuems đã có dữ liệu được lấy từ dao.bây giờ tao muốn chuyển nó sang output
		//tao sử dụng vòng lặp foreach để duyệt qua từng giá trị rồi gán nó lớp output.và để làm được điều này .
		//đơn gỉan thôi tao lại sử dụng biến tham chiếu thôi.để luu tất cả những giá trị trong anhyeuems sang output.
		// ôn lại một chut nay .dây có 1 lớp buildingoutput nhưng tao đã tạo hai đối tượng là outputs và buildingoutputs
		//vai trò của hai đối tượng này hoàn toàn khác nhau .outputs là đối tượng đã được làm đẹp chỉ cần mang ra sài thôi.
		//còn thằng buildingouts là đối tượng đang  sử lý logic làm đẹp.
		for(BuildingDaoAnhyeuem item : anhyeuems) { 
			BuildingSearchOutput buildingOutput =buildingConverter.convertFromAnhyeuemToOutput(item);
			//BuildingSearchOutput buildingOutput = new BuildingSearchOutput();
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