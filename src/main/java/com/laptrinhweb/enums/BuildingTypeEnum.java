package com.laptrinhweb.enums;

public enum BuildingTypeEnum {
	tang_tret ("tang tret"),
	nguyen_can("nguyen can"),
	noi_that("noi that");
	private final String value;
 private BuildingTypeEnum  (String value) {
	 this.value=value;
 }
 public String getValue() {
	 return value;
 }
}
