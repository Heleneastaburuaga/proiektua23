package businessLogic;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import configuration.ConfigXML;

public class ExternalBLFacadeFactory implements BLFacadeFactory {
    public BLFacade createBLFacade() {
    	try {
    		String serviceName = "http://"+ConfigXML.getInstance().getBusinessLogicNode() +
                                 ":" + ConfigXML.getInstance().getBusinessLogicPort() +
                                 "/ws/" + ConfigXML.getInstance().getBusinessLogicName() + "?wsdl";
            URL url = new URL(serviceName);
            QName qname = new QName("http://businessLogic/", "BLFacadeImplementationService");
            Service service = Service.create(url, qname);
            return service.getPort(BLFacade.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
