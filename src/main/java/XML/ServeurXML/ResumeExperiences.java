package XML.ServeurXML;

import javax.xml.bind.annotation.XmlElement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by saidiaym on 15/04/14.
 */
public class ResumeExperiences {
    List<String> lang;

    public ResumeExperiences() {
        this.lang = new LinkedList<String>();
    }

    public void addExperiences(String lang, String niveau) {
        this.lang.add(lang + ": " +niveau);
    }

    @XmlElement
    public  List<String> getExperiences(){
        return this.lang;
    }
}