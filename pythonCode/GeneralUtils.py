import re


class GeneralValidation:

    @staticmethod
    def is_matches_with_regex(word, regex):
        p = re.compile(regex)
        if word is None:
            return False
        m = p.match(word)
        return m is not None

    @staticmethod
    def is_valid_SWIFT_code(swift_code):
        regex = r"^[A-Z]{4}[-]{0,1}[A-Z]{2}[-]{0,1}[A-Z0-9]{2}[-]{0,1}[0-9]{3}$"
        return GeneralValidation.is_matches_with_regex(swift_code, regex)

    @staticmethod
    def is_valid_MICR_code(mICRCode):
        regex = r"^[0-9]{1,9}$"
        return GeneralValidation.is_matches_with_regex(mICRCode, regex)

    @staticmethod
    def is_valid_IFSC_code(ifsc_code):
        regex = r"^[A-Z]{4}0[A-Z0-9]{6}$"
        return GeneralValidation.is_matches_with_regex(ifsc_code, regex)

    @staticmethod
    def is_valid_GST_number(gst_no):
        regex = r"^[0-9]{2}[A-Z]{5}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}$"
        return GeneralValidation.is_matches_with_regex(gst_no, regex)

    @staticmethod
    def is_valid_CVV_number(cvv_number):
        regex = r"^[0-9]{3,4}$"
        return GeneralValidation.is_matches_with_regex(cvv_number, regex)

    @staticmethod
    def is_valid_SSN(ssn_number):
        regex = r"^(?!666|000|9\\d{2})\\d{3}-(?!00)\\d{2}-(?!0{4})\\d{4}$"
        return GeneralValidation.is_matches_with_regex(ssn_number, regex)

    @staticmethod
    def is_valid_ISBN_code(isbn_code):
        regex = r"^(?=(?:[^0-9]*[0-9]){10}(?:(?:[^0-9]*[0-9]){3})?$)[\\d-]+$"
        return GeneralValidation.is_matches_with_regex(isbn_code, regex)

    @staticmethod
    def is_valid_ISIN_code(isin_code):
        regex = r"^[A-Z]{2}[-]{0,1}[0-9A-Z]{8}[-]{0,1}[0-9]{1}$"
        return GeneralValidation.is_matches_with_regex(isin_code, regex)

    @staticmethod
    def is_valid_guid(guid):
        regex = r"^[{]?[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}[}]?$"
        return GeneralValidation.is_matches_with_regex(guid, regex)

    @staticmethod
    def is_valid_visa_card_number(visaCardNo):
        regex = r"^4[0-9]{12}(?:[0-9]{3})?$"
        return GeneralValidation.is_matches_with_regex(visaCardNo, regex)

    @staticmethod
    def is_valid_master_card_number(masterCardNo):
        regex = r"^5[1-5][0-9]{14}|^(222[1-9]|22[3-9]\\d|2[3-6]\\d{2}|27[0-1]\\d|2720)[0-9]{12}$"
        return GeneralValidation.is_matches_with_regex(masterCardNo, regex)

    @staticmethod
    def is_valid_pan_card_number(panCardNo):
        regex = r"[A-Z]{5}[0-9]{4}[A-Z]{1}"
        return GeneralValidation.is_matches_with_regex(panCardNo, regex)

    @staticmethod
    def is_valid_pin_code(pin):
        regex = r"^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$"
        return GeneralValidation.is_matches_with_regex(pin, regex)

    @staticmethod
    def is_valid_hexa_color_code(hexaColorCode):
        regex = r"^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$"
        return GeneralValidation.is_matches_with_regex(hexaColorCode, regex)

    @staticmethod
    def is_valid_LEI_code(leiCode):
        regex = r"^[0-9]{4}[0]{2}[A-Z0-9]{12}[0-9]{2}$"
        return GeneralValidation.is_matches_with_regex(leiCode, regex)

    @staticmethod
    def is_valid_phone_number(phoneNo):
        regex = r"^[+]{1}(?:[0-9\\-\\(\\)\\/\\.]\\s?){6, 15}[0-9]{1}$"
        return GeneralValidation.is_matches_with_regex(phoneNo, regex)


# Example usage
swift_code = "ABCD-12-EF-34-567"
if GeneralValidation.is_valid_SWIFT_code(swift_code):
    print("Valid SWIFT code")
else:
    print("Invalid SWIFT code")


#### Calling
validation = GeneralValidation()

swift_code = "ABCD-12-EF-34-567"
if validation.is_valid_SWIFT_code(swift_code):
    print("Valid SWIFT code")
else:
    print("Invalid SWIFT code")

mICRCode = "123456789"
if validation.is_valid_MICR_code(mICRCode):
    print("Valid MICR code")
else:
    print("Invalid MICR code")

ifsc_code = "ABCD0123456"
if validation.is_valid_IFSC_code(ifsc_code):
    print("Valid IFSC code")
else:
    print("Invalid IFSC code")

gst_no = "12ABCDE1234Z1A"
if validation.is_valid_GST_number(gst_no):
    print("Valid GST number")
else:
    print("Invalid GST number")

cvv_number = "123"
if validation.is_valid_CVV_number(cvv_number):
    print("Valid CVV number")
else:
    print("Invalid CVV number")

ssn_number = "123-45-6789"
if validation.is_valid_SSN(ssn_number):
    print("Valid SSN")
else:
    print("Invalid SSN")

isbn_code = "978-3-16-148410-0"
if validation.is_valid_ISBN_code(isbn_code):
    print("Valid ISBN code")
else:
    print("Invalid ISBN code")