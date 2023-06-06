package com.bank.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeneralValidation {

	/**
	 * Validates a string with regex
	 * 
	 * @param word  a String
	 * @param regex a regular expression
	 * @return It returns true if given string validated with given regex otherwise
	 *         false
	 * @author Pintu Gorai
	 */
	public static boolean isMatchesWithRegex(String word, String regex) {
		Pattern p = Pattern.compile(regex);
		if (word == null)
			return false;
		Matcher m = p.matcher(word);
		return m.matches();
	}

	/**
	 * Validate SWIFT/BIC Code Using RegEx
	 * 
	 * @param swift_code
	 * @return returns true if the given value is valid otherwise return false
	 * @author Pintu Gorai
	 */
	public static boolean isValidSWIFTCode(String swift_code) {
		String regex = "^[A-Z]{4}[-]{0,1}[A-Z]{2}[-]{0,1}[A-Z0-9]{2}[-]{0,1}[0-9]{3}$";
		return GeneralValidation.isMatchesWithRegex(swift_code, regex);
	}

	/**
	 * Validate MICR Code Using RegEx
	 * 
	 * @param mICRCode
	 * @return returns true if the given value is valid otherwise return false
	 * @author Pintu Gorai
	 */
	public static boolean isValidMICRCode(String mICRCode) {
		String regex = "^[0-9]{1,9}$";
		return GeneralValidation.isMatchesWithRegex(mICRCode, regex);
	}

	/**
	 * Validate IFSC Code Using RegEx
	 * 
	 * @param ifsc_code
	 * @return returns true if the given value is valid otherwise return false
	 * @author Pintu Gorai
	 */
	public static boolean isValidIFSCCode(String ifsc_code) {
		// Regex to check valid IFSC Code.
		String regex = "^[A-Z]{4}0[A-Z0-9]{6}$";
		return GeneralValidation.isMatchesWithRegex(ifsc_code, regex);
	}

	/**
	 * Validate GST number Using RegEx
	 * 
	 * @param gst_no
	 * @return returns true if the given value is valid otherwise return false
	 * @author Pintu Gorai
	 */
	public static boolean isValidGSTNo(String gst_no) {
		// Regex to check valid
		// GST (Goods and Services Tax) number
		String regex = "^[0-9]{2}[A-Z]{5}[0-9]{4}" + "[A-Z]{1}[1-9A-Z]{1}" + "Z[0-9A-Z]{1}$";
		return GeneralValidation.isMatchesWithRegex(gst_no, regex);
	}

	/**
	 * Validate CVV Using RegEx
	 * 
	 * @param cvv_number
	 * @return returns true if the given value is valid otherwise return false
	 * @author Pintu Gorai
	 */
	public static boolean isValidCVVNumber(String cvv_number) {
		// Regex to check valid CVV number.
		String regex = "^[0-9]{3,4}$";
		return GeneralValidation.isMatchesWithRegex(cvv_number, regex);
	}

	/**
	 * Validate SSN Using RegEx
	 * 
	 * @param ssn_number
	 * @return returns true if the given value is valid otherwise return false
	 * @author Pintu Gorai
	 */
	public static boolean isValidSSN(String ssn_number) {
		// Regex to check SSN
		// (Social Security Number).
		String regex = "^(?!666|000|9\\d{2})\\d{3}" + "-(?!00)\\d{2}-" + "(?!0{4})\\d{4}$";
		return GeneralValidation.isMatchesWithRegex(ssn_number, regex);
	}

	/**
	 * Validate ISBN Using RegEx
	 * 
	 * @param isbn_code
	 * @return returns true if the given value is valid otherwise return false
	 * @author Pintu Gorai
	 */
	public static boolean isValidISBNCode(String isbn_code) {

		// Regex to check valid ISBN Code
		String regex = "^(?=(?:[^0-9]*[0-9]){10}(?:(?:[^0-9]*[0-9]){3})?$)[\\d-]+$";
		return GeneralValidation.isMatchesWithRegex(isbn_code, regex);
	}

	/**
	 * Validate ISIN Using RegEx
	 * 
	 * @param isin_code
	 * @return returns true if the given value is valid otherwise return false
	 * @author Pintu Gorai
	 */
	public boolean isValid_ISIN_Code(String isin_code) {
		// Regex to check valid ISIN Code
		String regex = "^[A-Z]{2}[-]{0,1}[0-9A-Z]{8}[-]{0,1}[0-9]{1}$";
		return GeneralValidation.isMatchesWithRegex(isin_code, regex);
	}

	/**
	 * Validate GUID Using RegEx
	 * 
	 * @param guid
	 * @return returns true if the given value is valid otherwise return false
	 * @author Pintu Gorai
	 */
	public boolean isValidGuid(String guid) {
		// Regex to check valid ISIN Code
		String regex = "^[{]?[0-9a-fA-F]{8}" + "-([0-9a-fA-F]{4}-)" + "{3}[0-9a-fA-F]{12}[}]?$";
		return GeneralValidation.isMatchesWithRegex(guid, regex);
		/*
		 * // Test Case 1: String v = "123e4567-e89b-12d3-a456-9AC7CBDCEE52";
		 * 
		 * 
		 * // Test Case 2: String v = "{123e4567-e89b-12d3-a456-9AC7CBDCEE52}";
		 * 
		 * 
		 * // Test Case 3: String i = "123e4567-h89b-12d3-a456-9AC7CBDCEE52";
		 * 
		 * 
		 * // Test Case 4: String i = "123e4567-h89b-12d3-a456";
		 */
	}

	/**
	 * Validate VISA Using RegEx
	 * 
	 * @param visaCardNo
	 * @return returns true if the given value is valid otherwise return false
	 * @author Pintu Gorai
	 */
	public boolean isValidVisaCardNo(String visaCardNo) {
		String regex = "^4[0-9]{12}(?:[0-9]{3})?$";
		return GeneralValidation.isMatchesWithRegex(visaCardNo, regex);
		/*
		 * // Test Case 1: String v= "4155279860457";
		 * 
		 * // Test Case 2: String v= "4155279860457201";
		 * 
		 * // Test Case 3: String i= "4155279";
		 * 
		 * 
		 * // Test Case 4: String i= "6155279860457";
		 * 
		 * 
		 * // Test Case 5: String i= "415a27##60457";
		 */
	}

	/**
	 * Validate Master Card number Using RegEx
	 * 
	 * @param masterCardNo
	 * @return returns true if the given value is valid otherwise return false
	 * @author Pintu Gorai
	 */
	public boolean isValidMasterCardNo(String masterCardNo) {
		String regex = "^5[1-5][0-9]{14}|" + "^(222[1-9]|22[3-9]\\d|" + "2[3-6]\\d{2}|27[0-1]\\d|" + "2720)[0-9]{12}$";
		return GeneralValidation.isMatchesWithRegex(masterCardNo, regex);
	}

	/**
	 * Validate PAN Using RegEx
	 * 
	 * @param panCardNo
	 * @return returns true if the given value is valid otherwise return false
	 * @author Pintu Gorai
	 */
	public boolean isValidPanCardNo(String panCardNo) {
		String regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
		return GeneralValidation.isMatchesWithRegex(panCardNo, regex);
	}

	/**
	 * Validate pin Using RegEx
	 * 
	 * @param pin
	 * @return returns true if the given value is valid otherwise return false
	 * @author Pintu Gorai
	 */
	public boolean isValidPinCode(String pin) {
		String regex = "^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$";
		return GeneralValidation.isMatchesWithRegex(pin, regex);
	}

	/**
	 * Validate hexaColorCode Using RegEx
	 * 
	 * @param hexaColorCode
	 * @return returns true if the given value is valid otherwise return false
	 * @author Pintu Gorai
	 */
	public boolean isValidHexaCode(String hexaColorCode) {
		String regex = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
		return GeneralValidation.isMatchesWithRegex(hexaColorCode, regex);
	}

	// Validate LEI(Legal Identity Identifier) using Regular Expression
	/**
	 * Validate LEI(Legal Identity Identifier) Using RegEx
	 * 
	 * @param leiCode
	 * @return returns true if the given value is valid otherwise return false
	 * @author Pintu Gorai
	 */
	public boolean isValid_LEICode(String leiCode) {
		String regex = "^[0-9]{4}[0]{2}[A-Z0-9]{12}[0-9]{2}$";
		return GeneralValidation.isMatchesWithRegex(leiCode, regex);
	}

	/**
	 * Validate indian phone number with country code Using RegEx
	 * 
	 * @param phoneNo
	 * @return returns true if the given value is valid otherwise return false
	 * @author Pintu Gorai
	 */
	public boolean isValidPhoneNumber(String phoneNo) {
		String regex = "^[+]{1}(?:[0-9\\-\\(\\)\\/\\.]\\s?){6, 15}[0-9]{1}$";
		return GeneralValidation.isMatchesWithRegex(phoneNo, regex);
	}

	public static void main(String[] args) {

	}
	// routing
}
