package XML.ServeurXML;

import javax.xml.bind.annotation.XmlElement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by saidiaym on 05/05/14.
 */
public class ResumeAdresse {
    List<String> adresse;

    public ResumeAdresse() {
        this.adresse = new LinkedList<String>();
    }

    public void addResumeAdresse(String adresse) {
        this.adresse.add(adresse);
    }

    @XmlElement
    public  List<String> getAdresse(){
        return this.adresse;
    }
}
