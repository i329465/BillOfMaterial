package com.sap.billofmaterial.controller;

import com.sap.billofmaterial.model.BillOfMaterial;
import com.sap.billofmaterial.service.BillOfMaterialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillOfMaterialController {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private BillOfMaterialService billOfMaterialService;

    @RequestMapping("/billOfMaterials/count")
    public long count() {
        log.info("Search total number of BOM");
        return billOfMaterialService.getCount();
    }

    @GetMapping("/billOfMaterials")
    public List<BillOfMaterial> getAllBillOfMaterial(){
        log.info("Searching all BOM");
        return billOfMaterialService.findAllBillOfMaterial();
    }

    @PostMapping(value = "/billOfMaterials")
    public boolean addBillOfMaterial(@RequestBody(required = false) BillOfMaterial billOfMaterial) {
        log.info("Creation/Updating BOM - "+billOfMaterial.toString());
        return billOfMaterialService.insertBillOfMaterial(billOfMaterial);
    }

    @GetMapping("/billOfMaterials/{headerGuid}" )
    public BillOfMaterial findById(@PathVariable (value = "headerGuid") String headerGuid) {
        log.info("Searching BOM with ID - "+ headerGuid);
        return billOfMaterialService.findBillOfMaterialById(headerGuid);
    }

    @DeleteMapping(value="/billOfMaterials/{headerGuid}")
    public boolean deleteBillOfMaterial(@PathVariable String headerGuid) {
        return billOfMaterialService.deleteBillOfMaterial(headerGuid);
    }
}
