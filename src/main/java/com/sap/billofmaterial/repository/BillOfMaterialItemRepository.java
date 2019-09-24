package com.sap.billofmaterial.repository;

import com.sap.billofmaterial.model.BillOfMaterial;
import com.sap.billofmaterial.model.BillOfMaterialItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillOfMaterialItemRepository extends JpaRepository<BillOfMaterialItem, String> {

    List<BillOfMaterialItem> findByBillOfMaterial(BillOfMaterial billOfMaterial);
    List<BillOfMaterialItem> findByGuidAndBillOfMaterial(String guid, BillOfMaterial billOfMaterial);
}
