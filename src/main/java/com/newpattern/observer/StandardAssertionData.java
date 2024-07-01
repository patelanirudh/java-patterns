package com.newpattern.observer;

public class StandardAssertionData {
	public String challengeId;
	public String phoneNumber;
	public String challengeStatus;
	public boolean isSuccess;
	
	public StandardAssertionData(String challengeId, String phoneNumber, String challengeStatus, boolean isSuccess) {
		super();
		this.challengeId = challengeId;
		this.phoneNumber = phoneNumber;
		this.challengeStatus = challengeStatus;
		this.isSuccess = isSuccess;
	}

	public String getChallengeId() {
		return challengeId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getChallengeStatus() {
		return challengeStatus;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	@Override
	public String toString() {
		return "StandardAssertionData [challengeId=" + challengeId + ", phoneNumber=" + phoneNumber
				+ ", challengeStatus=" + challengeStatus + ", isSuccess=" + isSuccess + "]";
	}
	
}
