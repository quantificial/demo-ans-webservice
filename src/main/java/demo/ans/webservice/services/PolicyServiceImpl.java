package demo.ans.webservice.services;

import java.util.Optional;

import javax.jws.WebService;

import org.apache.cxf.interceptor.InInterceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.ans.webservice.database.model.oracle.PolicyXMaster;
import demo.ans.webservice.database.model.oracle.PolicyXMasterRepository;

@InInterceptors(interceptors={"demo.ans.webservice.AuthInterceptor"})
@WebService(serviceName = "PolicyService", targetNamespace = "http://demo.ans.webservice/", endpointInterface = "demo.ans.webservice.services.PolicyService")
@Component
public class PolicyServiceImpl implements PolicyService {
	
	@Autowired
	private PolicyXMasterRepository policyXMasterRepository;

	@Override
	public PolicyXMaster getPolicyByPolicyNumber(String policyNumber) {

		// need to create and implement the IPolicyDAO for access the data of the policy
		// dummy data is used in the following for the demo
		
		Optional<PolicyXMaster> data = policyXMasterRepository.findByPolicyNumber(policyNumber);
				
		return data.get();
	}

	@Override
	public boolean addPolicy(PolicyXMaster policyXMaster) {
		// TODO Auto-generated method stub
		return false;
	}

}
