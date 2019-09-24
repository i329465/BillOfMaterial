package com.sap.billofmaterial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Table;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

//@Table(name="billofmaterialitem")
public class BillOfMaterialItem extends AuditModel{
//    private BillOfMaterial billOfMaterial;

    @Id
    @GenericGenerator(name = "sequence_dep_id", strategy = "com.sap.billofmaterial.model.GuidIdentifierGenerator")
    @GeneratedValue(generator = "sequence_dep_id")
    @Column(name ="guid", unique=true)
    private String guid;

    @Column(name ="posnr")
    private String posnr;

    @Column(name ="idnrk")
    private String idnrk;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "billofmaterial_guid", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore

    private BillOfMaterial billOfMaterial;

    public BillOfMaterial getBillOfMaterial() {
        return billOfMaterial;
    }

    public void setBillOfMaterial(BillOfMaterial billOfMaterial) {
        this.billOfMaterial = billOfMaterial;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getPosnr() {
        return posnr;
    }

    public void setPosnr(String posnr) {
        this.posnr = posnr;
    }

    public String getIdnrk() {
        return idnrk;
    }

    public void setIdnrk(String idnrk) {
        this.idnrk = idnrk;
    }

}
