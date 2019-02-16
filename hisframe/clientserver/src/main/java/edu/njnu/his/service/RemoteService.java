/*
package edu.njnu.his.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import edu.njnu.his.model.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RemoteService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackMr")
    public MedicalRecord getMr(String code) {
        //url :http://patient/mr/{1}
        ResponseEntity<MedicalRecord> entity = restTemplate.getForEntity("http://patient/mr/{1}", MedicalRecord.class, code);
        return entity.getBody();
    }

    public MedicalRecord fallbackMr(String code){
        return new MedicalRecord("error","error","error","error",null);
    }

}
*/
