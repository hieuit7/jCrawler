package org.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import org.config.Config;
import org.gui.listener.AnalyListener;
import org.model.CrawDocument;
import org.net.Producer;
import org.parser.Consumer;

public class MainRawler extends JFrame implements ActionListener{
	
	private Config config;
	
	
	private JTextField jTextUrl;
	private JButton jBtnAnaly,jBtnConfig,jBtnCreateObj,jBtnRun;
	private JTree jTreeTags,jTreeAttrs;
	private DefaultMutableTreeNode treeModel;
	private JTable jTblObj;
	
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
		tree.add(jTreeTags = new JTree(new DefaultMutableTreeNode()));
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
		jTextUrl.setText("http://www.journaldev.com/1034/java-blockingqueue-example-implementing-producer-consumer-problem");
		
		JPanel btn = new JPanel();
		
		btn.add(jBtnAnaly = new JButton("Analy"));
		
		jBtnAnaly.addActionListener(this);
		btn.add(jBtnConfig = new JButton("Setting"));
		
		jpnUrl.add(btn,BorderLayout.EAST);
		return jpnUrl;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		
		if(o.equals(jBtnAnaly)){
			System.out.println("Clicked!!");
			BlockingQueue<CrawDocument>queue = (BlockingQueue<CrawDocument>)this.config.getRegistry(0);
			Producer anlyz = new Producer(queue,jTextUrl.getText());
			Thread t = new Thread(anlyz);
			Consumer con = new Consumer(queue,treeModel = new DefaultMutableTreeNode(),jTreeTags);
			
			Thread cons = new Thread(con);
			
			t.start();
			cons.start();
			System.out.println("finish");
			try {
				cons.join();
				System.out.println(con.getTreeModel());;
			} catch (InterruptedException e1) {
				
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		}
	}
	
	
	
}
