package com.ewhale;

import javax.swing.UIManager;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;



public class Entrency {
	public static void main(String[] args) {
		
		//����beautyeye����
		try{	        	      
	        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.frameBorderStyle.generalNoTranslucencyShadow;
	        BeautyEyeLNFHelper.launchBeautyEyeLNF();
	        UIManager.put("RootPane.setupButtonVisible", false);
	    }
	    catch(Exception e) {	
	    }
		Service service = new Service();		
		//�򿪴���
		java.awt.EventQueue.invokeLater(new Runnable() {
	         public void run() {
	             new MainFrame(service).setVisible(true);
	         }
	     });
	        
		
	}

}
