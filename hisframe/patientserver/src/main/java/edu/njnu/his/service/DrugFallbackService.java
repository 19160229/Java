package edu.njnu.his.service;

import edu.njnu.his.model.MrDrug;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DrugFallbackService implements DrugService{

    @Override
    public List<MrDrug> getMrDrug(String mrId) {
        return null;
    }
}
