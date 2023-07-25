package testlib.process;

import java.io.InputStreamReader;
import java.io.Reader;

public class GetProcessID {

	/**
	 * Get process ID(PID) of a given port number for Windows
	 * 
	 * @param port
	 * @return
	 * @author Pintu
	 */
	public static int getPidWindows(int port) {
		String[] command = { "netstat", "-on" };
		try {
			Process netstat = Runtime.getRuntime().exec(command);

			StringBuilder conectionList = new StringBuilder();
			Reader reader = new InputStreamReader(netstat.getInputStream());
			char[] buffer = new char[1024];
			for (int n = reader.read(buffer); n != -1; n = reader.read(buffer)) {
				conectionList.append(buffer, 0, n);
			}
			reader.close();
			String[] conections = conectionList.toString().split("\n");
			int portIdx = 10000;
			String pid = null;
			for (String conection : conections) {
				int idx = conection.indexOf(":" + port);
				if (idx == -1 || idx > portIdx) {
					continue;
				}
				String state = "ESTABLISHED";
				int stateIdx = conection.indexOf(state);
				if (stateIdx == -1) {
					continue;
				}
				portIdx = idx;
				idx = stateIdx + state.length();
				pid = conection.substring(idx).trim();
			}
			if (pid != null) {
				return Integer.valueOf(pid);
			}

		} catch (Exception e) {
		}

		return 0;

	}

	/**
	 * Get process ID(PID) of a given port number for Linux OS
	 * 
	 * @param port
	 * @return process id(PID)
	 * @author Pintu
	 */
	public static int getPidLinux(int port) {
		String[] command = { "netstat", "-anp" };
		try {
			Process netstat = Runtime.getRuntime().exec(command);

			StringBuilder conectionList = new StringBuilder();
			Reader reader = new InputStreamReader(netstat.getInputStream());
			char[] buffer = new char[1024];
			for (int n = reader.read(buffer); n != -1; n = reader.read(buffer)) {
				conectionList.append(buffer, 0, n);
			}
			reader.close();
			String[] conections = conectionList.toString().split("\n");
			String pid = null;
			for (String conection : conections) {
				if (conection.contains(":" + port) && conection.contains("/soffice.bin")) {
					int idx = conection.indexOf("/soffice.bin");
					int idx2 = idx;
					while (Character.isDigit(conection.charAt(--idx2)))
						;
					pid = conection.substring(idx2 + 1, idx);
				}
			}
			if (pid != null) {
				return Integer.valueOf(pid);
			}

		} catch (Exception e) {
		}

		return 0;
	}

	/**
	 * Get process ID(PID) of a given port number
	 * 
	 * @param port_number
	 * @return
	 * @author Pintu
	 */
	public static int getPid(int port_number) {
		if (System.getProperty("os.name").startsWith("Windows")) {
			return getPidWindows(port_number);
		} else {
			return getPidLinux(port_number);
		}
	}

	public static void main(String[] args) {

		System.out.println(System.getProperty("os.name"));
		System.out.println(getPid(55061));

	}
}

package com.bank.util;

import java.util.*;
import java.util.Locale;

public class Country {

	private static Map<String, Locale> iso3CountryCodelocaleMap;
	private static Map<String, Locale> countryNameLocaleMap;

	/**
	 * Initialized country
	 * @author Pintu
	 */
	public static void initCountryCodeMapping() {
		String[] countries = Locale.getISOCountries();
		iso3CountryCodelocaleMap = new HashMap<String, Locale>(countries.length);
		countryNameLocaleMap = new HashMap<String, Locale>(countries.length);
		for (String country : countries) {
			Locale locale = new Locale("", country);
			iso3CountryCodelocaleMap.put(locale.getISO3Country().toUpperCase(), locale);
			countryNameLocaleMap.put(locale.getDisplayCountry().toLowerCase().trim(), locale);
		}
	}

	/**
	 * This method convert iso3 country code to iso2 country code
	 * @param iso3CountryCode
	 * @return iso2 country code
	 * @author Pintu
	 */
	public static String iso3CountryCodeToIso2CountryCode(String iso3CountryCode) {
		return iso3CountryCodelocaleMap.get(iso3CountryCode).getCountry();
	}

	/**
	 * This method convert iso2 country code to iso3 country code
	 * @param iso2CountryCode
	 * @return iso3 country code
	 * @author Pintu
	 */
	public static String iso2CountryCodeToIso3CountryCode(String iso2CountryCode) {
		Locale locale = new Locale("", iso2CountryCode);
		return locale.getISO3Country();
	}

	/**
	 * This method convert countryName to iso2 country code
	 * @param countryName
	 * @return iso2 country code
	 * @author Pintu
	 */
	public static String countryNameToIso2CountryCode(String countryName) {
		return countryNameLocaleMap.get(countryName.toLowerCase().trim()).getCountry();
	}

	/**
	 * This method convert countryName to iso3 country code
	 * @param countryName
	 * @return iso3 country code
	 * @author Pintu
	 */
	public static String countryNameToIso3CountryCode(String countryName) {
		return countryNameLocaleMap.get(countryName.toLowerCase().trim()).getISO3Country();
	}

	/**
	 * This method convert iso2 country code to country name
	 * @param iso2CountryCode
	 * @return country name
	 * @author Pintu
	 */
	public static String iso2ToCountryName(String iso2CountryCode) {
		Locale locale = new Locale("", iso2CountryCode);
		return locale.getDisplayCountry();
	}

	/**
	 * This method convert iso3 country code to country name
	 * @param iso3CountryCode
	 * @return country name
	 * @author Pintu
	 */
	public static String iso3ToCountryName(String iso3CountryCode) {
		return iso3CountryCodelocaleMap.get(iso3CountryCode).getDisplayCountry();
	}

	public static void getCountryAndCountryCode() {
		Locale[] locales = Locale.getAvailableLocales();
		System.out.println(locales.length);
		ArrayList<String> countries = new ArrayList<String>();
		HashMap<String, String> countryAndCountryCode = new HashMap<String, String>();
		for (Locale locale : locales) {
			String country = locale.getDisplayCountry();
			String code3 = locale.getISO3Country();
			String code2 = locale.getCountry();
			System.out.println(country + " " + code3 + " " + code2);
		}
	}

	public static void main(String[] args) {
		/*
		 * Locale[] locales = Locale.getAvailableLocales(); ArrayList<String> countries
		 * = new ArrayList<String>(); for (Locale locale : locales) { String country =
		 * locale.getDisplayCountry(); if (country.trim().length() > 0 &&
		 * !countries.contains(country)) { countries.add(country); } }
		 * Collections.sort(countries); for (String country : countries) {
		 * System.out.println(country); } System.out.println("# countries found: " +
		 * countries.size());
		 */

		// Country.getCountryAndCountryCode();

		Country.initCountryCodeMapping();
		for (Map.Entry<String, Locale> entry : iso3CountryCodelocaleMap.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", = " + entry.getValue().getCountry() + ", = "
					+ entry.getValue().getISO3Country() + ", = " + entry.getValue().getDisplayCountry() + ", = "
					+ entry.getValue().getDisplayLanguage());
		}

		System.out.println(countryNameToIso2CountryCode("India"));
		System.out.println(countryNameToIso3CountryCode("India"));
		System.out.println(iso2CountryCodeToIso3CountryCode("IN"));
		System.out.println(iso3CountryCodeToIso2CountryCode("IND"));
		System.out.println(iso2ToCountryName("CH"));
		System.out.println(iso3ToCountryName("IND"));
	}

}



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

