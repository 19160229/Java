package edu.njnu.his.dao;

import edu.njnu.his.model.MedicalRecord;
import org.springframework.data.repository.CrudRepository;

public interface MrDao extends CrudRepository<MedicalRecord,String> {

    MedicalRecord findByCode(String code);

}
