package com.ewhale;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;




public class Service {

	protected String defaultDisk ;
	protected String[] saveType = {"dat"} ;
	protected String defaultFilePath ="/image/EWhalesConfig.dat"; 
	
	
	public Service() {
		//获取桌面路径
		File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();	
		this.defaultDisk = desktopDir.getAbsolutePath();		
	}
	
	
	/**
	 * 初始化组件
	 */
	//初始化按钮组
	public void initButtons(JButton btnNewButton_1, JButton jButton2, JButton jButton3, JButton jButton6, JButton jButton7) {
		
		jButton2.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jButton2.setText("打   开");
        jButton2.setBackground(new Color(176, 196, 222));
        jButton2.setForeground(Color.BLACK);
        
        jButton3.setText("保存并退出");
        jButton3.setEnabled(false);
        jButton3.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jButton3.setBackground(new Color(176, 196, 222));
        
        jButton6.setText("关   于");
        jButton6.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jButton6.setBackground(new Color(176, 224, 230));
        
        jButton7.setEnabled(false);
        jButton7.setText("恢复默认");
        jButton7.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        jButton7.setBackground(new Color(127, 255, 212));
        
        btnNewButton_1.setText("新建文件");
        btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        btnNewButton_1.setBackground(new Color(176, 196, 222));       
        btnNewButton_1.setForeground(Color.BLACK);
		
	}
	//初始化容器组
	public void initPanels(JPanel jPanel2, JPanel jPanel3, JScrollPane jScrollPane1, MainFrame mainFrame, JButton btnNewButton_1, JButton jButton2, JButton jButton3, JButton jButton6, JButton jButton7, JLabel jLabel2) {
		
		//设置滚动条大小
		jScrollPane1.getVerticalScrollBar().setUnitIncrement(25);
		
        //设置panel3布局
        GroupLayout gl_jPanel3 = new GroupLayout(jPanel3);
        gl_jPanel3.setHorizontalGroup(
		gl_jPanel3.createParallelGroup(Alignment.TRAILING)
		.addGroup(gl_jPanel3.createSequentialGroup()
		.addGap(58)
		.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
		.addGap(42)
		.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
		.addGap(48)
		.addComponent(jButton3)
		.addGap(61)
		.addComponent(jButton7, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
		.addGap(62)
		.addComponent(jButton6, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
		.addContainerGap(62, Short.MAX_VALUE))
		.addGroup(Alignment.LEADING, gl_jPanel3.createSequentialGroup()
		.addGap(51)
		.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 745, GroupLayout.PREFERRED_SIZE)
		.addContainerGap(51, Short.MAX_VALUE))
		.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
        );
        
        
        gl_jPanel3.setVerticalGroup(
    	gl_jPanel3.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_jPanel3.createSequentialGroup()
		.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
		.addPreferredGap(ComponentPlacement.RELATED)
		.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
		.addPreferredGap(ComponentPlacement.RELATED)
		.addGroup(gl_jPanel3.createParallelGroup(Alignment.LEADING)
		.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
		.addGroup(gl_jPanel3.createParallelGroup(Alignment.LEADING, false)
		.addComponent(jButton6, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
		.addGroup(gl_jPanel3.createParallelGroup(Alignment.BASELINE)
		.addComponent(jButton3, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
		.addComponent(jButton2, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
		.addComponent(jButton7, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)))))
        );
        jPanel3.setLayout(gl_jPanel3);
        
        
       //设置panel2布局
	   GridBagConstraints gbc_jPanel2 = new GridBagConstraints();
	   gbc_jPanel2.insets = new Insets(0, 0, 5, 0);
	   gbc_jPanel2.gridy = 0;
	   gbc_jPanel2.gridx = 0;
	   mainFrame.getContentPane().add(jPanel2, gbc_jPanel2);
	   jPanel2.setLayout(new BorderLayout(0, 0));
	   jPanel2.add(jPanel3);
              
       
		
	}
	//初始化窗体
	public void initFrame(MainFrame mainFrame, JLabel jLabel2) {
		 /**  
         * 初始化窗体
         */
        //设置标题和小icon
  		mainFrame.setTitle("修改配置文件");
  		Image icon =new ImageIcon(MainFrame.class.getResource("/image/logo-圆形-无背景.png")).getImage();
  		mainFrame.setIconImage(icon);
  		
  		//设置窗体位置
  		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
  		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
  		int windowsWedth = 830;
  		int windowsHeight =  635;
  		mainFrame.setBounds((width - windowsWedth) / 2,(height - windowsHeight) / 4, 853, 756);
  		mainFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
  		
  		//设置公司logo
  		URL imgURL = MainFrame.class.getResource("/image/logo-长条-无背景.png");	        
  	    jLabel2.setIcon(new ImageIcon(new ImageIcon(imgURL).getImage().getScaledInstance(750, 220, Image.SCALE_DEFAULT)));
  	    jLabel2.setMaximumSize(new java.awt.Dimension(50, 30));
  	    jLabel2.setMinimumSize(new java.awt.Dimension(50, 30));
  	    jLabel2.setPreferredSize(new java.awt.Dimension(50, 30));
      		
      		
  		//设置窗体布局
  		 GridBagLayout gridBagLayout = new GridBagLayout();
  	     gridBagLayout.rowWeights = new double[]{0.0};
  	     gridBagLayout.columnWeights = new double[]{1.0};
  	     mainFrame.getContentPane().setLayout(gridBagLayout);
		
	}
	

	
	/**
	 * 监听事件
	 * @param 
	 */
	//1、新建配置文件
	public void createNewConfigFile(JButton btnNewButton_1, 
									JButton jButton2, 
									JButton jButton3, 
									JScrollPane jScrollPane1,
									JPanel jPanel1, String encoding) {
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getDefaultFileAndShow(btnNewButton_1, jButton2, jButton3, jScrollPane1, jPanel1, encoding);
				
				
			}



			

			
		});
		
	}

