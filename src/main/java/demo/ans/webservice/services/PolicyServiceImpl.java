package demo.ans.webservice.services;

import java.util.List;
import java.util.Optional;

import javax.jws.WebService;

import org.apache.cxf.interceptor.InInterceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.ans.webservice.database.model.oracle.OraclePolicyMaster;
import demo.ans.webservice.database.model.oracle.OraclePolicyMasterRepository;

@InInterceptors(interceptors={"demo.ans.webservice.BasicAuthInterceptor"})
@WebService(serviceName = "PolicyService", targetNamespace = "http://demo.ans.webservice/", endpointInterface = "demo.ans.webservice.services.PolicyService")
@Component
public class PolicyServiceImpl implements PolicyService {
	
	@Autowired
	private OraclePolicyMasterRepository oraclePolicyMasterRepository;

	@Override
	public OraclePolicyMaster getPolicyByPolicyNumber(String policyNumber) {

		// need to create and implement the IPolicyDAO for access the data of the policy
		// dummy data is used in the following for the demo
		
		Optional<OraclePolicyMaster> data = oraclePolicyMasterRepository.findByPolicyNumber(policyNumber);
				
		return data.get();
	}

	@Override
	public boolean addPolicy(OraclePolicyMaster policyXMaster) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getOwnerClientNumber(String policyNumber) {
		Optional<OraclePolicyMaster> data = oraclePolicyMasterRepository.findByPolicyNumber(policyNumber);
		
		return data.get().getOwnerClientNumber();
	}

	@Override
	public List<OraclePolicyMaster> getAllPolicies() {
		
		List<OraclePolicyMaster> result = oraclePolicyMasterRepository.findAll();
		
		return result;
	}

}
