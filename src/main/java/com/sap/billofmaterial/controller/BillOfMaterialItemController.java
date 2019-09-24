package com.sap.billofmaterial.controller;

import com.sap.billofmaterial.model.BillOfMaterial;
import com.sap.billofmaterial.model.BillOfMaterialItem;
import com.sap.billofmaterial.service.BillOfMaterialItemService;
import com.sap.billofmaterial.service.BillOfMaterialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BillOfMaterialItemController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private BillOfMaterialItemService billOfMaterialItemService;

    @Autowired
    private BillOfMaterialService billOfMaterialService;

    @GetMapping("/billOfMaterials/{headerGuid}/items/count")
    public long count(@PathVariable (value = "headerGuid") String headerGuid) {
        log.info("Search total number of BOM Line items");
        return billOfMaterialItemService.getCount(headerGuid);
    }

    @GetMapping("/billOfMaterials/{headerGuid}/items")
    public List<BillOfMaterialItem> getAllItemsByHeaderGuid(@PathVariable (value = "headerGuid") String headerGuid){
        log.info("Searching all BOM items");
        return billOfMaterialItemService.findAllItemsByHeaderGuid(headerGuid);
    }

    @PostMapping(value = "/billOfMaterials/{headerGuid}/items")
    public boolean addBillOfMaterialItem(@PathVariable (value = "headerGuid") String headerGuid,
                                         @Valid @RequestBody BillOfMaterialItem billOfMaterialItem) {

        log.info("Creation/Updating BOM - "+billOfMaterialItem.toString());
        return billOfMaterialItemService.insertBillOfMaterialItem(billOfMaterialItem,headerGuid);
    }

    @PutMapping("/billOfMaterials/{headerGuid}/items/")
    public boolean updateBillOfMaterialItem(@PathVariable (value = "headerGuid") String headerGuid,
                                            @Valid @RequestBody BillOfMaterialItem billOfMaterialItem) {
        log.info("Creation/Updating BOM - "+billOfMaterialItem.toString());
        return billOfMaterialItemService.updateBillOfMaterialItem(headerGuid,billOfMaterialItem);
    }

    @GetMapping("/billOfMaterials/{headerGuid}/items/{itemGuid}" )
    public BillOfMaterialItem findById(@PathVariable (value = "headerGuid") String headerGuid,
                                       @PathVariable (value = "itemGuid") String itemGuid) {
        log.info("Searching BOM item with ID - "+ itemGuid);
        return billOfMaterialItemService.findBillOfMaterialItemById(headerGuid,itemGuid);
    }

    @DeleteMapping("/billOfMaterials/{headerGuid}/items/{itemGuid}")
    public boolean deleteBillOfMaterialItem(@PathVariable (value = "headerGuid") String headerGuid,
                                            @PathVariable (value = "itemGuid") String itemGuid) {
        return billOfMaterialItemService.deleteBillOfMaterialItem(headerGuid,itemGuid);
    }
}
