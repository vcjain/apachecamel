import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * 
 */

/**
 * @author vcjain
 * 
 */
public class CamelTest {
	public static void main(String args[]) throws Exception {
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {
			public void configure() {
				from(
						"ftp://rider.com/orders"
								+ "?username=rider&password=secret").to(
						"jms:incomingOrders");
			}
		});
		context.start();
		Thread.sleep(10000);
		context.stop();
	}
}
