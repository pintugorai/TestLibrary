package dataValidations;


public class BanksUnitTest {

	//@Test()
	public void isValid_SWIFT_Code_test_01() {
		String str1 = "AAAABB11222";
	    boolean result = new Banks().isValid_SWIFT_Code(str1);
	}
}