	//2、打开配置文件
	public void openConfigFile(JButton jButton2, 
			   JPanel jPanel1, 
			   JButton jButton3, 
			   JButton btnNewButton_1,
			   JButton jButton22, String encoding, JScrollPane jScrollPane1) {

		jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
				//新建文件选择器
				JFileChooser chooser = new JFileChooser();  
				chooser.setCurrentDirectory(new File(defaultDisk));	
				chooser.setFileFilter(new FileNameExtensionFilter(".dat", saveType));
				int returnVal = chooser.showOpenDialog(jButton2);        //是否打开文件选择框    
				if (returnVal == JFileChooser.APPROVE_OPTION) {          //如果符合文件类型
					String  selectedFileUrl = chooser.getSelectedFile().getAbsolutePath();      //获取绝对路径  
					if(selectedFileUrl!=null&&jPanel1.getComponentCount()==0) {
						
						//读取文件打开输入流
						FileInputStream fis = null;
						try {
							 fis = new FileInputStream(selectedFileUrl);								
							List<String> line =  completeDataPackByFileInputStream(jPanel1, encoding, fis);							
							 setPanelLayout(jScrollPane1,jPanel1,line.size()/2);
							 if(jPanel1.getComponentCount()!=0) {
									jButton3.setEnabled(true);
									btnNewButton_1.setEnabled(false);
									jButton2.setEnabled(false);
							 }
						} catch (Exception e2) {
							// TODO: handle exception
						}finally {
							try {
								if(fis!=null) {
									fis.close();
								}
							} catch (Exception e3) {
								// TODO: handle exception
							}
						}
						
						
						if(jPanel1.getComponentCount()!=0) {
							jButton3.setEnabled(true);
							btnNewButton_1.setEnabled(false);
							jButton2.setEnabled(false);
						}
						return;
					}else {
						if(jPanel1.getComponentCount()!=0) {
							JOptionPane.showMessageDialog(null, "有文件已打开！","警告",JOptionPane.WARNING_MESSAGE);							
							return;
						}
					}
				}
			}

