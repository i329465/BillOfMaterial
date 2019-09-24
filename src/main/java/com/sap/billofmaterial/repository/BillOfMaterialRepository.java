package com.sap.billofmaterial.repository;

import com.sap.billofmaterial.model.BillOfMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillOfMaterialRepository extends JpaRepository<BillOfMaterial, String> {

}
