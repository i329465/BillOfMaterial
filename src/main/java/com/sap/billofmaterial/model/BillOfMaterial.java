package com.sap.billofmaterial.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

//@Table(name = "posts")
public class BillOfMaterial extends AuditModel {
    @Id
    @GenericGenerator(name = "sequence_dep_id", strategy = "com.sap.billofmaterial.model.GuidIdentifierGenerator")
    @GeneratedValue(generator = "sequence_dep_id")
    @Column(name ="guid", unique=true)
    private String guid;

    @Column(name ="stlty")
    private String stlty;

    @Column(name ="stlal")
    private String stlal;

    @Column(name ="versionid")
    private String versionid;


//    public BillOfMaterial() {
//    }
//
//    public BillOfMaterial(String guid, String stlty, String stlal, String versionid) {
//        this.guid = guid;
//        this.stlty = stlty;
//        this.stlal = stlal;
//        this.versionid = versionid;
//    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getStlty() {
        return stlty;
    }

    public void setStlty(String stlty) {
        this.stlty = stlty;
    }

    public String getStlal() {
        return stlal;
    }

    public void setStlal(String stlal) {
        this.stlal = stlal;
    }

    public String getVersionid() {
        return versionid;
    }

    public void setVersionid(String versionid) {
        this.versionid = versionid;
    }
}
