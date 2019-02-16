package edu.njnu.his.controller;

import edu.njnu.his.dao.MrDrugDao;
import edu.njnu.his.model.MrDrug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DrugController {

    @Autowired
    private MrDrugDao mrDrugDao;

    @GetMapping("/mrdrug/{mrId}")
    public List<MrDrug> getMrDrug(@PathVariable String mrId){
        return mrDrugDao.findByMrId(mrId);
        /*List<MrDrug> mrDrugs = new ArrayList<>();
        for (int i=0;i<5;i++){
            Double amount=Math.random()*10;
            mrDrugs.add(new MrDrug(i+"",i+"10",mrId,amount.intValue(),
                    new Drug(i+"10",i+"10",i+10.0,"测试药品"+i,"盒")));
        }
        return mrDrugs;*/
    }

}
