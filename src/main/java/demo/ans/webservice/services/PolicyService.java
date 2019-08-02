package demo.ans.webservice.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import demo.ans.webservice.database.model.oracle.PolicyXMaster;

@WebService(targetNamespace="http://demo.ans.webservice/")
public interface PolicyService {
	
	// in order to test the service in SOAP-UI
	// add the wsdl, http://localhost:8000/soap/policyService
	// add the basic auth. and input the username and password defined in the AuthInterceptor
	// use Authenticate pre-emptively

	@WebMethod
	PolicyXMaster getPolicyByPolicyNumber(@WebParam(name = "policyNumber") String policyNumber);

	@WebMethod
	boolean addPolicy(PolicyXMaster policyXMaster);
	

}
