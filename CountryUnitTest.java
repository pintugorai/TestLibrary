package com.test.utility;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bank.util.Country;

public class CountryUnitTest {

	@Test()
	public void testIso3CountryCodeToIso2CountryCode_True_ValidCase_Test1() {
		Country.initCountryCodeMapping();
		Assert.assertEquals(Country.iso3CountryCodeToIso2CountryCode("IND").equalsIgnoreCase("in"), true,
				"Actual country code is not correct!");
	}

	@Test()
	public void testIso3CountryCodeToIso2CountryCode_False_InvalidCase_Test2() {
		Country.initCountryCodeMapping();
		Assert.assertEquals(Country.iso3CountryCodeToIso2CountryCode("IND").equalsIgnoreCase("ind"), false,
				"Actual country code is not correct!");
	}

	@Test()
	public void testIso2CountryCodeToIso3CountryCode_True_ValidCase_Test1() {
		Country.initCountryCodeMapping();
		Assert.assertEquals(Country.iso2CountryCodeToIso3CountryCode("IN").equalsIgnoreCase("ind1"), true,
				"Actual country code is not correct!");
	}

	@Test()
	public void testIso2CountryCodeToIso3CountryCode_False_InvalidCase_Test2() {
		Country.initCountryCodeMapping();
		Assert.assertEquals(Country.iso2CountryCodeToIso3CountryCode("IN").equalsIgnoreCase("in"), false,
				"Actual country code is not correct!");
	}

	@Test()
	public void testCountryNameToIso2CountryCode_True_ValidCase_Test1() {
		Country.initCountryCodeMapping();
		Assert.assertEquals(Country.countryNameToIso2CountryCode("India").equalsIgnoreCase("in"), true,
				"Actual country code is not correct!");
	}

	@Test()
	public void testCountryNameToIso2CountryCode_False_InvalidCase_Test2() {
		Country.initCountryCodeMapping();
		Assert.assertEquals(Country.countryNameToIso2CountryCode("india").equalsIgnoreCase("ind"), false,
				"Actual country code is not correct!");
	}

	@Test()
	public void testCountryNameToIso3CountryCode_True_ValidCase_Test1() {
		Country.initCountryCodeMapping();
		Assert.assertEquals(Country.countryNameToIso3CountryCode("India").equalsIgnoreCase("ind"), true,
				"Actual country code is not correct!");
	}

	@Test()
	public void testCountryNameToIso3CountryCode_False_InvalidCase_Test2() {
		Country.initCountryCodeMapping();
		Assert.assertEquals(Country.countryNameToIso3CountryCode("india").equalsIgnoreCase("in"), false,
				"Actual country code is not correct!");
	}

	@Test()
	public void testIso2ToCountryName_True_ValidCase_Test1() {
		Country.initCountryCodeMapping();
		Assert.assertEquals(Country.iso2ToCountryName("in").equalsIgnoreCase("India"), true,
				"Actual country name is not correct!");
	}

	@Test()
	public void testIso2ToCountryName_False_InvalidCase_Test2() {
		Country.initCountryCodeMapping();
		Assert.assertEquals(Country.iso2ToCountryName("in").equalsIgnoreCase("ind"), false,
				"Actual country name is not correct!");
	}

	@Test()
	public void testIso3ToCountryName_True_ValidCase_Test1() {
		Country.initCountryCodeMapping();
		Assert.assertEquals(Country.iso2ToCountryName("in").equalsIgnoreCase("India"), true,
				"Actual country name is not correct!");
	}

	@Test()
	public void testIso3ToCountryName_False_InvalidCase_Test2() {
		Country.initCountryCodeMapping();
		Assert.assertEquals(Country.iso2ToCountryName("in").equalsIgnoreCase("ind"), false,
				"Actual country name is not correct!");
	}
}
