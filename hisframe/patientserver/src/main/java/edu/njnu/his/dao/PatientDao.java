/*
package edu.njnu.his.dao;

import edu.njnu.his.model.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;


@Component
public class PatientDao{

    @Autowired
    private MongoTemplate mongoTemplate;

    public MedicalRecord findByCode(String code){
        Query query=new Query(Criteria.where("code").is(code));
        return mongoTemplate.findOne(query,MedicalRecord.class);
    }

}
*/
