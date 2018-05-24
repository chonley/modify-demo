package com.ewhale;

import javax.swing.UIManager;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;



public class Entrency {
	public static void main(String[] args) {
		
		//加载beautyeye主题
		try{	        	      
	        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.frameBorderStyle.generalNoTranslucencyShadow;
	        BeautyEyeLNFHelper.launchBeautyEyeLNF();
	        UIManager.put("RootPane.setupButtonVisible", false);
	    }
	    catch(Exception e) {	
	    }
		Service service = new Service();		
		//打开窗体
		java.awt.EventQueue.invokeLater(new Runnable() {
	         public void run() {
	             new MainFrame(service).setVisible(true);
	         }
	     });
	        
		
	}

}
