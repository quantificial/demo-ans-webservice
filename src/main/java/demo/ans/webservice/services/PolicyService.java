package demo.ans.webservice.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlElement;

import demo.ans.webservice.database.model.oracle.OraclePolicyMaster;

@WebService(targetNamespace="http://demo.ans.webservice/")
//@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface PolicyService {
	
	// in order to test the service in SOAP-UI
	// add the wsdl, http://localhost:8000/soap/policyService
	// add the basic auth. and input the username and password defined in the AuthInterceptor
	// use Authenticate pre-emptively

	@WebMethod
	@XmlElement(name="policy")
	OraclePolicyMaster getPolicyByPolicyNumber(@WebParam(name = "policyNumber") String policyNumber);
	
	@WebMethod
	@XmlElement(name="clientNumber")
	int getOwnerClientNumber(@WebParam(name="policyNumber") String policyNumber);
	
	@WebMethod
	@XmlElement(name="policy")
	List<OraclePolicyMaster> getAllPolicies();
	
	@WebMethod
	boolean addPolicy(OraclePolicyMaster policyXMaster);
	

}
