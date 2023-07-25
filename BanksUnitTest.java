package com.test.utility;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bank.util.GeneralValidation;

public class BanksUnitTest {
	// Test for isValidSWIFTCode() method

	@Test()
	public void isValidSWIFTCode_True_ValidSwift_test1() {
		String swift_code = "AAAABB11222";
		Assert.assertTrue(GeneralValidation.isValidSWIFTCode(swift_code), "Validation Failed, swift = " + swift_code);
	}

	@Test()
	public void isValidSWIFTCode_True_ValidSwift_test2() {
		String swift_code = "AAAA-BB-11-222";
		Assert.assertTrue(GeneralValidation.isValidSWIFTCode(swift_code), "Validation Failed, swift = " + swift_code);
	}

	@Test()
	public void isValidSWIFTCode_False_InvalidSwift_test3() {
		String swift_code = "@US-12345";
		Assert.assertFalse(GeneralValidation.isValidSWIFTCode(swift_code), "Validation Failed, swift = " + swift_code);
	}

	// Test for isMatchesWithRegex() method
	@Test()
	public void isMatchesWithRegex_True_ValidCase_Test1() {
		String regex = "^[A-Z]{4}[-]{0,1}[A-Z]{2}[-]{0,1}[A-Z0-9]{2}[-]{0,1}[0-9]{3}$";
		String word = "AAAABB11222";
		Assert.assertTrue(GeneralValidation.isMatchesWithRegex(word, regex), "Validation Failed, word = " + word);
	}

	@Test()
	public void isMatchesWithRegex_False_invalidCase_Test2() {
		String regex = "^[A-Z]{4}[-]{0,1}[A-Z]{2}[-]{0,1}[A-Z0-9]{2}[-]{0,1}[0-9]{3}$";
		String word = "123AAAABB11222";
		Assert.assertFalse(GeneralValidation.isMatchesWithRegex(word, regex), "Validation Failed, word = " + word);
	}

	// Test for isValidMICRCode() method
	@Test()
	public void isValidMICRCode_True_ValidCase_Test1() {
		String mICRCode = "934517865";
		Assert.assertTrue(GeneralValidation.isValidMICRCode(mICRCode), "Validation Failed, mICRCode = " + mICRCode);
	}

	@Test()
	public void isValidMICRCode_False_InvalidCase_Test2() {
		String mICRCode = "123@3459";
		Assert.assertFalse(GeneralValidation.isValidMICRCode(mICRCode), "Validation Failed, mICRCode = " + mICRCode);
	}

	// Test for isValidIFSCCode() method
	@Test()
	public void isValidIFSCCode_True_ValidCase_Test1() {
		String ifsc_code = "SBIN0125620";
		Assert.assertTrue(GeneralValidation.isValidIFSCCode(ifsc_code), "Validation Failed, ifsc_code = " + ifsc_code);
	}

	@Test()
	public void isValidIFSCCode_False_InvalidCase_Test2() {
		String ifsc_code = "934517865";
		Assert.assertFalse(GeneralValidation.isValidIFSCCode(ifsc_code), "Validation Failed, ifsc_code = " + ifsc_code);
	}

	// Test for isValidGSTNo() method
	@Test()
	public void isValidGSTNo_True_ValidCase_Test1() {
		String gst_no = "06BZAHM6385P6Z2";
		Assert.assertTrue(GeneralValidation.isValidGSTNo(gst_no), "Validation Failed, gst_no = " + gst_no);
	}

	@Test()
	public void isValidGSTNo_False_InvalidCase_Test2() {
		String gst_no = "AZBZAHM6385P6Z2";
		Assert.assertFalse(GeneralValidation.isValidGSTNo(gst_no), "Validation Failed, gst_no = " + gst_no);
	}

	// Test for isValidCVVNumber() method
	@Test()
	public void isValidCVVNumber_True_ValidCase_Test1() {
		String cvv_number = "561";
		Assert.assertTrue(GeneralValidation.isValidCVVNumber(cvv_number), "Validation Failed, cvv_number = " + cvv_number);
	}

	@Test()
	public void isValidCVVNumber_True_ValidCase_Test2() {
		String cvv_number = "5061";
		Assert.assertTrue(GeneralValidation.isValidCVVNumber(cvv_number), "Validation Failed, cvv_number = " + cvv_number);
	}

	@Test()
	public void isValidCVVNumber_False_InvalidCase_Test3() {
		String cvv_number = "561561";
		Assert.assertFalse(GeneralValidation.isValidCVVNumber(cvv_number), "Validation Failed, cvv_number = " + cvv_number);
	}

	// Test for isValidSSN() method
	@Test()
	public void isValidSSN_True_ValidCase_Test1() {
		String ssn_number = "856-45-6789";
		Assert.assertTrue(GeneralValidation.isValidSSN(ssn_number), "Validation Failed, ssn_number = " + ssn_number);
	}

	@Test()
	public void isValidSSN_False_InvalidCase_Test2() {
		String ssn_number = "856-452-6789";
		Assert.assertFalse(GeneralValidation.isValidSSN(ssn_number), "Validation Failed, ssn_number = " + ssn_number);
	}

}
