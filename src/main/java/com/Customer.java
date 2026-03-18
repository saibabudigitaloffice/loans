package com;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String mobile;
    private String email;
    private String loanType;
    private String message;

    // getters setters
    public Long getId(){ return id; }
    public void setId(Long id){ this.id=id; }

    public String getName(){ return name; }
    public void setName(String name){ this.name=name; }

    public String getMobile(){ return mobile; }
    public void setMobile(String mobile){ this.mobile=mobile; }

    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email=email; }

    public String getLoanType(){ return loanType; }
    public void setLoanType(String loanType){ this.loanType=loanType; }

    public String getMessage(){ return message; }
    public void setMessage(String message){ this.message=message; }
}