			private List<String> completeDataPackByFileInputStream(JPanel jPanel1, String encoding, FileInputStream fis) {
				List<String> splitLineByIcon = FileUtils.splitLineByIcon(FileUtils.readFileOrderByLine(fis, encoding));
				 Map<JLabel, JTextField> packageDataMap = FileUtils.packageDataMap(splitLineByIcon);
				 
				 packageDataIntoPanel(packageDataMap, jPanel1);
				 return splitLineByIcon;
			}
		});

}
	
	//3、恢复默认
	public void resetConfigFile(JButton jButton7, JButton btnNewButton_1, JButton jButton2, JButton jButton3, JScrollPane jScrollPane1, JPanel jPanel1, String encoding, String defaultFileName, MainFrame mainFrame) {
		jButton7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getDefaultFileAndShow(btnNewButton_1, jButton2, jButton3, jScrollPane1, jPanel1, encoding);
				//得到所有的label和panel中的内容并且拼接到字符串中
				Component[] components = jPanel1.getComponents();
				String text = scanComponentIntoText(components);
				File saveFile=new File(defaultDisk,defaultFileName+".dat"); //默认存到桌面，可以更改
				saveConfigFile(encoding, text, saveFile);
				mainFrame.dispose();//关闭窗体
			}
		});
		
	}
	
	//4、保存并退出
	public void saveConfigFileAndQuit(JButton jButton3, JPanel jPanel1, String encoding, String defaultFileName, MainFrame mainFrame) {
		jButton3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//得到所有的label和panel中的内容并且拼接到字符串中
				Component[] components = jPanel1.getComponents();
				String text = scanComponentIntoText(components);
				//打开文件夹选择框
				JFileChooser jfc = new JFileChooser();    
				jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				jfc.setCurrentDirectory(new File(defaultDisk));	
				jfc.setDialogTitle("选择保存文件路径");
				while(true) {
					//选择了保存按钮
					if(JFileChooser.APPROVE_OPTION == jfc.showSaveDialog(jButton3)) {
						//这里可以设置默认路径
						File saveFile=new File(jfc.getSelectedFile(),defaultFileName+".dat"); //加上后缀
						if(saveFile.exists()) {
							//同名文件存在，弹出是否覆盖，返回0或1
							int n = JOptionPane.showConfirmDialog(null, "文件已存在，是否覆盖？", "保存文件",JOptionPane.YES_NO_OPTION);
							if(0==n) {
								saveConfigFile(encoding, text, saveFile); 
								JOptionPane.showMessageDialog(null, "覆盖保存成功！"); 
								mainFrame.dispose();//关闭窗体
								break;
							}else {
								JOptionPane.showMessageDialog(null, "请重新保存！"); 						
							}							
						}else {										
							saveConfigFile(encoding, text, saveFile); 
							JOptionPane.showMessageDialog(null, "保存成功！"); 
							mainFrame.dispose();//关闭窗体
							break;
						}											
					}else {
						break;
					}
					
				}
				
			}

			

		
		});
		
	}
	
	//5、关于
	public void about(JButton jButton6) {
		
		jButton6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog frame = new JDialog();
				initNewFrame(frame);
				frame.setVisible(true);
				
			}

			
		});
	}
	
	
	/**
	 * 通用方法
	 */
	//组装进去jpanel中
	public static void packageDataIntoPanel(Map<JLabel, JTextField> map,JPanel jPanel1) {

		if(null==map) {
			return;
		}
		//遍历map,将组件装到文件panel中		
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()) {
			@SuppressWarnings("unchecked")
			Map.Entry<JLabel, JTextField> entry = (Entry<JLabel, JTextField>) it.next();
			jPanel1.add(entry.getKey());
			jPanel1.add(entry.getValue());
			
		}
	}
	
	//设置中间的panel的布局（带有滑竿的）
	private void setPanelLayout(JScrollPane jScrollPane1, JPanel jPanel1, int size) {
		int rows = size;					
		jScrollPane1.setViewportView(jPanel1);
		jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		jPanel1.setPreferredSize(new java.awt.Dimension(600, rows*38));
		jPanel1.setLayout(new GridLayout(rows, 2, 0, 0));
	}


	
	//收集修改数据
	private  String scanComponentIntoText(Component[] components) {
		String text = "";
		for(int i = 0;i<components.length;i++) {
			if(components[i] instanceof JLabel) {
				text += ((JLabel) components[i]).getText();
			}else if(components[i] instanceof JTextField) {
				text += ((JTextField) components[i]).getText();
			}
			if(i%2==1) {
				text +="\r\n";
			}
		}
		return text;
	}
	
	//保存文件
	private void saveConfigFile(String encoding, String text, File saveFile) {
		FileOutputStream outputStream = null ;
		BufferedWriter bw  = null;
		try {
			outputStream = new FileOutputStream(saveFile);
			   bw =  new BufferedWriter(new OutputStreamWriter(outputStream, encoding));
			  bw.write(text); 							  
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				bw.close();
				outputStream.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

		}
	}


	
	//关于页面
	private void initNewFrame(JDialog frame) {
		Image icon =new ImageIcon(MainFrame.class.getResource("/image/logo-圆形-无背景.png")).getImage();
			
		frame.setIconImage(icon);   
		frame.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		frame.setResizable(false);
		frame.setTitle("\u7CFB\u7EDF\u5F00\u53D1\u8005\u4FE1\u606F");
		frame.setBounds(600, 300, 650, 260);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
        
		 java.net.URL imgURL = MainFrame.class.getResource("/image/logo-圆形-无背景.png");
        
         lblNewLabel.setIcon(new ImageIcon(new ImageIcon(imgURL).getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT)));
		
		
		lblNewLabel.setBounds(20, 18, 160, 169);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u667A\u8054\u4E07\u7269\uFF0C\u9CB8\u63A7\u672A\u6765");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(188, 18, 277, 41);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5982\u6709\u95EE\u9898\uFF0C\u8BF7\u4E0E\u6211\u4EEC\u8054\u7CFB\uFF1A");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(188, 54, 258, 41);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("www.alwhales.com\r\n");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(188, 84, 193, 35);
		frame.getContentPane().add(lblNewLabel_3);
		
