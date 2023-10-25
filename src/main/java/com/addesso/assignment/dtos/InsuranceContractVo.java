package com.addesso.assignment.dtos;

public class InsuranceContractVo {

    private int id;

    private String policyHolderName;

    public InsuranceContractVo(int id, String policyHolderName) {
        this.id = id;
        this.policyHolderName = policyHolderName;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPolicyHolderName() {
        return this.policyHolderName;
    }

    public void setPolicyHolderName(String policyHolderName) {
        this.policyHolderName = policyHolderName;
    }

}
