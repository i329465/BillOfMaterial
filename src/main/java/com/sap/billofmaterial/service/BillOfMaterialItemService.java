package com.sap.billofmaterial.service;

import com.sap.billofmaterial.exception.ResourceNotFoundException;
import com.sap.billofmaterial.model.BillOfMaterial;
import com.sap.billofmaterial.model.BillOfMaterialItem;
import com.sap.billofmaterial.repository.BillOfMaterialItemRepository;
import com.sap.billofmaterial.repository.BillOfMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BillOfMaterialItemService {
    @Autowired
    private BillOfMaterialItemRepository billOfMaterialItemRepository;
    @Autowired
    private BillOfMaterialRepository billOfMaterialRepository;
//    private String headerGuid;
//    private String itemGuid;
//    private BillOfMaterialItem billOfMaterialItem;

    public long getCount(String headerGuid) {
//        try {
//            Optional<BillOfMaterial> billOfMaterial = billOfMaterialItemRepository.findById(headerGuid);
//        }
        long count = billOfMaterialItemRepository.count();
        return count;
    }

    public List<BillOfMaterialItem> findAllItemsByHeaderGuid(String headerGuid) {
        List<BillOfMaterialItem> bomLineItem = new ArrayList<>();
        Optional<BillOfMaterial> billOfMaterial = billOfMaterialRepository.findById(headerGuid);
        billOfMaterialItemRepository.findByBillOfMaterial(billOfMaterial.get()).forEach(bomLineItem::add);
        return bomLineItem;
    }

    public boolean insertBillOfMaterialItem(BillOfMaterialItem billofmaterialItem, String headerGuid) throws ResourceNotFoundException {
        if(!billOfMaterialRepository.existsById(headerGuid))
            throw new ResourceNotFoundException("Bill Of Material Header Guid " + headerGuid + " not found");
        try {
            Optional<BillOfMaterial> billOfMaterial = billOfMaterialRepository.findById(headerGuid);
            billofmaterialItem.setBillOfMaterial(billOfMaterial.get());
            billOfMaterialItemRepository.save(billofmaterialItem);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateBillOfMaterialItem(String headerGuid,BillOfMaterialItem billOfMaterialItem) {
        if(!billOfMaterialRepository.existsById(headerGuid))
            throw new ResourceNotFoundException("Bill Of Material Header Guid " + headerGuid + " not found");
        try {
            Optional<BillOfMaterial> billOfMaterial = billOfMaterialRepository.findById(headerGuid);
            billOfMaterialItem.setBillOfMaterial(billOfMaterial.get());
            billOfMaterialItemRepository.save(billOfMaterialItem);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public BillOfMaterialItem findBillOfMaterialItemById(String headerGuid,String itemGuid) {
        BillOfMaterialItem billofmaterialItem = billOfMaterialItemRepository.findById(itemGuid).orElse(null);
        return billofmaterialItem;
    }

    public boolean deleteBillOfMaterialItem(String headerGuid,String itemGuid) {
        Optional<BillOfMaterial> billOfMaterial = billOfMaterialRepository.findById(headerGuid);
        List<BillOfMaterialItem> billOfMaterialItem = billOfMaterialItemRepository.findByGuidAndBillOfMaterial(itemGuid,billOfMaterial.get());
        if (billOfMaterialItem != null){
            for(BillOfMaterialItem item:billOfMaterialItem){
                billOfMaterialItemRepository.delete(item);
            }
            return true;
        }
        return false;
    }
}