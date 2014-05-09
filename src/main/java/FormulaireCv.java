import XML.ServeurXML.*;

import javax.swing.*;
import javax.xml.bind.JAXBException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by saidi on 08/05/2014.
 */
public class FormulaireCv extends JFrame implements ActionListener{




    private JTextField Nom, Prenom, Adresse,Email, id,Com1,Com2,Exp1,Exp2,Loisirs ,Lang1, LanG2;

    private JLabel nom, prenom, adresse, Mail, ID, Competences,Competences1, Experiences1, Experiences2, langue1,langue2, loisirs,lniveau1, lniveau2;
    private JButton enregistrer;
    private JComboBox NivLang1;
    private JComboBox NivLang2;
    private JComboBox duree1;
    private JComboBox duree2;
    private JComboBox NivC1;
    private JComboBox NivC2;
    private JComboBox Langue1;
    private JComboBox Langue2;

    public FormulaireCv(){
        setSize(600,730);
        this.setLayout(null);

        enregistrer = new JButton("Envoyer");
        enregistrer.setBounds(40,620,150,20);//(liman,     ,lta7t)
        getContentPane().add(enregistrer);

        enregistrer.addActionListener(this);
        nom = new JLabel("Nom : ");
        nom.setBounds(40,15,150,20);
        getContentPane().add(nom);

        prenom = new JLabel("Prenom : ");
        prenom.setBounds(40,40,150,20);
        getContentPane().add(prenom);

        adresse = new JLabel("Adresse : ");
        adresse.setBounds(40,65,150,20);
        getContentPane().add(adresse);


        Mail = new JLabel("Email : ");
        Mail.setBounds(40,95,150,20);
        getContentPane().add(Mail);


        ID = new JLabel("Ientifiant : ");
        ID.setBounds(40,120,150,20);
        getContentPane().add(ID);


        Competences = new JLabel("Compétence Professionnels : ");
        Competences.setBounds(40,225,150,20);
        getContentPane().add(Competences);

        Competences1 = new JLabel("Compétence Professiones2: ");
        Competences1.setBounds(40, 250, 150, 20);//(liman,     ,lta7t)
        getContentPane().add(Competences1);


         Experiences1 = new JLabel("Experience1: ");
         Experiences1.setBounds(40, 275, 150, 20);//(liman,     ,lta7t)
          getContentPane().add(Experiences1);

         Experiences2 = new JLabel("Experience2 : ");
         Experiences2.setBounds(40,310,150,20);//(liman,     ,lta7t)
         getContentPane().add(Experiences2);


        langue1 = new JLabel("langue Mere: ");
        langue1.setBounds(40,335,150,20);//(liman,     ,lta7t)
        getContentPane().add(langue1);

        langue2 = new JLabel("autres langues ");
        langue2.setBounds(40,370,150,20);//(liman,     ,lta7t)
        getContentPane().add(langue2);

        loisirs = new JLabel("Loisirs : ");
        loisirs.setBounds(40,395,150,20);//(liman,     ,lta7t)
        getContentPane().add(loisirs);



        /************ text field **********/

        Nom = new JTextField();
        Nom.setBounds(250,15,150,20);//(liman,     ,lta7t)
        getContentPane().add(Nom);

        Prenom = new JTextField();
        Prenom.setBounds(250,40,150,20);//(liman,     ,lta7t)
        getContentPane().add(Prenom);

        Adresse = new JTextField();
        Adresse.setBounds(250,65,150,20);//(liman,     ,lta7t)
        getContentPane().add(Adresse);


        Email = new JTextField();
        Email.setBounds(250,90,150,20);//(liman,     ,lta7t)
        getContentPane().add(Email);

        id = new JTextField();
        id.setBounds(250,120,150,20);//(liman,     ,lta7t)
        getContentPane().add(id);


        Com1 = new JTextField();
        Com1.setBounds(250, 225, 150, 20);//(liman,     ,lta7t)
        getContentPane().add(Com1);

        Com2 = new JTextField();
        Com2.setBounds(250, 250, 150, 20);//(liman,     ,lta7t)
        getContentPane().add(Com2);



        Exp1 = new JTextField();
        Exp1.setBounds(250, 275, 150, 20);
        getContentPane().add(Exp1);

        Exp2 = new JTextField();
        Exp2.setBounds(250, 310, 150, 20);
        getContentPane().add(Exp2);

        Langue1 = new JComboBox();
        Langue1.addItem("Francais");
        Langue1.addItem("Arab");
        Langue1.addItem(" Anglais");
        Langue1.setBounds(250, 335, 150, 20);
        getContentPane().add(Langue1);

        Langue2 = new JComboBox();
        Langue2.addItem("Francais");
        Langue2.addItem("Arab");
        Langue2.addItem(" Anglais");
        Langue2.setBounds(250, 370, 150, 20);
        getContentPane().add(Langue2);

        Loisirs = new JTextField();
        Loisirs.setBounds(250,395,150,20);
        getContentPane().add(Loisirs);

        NivLang1= new JComboBox();
        NivLang1.addItem("Faibles");
        NivLang1.addItem("Moyen");
        NivLang1.addItem("Haut");
        NivLang1.setBounds(400, 335, 150, 20);//(liman,     ,lta7t)
        getContentPane().add(NivLang1);


        NivLang2 = new JComboBox();
        NivLang2.addItem("Faibles");
        NivLang2.addItem("Moyen");
        NivLang2.addItem("Haut");
        NivLang2.setBounds(400,370,150,20);//(liman,     ,lta7t)
        getContentPane().add(NivLang2);
        /************************************/

        NivC1= new JComboBox();
        NivC1.addItem("Faibles");
        NivC1.addItem("Moyen");
        NivC1.addItem("Haut");
        NivC1.setBounds(400, 225, 150, 20);//(liman,     ,lta7t)
        getContentPane().add(NivC1);

        NivC2= new JComboBox();
        NivC2.addItem("Faibles");
        NivC2.addItem("Moyen");
        NivC2.addItem("Haut");
        NivC2.setBounds(400, 250, 150, 20);//(liman,     ,lta7t)
        getContentPane().add(NivC2);

        duree1= new JComboBox();
        duree1.addItem("2 mois");
        duree1.addItem("4 mois");
        duree1.addItem("pluss");
        duree1.setBounds(400, 275, 150, 20);//(liman,     ,lta7t)
        getContentPane().add(duree1);

        duree2= new JComboBox();
        duree2.addItem("2 mois");
        duree2.addItem("4 mois ");
        duree2.addItem("plus");
        duree2.setBounds(400, 310, 150, 20);//(liman,     ,lta7t)
        getContentPane().add(duree2);



        JLabel  cv = new JLabel(" ***************FORMULAIRE**************");
        cv.setBounds(250,620,150,20);
        getContentPane().add(cv);


        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == enregistrer) {
            String cv;
            try {
                String mail = Email.getText();
                String ident = id.getText();
                String adresse = Adresse.getText();
                String nom = Nom.getText();
                String prenom = Prenom.getText();
                String loisirs =Loisirs.getText();
                String langu1 = langue1.getText();
                String Nivln  = NivLang1.getSelectedItem().toString();
                String langu2 = langue2.getText();
                String Nivln1  = NivLang2.getSelectedItem().toString();
                String competences = Com1.getText();
                String com1  = NivC1.getSelectedItem().toString();
                String competences1 = Com2.getText();
                String com2  = NivC1.getSelectedItem().toString();
                String exp1 = Exp1.getText();
                String d1  = duree1.getSelectedItem().toString();
                String exp2 = Exp2.getText();
                String d2 = duree2.getSelectedItem().toString();

                ResumeAdresse resumeAdresse = new ResumeAdresse();
                ResumeCompetences resumeCompetences = new ResumeCompetences();
                ResumeExperiences resumeExperiences = new ResumeExperiences();
                ResumeLangue resumeLangue = new ResumeLangue();
                ResumeLoisirs resumeLoisirs = new ResumeLoisirs();

                resumeAdresse.addResumeAdresse(adresse);
                resumeCompetences.addCompetences(competences, com1);
                resumeCompetences.addCompetences(competences1,com2);
                resumeExperiences.addExperiences(exp1, d1);
                resumeExperiences.addExperiences(exp2,d2);
                resumeLangue.addLangue(langu1, Nivln);
                resumeLangue.addLangue(langu2,Nivln1);
                resumeLoisirs.addLoisir(loisirs);
                System.out.println(ident);
                Resume resume=new Resume(ident, prenom,nom,mail,resumeAdresse,resumeLangue,resumeLoisirs,resumeExperiences,resumeCompetences);
                GetWithPut getWithPut = new GetWithPut();
                getWithPut.addResume(resume);

            } catch (JAXBException e1) {
                e1.printStackTrace();
            }
            Email.setText("");
            id.setText("");
            Adresse.setText("");
            Nom.setText("");
            Prenom.setText("");
            Loisirs.setText("");
            langue1.setText("");
            langue2.setText("");
            Com1.setText("");
            Com2.setText("");
            Exp1.setText("");
            Exp2.setText("");




        }

  }




}






