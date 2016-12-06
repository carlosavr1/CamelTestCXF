package cameltest;

import com.cdyne.ws.ArrayOfAnyType;
import com.cdyne.ws.EmailVerNoTestEmailSoap;
import com.cdyne.ws.ReturnIndicator;

public class EmailValidatorImpl implements EmailVerNoTestEmailSoap{

	@Override
	public int verifyMXRecord(String email, String licenseKey) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReturnIndicator advancedVerifyEmail(String email, int timeout, String licenseKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReturnIndicator verifyEmail(String email, String licenseKey) {
		ReturnIndicator respuesta = new ReturnIndicator();
		respuesta.setResponseText("TEST-ResponseText");
		respuesta.setResponseCode(0);
		respuesta.setLastMailServer("TEST-LastMailServer");
		respuesta.setGoodEmail(true);
		return respuesta;
	}

	@Override
	public ArrayOfAnyType returnCodes() {
		// TODO Auto-generated method stub
		return null;
	}

}
