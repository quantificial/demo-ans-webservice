package demo.ans.webservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import demo.ans.webservice.database.model.h2.ClientMaster;
import demo.ans.webservice.database.model.h2.ClientMasterRepository;
import demo.ans.webservice.database.model.h2.PolicyMaster;
import demo.ans.webservice.database.model.h2.PolicyMasterRepository;
import demo.ans.webservice.database.model.oracle.PolicyXMaster;
import demo.ans.webservice.database.model.oracle.PolicyXMasterRepository;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableEncryptableProperties
@Slf4j
public class Application implements CommandLineRunner {

	@Autowired
	private PolicyMasterRepository policyMasterRespositry;
	
	@Autowired
	private ClientMasterRepository clientMasterRespository;
	
	@Autowired
	private PolicyXMasterRepository policyXMasterRepository;
		
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		log.info("console start.......");
		
		List<PolicyMaster> policyMaster = policyMasterRespositry.findAll();
		
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
		
		
		for(PolicyXMaster m : policyXMasterRepository.findAll()) {
			
			log.info(m.toString());
		}
		
		
		log.info("console end.......");
		
	}

}
