package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.lang.reflect.*;
/**
 * View of the MVC architecture
 * Initialises all containers and components
 * Maps action listeners to the buttons
 */
public class View extends JFrame{
	private JPanel panel;
	private int WIDTH, HEIGHT;
	
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JPanel p4;
	
	private JPanel i1;
	private JPanel i2;
	private JPanel i3;
	private JPanel i4;
	
	private JPanel t1;
	private JPanel t2;
	private JPanel t3;
	private JPanel t4;
	
	
	private JLabel id_tcountryCOL;
	private JLabel countryCOL;
	
	private JLabel id_tproductPL;
	private JLabel product_namePL;
	private JLabel stockPL;
	private JLabel pricePL;
	
	private JLabel id_torderOL;
	private JLabel id_tclientOL;
	private JLabel id_tproductOL;
	private JLabel quantityOL;
	
	private JLabel id_tclientCL;
	private JLabel nameCL;
	private JLabel addressCL;
	private JLabel ageCL;
	private JLabel emailCL;
	private JLabel id_tcountryCL;
	
	
	private JTextField id_tcountryCOTF;
	private JTextField countryCOTF;
	
	private JTextField id_tproductPTF;
	private JTextField product_namePTF;
	private JTextField stockPTF;
	private JTextField pricePTF;
	
	private JTextField id_torderOTF;
	private JTextField id_tclientOTF;
	private JTextField id_tproductOTF;
	private JTextField quantityOTF;
	
	private JTextField id_tclientCTF;
	private JTextField nameCTF;
	private JTextField addressCTF;
	private JTextField ageCTF;
	private JTextField emailCTF;
	private JTextField id_tcountryCTF;
	
	
	private JButton jButtonDeleteC;
	private JButton jButtonInsertC;
	private JButton jButtonUpdateC;
	private JButton jButtonViewC;
	private JButton jButtonIdC;
	private JButton jButtonOrderC;
	
	private JButton jButtonDeleteCO;
	private JButton jButtonInsertCO;
	private JButton jButtonUpdateCO;
	private JButton jButtonViewCO;
	private JButton jButtonIdCO;
	
	private JButton jButtonDeleteP;
	private JButton jButtonInsertP;
	private JButton jButtonUpdateP;
	private JButton jButtonViewP;
	private JButton jButtonIdP;
	
	private JButton jButtonDeleteO;
	private JButton jButtonInsertO;
	private JButton jButtonUpdateO;
	private JButton jButtonViewO;
	private JButton jButtonIdO;
	
	private JTable infoTableC;
	private JTable infoTableCO;
	private JTable infoTableP;
	private JTable infoTableO;
	
	private JTabbedPane tp;   

