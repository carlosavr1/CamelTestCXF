# CamelTestCXF

Route that every 30 seconds creates a 'List' with the values: 'carlos.a.vallejo.r@gmail.com', 'abc'. To invoke the web service [WSDL](http://ws.cdyne.com/emailverify/Emailvernotestemail.asmx?WSDL) with the VerifyEmail method.

## To perform the unit test you need:

1) Create a class that implements the service interface 'com.cdyne.ws.EmailVerNoTestEmailSoap'. 
> NOTE: The classes in the package 'com.cdyne.ws' were automatically generated with 'wsimport -keep http://ws.cdyne.com/emailverify/Emailvernotestemail.asmx?WSDL'

2) Modify the implementation. In this case, set values static to the request
ResponseText = 'TEST-ResponseText'
ResponseCode = 0
LastMailServer = 'TEST-LastMailServer'
GoodEmail = true

3) Create an Endpoint with a URL and an instance of the implementation.
> NOTE: I recommend that the URL is always 'localhost' and that it has a port that normally does not occupy, since if the name of a server is placed instead of 'localhost', if the server where the route is displayed does not resolve That name, the test will fail. Also if the port is already being used, the test will also fail.

4) Intervene the route, so that before doing the 'to -> InvocacionCXF', you change the URL by which it was defined.
> NOTE: When the message has the 'CamelDestinationOverrideUrl' property in the Header, the path uses that property as the service address.
[How to override the CXF producer address from message header ](http://camel.apache.org/cxf.html)
