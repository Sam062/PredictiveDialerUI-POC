package base.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.controller.DialerController;
import base.entity.DialerDataEntity;
import base.model.DialerData;
import base.repository.DialerDataRepo;

@Service
public class DialerService {
	private static final Logger log = LogManager.getLogger(DialerController.class);

	@Autowired
	private DialerDataRepo repo;

	public Boolean saveAll(String contactListId, List<DialerData> dialerModelList) {
		if (dialerModelList != null && dialerModelList.size() > 0) {
			try {
				List<DialerDataEntity> entityList = dialerModelList.stream().map(dialerModel -> {
					DialerDataEntity entity = new DialerDataEntity();

					// Copying properties into Entity
					BeanUtils.copyProperties(dialerModel, entity);

					if (entity.getCountryCode() != null && !entity.getCountryCode().isEmpty())
						entity.setCountryCode("+" + entity.getCountryCode());
					entity.setContactListId(Integer.valueOf(contactListId));

					return entity;
				}).collect(Collectors.toList());

				// Inserting Data into Database
				List<DialerDataEntity> saveAll = repo.saveAll(entityList);

				if (dialerModelList.size() == saveAll.size()) {
					log.info("All data inserted into DB");
					return true;
				} else
					log.warn("Something Went wrong");
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} else {
			log.warn("No Data Found in the list");
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
				log.warn("No data found in database.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return dialerModelList;
		}
		return dialerModelList;
	}

	public DialerData findByMobile1(String number) {
		DialerDataEntity data = repo.findByMobile1(number);
		if (data != null) {
			DialerData model = new DialerData();
			BeanUtils.copyProperties(data, model);
			return model;
		}
		return null;
	}

	public Boolean updateDialerEntity(DialerData dialerData) {
		if (dialerData != null) {
			DialerDataEntity entity = new DialerDataEntity();
			BeanUtils.copyProperties(dialerData, entity);

			DialerDataEntity status = repo.save(entity);
			if (status != null && status.getDialerId() != null) {
				log.info("Entity Updated.");
				return true;
			} else {
				log.warn("Couldn't update data.");
			}

		} else
			log.warn("Dialer Data is Null.");
		return false;
	}

}
