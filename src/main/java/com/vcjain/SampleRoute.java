/**
 * 
 */
package com.vcjain;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

/**
 * @author vcjain
 *
 */
public class SampleRoute extends RouteBuilder{

	/**
	 * Route implementation
	 */
	public void configure() throws Exception {
		from("file:src/data?noop=true").
		process(new Processor(){
			public void process(Exchange exchange) throws Exception {
				System.out.println(exchange.getIn());
			}
		}).
		to("cxf://http://www.webservicex.net/stockquote.asmx?wsdlURL=src/main/resources/META-INF/stockquote.wsdl&serviceName={http://www.webserviceX.NET/}StockQuote&portName={http://www.webserviceX.NET/}StockQuoteSoap&dataFormat=MESSAGE");
	}
}
