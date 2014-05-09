package XML.ServeurXML;

import javax.xml.bind.annotation.XmlElement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by saidiaym on 15/04/14.
 */
public class ResumeLoisirs {

    List<String> mesloisirs;

    public ResumeLoisirs() {
        this.mesloisirs = new LinkedList<String>();
    }

    public void addLoisir(String loi) {
        this.mesloisirs.add(loi );
    }

    @XmlElement
    public  List<String> getLoisir(){
        return this.mesloisirs;
    }
}
