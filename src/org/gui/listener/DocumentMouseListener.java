package org.gui.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import org.model.CrawNode;

public class DocumentMouseListener implements MouseListener {
	
	private JTree tree;
	private JPopupMenu menu;
	
	
	
	public DocumentMouseListener(JTree tree,JPopupMenu menu) {
		this.tree = tree;
		this.menu = menu;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getButton() == 3){
			int selRow = this.tree.getRowForLocation(e.getX(), e.getY());
			TreePath selPath = this.tree.getPathForLocation(e.getX(), e.getY());
			DefaultMutableTreeNode obj = (DefaultMutableTreeNode)selPath.getLastPathComponent();
			
			
			
			this.tree.updateUI();
			
			System.out.println("ok");
			if (e.isPopupTrigger()) {
	            menu.show(e.getComponent(),
	                       e.getX(), e.getY());
	        }		
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.isPopupTrigger()) {
            menu.show(e.getComponent(),
                       e.getX(), e.getY());
            
        }
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
