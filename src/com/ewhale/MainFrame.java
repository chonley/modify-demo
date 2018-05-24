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
	//窗体组件定义 给予包级别权限	
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
	
	//窗体各组件初始化
	public MainFrame(Service service) {
		this.service = service;
		//设置窗体标题
		setResizable(false);
		setFont(new Font("微软雅黑", Font.PLAIN, 15));
		ininComponent();
	}
	
	//空参构造初始化
	public MainFrame() {}


	//各部分组件
	private void ininComponent() {
		//按钮组
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
       
      
        //完成窗体绘制
        service.initButtons(btnNewButton_1,jButton2,jButton3,jButton6,jButton7);
        service.initFrame(this,jLabel2);
        service.initPanels(jPanel2,jPanel3,jScrollPane1,this,btnNewButton_1,jButton2,jButton3,jButton6,jButton7,jLabel2);
        
        //完成动作
        //1、新建文件：
        service.createNewConfigFile(btnNewButton_1,jButton2,jButton3,jScrollPane1,jPanel1,encoding);
        //2、打开配置文件
        service.openConfigFile(jButton2,jPanel1,jButton3,btnNewButton_1,jButton2,encoding,jScrollPane1);
        //3、恢复默认       
        service.resetConfigFile(jButton7,btnNewButton_1, jButton2, jButton3, jScrollPane1, jPanel1, encoding,defaultFileName,this);
        //4、保存并退出
        service.saveConfigFileAndQuit(jButton3,jPanel1,encoding,defaultFileName,this);
        //5、关于
        service.about(jButton6);
        
        
        pack();
        
        
        
	}
	
		
 
}
