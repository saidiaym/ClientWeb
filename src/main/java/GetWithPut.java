import XML.ServeurXML.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;
import java.util.Map;

/**
 * Created by saidiaym on 07/05/14.
 */
public class GetWithPut {

    private Service service;
    private JAXBContext jc;

    private static final QName qname = new QName("", "");
    private static final String url = "http://resumexml.saidiaym.cloudbees.net/rest/Resume/";

    public GetWithPut() {
        try {
            jc = JAXBContext.newInstance(Resume.class, ResumeExperiences.class,
                    ResumeCompetences.class, ResumeLangue.class , String.class);
        } catch (JAXBException je) {
            System.out.println("Cannot create JAXBContext " + je);
        }
    }
    public void addResume(Resume resume) throws JAXBException {
        service = Service.create(qname);
        service.addPort(qname, HTTPBinding.HTTP_BINDING, url);
        Dispatch<Source> dispatcher = service.createDispatch(qname,
                Source.class, Service.Mode.MESSAGE);
        Map<String, Object> requestContext = dispatcher.getRequestContext();
        requestContext.put(MessageContext.HTTP_REQUEST_METHOD, "PUT");
       /* Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(resume, System.out);*/
        Source result = dispatcher.invoke(new JAXBSource(jc, resume));
        // printSource(result);
    }



}
