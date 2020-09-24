package uk.gov.hmrc.information.route;


import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import uk.gov.hmrc.information.model.Message;


@Component
public class InformationProcessingRoute extends RouteBuilder {

    @Value("${server.port}")
    String serverPort;

    @Value("${information.api.path}")
    String contextPath;

    @Override
    public void configure() throws Exception {

        CamelContext context = new DefaultCamelContext();

        from("direct:remoteService").routeId("direct-route")
                .tracing()
                .log(">>> ${body.id}")
                .log(">>> ${body.name}")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        Message bodyIn = (Message) exchange.getIn()
                                .getBody();

                        exchange.getIn()
                                .setBody(bodyIn);
                    }
                })
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201));

    }
}
