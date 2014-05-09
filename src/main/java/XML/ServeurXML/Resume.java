package XML.ServeurXML;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by saidiaym on 08/04/14.
 */

@XmlRootElement
public class Resume {
    public String Identifiant;
    private  String mail;
    private String nom;
    private String Prenom;
    public ResumeLangue langue;
    public ResumeCompetences Competences;
    public ResumeLoisirs Lois;
    public ResumeExperiences resumeResumeExperiences;
    public ResumeAdresse resumeAdresse;

    public Resume(String Identifiant, String Prenom,String Nom,String mail, ResumeAdresse resumeAdresse,ResumeLangue Langue , ResumeLoisirs lois, ResumeExperiences ResumeExperiences,ResumeCompetences competences) {
        this.Identifiant = Identifiant;
        this.nom = Nom;
        this.Prenom = Prenom;
        this.mail = mail;
        //this.Lois = new ResumeLoisirs();
       /* this.Competences = new ResumeCompetences();
        this.resumeResumeExperiences = new ResumeExperiences();
        this.langue = new ResumeLangue();*/
        this.langue = Langue;
        this.Lois = lois;
        this.resumeResumeExperiences = ResumeExperiences;
        this.Competences = competences;
        this.resumeAdresse = resumeAdresse;



    }
    public Resume(){

    }

    @XmlElement
    public  String  getMail(){
        return mail;
    }

    public void setMail(String n) {
        this.mail = n;
    }

    @XmlElement
    public String getNom(){

        return nom;
    }

    public void setNom(String n) {
        this.nom = n;
    }

    @XmlElement
    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom (String p) {
        this.Prenom = p;
    }

    @XmlElement
    public String getIdentifiant() {
        return Identifiant;
    }

    public void setIdentifiant (String identifiant) {
        this.Identifiant = identifiant;
    }

}