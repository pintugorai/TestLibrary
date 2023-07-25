package dataValidations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Banks {

	public static boolean isMatchesWithRegex(String word, String regex) {

		Pattern p = Pattern.compile(regex);
		if (word == null) {
			return false;
		}
		Matcher m = p.matcher(word);
		return m.matches();
	}

	// How to Validate SWIFT/BIC Code Using RegEx?
	public static boolean isValid_SWIFT_Code(String swift_code) {

		// Regex of valid ISIN Code
		String regex = "^[A-Z]{4}[-]{0,1}[A-Z]{2}[-]{0,1}[A-Z0-9]{2}[-]{0,1}[0-9]{3}$";

		return Banks.isMatchesWithRegex(swift_code, regex);
	}

	public static boolean isValidMICRCode(String mICRCode) {
		String regex = "^[0-9]{1,9}$";

		if (mICRCode == null) {
			return false;
		}

		return Banks.isMatchesWithRegex(mICRCode, regex);
	}

	public static boolean isValidIFSCCode(String ifsc_code) {
		// Regex to check valid IFSC Code.
		String regex = "^[A-Z]{4}0[A-Z0-9]{6}$";

		if (ifsc_code == null) {
			return false;
		}

		return Banks.isMatchesWithRegex(ifsc_code, regex);
	}

	public static boolean isValidGSTNo(String gst_no) {
		// Regex to check valid
		// GST (Goods and Services Tax) number
		String regex = "^[0-9]{2}[A-Z]{5}[0-9]{4}" + "[A-Z]{1}[1-9A-Z]{1}" + "Z[0-9A-Z]{1}$";

		if (gst_no == null) {
			return false;
		}

		return Banks.isMatchesWithRegex(gst_no, regex);
	}

	public static boolean isValidCVVNumber(String cvv_number) {
		// Regex to check valid CVV number.
		String regex = "^[0-9]{3,4}$";

		if (cvv_number == null) {
			return false;
		}

		return Banks.isMatchesWithRegex(cvv_number, regex);
	}

	public static boolean isValidSSN(String ssn_number) {
		// Regex to check SSN
		// (Social Security Number).
		String regex = "^(?!666|000|9\\d{2})\\d{3}" + "-(?!00)\\d{2}-" + "(?!0{4})\\d{4}$";

		if (ssn_number == null) {
			return false;
		}

		return Banks.isMatchesWithRegex(ssn_number, regex);
	}

	public static void main(String[] args) {

		Banks bank = new Banks();
		// bank.pattern_check_driver();
		// bank.swift_check_driver();
		// bank.micr_check_driver();
		// bank.ifsc_check_driver();
		// bank.gst_no_check_driver();
		// bank.cvv_check_driver();
		bank.ssn_check_driver();
	}

	private void pattern_check_driver() {
		String regex = "^[A-Za-z]\\w{5,29}$";
		String word = "Geeksforgeeks";

		System.out.println(Banks.isMatchesWithRegex(word, regex));
	}

	private void swift_check_driver() {
		// Swift
		String str1 = "AAAABB11222";
		System.out.println("IS " + str1 + " matches with valid SWIFT Code? " + isValid_SWIFT_Code(str1));

		// Test Case 2:
		String str2 = "AAAA-BB-11-222";
		System.out.println("IS " + str2 + " matches with valid SWIFT Code? " + isValid_SWIFT_Code(str2));

		// Test Case 3:
		String str3 = "@US-12345";
		System.out.println("IS " + str3 + " matches with valid SWIFT Code? " + isValid_SWIFT_Code(str3));

		// Test Case 4:
		String str4 = "XS9136812895";
		System.out.println("IS " + str4 + " matches with valid SWIFT Code? " + isValid_SWIFT_Code(str4));

		// Test Case 5:
		String str5 = "US45256BAD38";
		System.out.println("IS " + str5 + " matches with valid SWIFT Code? " + isValid_SWIFT_Code(str5));

		// Test Case 6:
		String str6 = "AAAA-BB-RR-222";
		System.out.println("IS " + str6 + " matches with valid SWIFT Code? " + isValid_SWIFT_Code(str6));
	}

	private void micr_check_driver() {
		// Test Case 1:
		String str1 = "BNZAA2318J";
		System.out.println(isValidMICRCode(str1));

		// Test Case 2:
		String str2 = "123@3459";
		System.out.println(isValidMICRCode(str2));

		// Test Case 3:
		String str3 = "BNZAA2318JM";
		System.out.println(isValidMICRCode(str3));

		// Test Case 4:
		String str4 = "934517865";
		System.out.println(isValidMICRCode(str4));

		// Test Case 5:
		String str5 = "Rahul 1998";
		System.out.println(isValidMICRCode(str5));

		// Test Case 6:
		String str6 = "654294563";
		System.out.println(isValidMICRCode(str6));
	}

	private void ifsc_check_driver() {
		// Test Case 1:
		String str1 = "SBIN0125620";
		System.out.println(isValidIFSCCode(str1));

		// Test Case 2:
		String str2 = "SBIN0125";
		System.out.println(isValidIFSCCode(str2));

		// Test Case 3:
		String str3 = "1234SBIN012";
		System.out.println(isValidIFSCCode(str3));

		// Test Case 4:
		String str4 = "SBIN7125620";
		System.out.println(isValidIFSCCode(str4));
	}

	private void gst_no_check_driver() {
		// Test Case 1:
		String str1 = "06BZAHM6385P6Z2";
		System.out.println(isValidGSTNo(str1));

		// Test Case 2:
		String str2 = "06BZAF67";
		System.out.println(isValidGSTNo(str2));

		// Test Case 3:
		String str3 = "AZBZAHM6385P6Z2";
		System.out.println(isValidGSTNo(str3));

		// Test Case 4:
		String str4 = "06BZ63AHM85P6Z2";
		System.out.println(isValidGSTNo(str4));

		// Test Case 5:
		String str5 = "06BZAHM6385P6F2";
		System.out.println(isValidGSTNo(str5));
	}

	private void cvv_check_driver() {
		// Test Case 1:
		String str1 = "561";
		System.out.println(isValidCVVNumber(str1));

		// Test Case 2:
		String str2 = "5061";
		System.out.println(isValidCVVNumber(str2));

		// Test Case 3:
		String str3 = "50614";
		System.out.println(isValidCVVNumber(str3));

		// Test Case 4:
		String str4 = "5a#1";
		System.out.println(isValidCVVNumber(str4));
	}

	private void ssn_check_driver() {
		// Test Case 1:
		String str1 = "856-45-6789";
		;
		System.out.println(isValidSSN(str1));

		// Test Case 2:
		String str2 = "000-45-6789";
		;
		System.out.println(isValidSSN(str2));

		// Test Case 3:
		String str3 = "856-452-6789";
		System.out.println(isValidSSN(str3));

		// Test Case 4:
		String str4 = "856-45-0000";
		System.out.println(isValidSSN(str4));

	}
}
