package org.parser;

import java.util.concurrent.BlockingQueue;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import org.model.CrawDocument;

public class Consumer implements Runnable{

	private BlockingQueue<CrawDocument> queue;
	private DefaultMutableTreeNode treeModel;
	private JTree tree;
	
	public Consumer(BlockingQueue<CrawDocument> queue,DefaultMutableTreeNode treeModel,JTree tree) {
		
		this.queue = queue;
		this.tree = tree;
		this.treeModel = treeModel;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("Start create tree11111");
			DefaultMutableTreeNode get = this.queue.take().getTagsModel(); 
			System.out.println("obj"+get);
			treeModel.add(get);
			tree.updateUI();
			System.out.println("End create tree");
		} catch (InterruptedException e) {
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
