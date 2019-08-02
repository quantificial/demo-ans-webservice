package demo.ans.webservice;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import demo.ans.webservice.services.PolicyService;

@Configuration
public class SoapConfig {
	
    @Autowired
    private PolicyService policyService;

    @Autowired
    @Qualifier(Bus.DEFAULT_BUS_ID)
    private SpringBus bus;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, policyService);
        endpoint.publish("/policyService");
        return endpoint;
    }
    
      // Alternative way to set the context path for the service endpoints
      // for example, with the configuration below, all the service endpoints will be
      // available at URL /services/* 
//    @Bean
//    public ServletRegistrationBean dispatcherServlet() {
//     return new ServletRegistrationBean(new CXFServlet(), "/services/*");
//    }
//     
//    @Bean(name=Bus.DEFAULT_BUS_ID)
//    public SpringBus springBus() {    
//     SpringBus springBus = new SpringBus();       
//     return springBus;
//    }
    
    
}
