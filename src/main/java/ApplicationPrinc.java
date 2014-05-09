
import org.w3c.dom.Node;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;


public class ApplicationPrinc {
	
	//constante
	
	private static final int WIDTH = 700;
	private static final int HEIGTH = 700;
	
	// ATTRIBUTS
	
	private JFrame frame;

	
	private JButton AfficherAll;
	private JButton ajouter;
	private JButton reset;
	private ConverterXML pars = new  ConverterXML();
	
	
	private JScrollPane scroll;
	private JScrollPane scroll1;
	private File[] roots;
	private JTextArea area;
	private JTree Tree ;
	private DefaultMutableTreeNode root;

	private TreeModel treemodel;
	private List<String> ID;


	public ApplicationPrinc() throws IOException {
        createModel();
		createView();
        placeComponents();
        createController();
	}

	public void Display() {

		frame.pack();
		frame.setVisible(true);
		frame.validate();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public void createModel() {

	}

	private void createController() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// TODO Auto-generated method stub
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				area.setText("");
			}
		});

		 AfficherAll.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent arg0)  {
				// TODO Auto-generated method stub
				String result;

					 try {

						result = ApplicationPrinc.get("http://resumexml.saidiaym.cloudbees.net/rest/Resume/");
						area.setText("");
						frame.repaint();
						} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			}

			});
		 ajouter.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					openFrame();
					frame.dispose();

				}
			});
		 Tree.addTreeSelectionListener(new TreeSelectionListener() {

				public void valueChanged(TreeSelectionEvent e) {
					DefaultMutableTreeNode node1 = (DefaultMutableTreeNode) Tree.getLastSelectedPathComponent();
					if (node1 == null) {
						return;
					}
					Object nodeInfo;

					if (node1.isLeaf())
					{
						/*int  identifiant = node1.getIndex(node1.getNextLeaf());
						System.out.println(identifiant);*/
						String leafts  = e.getNewLeadSelectionPath().getLastPathComponent().toString();
						System.out.println();
						try {

							 List<String> myList = new LinkedList<String>();
							 String result;
							result = ApplicationPrinc.get("http://resumexml.saidiaym.cloudbees.net/rest/Resume/" + leafts);
							Node myNode = ConverterXML.ConvertStringToNode(result);
							ConverterXML.Idrecup(myNode, myList, "nom");
							  String nom = myList.get(0);
							  myList.clear();
							ConverterXML.Idrecup(myNode, myList, "prenom");
							  String prenom = myList.get(0);
							  myList.clear();

							 ConverterXML.Idrecup(myNode, myList, "mail");
							  String mail = myList.get(0);
							  myList.clear();

							 ConverterXML.Idrecup(myNode, myList, "adresse");
							  String adresse = myList.get(0);
							  myList.clear();
							  ConverterXML.Idrecup(myNode, myList, "experiences");

							  String exp1 = myList.get(0);

							  myList.clear();

							 ConverterXML.Idrecup(myNode, myList, "competences");

							  String com1 = myList.get(0);
							  String com2 = myList.get(1);

							  myList.clear();

							  ConverterXML.Idrecup(myNode, myList, "langues");


							  String lan1 = myList.get(0);
							  String lan2 = myList.get(1);

							  myList.clear();


							  ConverterXML.Idrecup(myNode, myList, "loisir");


							  String loisir1 = myList.get(0);

							  myList.clear();
							  String CVdom = new String();
							  String NewLigne = System.getProperty("line.separator");
							  CVdom = "Nom :"+ nom + NewLigne + "Prenom :" + prenom +  NewLigne +"Mail :"+mail+NewLigne+"Adresse"+adresse+NewLigne+ "Experiences :" + NewLigne + exp1 + NewLigne+ /*exp2*/ NewLigne + "Competences :" + NewLigne + com1 + NewLigne+ com2+ NewLigne  +"Langues :" + NewLigne + lan1 + NewLigne+ lan2+ NewLigne + "Loisirs :" + NewLigne + loisir1 + NewLigne    ;

							  area.setText(CVdom);

						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}



					}

					}
			});

	 }
	 public static String get(String url) throws IOException {
		 String source ="";
		URL oracle = new URL(url);
		URLConnection yc = oracle.openConnection();
		BufferedReader in = new BufferedReader(
		new InputStreamReader(
		yc.getInputStream()));
		String inputLine;

		while ((inputLine = in.readLine()) != null)
		source +=inputLine;
		in.close();
		return source;
}
	 private void openFrame() {
		    FormulaireCv t = new FormulaireCv();
		    t.isVisible();
		  }


	private void createView() {

		// TODO Auto-generated method stub
		frame = new JFrame("Gestionnaire des fichiers");
		frame.setPreferredSize(
				new Dimension(WIDTH, HEIGTH)
		);
		AfficherAll = new JButton("AfficherAll");
		ajouter = new JButton("ajouter");
		reset = new JButton("Reset");
		area = new JTextArea();
		scroll1 = new JScrollPane(area);
		Tree = new JTree(treemodel);
		root =  new DefaultMutableTreeNode("CVS");
	    DefaultTreeModel treeModel = new DefaultTreeModel(root);

	    Tree = new JTree(treeModel);
	    Tree.setShowsRootHandles(true);

		scroll = new JScrollPane();
	    scroll.setViewportView(Tree);
		scroll.setPreferredSize(new Dimension(150,700));
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


	}

	private void placeComponents() throws IOException {
		// TODO Auto-generated method stub

		JPanel p = new JPanel(new BorderLayout());
		JPanel q = new JPanel(new FlowLayout());{
            AfficherAll.setBounds(20,620,150,20);
            ajouter.setBounds(20,645,150,20);
            reset.setBounds(20,645,150,20);
			q.add(AfficherAll);
			q.add(ajouter);
			q.add(reset);
		}
		p.add(q,BorderLayout.EAST);
        JPanel d = new JPanel(new FlowLayout(FlowLayout.CENTER)); {
            JLabel copyright = new JLabel("Interface Graphique");
            copyright.setForeground(Color.BLACK);
            d.add(copyright);
            d.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Definitions",0,0,new Font("dialog",1,12),Color.black));
        }

		JPanel j = new JPanel(new BorderLayout());{
		j.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Affichage",0,0,new Font("dialog",1,12),Color.black));
		j.add(area);
		}
		p.add(j,BorderLayout.CENTER);

        JPanel c = new JPanel(new FlowLayout(FlowLayout.LEFT)); {
            JLabel copyright = new JLabel("Copyright 2014");
            copyright.setForeground(Color.BLACK);
            c.add(copyright);
        }

        c.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        frame.add(scroll,BorderLayout.WEST);
        frame.add(p,BorderLayout.CENTER);
        frame.add(c, BorderLayout.SOUTH);
        frame.add(d,BorderLayout.NORTH);



        String listCVString;
		 	ID = new LinkedList<String>();
			listCVString = ApplicationPrinc.get("http://resumexml.saidiaym.cloudbees.net/rest/Resume/");
			 System.out.println(listCVString);
			Node myNode = ConverterXML.ConvertStringToNode(listCVString);
			System.out.println(myNode.getNodeName());
				ConverterXML.Idrecup(myNode, ID, "identifiant");
				 for(int i = 0; i<ID.size();i++){
			            System.out.println(ID.get(i));
			         }



	        try {
				fillTree(ID);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	 public JTree getjTreeFile() {
			return Tree;
		}
		 
		 public void fillTree(List<String> ID) throws IOException{
			 for(String row:ID){
				 
				 DefaultMutableTreeNode node=new DefaultMutableTreeNode(row);
				 
				 root.add(node);
			 }
			 
		}

	 public static void main(String[] args) {
		 SwingUtilities.invokeLater(
		     new Runnable() {
	             public void run() {
	                 try {
						new ApplicationPrinc().Display();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	             }
	         }
	     );
	 }
}
