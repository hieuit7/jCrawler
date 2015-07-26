package org.gui.listener;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import org.model.CrawNode;

public class DocumentSelectListener implements TreeSelectionListener {
	private CrawNode node; 
	
	@Override
	
	public void valueChanged(TreeSelectionEvent e) {
		// TODO Auto-generated method stub
		JTree tree = (JTree)e.getSource();
		DefaultMutableTreeNode data = (DefaultMutableTreeNode)e.getPath().getLastPathComponent();
		CrawNode node = (CrawNode)data.getUserObject();
		TreePath path = e.getPath();		
		System.out.println(node.getPath());
	}

}