/*				JLabel lblNewLabel_4 = new JLabel("\u5403\u9CB8\u7535\u5B50\u79D1\u6280\uFF08\u4E0A\u6D77\uFF09\u6709\u9650\u516C\u53F8\r\n\u7248\u6743\u6240\u6709 \u4FB5\u6743\u5FC5\u7A76");
*/				
		JLabel lblNewLabel_4 = new JLabel("<html><a href='http://www.alwhales.com/'>http://www.alwhales.com/</a></html>");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {  
			  
            public void mouseClicked(MouseEvent e) {  
                try {  
                	
                	Desktop desktop = Desktop.getDesktop();  
                	desktop.browse(new URI("http://www.alwhales.com"));
                
                } catch (Exception ex) {  
                    ex.printStackTrace();  
                }  
            }  
        });
		lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(188, 115, 409, 35);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("v1.1 Beta");
		lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(188, 146, 258, 29);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("O K");
		btnNewButton.setBackground(new Color(176, 224, 230));
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		btnNewButton.setBounds(469, 178, 93, 34);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		frame.setModal(true);
		/*frame.setBackground(new Color(176, 224, 230));*/
		frame.getContentPane().add(btnNewButton);
	}

	//读取默认文件以及展示出来
	private void getDefaultFileAndShow(JButton btnNewButton_1, JButton jButton2, JButton jButton3, JScrollPane jScrollPane1,
			JPanel jPanel1, String encoding) {
		InputStream in = null;
		try {
			//读取文件并填充进panel
			in = this.getClass().getResourceAsStream(defaultFilePath);
			List<String> readFileOrderByLine = completeDataPackByInputStream(jPanel1, encoding, in);					
			//设置布局，每行两个
			
			setPanelLayout(jScrollPane1, jPanel1, readFileOrderByLine.size());
			
			
			//设置其他按键状态
			btnNewButton_1.setEnabled(false);
			jButton2.setEnabled(false);
			jButton3.setEnabled(true);
			
		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println(e2.getMessage());
		}finally {
			try {
				if(null!=in) {
					in.close();
				}
			} catch (Exception e3) {
				// TODO: handle exception
			}
		}
	}

	//输入流完成打包任务
	private List<String> completeDataPackByInputStream(JPanel jPanel1, String encoding, InputStream in) {
		List<String> readFileOrderByLine = FileUtils.readFileOrderByLine(in, encoding);
		List<String> splitLineByIcon = FileUtils.splitLineByIcon(readFileOrderByLine);
		Map<JLabel, JTextField> dataMap = FileUtils.packageDataMap(splitLineByIcon);
		packageDataIntoPanel(dataMap, jPanel1);
		return readFileOrderByLine;
	}
	

}















