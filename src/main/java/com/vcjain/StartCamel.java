/**
 * 
 */
package com.vcjain;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author vcjain
 *
 */
public class StartCamel {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new SampleRoute());
		context.start();
	}

}
