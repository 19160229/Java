package edu.njnu.his.service;

import edu.njnu.his.model.MedicalRecord;
import org.springframework.stereotype.Component;

@Component
public class PatientFallbackService implements PatientService{

    @Override
    public MedicalRecord getMr(String code) {
        return new MedicalRecord("error","error","error","error",null,null);
    }

}