	/**
	 * Constructor
	 */
	public View() {
		panel = new JPanel();
		WIDTH = 1400;
		HEIGHT = 650;
		panel.setSize(WIDTH,HEIGHT);
		panel.setBackground(new java.awt.Color(204, 204, 255));
		this.setContentPane(panel);
		this.setSize(WIDTH, HEIGHT);
		this.setTitle("DataBase App");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font font = new Font("SansSerif", Font.PLAIN, 16);
		
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p1.setPreferredSize(new Dimension(1350, 550));
		p2.setPreferredSize(new Dimension(1350, 550));
		p3.setPreferredSize(new Dimension(1350, 550));
		p4.setPreferredSize(new Dimension(1350, 550));
		
		
		id_tcountryCOL = new JLabel("id_tcountry");
		countryCOL = new JLabel("country");
		
		id_tproductPL = new JLabel("id_tproduct");
		product_namePL = new JLabel("product_name");
		stockPL = new JLabel("stock");
		pricePL = new JLabel("price");
		
		id_torderOL = new JLabel("id_torder");
		id_tclientOL = new JLabel("id_tclient");
		id_tproductOL = new JLabel("id_tproduct");
		quantityOL = new JLabel("quantity");
		
		id_tclientCL = new JLabel("id_tclient");
		nameCL = new JLabel("name");
		addressCL = new JLabel("address");
		ageCL = new JLabel("age");
		emailCL = new JLabel("email");
		id_tcountryCL = new JLabel("id_tcountry");
		
		
		id_tcountryCOL.setFont(font);
		countryCOL.setFont(font);
		
		id_tproductPL.setFont(font);
		product_namePL.setFont(font);
		stockPL.setFont(font);
		pricePL.setFont(font);
		
		id_torderOL.setFont(font);
		id_tclientOL.setFont(font);
		id_tproductOL.setFont(font);
		quantityOL.setFont(font);
		
		id_tclientCL.setFont(font);
		nameCL.setFont(font);
		addressCL.setFont(font);
		ageCL.setFont(font);
		emailCL.setFont(font);
		id_tcountryCL.setFont(font);
		
		
		id_tcountryCOTF = new JTextField();
		countryCOTF = new JTextField();
		
		id_tproductPTF = new JTextField();
		product_namePTF = new JTextField();
		stockPTF = new JTextField();
		pricePTF = new JTextField();
		
		id_torderOTF = new JTextField();
		id_tclientOTF = new JTextField();
		id_tproductOTF = new JTextField();
		quantityOTF = new JTextField();
		
		id_tclientCTF = new JTextField();
		nameCTF = new JTextField();
		addressCTF = new JTextField();
		ageCTF = new JTextField();
		emailCTF = new JTextField();
		id_tcountryCTF = new JTextField();
		
		
		id_tcountryCOTF.setFont(font);
		countryCOTF.setFont(font);
		
		id_tproductPTF.setFont(font);
		product_namePTF.setFont(font);
		stockPTF.setFont(font);
		pricePTF.setFont(font);
		
		id_torderOTF.setFont(font);
		id_tclientOTF.setFont(font);
		id_tproductOTF.setFont(font);
		quantityOTF.setFont(font);
		
		id_tclientCTF.setFont(font);
		nameCTF.setFont(font);
		addressCTF.setFont(font);
		ageCTF.setFont(font);
		emailCTF.setFont(font);
		id_tcountryCTF.setFont(font);
		
		
		jButtonDeleteC = new JButton("Delete");
		jButtonInsertC= new JButton("Insert");
		jButtonUpdateC= new JButton("Update");
		jButtonViewC= new JButton("View");
		jButtonIdC = new JButton("Find by id");
		jButtonOrderC = new JButton("Place order");
		
		jButtonDeleteCO= new JButton("Delete");
		jButtonInsertCO= new JButton("Insert");
		jButtonUpdateCO= new JButton("Update");
		jButtonViewCO= new JButton("View");
		jButtonIdCO	 = new JButton("Find by id");
		
		jButtonDeleteP= new JButton("Delete");
		jButtonInsertP= new JButton("Insert");
		jButtonUpdateP= new JButton("Update");
		jButtonViewP= new JButton("View");
		jButtonIdP = new JButton("Find by id");
		
		jButtonDeleteO= new JButton("Delete");
		jButtonInsertO= new JButton("Insert");
		jButtonUpdateO= new JButton("Update");
		jButtonViewO= new JButton("View");
		jButtonIdO = new JButton("Find by id");
		
		jButtonDeleteC.setFont(font);
		jButtonInsertC.setFont(font);
		jButtonUpdateC.setFont(font);
		jButtonViewC.setFont(font);
		jButtonIdC.setFont(font);
		jButtonOrderC.setFont(font);
		
		jButtonDeleteCO.setFont(font);
		jButtonInsertCO.setFont(font);
		jButtonUpdateCO.setFont(font);
		jButtonViewCO.setFont(font);
		jButtonIdCO.setFont(font);
		
		jButtonDeleteP.setFont(font);
		jButtonInsertP.setFont(font);
		jButtonUpdateP.setFont(font);
		jButtonViewP.setFont(font);
		jButtonIdP.setFont(font);
		
		jButtonDeleteO.setFont(font);
		jButtonInsertO.setFont(font);
		jButtonUpdateO.setFont(font);
		jButtonViewO.setFont(font);
		jButtonIdO.setFont(font);
		
		infoTableC = new JTable();
		infoTableCO = new JTable();
		infoTableP = new JTable();
		infoTableO = new JTable();
		
		infoTableC.setPreferredSize(new Dimension(890, 500));
		infoTableCO.setPreferredSize(new Dimension(890, 500));
		infoTableP.setPreferredSize(new Dimension(890, 500));
		infoTableO.setPreferredSize(new Dimension(890, 500));
		
		t1 = new JPanel();
		t2 = new JPanel();
		t3 = new JPanel();
		t4 = new JPanel();
		t1.setLayout(new BorderLayout());
		t2.setLayout(new BorderLayout());
		t3.setLayout(new BorderLayout());
		t4.setLayout(new BorderLayout());
		t1.setPreferredSize(new Dimension(900, 520));
		t2.setPreferredSize(new Dimension(900, 520));
		t3.setPreferredSize(new Dimension(900, 520));
		t4.setPreferredSize(new Dimension(900, 520));
		t1.setBackground(new Color(102, 102, 255));
		t2.setBackground(new Color(102, 102, 255));
		t3.setBackground(new Color(102, 102, 255));
		t4.setBackground(new Color(102, 102, 255));
		
		i1 = new JPanel();
		i2 = new JPanel();
		i3 = new JPanel();
		i4 = new JPanel();
		i1.setBackground(new Color(102, 102, 255));
		i2.setBackground(new Color(102, 102, 255));
		i3.setBackground(new Color(102, 102, 255));
		i4.setBackground(new Color(102, 102, 255));
		GroupLayout gl1 = new GroupLayout(i1);
		i1.setLayout(gl1);
		gl1.setHorizontalGroup(  
				gl1.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(gl1.createSequentialGroup()
	                .addGroup(gl1.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(gl1.createSequentialGroup()
	                        .addContainerGap()
	                        .addGroup(gl1.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addComponent(id_tclientCL)
	                            .addComponent(nameCL)
	                            .addComponent(addressCL)
	                            .addComponent(ageCL)
	                            .addComponent(emailCL)
	                            .addComponent(id_tcountryCL))
	                        .addGap(10, 10, 10)
	                        .addGroup(gl1.createParallelGroup(GroupLayout.Alignment.LEADING, false)
	                            .addComponent(id_tclientCTF, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
	                            .addComponent(nameCTF, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
	                            .addComponent(addressCTF, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
	                            .addComponent(ageCTF, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
	                            .addComponent(emailCTF, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
	                            .addComponent(id_tcountryCTF, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
	                    .addGroup(gl1.createSequentialGroup()
	                        .addGap(14, 14, 14)
	                        .addComponent(jButtonInsertC, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addComponent(jButtonDeleteC, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addComponent(jButtonUpdateC, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(gl1.createSequentialGroup()
	                        .addGap(14, 14, 14)
	                        .addComponent(jButtonViewC, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
			                .addGap(18, 18, 18)
		                    .addComponent(jButtonIdC, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
		                    .addGap(18, 18, 18)
		                    .addComponent(jButtonOrderC, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))        
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
		
		gl1.setVerticalGroup(
				gl1.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(gl1.createSequentialGroup()
	                .addGap(40, 40, 40)
	                .addGroup(gl1.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(id_tclientCL, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(id_tclientCTF, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
	                .addGap(10, 10, 10)
	                .addGroup(gl1.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(nameCL, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(nameCTF, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
	                .addGap(10, 10, 10)
	                .addGroup(gl1.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(addressCL, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(addressCTF, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
	                .addGap(10, 10, 10)
	                .addGroup(gl1.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(ageCL, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(ageCTF, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
	                .addGap(10, 10, 10)
	                .addGroup(gl1.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(emailCL, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(emailCTF, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
	                .addGap(10, 10, 10)
	                .addGroup(gl1.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(id_tcountryCL, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(id_tcountryCTF, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
	                .addGap(50, 50, 50)
	                .addGroup(gl1.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jButtonInsertC, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jButtonDeleteC, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jButtonUpdateC, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
	                .addGap(20, 20, 20)
	                .addGroup(gl1.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                .addComponent(jButtonViewC, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                .addComponent(jButtonIdC, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                .addComponent(jButtonOrderC, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
	                .addGap(60, 60, 60))
	        );
		
		GroupLayout gl2 = new GroupLayout(i2);
		i2.setLayout(gl2);
		gl2.setHorizontalGroup(  
				gl2.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(gl2.createSequentialGroup()
	                .addGroup(gl2.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(gl2.createSequentialGroup()
	                        .addContainerGap()
	                        .addGroup(gl2.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addComponent(id_tproductPL)
	                            .addComponent(product_namePL)
	                            .addComponent(stockPL)
	                            .addComponent(pricePL))
	                        .addGap(10, 10, 10)
	                        .addGroup(gl2.createParallelGroup(GroupLayout.Alignment.LEADING, false)
	                            .addComponent(id_tproductPTF, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
	                            .addComponent(product_namePTF, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
	                            .addComponent(stockPTF, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
	                            .addComponent(pricePTF, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
	                    .addGroup(gl2.createSequentialGroup()
		                        .addGap(14, 14, 14)
		                        .addComponent(jButtonInsertP, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
		                        .addGap(18, 18, 18)
		                        .addComponent(jButtonDeleteP, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
		                        .addGap(18, 18, 18)
		                        .addComponent(jButtonUpdateP, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(gl2.createSequentialGroup()
		                        .addGap(75, 75, 75)
		                        .addComponent(jButtonViewP, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
				                .addGap(18, 18, 18)
			                    .addComponent(jButtonIdP, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))        
		                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		        );
		
		gl2.setVerticalGroup(
				gl2.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(gl2.createSequentialGroup()
	                .addGap(70, 70, 70)
	                .addGroup(gl2.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(id_tproductPL, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(id_tproductPTF, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
	                .addGap(10, 10, 10)
	                .addGroup(gl2.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(product_namePL, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(product_namePTF, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
	                .addGap(10, 10, 10)
	                .addGroup(gl2.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(stockPL, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(stockPTF, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
	                .addGap(10, 10, 10)
	                .addGroup(gl2.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(pricePL, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(pricePTF, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
	                .addGap(60, 60, 60)
	                .addGroup(gl2.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jButtonInsertP, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jButtonDeleteP, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jButtonUpdateP, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
	                .addGap(20, 20, 20)
	                .addGroup(gl2.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                .addComponent(jButtonViewP, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                .addComponent(jButtonIdP, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
	                .addGap(60, 60, 60))
	        );
		
		
		GroupLayout gl3 = new GroupLayout(i3);
		i3.setLayout(gl3);
		gl3.setHorizontalGroup(  
				gl3.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(gl3.createSequentialGroup()
	                .addGroup(gl3.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(gl3.createSequentialGroup()
	                        .addContainerGap()
	                        .addGroup(gl3.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addComponent(id_torderOL)
	                            .addComponent(id_tclientOL)
	                            .addComponent(id_tproductOL)
	                            .addComponent(quantityOL))
	                        .addGap(10, 10, 10)
	                        .addGroup(gl3.createParallelGroup(GroupLayout.Alignment.LEADING, false)
	                            .addComponent(id_torderOTF, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
	                            .addComponent(id_tclientOTF, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
	                            .addComponent(id_tproductOTF, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
	                            .addComponent(quantityOTF, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
	                    .addGroup(gl3.createSequentialGroup()
	                        .addGap(14, 14, 14)
	                        .addComponent(jButtonInsertO, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addComponent(jButtonDeleteO, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addComponent(jButtonUpdateO, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(gl3.createSequentialGroup()
		                        .addGap(75, 75, 75)
		                        .addComponent(jButtonViewO, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
				                .addGap(18, 18, 18)
			                    .addComponent(jButtonIdO, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))        
		                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		        );
		
		gl3.setVerticalGroup(
				gl3.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(gl3.createSequentialGroup()
	                .addGap(40, 40, 40)
	                .addGroup(gl3.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(id_torderOL, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(id_torderOTF, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
	                .addGap(10, 10, 10)
	                .addGroup(gl3.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(id_tclientOL, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(id_tclientOTF, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
	                .addGap(10, 10, 10)
	                .addGroup(gl3.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(id_tproductOL, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(id_tproductOTF, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
	                .addGap(10, 10, 10)
	                .addGroup(gl3.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(quantityOL, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(quantityOTF, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
	                .addGap(50, 50, 50)
	                .addGroup(gl3.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jButtonInsertO, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jButtonDeleteO, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jButtonUpdateO, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
	                .addGap(20, 20, 20)
	                .addGroup(gl3.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                .addComponent(jButtonViewO, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                .addComponent(jButtonIdO, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
	                .addGap(60, 60, 60))
	        );
		
		
		GroupLayout gl4 = new GroupLayout(i4);
		i4.setLayout(gl4);
		gl4.setHorizontalGroup(  
				gl4.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(gl4.createSequentialGroup()
	                .addGroup(gl4.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(gl4.createSequentialGroup()
	                        .addContainerGap()
	                        .addGroup(gl4.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addComponent(id_tcountryCOL)
	                            .addComponent(countryCOL))
	                        .addGap(10, 10, 10)
	                        .addGroup(gl4.createParallelGroup(GroupLayout.Alignment.LEADING, false)
	                            .addComponent(id_tcountryCOTF, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
	                            .addComponent(countryCOTF, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
	                    .addGroup(gl4.createSequentialGroup()
	                        .addGap(14, 14, 14)
	                        .addComponent(jButtonInsertCO, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addComponent(jButtonDeleteCO, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addComponent(jButtonUpdateCO, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(gl4.createSequentialGroup()
		                        .addGap(75, 75, 75)
		                        .addComponent(jButtonViewCO, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
				                .addGap(18, 18, 18)
			                    .addComponent(jButtonIdCO, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))        
		                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		        );
		
		gl4.setVerticalGroup(
				gl4.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(gl4.createSequentialGroup()
	                .addGap(40, 40, 40)
	                .addGroup(gl4.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(id_tcountryCOL, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(id_tcountryCOTF, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
	                .addGap(10, 10, 10)
	                .addGroup(gl4.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(countryCOL, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(countryCOTF, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
	                .addGap(50, 50, 50)
	                .addGroup(gl4.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(jButtonInsertCO, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jButtonDeleteCO, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jButtonUpdateCO, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
	                .addGap(20, 20, 20)
	                .addGroup(gl4.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                .addComponent(jButtonViewCO, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
	                .addComponent(jButtonIdCO, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
	                .addGap(60, 60, 60))
	        );
		
		
		p1.add(i1);
		p2.add(i2);
		p3.add(i3);
		p4.add(i4);
		
		t1.add(infoTableC);
		t2.add(infoTableP);
		t3.add(infoTableO);
		t4.add(infoTableCO);
		
		p1.add(t1);
		p2.add(t2);
		p3.add(t3);
		p4.add(t4);
		
		tp= new JTabbedPane(); 
		tp.setSize(WIDTH,HEIGHT);
		tp.add("Clients", p1);
		tp.add("Products",p2);  
		tp.add("Orders",p3);  
		tp.add("Countries",p4);
		
		panel.add(tp);
	}
	/**
	 * Sets action listeners to the buttons
	 * @param a
	 */
	public void listener(ActionListener a) {
        jButtonDeleteC.addActionListener(a);
        jButtonDeleteCO.addActionListener(a);
        jButtonDeleteP.addActionListener(a);
        jButtonDeleteO.addActionListener(a);
        
        jButtonInsertC.addActionListener(a);
        jButtonInsertCO.addActionListener(a);
        jButtonInsertP.addActionListener(a);
        jButtonInsertO.addActionListener(a);
        
        jButtonUpdateC.addActionListener(a);
        jButtonUpdateCO.addActionListener(a);
        jButtonUpdateP.addActionListener(a);
        jButtonUpdateO.addActionListener(a);
        
        jButtonViewC.addActionListener(a);
        jButtonViewCO.addActionListener(a);
        jButtonViewP.addActionListener(a);
        jButtonViewO.addActionListener(a);
        
        jButtonIdC.addActionListener(a);
        jButtonIdCO.addActionListener(a);
        jButtonIdP.addActionListener(a);
        jButtonIdO.addActionListener(a);
        
        jButtonOrderC.addActionListener(a);
    }
	
	/**
	 * Provides a list of buttons. Utility
	 * @return list of buttons
	 */
	public JButton[] getButtons(){
	    JButton[] temp = new JButton[21];
	    temp[0] = jButtonDeleteC;
	    temp[1] = jButtonDeleteCO;
	    temp[2] = jButtonDeleteP;
	    temp[3] = jButtonDeleteO;
	    
	    temp[4] = jButtonInsertC;
	    temp[5] = jButtonInsertCO;
	    temp[6] = jButtonInsertP;
	    temp[7] = jButtonInsertO;
	    
	    temp[8] = jButtonUpdateC;
	    temp[9] = jButtonUpdateCO;
	    temp[10] = jButtonUpdateP;
	    temp[11] = jButtonUpdateO;
	    
	    temp[12] = jButtonViewC;
	    temp[13] = jButtonViewCO;
	    temp[14] = jButtonViewP;
	    temp[15] = jButtonViewO;
	    
	    temp[16] = jButtonIdC;
	    temp[17] = jButtonIdCO;
	    temp[18] = jButtonIdP;
	    temp[19] = jButtonIdO;
	    
	    temp[20] = jButtonOrderC;
	 
	    return temp;
	}
	
	/**
	 * Populates a JTable with the entries in the list parameter
	 * Uses reflection
	 * @param list
	 * @return JTable
	 */
	public JTable createTable(ArrayList<Object> list) {
		JTable infoTable;
		int collumns = list.get(0).getClass().getDeclaredFields().length; 		
		Object[][] entries = new Object[list.size()][collumns];
		String[] collumnNames = new String[collumns];
		for(int i = 0; i < collumns; i++) {
			collumnNames[i] = list.get(0).getClass().getDeclaredFields()[i].getName();			
		}
		
		for(int i = 0; i < list.size(); i++) {
			int j=0;
			for (Field field : list.get(i).getClass().getDeclaredFields()) {
				field.setAccessible(true); 
				Object value;
				try {
					value = field.get(list.get(i));
					entries[i][j] = value;

				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				j++;
			}
		}
		infoTable = new JTable(entries, collumnNames);
		
		return infoTable;
	}
	
	public JTextField getId_tcountryCOTF() {
		return id_tcountryCOTF;
	}
	public void setId_tcountryCOTF(JTextField id_tcountryCOTF) {
		this.id_tcountryCOTF = id_tcountryCOTF;
	}
	public JTextField getCountryCOTF() {
		return countryCOTF;
	}
	public void setCountryCOTF(JTextField countryCOTF) {
		this.countryCOTF = countryCOTF;
	}
	public JTextField getId_tproductPTF() {
		return id_tproductPTF;
	}
	public void setId_tproductPTF(JTextField id_tproductPTF) {
		this.id_tproductPTF = id_tproductPTF;
	}
	public JTextField getProduct_namePTF() {
		return product_namePTF;
	}
	public void setProduct_namePTF(JTextField product_namePTF) {
		this.product_namePTF = product_namePTF;
	}
	public JTextField getStockPTF() {
		return stockPTF;
	}
	public void setStockPTF(JTextField stockPTF) {
		this.stockPTF = stockPTF;
	}
	public JTextField getPricePTF() {
		return pricePTF;
	}
	public void setPricePTF(JTextField pricePTF) {
		this.pricePTF = pricePTF;
	}
	public JTextField getId_torderOTF() {
		return id_torderOTF;
	}
	public void setId_torderOTF(JTextField id_torderOTF) {
		this.id_torderOTF = id_torderOTF;
	}
	public JTextField getId_tclientOTF() {
		return id_tclientOTF;
	}
	public void setId_tclientOTF(JTextField id_tclientOTF) {
		this.id_tclientOTF = id_tclientOTF;
	}
	public JTextField getId_tproductOTF() {
		return id_tproductOTF;
	}
	public void setId_tproductOTF(JTextField id_tproductOTF) {
		this.id_tproductOTF = id_tproductOTF;
	}
	public JTextField getQuantityOTF() {
		return quantityOTF;
	}
	public void setQuantityOTF(JTextField quantityOTF) {
		this.quantityOTF = quantityOTF;
	}
	public JTextField getId_tclientCTF() {
		return id_tclientCTF;
	}
	public void setId_tclientCTF(JTextField id_tclientCTF) {
		this.id_tclientCTF = id_tclientCTF;
	}
	public JTextField getNameCTF() {
		return nameCTF;
	}
	public void setNameCTF(JTextField nameCTF) {
		this.nameCTF = nameCTF;
	}
	public JTextField getAddressCTF() {
		return addressCTF;
	}
	public void setAddressCTF(JTextField addressCTF) {
		this.addressCTF = addressCTF;
	}
	public JTextField getAgeCTF() {
		return ageCTF;
	}
	public void setAgeCTF(JTextField ageCTF) {
		this.ageCTF = ageCTF;
	}
	public JTextField getEmailCTF() {
		return emailCTF;
	}
	public void setEmailCTF(JTextField emailCTF) {
		this.emailCTF = emailCTF;
	}
	public JTextField getId_tcountryCTF() {
		return id_tcountryCTF;
	}
	public void setId_tcountryCTF(JTextField id_tcountryCTF) {
		this.id_tcountryCTF = id_tcountryCTF;
	}
	public JTable getInfoTableC() {
		return infoTableC;
	}
	public void setInfoTableC(JTable infoTableC) {
		this.infoTableC = infoTableC;
	}
	public JTable getInfoTableCO() {
		return infoTableCO;
	}
	public void setInfoTableCO(JTable infoTableCO) {
		this.infoTableCO = infoTableCO;
	}
	public JTable getInfoTableP() {
		return infoTableP;
	}
	public void setInfoTableP(JTable infoTableP) {
		this.infoTableP = infoTableP;
	}
	public JTable getInfoTableO() {
		return infoTableO;
	}
	public void setInfoTableO(JTable infoTableO) {
		this.infoTableO = infoTableO;
	}
	public JPanel getT1() {
		return t1;
	}
	public void setT1(JPanel t1) {
		this.t1 = t1;
	}
	public JPanel getT2() {
		return t2;
	}
	public void setT2(JPanel t2) {
		this.t2 = t2;
	}
	public JPanel getT3() {
		return t3;
	}
	public void setT3(JPanel t3) {
		this.t3 = t3;
	}
	public JPanel getT4() {
		return t4;
	}
	public void setT4(JPanel t4) {
		this.t4 = t4;
	}
	
}
