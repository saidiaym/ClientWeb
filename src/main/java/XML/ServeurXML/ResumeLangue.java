package XML.ServeurXML;

import javax.xml.bind.annotation.XmlElement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by saidiaym on 15/04/14.
 */
public class ResumeLangue {

    List<String> lang;

    public ResumeLangue() {
        this.lang = new LinkedList<String>();
    }

    public void addLangue(String lang, String niveau) {
        this.lang.add(lang + ": " +niveau);
    }

    @XmlElement
    public  List<String> getLangues(){
        return this.lang;
    }

}

