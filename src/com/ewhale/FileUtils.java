package com.ewhale;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FileUtils {

	
	//���ж�ȡ�����list
	public static List<String> readFileOrderByLine(InputStream in,String encoding){
		
		//�ǿռ��
		if(in==null) {
			return null;
		}
		
		
		List<String> everyLine = new ArrayList<>();	
		 InputStreamReader isr = null;
		 BufferedReader br = null;
		try {			
			 isr = new InputStreamReader(in,encoding);
			  br = new BufferedReader(isr);			 
		     String line = null;
		     int num = 0;
			 while((line=br.readLine())!=null) {
				num++;
				int a=0;
				Pattern p = Pattern.compile("->");
				Matcher m = p.matcher(line);
				while(m.find()) {
					a++;
				}					
				if(a==1) {
					if(!line.startsWith("->")&&!line.endsWith("->")) {
						everyLine.add(line);
					}
				}else {
					JOptionPane.showMessageDialog(null, "�ļ�����!  �����"+num+"�У�") ; 
					
					return null;
				}
			}
		} catch (Exception e) {
			 e.printStackTrace();
			 JOptionPane.showMessageDialog(null, "�ļ���ȡ·������!") ; 
		}finally {
			 if(isr!=null)
				try {
					br.close();
					isr.close();
				} catch (IOException e1) {
					
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "�ļ�δ�رգ�");
					
				}
		}		
		return everyLine;
	
	} 
	
	//�и�ÿ���ַ����������µļ�����
	public static List<String> splitLineByIcon(List<String> line) {
		
		//�ǿռ��
		if(line==null) {
			return null;
		}
		
		List<String> segment = new ArrayList<>();
		
		for (String str : line) {
			String[] a = str.split("->");
			for (String sre : a) {
				segment.add(sre);
			}
		}
		return segment;
	}
	
	//��ÿ���ַ���װ��һ��label��textfield��
	public static Map<JLabel, JTextField> packageDataMap(List<String> list){
		  
		//�ǿռ��
		if(list==null) {
			return null;
		}
		
		Map<JLabel, JTextField> map = new LinkedHashMap<>();
	    	
		  for (int i =0;i<list.size()-1;i+=2) {
				
				JLabel label = new JLabel();
				label.setFont(new Font("΢���ź�", Font.PLAIN, 17)); // NOI18N
				label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
				label.setText((String) list.get(i)+"->");
				label.setMaximumSize(new java.awt.Dimension(420, 18));
				label.setMinimumSize(new java.awt.Dimension(420, 18));
				label.setPreferredSize(new java.awt.Dimension(420, 18));
				
				
				JTextField jTextField1 = new JTextField();
				 jTextField1.setColumns(15);
				
				 jTextField1.setMaximumSize(new java.awt.Dimension(420, 18));
				 jTextField1.setMinimumSize(new java.awt.Dimension(420, 18));
				 jTextField1.setPreferredSize(new java.awt.Dimension(420, 18));
	             jTextField1.setFont(new Font("΢���ź�", Font.PLAIN, 17)); // NOI18N
	             jTextField1.setText((String) list.get(i+1));
				
	            
	             map.put(label, jTextField1);
				
			}	
			return map;	
		
		
	}
	
	
	
	
	
	
}
