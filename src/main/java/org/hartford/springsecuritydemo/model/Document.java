package org.hartford.springsecuritydemo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String documentType;

    @Column(nullable = false)
    private String documentNumber;

    @Column(nullable = false)
    private String issuedBy;

    public Document() {
    }

    public Document(String documentType, String documentNumber, String issuedBy) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.issuedBy = issuedBy;
    }

    public Document(Long id, String documentType, String documentNumber, String issuedBy) {
        this.id = id;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.issuedBy = issuedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }
}
