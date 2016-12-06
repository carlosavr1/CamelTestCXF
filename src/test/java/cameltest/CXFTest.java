package cameltest;

import javax.xml.ws.Endpoint;

import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.model.language.SimpleExpression;
import org.apache.camel.test.blueprint.CamelBlueprintTestSupport;
import org.junit.Test;

public class CXFTest extends CamelBlueprintTestSupport{

	@Override
    protected String getBlueprintDescriptor() {
        return "OSGI-INF/blueprint/blueprint.xml";
    }
	
	@Test
	public void testCXF() throws Exception {
		final String urlValidadorEmail = "http://localhost:4444/test";
		
		EmailValidatorImpl emailValidatorImpl = new EmailValidatorImpl();
		Endpoint endpointValidadorEmail = Endpoint.publish(urlValidadorEmail, emailValidatorImpl);
		
		context.getRouteDefinition("_routePrincipal").adviceWith(context, new AdviceWithRouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				weaveById("_toValidadorEmail").before()
				.setHeader("CamelDestinationOverrideUrl", constant(urlValidadorEmail) );
				
				weaveById("_toValidadorEmail").after()
				.log("[CXFTest][testCXF] ${body[0]}")
				.setBody(new SimpleExpression("${body[0]}"))
				.to("mock:mockEndCXF");
				
			}
		});
		
		MockEndpoint mockEndCXF = MockEndpoint.resolve(context, "mock:mockEndCXF");
		mockEndCXF.expectedBodiesReceived("[ReturnIndicator = responseText: 'TEST-ResponseText', ResponseCode: '0', LastMailServer: 'TEST-LastMailServer', GoodEmail: 'true']");
		mockEndCXF.assertIsSatisfied();
		
		endpointValidadorEmail.stop();
	}
}
