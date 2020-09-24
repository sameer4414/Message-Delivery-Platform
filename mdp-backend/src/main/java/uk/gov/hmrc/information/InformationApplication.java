package uk.gov.hmrc.information;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InformationApplication {

	@Value("${server.port}")
	String serverPort;

	@Value("${message.api.path}")
	String contextPath;

	public static void main(String[] args) {
		SpringApplication.run(InformationApplication.class, args);
	}

	@Bean
	ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean servlet = new ServletRegistrationBean(new CamelHttpTransportServlet(), contextPath + "/*");
		servlet.setName("CamelServlet");
		return servlet;
	}

}
