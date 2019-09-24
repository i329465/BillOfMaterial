package com.sap.billofmaterial.service;

import com.sap.billofmaterial.model.BillOfMaterial;
import com.sap.billofmaterial.repository.BillOfMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillOfMaterialService {
    @Autowired
    private BillOfMaterialRepository billOfMaterialRepository;

    public long getCount() {
        long count = billOfMaterialRepository.count();
        return count;
    }

    public List<BillOfMaterial> findAllBillOfMaterial(){
        List<BillOfMaterial> bom = new ArrayList<>();
        billOfMaterialRepository.findAll().forEach(bom::add);
        return bom;
    }

    public boolean insertBillOfMaterial(BillOfMaterial billofmaterial) {
        try {
            billOfMaterialRepository.save(billofmaterial);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public BillOfMaterial findBillOfMaterialById(String id) {
        BillOfMaterial billofmaterial = billOfMaterialRepository.findById(id).orElse(null);
        return billofmaterial;
    }

    public boolean deleteBillOfMaterial(String id) {
        BillOfMaterial billOfMaterial = billOfMaterialRepository.findById(id).orElse(null);
        if(billOfMaterial!=null) {
            billOfMaterialRepository.delete(billOfMaterial);
            return true;
        }
        return false;
    }

}