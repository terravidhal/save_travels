package com.dojo.savetravels.save_travels.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;




@Entity
@Table(name="travels")
public class Travels {
	
    @Id  // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 5, max = 200)
    private String expense;

    @NotNull
    @Size(min = 5, max = 200) 
    private String vendor;

    //NEW
    @NotNull( message="Must not be blank." )
    @Min(value=1, message="Amount should be greater than 0")
    private Integer amount;

    @NotNull
    @Size(min = 5, max = 200)
    private String description;

    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // 02 constructeurs , tjrs en avoir 02
    public Travels() {
    }
    public Travels(String expense, String vendor, int amount, String description) {
        this.expense = expense;
        this.vendor = vendor;
        this.amount = amount;
        this.description = description;
    }
    
    // other getters and setters removed for brevity
    @PrePersist // extrait la date actuelle avant de l'enregistrer dns la database
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate // enregistr chaq fois q l'on fera une mise à jour
    protected void onUpdate(){
        this.updatedAt = new Date();
    }


    // getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getExpense() {
        return expense;
    }
    public void setExpense(String expense) {
        this.expense = expense;
    }
    public String getVendor() {
        return vendor;
    }
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }   
    
}
