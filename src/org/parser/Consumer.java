package org.parser;

import java.util.concurrent.BlockingQueue;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import org.config.Config;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;
import org.model.CrawDocument;
import org.model.CrawNode;

public class Consumer implements Runnable{

	private BlockingQueue<Document> queue;
	private DefaultMutableTreeNode treeModel;
	private JTree tree;
	private Config config;
	
	public Consumer(BlockingQueue<Document> queue,Config config) {		
		this.queue = queue;
		this.config = config;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("Start create tree11111");
			Document doc = this.queue.take();
			if(config.analyz){
				
				Element el = doc.getElementsByTag("html").first();
				
				CrawNode node  = new CrawNode(el);
				treeModel = new DefaultMutableTreeNode(node);
				
				DocumentParser par = new DocumentParser(doc);
				
				Elements els = doc.children();
				System.out.println(els.size());
				for (int i = 0; i < els.size(); i++) {
					par.parseTree(treeModel, els.get(i));
				}
				
			}else{
				
			}
			
			System.out.println("End create tree");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public DefaultMutableTreeNode getTreeModel() {
		
		return treeModel;
	}


	public void setTreeModel(DefaultMutableTreeNode treeModel) {
		this.treeModel = treeModel;
	}
	
	
	
}
