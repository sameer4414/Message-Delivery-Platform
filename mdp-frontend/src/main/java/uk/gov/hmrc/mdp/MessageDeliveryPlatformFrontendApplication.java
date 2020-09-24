package uk.gov.hmrc.mdp;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.resource.servlet.OAuth2ResourceServerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = { WebSocketServletAutoConfiguration.class, AopAutoConfiguration.class, OAuth2ResourceServerAutoConfiguration.class, EmbeddedWebServerFactoryCustomizerAutoConfiguration.class })
@ComponentScan(basePackages = "uk.gov.hmrc.mdp")
public class MessageDeliveryPlatformFrontendApplication {

	@Value("${server.port}")
	String serverPort;

	@Value("${message.api.path}")
	String contextPath;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MessageDeliveryPlatformFrontendApplication.class, args);
	}

	@Bean
	ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean servlet = new ServletRegistrationBean(new CamelHttpTransportServlet(), contextPath + "/*");
		servlet.setName("CamelServlet");
		return servlet;
	}

}
