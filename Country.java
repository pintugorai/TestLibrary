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
