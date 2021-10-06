package com.jeremy.pokebook.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;
@Entity
@Table(name="expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
//    @NotNull
    @NotEmpty(message="Name must be entered!")
//    @Min(value=1, message="Name must be entered!")
    private String name;
    
    
    @NotEmpty(message="Vendor must be entered!")
//    @Min(value=1, message="Vendor must be entered!")
    private String vendor;
    
    @NotNull(message="Amount must be entered!")
    @DecimalMin(message="Amount must be greated than 0!", value = "0.01")
    private Double amount;
    
//    @Min(value=1, message="Description must be entered!")
    @NotEmpty(message="Description must be entered!")
    private String description;
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Expense() {
    }
    public Expense(String name, String vendor, Double amount, String description) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.vendor = vendor;
    }
    

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	// other getters and setters removed for brevity
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    public Date getCreatedAt() {
    	return this.createdAt;
    }
    public Date getUpdatedAt() {
    	return this.updatedAt;
    }
}
