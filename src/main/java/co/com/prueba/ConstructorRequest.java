package co.com.prueba;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ConstructorRequest implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		List<Object> bodyOut = new ArrayList<>();
		bodyOut.add("carlos.a.vallejo.r@gmail.com");
		bodyOut.add("abc");		
		exchange.getOut().setBody(bodyOut);
	}

}
