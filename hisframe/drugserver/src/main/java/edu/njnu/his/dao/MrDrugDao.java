package edu.njnu.his.dao;

import edu.njnu.his.model.MrDrug;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MrDrugDao extends CrudRepository<MrDrug, String> {

    List<MrDrug> findByMrId(String mrId);

}
