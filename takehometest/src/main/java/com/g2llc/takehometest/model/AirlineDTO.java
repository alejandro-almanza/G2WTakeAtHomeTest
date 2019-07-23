package com.g2llc.takehometest.model;

public class AirlineDTO {
	private String name;
	private String twoDigitCode;
	private String treeDigitCode;
	private String country;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTwoDigitCode() {
		return twoDigitCode;
	}
	public void setTwoDigitCode(String twoDigitCode) {
		this.twoDigitCode = twoDigitCode;
	}
	public String getTreeDigitCode() {
		return treeDigitCode;
	}
	public void setTreeDigitCode(String treeDigitCode) {
		this.treeDigitCode = treeDigitCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
