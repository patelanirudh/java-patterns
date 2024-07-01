package com.newpattern.observer;

public class HifidelityAssertionData {
	public String challengeId;
	public String faceId;
	public String phoneNumber;
	public String challengeStatus;
	public boolean isSuccess;
	
	public HifidelityAssertionData(String challengeId, String faceId, String phoneNumber, String challengeStatus,
			boolean isSuccess) {
		super();
		this.challengeId = challengeId;
		this.faceId = faceId;
		this.phoneNumber = phoneNumber;
		this.challengeStatus = challengeStatus;
		this.isSuccess = isSuccess;
	}
	
	public String getChallengeId() {
		return challengeId;
	}

	public String getFaceId() {
		return faceId;
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
		return "HifidelityAssertionData [challengeId=" + challengeId + ", faceId=" + faceId + ", phoneNumber="
				+ phoneNumber + ", challengeStatus=" + challengeStatus + ", isSuccess=" + isSuccess + "]";
	}
}
