import unittest

from Utilities.generalUtilities.GeneralUtils import GeneralValidation


class BanksUnitTest(unittest.TestCase):
    # Test for isValidSWIFTCode() method

    def test_isValidSWIFTCode_True_ValidSwift_test1(self):
        swift_code = "AAAABB11222"
        self.assertTrue(GeneralValidation.isValidSWIFTCode(swift_code), "Validation Failed, swift = " + swift_code)

    def test_isValidSWIFTCode_True_ValidSwift_test2(self):
        swift_code = "AAAA-BB-11-222"
        self.assertTrue(GeneralValidation.isValidSWIFTCode(swift_code), "Validation Failed, swift = " + swift_code)

    def test_isValidSWIFTCode_False_InvalidSwift_test3(self):
        swift_code = "@US-12345"
        self.assertFalse(GeneralValidation.isValidSWIFTCode(swift_code), "Validation Failed, swift = " + swift_code)

    # Test for isMatchesWithRegex() method
    def test_isMatchesWithRegex_True_ValidCase_Test1(self):
        regex = "^[A-Z]{4}[-]{0,1}[A-Z]{2}[-]{0,1}[A-Z0-9]{2}[-]{0,1}[0-9]{3}$"
        word = "AAAABB11222"
        self.assertTrue(GeneralValidation.isMatchesWithRegex(word, regex), "Validation Failed, word = " + word)

    def test_isMatchesWithRegex_False_invalidCase_Test2(self):
        regex = "^[A-Z]{4}[-]{0,1}[A-Z]{2}[-]{0,1}[A-Z0-9]{2}[-]{0,1}[0-9]{3}$"
        word = "123AAAABB11222"
        self.assertFalse(GeneralValidation.isMatchesWithRegex(word, regex), "Validation Failed, word = " + word)

    # Test for isValidMICRCode() method
    def test_isValidMICRCode_True_ValidCase_Test1(self):
        mICRCode = "934517865"
        self.assertTrue(GeneralValidation.isValidMICRCode(mICRCode), "Validation Failed, mICRCode = " + mICRCode)

    def test_isValidMICRCode_False_InvalidCase_Test2(self):
        mICRCode = "123@3459"
        self.assertFalse(GeneralValidation.isValidMICRCode(mICRCode), "Validation Failed, mICRCode = " + mICRCode)

    # Test for isValidIFSCCode() method
    def test_isValidIFSCCode_True_ValidCase_Test1(self):
        ifsc_code = "SBIN0125620"
        self.assertTrue(GeneralValidation.isValidIFSCCode(ifsc_code), "Validation Failed, ifsc_code = " + ifsc_code)

    def test_isValidIFSCCode_False_InvalidCase_Test2(self):
        ifsc_code = "934517865"
        self.assertFalse(GeneralValidation.isValidIFSCCode(ifsc_code), "Validation Failed, ifsc_code = " + ifsc_code)

    # Test for isValidGSTNo() method
    def test_isValidGSTNo_True_ValidCase_Test1(self):
        gst_no = "06BZAHM6385P6Z2"
        self.assertTrue(GeneralValidation.isValidGSTNo(gst_no), "Validation Failed, gst_no = " + gst_no)

    def test_isValidGSTNo_False_InvalidCase_Test2(self):
        gst_no = "AZBZAHM6385P6Z2"
        self.assertFalse(GeneralValidation.isValidGSTNo(gst_no), "Validation Failed, gst_no = " + gst_no)

    # Test for isValidCVVNumber() method
    def test_isValidCVVNumber_True_ValidCase_Test1(self):
        cvv_number = "561"
        self.assertTrue(GeneralValidation.isValidCVVNumber(cvv_number), "Validation Failed, cvv_number = " + cvv_number)

    def test_isValidCVVNumber_True_ValidCase_Test2(self):
        cvv_number = "5061"
        self.assertTrue(GeneralValidation.isValidCVVNumber(cvv_number), "Validation Failed, cvv_number = " + cvv_number)

    def test_isValidCVVNumber_False_InvalidCase_Test3(self):
        cvv_number = "561561"
        self.assertFalse(GeneralValidation.isValidCVVNumber(cvv_number), "Validation Failed, cvv_number = " + cvv_number)

    # Test for isValidSSN() method
    def test_isValidSSN_True_ValidCase_Test1(self):
        ssn_number = "856-45-6789"
        self.assertTrue(GeneralValidation.isValidSSN(ssn_number), "Validation Failed, ssn_number = " + ssn_number)

    def test_isValidSSN_False_InvalidCase_Test2(self):
        ssn_number = "856-452-6789"
        self.assertFalse(GeneralValidation.isValidSSN(ssn_number), "Validation Failed, ssn_number = " + ssn_number)

if __name__ == '__main__':
    unittest.main()