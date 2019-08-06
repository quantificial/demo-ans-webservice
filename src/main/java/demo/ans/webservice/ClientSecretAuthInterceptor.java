package demo.ans.webservice;

import java.util.Base64;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.xml.soap.SOAPException;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.common.util.StringUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ClientSecretAuthInterceptor extends AbstractSoapInterceptor {
	
	@Value("${ws.client-id}")
    private String clientId;
	
	@Value("${ws.client-secret}")
    private String clientSecret;
	
	@Value("${ws.client-id-header}")
	private String clientIdHeader;
	
	@Value("${ws.client-secret-header}")
	private String clientSecretHeader;

    public ClientSecretAuthInterceptor() {
        super(Phase.PRE_INVOKE);
    }

    @Override
    public void handleMessage(SoapMessage message) throws Fault {
    	
        HttpServletRequest request = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
          
        String requestClientId = request.getHeader(clientIdHeader);
        
        if (requestClientId == null) {
            SOAPException exception = new SOAPException("required header ["+clientIdHeader+"] not exists");
            throw new Fault(exception);
        }
        
        String requestClientSecret = request.getHeader(clientSecretHeader);
        
        if (requestClientSecret == null) {
            SOAPException exception = new SOAPException("required header ["+clientSecretHeader+"] not exists");
            throw new Fault(exception);
        }
        
        
        if (!clientId.equals(requestClientId) || !clientSecret.equals(requestClientSecret)) {
            SOAPException exception = new SOAPException("authentication failed, client id or client secret is incorrect");
            throw new Fault(exception);
        }
    }
}

