package XML.ServeurXML;

import javax.xml.bind.annotation.XmlElement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by saidiaym on 15/04/14.
 */
public class ResumeCompetences {

    List<String> lang;

    public ResumeCompetences() {
        this.lang = new LinkedList<String>();
    }

    public void addCompetences(String lang, String niveau) {
        this.lang.add(lang + ": " +niveau);
    }

    @XmlElement
    public  List<String> getCompetences(){
        return this.lang;
    }
}

