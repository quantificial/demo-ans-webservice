package demo.ans.webservice;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import demo.ans.webservice.database.model.h2.ClientMaster;
import demo.ans.webservice.database.model.h2.ClientMasterRepository;
import demo.ans.webservice.database.model.h2.PolicyMaster;
import demo.ans.webservice.database.model.h2.PolicyMasterRepository;
import demo.ans.webservice.database.model.oracle.OraclePolicyMaster;
import demo.ans.webservice.database.model.oracle.OraclePolicyMasterRepository;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableEncryptableProperties
@Slf4j
public class Application implements CommandLineRunner {

	@Autowired
	private PolicyMasterRepository policyMasterRespository;
	
	@Autowired
	private ClientMasterRepository clientMasterRespository;
	
	@Autowired
	private OraclePolicyMasterRepository oraclePolicyMasterRepository;
		
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		log.info("repository testing start.......");
		
		List<PolicyMaster> policyMaster = policyMasterRespository.findAll();
		
		for(PolicyMaster pm : policyMaster) {
			
			log.info("Policy Number: " + pm.getPolicyNumber());
			log.info(pm.toString());
			
			//clientMasterRespository.findOne(c.getOwnerClientNumber());
			//clientMasterRespository.findby
			
			Optional<ClientMaster> cm = clientMasterRespository.findByClientId(pm.getOwnerClientNumber());
			
			if(cm.isPresent()) {
				log.info("Client Name: " + cm.get().getFirstName() + " " + cm.get().getLastName());
				log.info(cm.toString());
			}
		}
		
		for(OraclePolicyMaster m : oraclePolicyMasterRepository.findAll()) {
			
			log.info(m.toString());
		}
		
		
	}

}
