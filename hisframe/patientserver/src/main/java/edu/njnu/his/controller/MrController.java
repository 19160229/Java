package edu.njnu.his.controller;

import edu.njnu.his.dao.MrDao;
import edu.njnu.his.model.MedicalRecord;
import edu.njnu.his.model.MrDrug;
import edu.njnu.his.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MrController {

    @Autowired
    private Environment env;
    //代表当前patientServer服务的运行环境，所以可以通过它读取配置文件application.yaml内容

    @Autowired
    private MrDao mrDao;

    @Autowired
    private DrugService drugService;

    /*
    @Autowired
    private PatientDao patientDao;
    */

    @GetMapping("/mr/{id}")
    public MedicalRecord findMr(@PathVariable String id) {
        //env.getProperty(String) 通过传入配置文件中的某一个属性名称来获得对应属性值
        System.out.println("from port: " + env.getProperty("server.port"));
        MedicalRecord mr = mrDao.findByCode(id);
        if (mr != null && mr.getId() != null && !"".equals(mr.getId())) {
            List<MrDrug> mrDrugs = drugService.getMrDrug(mr.getId());
            mr.setMrDrugs(mrDrugs);
        }
        return mr;
        /*MedicalRecord medicalRecord = patientDao.findByCode(id);
        return medicalRecord;*/
        //return new MedicalRecord(id, "1234", "张三", "男", 18);
    }

}
