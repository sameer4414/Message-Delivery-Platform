package uk.gov.hmrc.mdp.route;


import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class MessageTransformationRoute extends RouteBuilder {

    @Value("${server.port}")
    String serverPort;

    @Value("${message.api.path}")
    String contextPath;

    @Override
    public void configure() throws Exception {

        CamelContext context = new DefaultCamelContext();

        from("direct:remoteService").routeId("direct-route")
                .tracing()
                .log(">>> ${body.id}")
                .log(">>> ${body.name}")
                 .transform().simple("blue ${in.body.name}")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201));

    }
}
