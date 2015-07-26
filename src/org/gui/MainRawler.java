package org.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.annotation.Annotation;
import java.util.concurrent.BlockingQueue;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import org.config.Config;
import org.gui.listener.AnalyListener;
import org.gui.listener.CreateObjectListener;
import org.gui.listener.DocumentMouseListener;
import org.gui.listener.DocumentSelectListener;
import org.jsoup.nodes.Document;
import org.model.CrawDocument;
import org.model.CrawNode;
import org.net.Producer;
import org.parser.Consumer;

public class MainRawler extends JFrame implements ActionListener{

	private Config config;


	private JTextField jTextUrl;
	private JButton jBtnAnaly,jBtnConfig,jBtnCreateObj,jBtnRun;
	private JTree jTreeTags,jTreeAttrs;
	private DefaultMutableTreeNode treeModel;
	private JTable jTblObj;
	private JPopupMenu jPopup;

	private JPanel jPnTags,jPnAttrs,jPnObjs; 

	public MainRawler(Config config) {
		this.config = config;
		// TODO Auto-generated constructor stub
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(300, 500));
		createGui();
	}



	private void createGui() {
		// TODO Auto-generated method stub
		Box root = Box.createVerticalBox();



		JPanel jpnUrl = createUrlLayout();
		JPanel jpnContent  = createConentLayout(); 




		jpnUrl.setBorder(BorderFactory.createTitledBorder("Url"));
		this.add(jpnUrl,BorderLayout.NORTH);




		
		this.add(jpnContent);
		//this.add(root);
		this.pack();
	}


	private JPanel createConentLayout(){
		JPanel content = new JPanel();
		GridLayout grid = new GridLayout(1, 2);
		//		content.setLayout(new BorderLayout());
		content.setLayout(grid);

		Box b  = Box.createVerticalBox();


		b.setBorder(BorderFactory.createTitledBorder("Content"));

		jPnTags = new JPanel();
		jPnTags.setLayout(new BorderLayout());
		jPnTags.add(new JLabel("List tags HTML"),BorderLayout.NORTH);
		JPanel tree = new JPanel(new BorderLayout());
		//tree.add(jTreeTags = new JTree(new DefaultMutableTreeNode()));
		jPnTags.add(tree);


		jPnAttrs = new JPanel();
		jPnAttrs.setLayout(new BorderLayout());
		jPnAttrs.add(new JLabel("List attrs"),BorderLayout.NORTH);
		JPanel attrTree = new JPanel(new BorderLayout());
		attrTree.add(jTreeAttrs = new JTree(new DefaultMutableTreeNode()));
		jPnAttrs.add(attrTree);

		b.add(jPnTags);
		b.add(Box.createVerticalStrut(10));
		b.add(jPnAttrs);


		jPnObjs = new JPanel(new BorderLayout());

		jPnObjs.add(new JLabel("Objects"));
		jPnObjs.setBorder(BorderFactory.createTitledBorder("Objects"));

		

		content.add(b);
		


		content.add(jPnObjs);
		return content;
	}
	private JPanel createUrlLayout() {
		JPanel jpnUrl = new JPanel(new BorderLayout());


		jpnUrl.add(new JLabel("URL:"),BorderLayout.WEST);

		JPanel content = new JPanel();
		//content.add();

		jpnUrl.add(jTextUrl = new JTextField(100));
		jTextUrl.setText("http://elearning.loc/");

		JPanel btn = new JPanel();

		btn.add(jBtnAnaly = new JButton("Analy"));

		jBtnAnaly.addActionListener(this);

		btn.add(jBtnConfig = new JButton("Setting"));
		jBtnConfig.addActionListener(this);

		jpnUrl.add(btn,BorderLayout.EAST);
		return jpnUrl;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();

		if(o.equals(jBtnAnaly)){
			BlockingQueue<Document>queue = (BlockingQueue<Document>)this.config.getRegistry("queue");
			Producer anlyz = new Producer(queue,jTextUrl.getText());
			Thread t = new Thread(anlyz);
			this.config.analyz = true;
			Consumer con = new Consumer(queue,config);
			Thread cons = new Thread(con);
			t.start();
			cons.start();
			try {
				cons.join();
				this.jTreeTags = new JTree(con.getTreeModel());
				this.jTreeTags.addTreeSelectionListener(new DocumentSelectListener());
				jPopup = new JPopupMenu();
				JMenuItem itemObj = new JMenuItem("Create Object");
				itemObj.addActionListener(new CreateObjectListener());
				JMenuItem itemField = new JMenuItem("Create Field");
				jPopup.add(itemObj);
				jPopup.add(itemField);
				
				this.jTreeTags.addMouseListener(new DocumentMouseListener(jTreeTags,jPopup));
				
				this.jTreeTags.add(jPopup);
				this.jPnTags.add(new JScrollPane(jTreeTags));
				jTreeTags.updateUI();
				this.jPnTags.updateUI();
				
			} catch (InterruptedException e1) {

				// TODO Auto-generated catch block
				e1.printStackTrace();
			}



		}else if(o.equals(jBtnRun)){
			System.out.println("ok");
		}else if(o.equals(jBtnConfig)){


		}
	}



}
