package com.accountmanager.accIrembo.enumaration;


public enum VerificationStatus {
    PENDING("Still in progress"),
    APPROVED("Successfully Verified"),
    REJECTED("Failed Verification");

    private final String verificationStatus;

    VerificationStatus(String status ){
        this.verificationStatus = status;
    }

    public String getStatus(){
        return this.verificationStatus;
    }
}
