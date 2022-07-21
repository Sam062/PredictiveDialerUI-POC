package base.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.entity.DialerDataEntity;
import base.model.DialerData;
import base.repository.DialerDataRepo;

@Service
public class DialerService {

	@Autowired
	private DialerDataRepo repo;

	public Boolean saveAll(List<DialerData> dialerModelList) {
		if (dialerModelList != null && dialerModelList.size() > 0) {
			try {
				List<DialerDataEntity> entityList = dialerModelList.stream().map(dialerModel -> {
					DialerDataEntity entity = new DialerDataEntity();

					// Copying properties into Entity
					BeanUtils.copyProperties(dialerModel, entity);

					return entity;
				}).collect(Collectors.toList());

				// Inserting Data into Database
				List<DialerDataEntity> saveAll = repo.saveAll(entityList);

				if (dialerModelList.size() == saveAll.size()) {
					System.out.println("All data inserted into DB");
					return true;
				} else
					System.out.println("Something Went wrong");
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} else {
			System.out.println("No Data Found in the list");
		}
		return false;
	}

	public List<DialerData> getAllDialerData() {
		List<DialerData> dialerModelList = null;

		try {
			List<DialerDataEntity> entityList = repo.findAll();
			if (entityList != null && entityList.size() > 0) {
				dialerModelList = entityList.stream().map(entity -> {
					DialerData dialerModel = new DialerData();

					BeanUtils.copyProperties(entity, dialerModel);

					return dialerModel;
				}).collect(Collectors.toList());

				return dialerModelList;
			} else {
				System.out.println("No data found in database.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return dialerModelList;
		}
		return dialerModelList;
	}

}
