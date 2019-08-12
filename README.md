## soap webservice demo


to rename the return XML node name, apply to the interface method

@XmlElement(name="clientNumber")


### end point

implemented at PolicyService and PolicyServiceImpl

### consumer

implemented at TestController

### implemented Interceptor for the authentication

The Interceptor cannot be applied through annotation and must be added to the endpoint because we want spring to help to manage the Interceptor bean and hence the autowired / DI could be used.

### TestController demonstrated how to consume the end point through HTTPS

use JaxWsDynamicClientFactory as client

set the server public keyStore to the system properties and trust the server SSL connection

load the field through reflection


