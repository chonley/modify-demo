package com.ewhale;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @author chonley
 *
 */
public class MainFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//����������� ���������Ȩ��	
	protected JButton jButton1;
	protected JButton jButton2;
	protected JButton jButton3;
	protected JButton jButton6;
	protected JButton jButton7;  
	protected JLabel jLabel2;    
	protected JPanel jPanel1;
	protected JPanel jPanel2;
	protected JPanel jPanel3;
	protected JScrollPane jScrollPane1;	
	protected JButton btnNewButton_1;
	
	protected String url;
	protected String defaultConfigFilePath ="/image/EWhalesConfig.dat";
	protected String encoding = "utf-8";
	protected String defaultFileName = "EWhalesConfig";
	
	
	
	
	public Service service;
	
	//����������ʼ��
	public MainFrame(Service service) {
		this.service = service;
		//���ô������
		setResizable(false);
		setFont(new Font("΢���ź�", Font.PLAIN, 15));
		ininComponent();
	}
	
	//�ղι����ʼ��
	public MainFrame() {}


	//���������
	private void ininComponent() {
		//��ť��
		jButton2 = new JButton();
        jButton3 = new JButton();
        jButton6 = new JButton();       
        jButton7 = new JButton(); 
        btnNewButton_1 = new JButton();
        jLabel2 = new JLabel();
        jPanel1 = new JPanel();        
		jPanel2 = new JPanel(); 
        jPanel3 = new JPanel();               
        jScrollPane1 = new JScrollPane();
       
      
        //��ɴ������
        service.initButtons(btnNewButton_1,jButton2,jButton3,jButton6,jButton7);
        service.initFrame(this,jLabel2);
        service.initPanels(jPanel2,jPanel3,jScrollPane1,this,btnNewButton_1,jButton2,jButton3,jButton6,jButton7,jLabel2);
        
        //��ɶ���
        //1���½��ļ���
        service.createNewConfigFile(btnNewButton_1,jButton2,jButton3,jScrollPane1,jPanel1,encoding);
        //2���������ļ�
        service.openConfigFile(jButton2,jPanel1,jButton3,btnNewButton_1,jButton2,encoding,jScrollPane1);
        //3���ָ�Ĭ��       
        service.resetConfigFile(jButton7,btnNewButton_1, jButton2, jButton3, jScrollPane1, jPanel1, encoding,defaultFileName,this);
        //4�����沢�˳�
        service.saveConfigFileAndQuit(jButton3,jPanel1,encoding,defaultFileName,this);
        //5������
        service.about(jButton6);
        
        
        pack();
        
        
        
	}
	
		
 
}
