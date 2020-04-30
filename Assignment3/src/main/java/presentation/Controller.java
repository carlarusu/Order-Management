package presentation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.text.TabableView;

import bll.*;
import model.*;
import reflectionUtility.ReflectionExample;
/**
 * 
 * Controller of the MVC 
 * Provides the method to perform the actions mapped through the action listener to the buttons
 * Instantiates the application in the main method
 */
public class Controller {

	private View view;
	private JButton[] buttons;
	/**
	 * Constructor
	 * Initialises view and calls the listeners
	 * @param view
	 */
	public Controller(View view) {
		this.view = view;
		addListeners();
	}
	/**
	 * Method containing the listeners
	 * Each button performs a different action
	 */
	private void addListeners() {
			buttons = view.getButtons();
			view.listener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	String s = "";
		        	//delete buttons
		            if(e.getSource() == buttons[0]){
		            	try {
		            		if (!view.getId_tclientCTF().getText().matches("[0-9]*")) {
						    	s += "Id field must only contain positive numbers.";
								JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
						    }else {
		            			int id_tclient = Integer.parseInt(view.getId_tclientCTF().getText());
								   
				            	TClientBL tClientBL = new TClientBL();
				        		TClient c = null;
				        		int found = 1;
				        		try {
				        			c = tClientBL.findClientById(id_tclient);
				        		} catch (Exception ex) {
				        			found--;
				        		}
				        		if (found==1) {
				        			tClientBL.deleteClientById(id_tclient);
				        		}else {
				        			s += "Client not found.";
									JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
				        		}
		            		}
		            	} catch(Exception ex) {
							JOptionPane.showMessageDialog(view, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
						}
		            }else if(e.getSource() == buttons[1]){
		            	try {
		            		if (!view.getId_tcountryCOTF().getText().matches("[0-9]*")) {
						    	s += "Id field must only contain positive numbers.";
								JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
						    }else {
		            			int id_tcountry = Integer.parseInt(view.getId_tcountryCOTF().getText());
								   
		            			TCountryBL tCountryBL = new TCountryBL();
		            			TCountry c= null;	
				        		int found = 1;
				        		try {
				        			c = tCountryBL.findCountryById(id_tcountry);
				        		} catch (Exception ex) {
				        			found--;
				        		}
				        		if (found==1) {
				        			tCountryBL.deleteCountryById(id_tcountry);
				        		}else {
				        			s += "Client not found.";
									JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
				        		}
		            		}
		            	} catch(Exception ex) {
							JOptionPane.showMessageDialog(view, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
						}
		                
		            }else if(e.getSource() == buttons[2]){
		            	try {
		            		if (!view.getId_tproductPTF().getText().matches("[0-9]*")) {
						    	s += "Id field must only contain positive numbers.";
								JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
						    }else {
		            			int id_tproduct = Integer.parseInt(view.getId_tproductPTF().getText());
								   
		            			TProductBL tProductBL = new TProductBL();
		            			TProduct c = null;
				        		int found = 1;
				        		try {
				        			c = tProductBL.findProductById(id_tproduct);
				        		} catch (Exception ex) {
				        			found--;
				        		}
				        		if (found==1) {
				        			tProductBL.deleteProductById(id_tproduct);	
				        		}else {
				        			s += "Client not found.";
									JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
				        		}
		            		}
		            	} catch(Exception ex) {
							JOptionPane.showMessageDialog(view, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
						}
		                
		            }else if(e.getSource() == buttons[3]){
		            	try {
		            		if (!view.getId_torderOTF().getText().matches("[0-9]*")) {
						    	s += "Id field must only contain positive numbers.";
								JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
						    }else {
		            			int id_tcountry = Integer.parseInt(view.getId_torderOTF().getText());
								   
		            			TOrderBL tOrderBL = new TOrderBL();
		            			TOrder c= null;
				        		int found = 1;
				        		try {
				        			c = tOrderBL.findOrderById(id_tcountry);
				        		} catch (Exception ex) {
				        			found--;
				        		}
				        		if (found==1) {
				        			tOrderBL.deleteOrderById(id_tcountry);	
				        		}else {
				        			s += "Client not found.";
									JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
				        		}
		            		}
		            	} catch(Exception ex) {
							JOptionPane.showMessageDialog(view, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
						}
		                
		            }
		            //insert buttons
		            else if(e.getSource() == buttons[4]){
		            	try {
						    if (!view.getAgeCTF().getText().matches("[0-9]*") || !view.getId_tcountryCTF().getText().matches("[0-9]*")) {
						    	s += "Age field must only contain positive numbers.";
								JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
						    }else {
						    	String name = view.getNameCTF().getText();
								String address = view.getAddressCTF().getText();
							    String email = view.getEmailCTF().getText();
							    int age = Integer.parseInt(view.getAgeCTF().getText());
							    int id_tcountry = Integer.parseInt(view.getId_tcountryCTF().getText());
							    
							    TClientBL tClientBL = new TClientBL();
								TClient client = new TClient(name, address, email, age, id_tcountry);
								
								if (tClientBL.insertClient(client)<0) {
									s += "Client was not inserted";
									JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);
								}
						    }
						} catch(Exception ex) {
							JOptionPane.showMessageDialog(view, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
						}
		                
		            }else if(e.getSource() == buttons[5]){
		            	try {
						    String country_name = view.getCountryCOTF().getText();
							    
						    TCountryBL tCountryBL = new TCountryBL();
						    TCountry country= new TCountry(country_name);
								
							if (tCountryBL.insertCountry(country)<0) {
								s += "Country was not inserted";
								JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);
							}
						} catch(Exception ex) {
							JOptionPane.showMessageDialog(view, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
						}
		                
		            }else if(e.getSource() == buttons[6]){
		            	try {
						    if (!view.getStockPTF().getText().matches("[0-9]*") || !view.getPricePTF().getText().matches("[0-9]*")) {
						    	s += "Stock and price fields must only contain positive numbers.";
								JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
						    }else {
						    	String product_name = view.getProduct_namePTF().getText();
							    int stock = Integer.parseInt(view.getStockPTF().getText());
							    int price = Integer.parseInt(view.getPricePTF().getText());
							    
							    TProductBL tProductBL = new TProductBL();
								TProduct product = new TProduct(product_name, stock, price);
								
								if (tProductBL.insertProduct(product)<0) {
									s += "Product was not inserted";
									JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);
								}
						    }
						} catch(Exception ex) {
							JOptionPane.showMessageDialog(view, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
						}
		                
		            }else if(e.getSource() == buttons[7]){
		            	try {
						    if (!view.getId_tclientOTF().getText().matches("[0-9]*") || !view.getId_tproductOTF().getText().matches("[0-9]*") || !view.getQuantityOTF().getText().matches("[0-9]*")) {
						    	s += "Fields must only contain positive numbers.";
								JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
						    }else {
						    	int id_tclient = Integer.parseInt(view.getId_tclientOTF().getText());
							    int id_tproduct = Integer.parseInt(view.getId_tproductOTF().getText());
							    int quantity = Integer.parseInt(view.getQuantityOTF().getText());
							    
							    int found = 2;
							    TClientBL tClientBL = new TClientBL();
								TClient findClient = null;
								try {
									findClient = tClientBL.findClientById(id_tclient);
								} catch (Exception ex) {
									found--;
								}
								
								TProductBL tProductBLfind = new TProductBL();
								TProduct findProduct = null;
								try {
									findProduct = tProductBLfind.findProductById(id_tproduct);
								} catch (Exception ex) {
									found--;
								}
								
								if (found<2) {
									s += "Product or client inexistent.";
									JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
								}else {
								    
								    TOrderBL tOrderBL = new TOrderBL();
									TOrder order= new TOrder(id_tclient,id_tproduct,quantity);
									
									//check if in stock
									int ok=1;
									TProductBL tProductBL2 = new TProductBL();
									List<TProduct> products2 = tProductBL2.findAllProducts();
									for(TProduct p: products2) {
										if (ReflectionExample.checkStock(p, quantity, id_tproduct)==2) {
											s += "Understock.";
											JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
											ok=0;
										}
									}
									if(ok==1) {
										if (tOrderBL.insertOrder(order)<0) {
											s += "Order was not inserted";
											JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);
										} else {
											TProductBL tProductBL3 = new TProductBL();
											List<TProduct> products3 = tProductBL3.findAllProducts();
											for(TProduct p: products3) {
												int res = ReflectionExample.updateStock(p, quantity, id_tproduct);
												if(res!=-1) {
													TProductBL tProductBL = new TProductBL();
													TProduct product = new TProduct(id_tproduct,p.getProduct_name(), res, p.getPrice());
													
													tProductBL.updateProduct(product);
												}
											}
										}
									}
							    }
						    }
						} catch(Exception ex) {
							JOptionPane.showMessageDialog(view, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
						}
		                
		            }
		            //update buttons
		            else if(e.getSource() == buttons[8]){
		            	try {
		            		if (!view.getId_tclientCTF().getText().matches("[0-9]*")) {
						    	s += "Id field must only contain positive numbers.";
								JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
						    }else {
		            			int id_tclient = Integer.parseInt(view.getId_tclientCTF().getText());
		            			String name = view.getNameCTF().getText();
								String address = view.getAddressCTF().getText();
							    String email = view.getEmailCTF().getText();
							    int age = Integer.parseInt(view.getAgeCTF().getText());
							    int id_tcountry = Integer.parseInt(view.getId_tcountryCTF().getText());
							    
		            			
				            	TClientBL tClientBL = new TClientBL();
				        		TClient c = null;
				        		int found = 1;
				        		try {
				        			c = tClientBL.findClientById(id_tclient);
				        		} catch (Exception ex) {
				        			found--;
				        		}
				        		if (found==1) {
				        			TClient student2 = new TClient(id_tclient,name, address, email, age, id_tcountry);
				        			tClientBL.updateClient(student2);
				        		}else {
				        			s += "Client not found.";
									JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
				        		}
		            		}
		            	} catch(Exception ex) {
							JOptionPane.showMessageDialog(view, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
						}
		                
		            }else if(e.getSource() == buttons[9]){
		            	try {
		            		if (!view.getId_tcountryCOTF().getText().matches("[0-9]*")) {
						    	s += "Id field must only contain positive numbers.";
								JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
						    }else {
		            			int id_tcountry = Integer.parseInt(view.getId_tcountryCOTF().getText());
		            			String country_name = view.getCountryCOTF().getText();
							    
							    TCountryBL tCountryBL = new TCountryBL();
							    TCountry c= null;
				        		int found = 1;
				        		try {
				        			c = tCountryBL.findCountryById(id_tcountry);
				        		} catch (Exception ex) {
				        			found--;
				        		}
				        		if (found==1) {
								    TCountry country= new TCountry(id_tcountry,country_name);
								    tCountryBL.updateCountry(country);
				        		}else {
				        			s += "Country not found.";
									JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
				        		}
		            		}
		            	} catch(Exception ex) {
							JOptionPane.showMessageDialog(view, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
						}
		                
		            }else if(e.getSource() == buttons[10]){
		            	try {
		            		if (!view.getId_tproductPTF().getText().matches("[0-9]*")) {
						    	s += "Id field must only contain positive numbers.";
								JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
						    }else {
		            			int id_tproduct = Integer.parseInt(view.getId_tproductPTF().getText());
		            			String product_name = view.getProduct_namePTF().getText();
							    int stock = Integer.parseInt(view.getStockPTF().getText());
							    int price = Integer.parseInt(view.getPricePTF().getText());
		            			
							    TProductBL tProductBL = new TProductBL();
							    TProduct c= null;
				        		int found = 1;
				        		try {
				        			c = tProductBL.findProductById(id_tproduct);
				        		} catch (Exception ex) {
				        			found--;
				        		}
				        		if (found==1) {
								    TProduct product= new TProduct(id_tproduct,product_name,stock,price);
								    tProductBL.updateProduct(product);
				        		}else {
				        			s += "Product not found.";
									JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
				        		}
		            		}
		            	} catch(Exception ex) {
							JOptionPane.showMessageDialog(view, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
						}
		                
		            }else if(e.getSource() == buttons[11]){
		            	try {
		            		if (!view.getId_torderOTF().getText().matches("[0-9]*")) {
						    	s += "Id field must only contain positive numbers.";
								JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
						    }else {
		            			int id_torder = Integer.parseInt(view.getId_torderOTF().getText());
		            			int id_tclient = Integer.parseInt(view.getId_tclientOTF().getText());
							    int id_tproduct = Integer.parseInt(view.getId_tproductOTF().getText());
							    int quantity = Integer.parseInt(view.getQuantityOTF().getText());
							    
							    TOrderBL tOrderBL = new TOrderBL();
							    TOrder c= null;
				        		int found = 1;
				        		try {
				        			c = tOrderBL.findOrderById(id_torder);
				        		} catch (Exception ex) {
				        			found--;
				        		}
				        		if (found==1) {
								    TOrder country= new TOrder(id_torder,id_tclient,id_tproduct,quantity);
								    tOrderBL.updateOrder(country);
				        		}else {
				        			s += "Product not found.";
									JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
				        		}
		            		}
		            	} catch(Exception ex) {
							JOptionPane.showMessageDialog(view, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
						}
		                
		            }
		            //view buttons
		            else if(e.getSource() == buttons[12]){
		            	try {
		            		JPanel t1 = view.getT1();
		            		TClientBL tClientBL = new TClientBL();
		            		List<TClient> clients = tClientBL.findAllClients();
		            		ArrayList<Object> obj = new ArrayList<Object>();
		            		for(TClient c : clients) {
		            			obj.add(c);
		            		}
		            		JTable infoTable1 = view.createTable(obj);
		            		/*for(int j=0; j<infoTable1.getColumnCount();j++) {
		            			System.out.print(infoTable1.getColumnName(j)+"		");
		            		}
		            		System.out.println();
		            		for (int i = 0; i<infoTable1.getRowCount();i++) {
		            			for(int j=0; j<infoTable1.getColumnCount();j++) {
		            				System.out.print(infoTable1.getModel().getValueAt(i, j)+"		");
		            			}
		            			System.out.println();
		            		}*/
		            		infoTable1.setFont(new java.awt.Font("Calibri Light", 1, 18));
		                    infoTable1.setForeground(new java.awt.Color(42, 42, 207));		
		                    infoTable1.setGridColor(new java.awt.Color(102, 102, 255));
		                    infoTable1.setSelectionBackground(new java.awt.Color(153, 102, 255));
		                    TableColumn column = null;
		                    for (int i = 0; i < infoTable1.getColumnCount(); i++) {
		                        column = infoTable1.getColumnModel().getColumn(i);
		                        if (i == 0 || i == 4 || i == 5) {
		                            column.setPreferredWidth(5); 
		                        } else {
		                            column.setPreferredWidth(80);
		                        }
		                    }    
		            		t1.setLayout(new BorderLayout());
		            		t1.setPreferredSize(new Dimension(900, 520));
		            		t1.add(infoTable1.getTableHeader(),BorderLayout.PAGE_START);
		            		t1.add(infoTable1, BorderLayout.CENTER);
		            		view.setT1(t1);
		            		view.revalidate();
		            	} catch(Exception ex) {
							JOptionPane.showMessageDialog(view, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
						}
		                
		            }else if(e.getSource() == buttons[13]){
		            	try {
		            		JPanel t2 = view.getT4();
		            		TCountryBL tCountryBL = new TCountryBL();
		            		List<TCountry> clients = tCountryBL.findAllCountries();
		            		ArrayList<Object> obj = new ArrayList<Object>();
		            		for(TCountry c : clients) {
		            			obj.add(c);
		            		}
		            		JTable infoTable1 = view.createTable(obj);
		            		infoTable1.setFont(new java.awt.Font("Calibri Light", 1, 18));
		                    infoTable1.setForeground(new java.awt.Color(42, 42, 207));		
		                    infoTable1.setGridColor(new java.awt.Color(102, 102, 255));
		                    infoTable1.setSelectionBackground(new java.awt.Color(153, 102, 255));
		            		t2.setLayout(new BorderLayout());
		            		t2.setPreferredSize(new Dimension(900, 520));
		            		t2.add(infoTable1.getTableHeader(),BorderLayout.PAGE_START);
		            		t2.add(infoTable1, BorderLayout.CENTER);
		            		view.setT4(t2);
		            		view.revalidate();
		            	} catch(Exception ex) {
							JOptionPane.showMessageDialog(view, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
						}
		                
		            }else if(e.getSource() == buttons[14]){
		            	try {
		            		JPanel t1 = view.getT2();
		            		TProductBL tProductBL = new TProductBL();
		            		List<TProduct> clients = tProductBL.findAllProducts();
		            		ArrayList<Object> obj = new ArrayList<Object>();
		            		for(TProduct c : clients) {
		            			obj.add(c);
		            		}
		            		JTable infoTable1 = view.createTable(obj);
		            		infoTable1.setFont(new java.awt.Font("Calibri Light", 1, 18));
		                    infoTable1.setForeground(new java.awt.Color(42, 42, 207));		
		                    infoTable1.setGridColor(new java.awt.Color(102, 102, 255));
		                    infoTable1.setSelectionBackground(new java.awt.Color(153, 102, 255));
		            		t1.setLayout(new BorderLayout());
		            		t1.setPreferredSize(new Dimension(900, 520));
		            		t1.add(infoTable1.getTableHeader(),BorderLayout.PAGE_START);
		            		t1.add(infoTable1, BorderLayout.CENTER);
		            		view.setT2(t1);
		            		view.revalidate();
		            	} catch(Exception ex) {
							JOptionPane.showMessageDialog(view, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
						}
		                
		            }else if(e.getSource() == buttons[15]){
		            	try {
		            		JPanel t1 = view.getT3();
		            		TOrderBL tClientBL = new TOrderBL();
		            		List<TOrder> clients = tClientBL.findAllOrders();
		            		ArrayList<Object> obj = new ArrayList<Object>();
		            		for(TOrder c : clients) {
		            			obj.add(c);
		            		}
		            		JTable infoTable1 = view.createTable(obj);
		            		infoTable1.setFont(new java.awt.Font("Calibri Light", 1, 18));
		                    infoTable1.setForeground(new java.awt.Color(42, 42, 207));		
		                    infoTable1.setGridColor(new java.awt.Color(102, 102, 255));
		                    infoTable1.setSelectionBackground(new java.awt.Color(153, 102, 255));
		            		t1.setLayout(new BorderLayout());
		            		t1.setPreferredSize(new Dimension(900, 520));
		            		t1.add(infoTable1.getTableHeader(),BorderLayout.PAGE_START);
		            		t1.add(infoTable1, BorderLayout.CENTER);
		            		view.setT3(t1);
		            		view.revalidate();
		            	} catch(Exception ex) {
							JOptionPane.showMessageDialog(view, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
						}
		                
		                
		            }
		            //id buttons
		            else if(e.getSource() == buttons[16]){
		            	try {
		            		if (!view.getId_tclientCTF().getText().matches("[0-9]*")) {
						    	s += "Id field must only contain positive numbers.";
								JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
						    }else {
		            			int id_tclient = Integer.parseInt(view.getId_tclientCTF().getText());
								   
				            	TClientBL tClientBL = new TClientBL();
				        		TClient c = null;
				        		int found = 1;
				        		try {
				        			c = tClientBL.findClientById(id_tclient);
				        		} catch (Exception ex) {
				        			found--;
				        		}
				        		if (found==1) {
				        			JOptionPane.showMessageDialog(view,ReflectionExample.retrieveProperties(c) , "Result", JOptionPane.PLAIN_MESSAGE);		
				        		}else {
				        			s += "Client not found.";
									JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
				        		}
		            		}
		            	} catch(Exception ex) {
							JOptionPane.showMessageDialog(view, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
						}
		                
		            }else if(e.getSource() == buttons[17]){
		            	try {
		            		if (!view.getId_tcountryCOTF().getText().matches("[0-9]*")) {
						    	s += "Id field must only contain positive numbers.";
								JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
						    }else {
		            			int id_tcountry = Integer.parseInt(view.getId_tcountryCOTF().getText());
								   
		            			TCountryBL tCountryBL = new TCountryBL();
		            			TCountry c= null;	
				        		int found = 1;
				        		try {
				        			c = tCountryBL.findCountryById(id_tcountry);
				        		} catch (Exception ex) {
				        			found--;
				        		}
				        		if (found==1) {
				        			JOptionPane.showMessageDialog(view,ReflectionExample.retrieveProperties(c) , "Result", JOptionPane.PLAIN_MESSAGE);		
				        		}else {
				        			s += "Client not found.";
									JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
				        		}
		            		}
		            	} catch(Exception ex) {
							JOptionPane.showMessageDialog(view, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
						}
		                
		            }else if(e.getSource() == buttons[18]){
		            	try {
		            		if (!view.getId_tproductPTF().getText().matches("[0-9]*")) {
						    	s += "Id field must only contain positive numbers.";
								JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
						    }else {
		            			int id_tproduct = Integer.parseInt(view.getId_tproductPTF().getText());
								   
		            			TProductBL tProductBL = new TProductBL();
		            			TProduct c = null;
				        		int found = 1;
				        		try {
				        			c = tProductBL.findProductById(id_tproduct);
				        		} catch (Exception ex) {
				        			found--;
				        		}
				        		if (found==1) {
				        			JOptionPane.showMessageDialog(view,ReflectionExample.retrieveProperties(c) , "Result", JOptionPane.PLAIN_MESSAGE);		
				        		}else {
				        			s += "Client not found.";
									JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
				        		}
		            		}
		            	} catch(Exception ex) {
							JOptionPane.showMessageDialog(view, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
						}
		                
		            }else if(e.getSource() == buttons[19]){
		            	try {
		            		if (!view.getId_torderOTF().getText().matches("[0-9]*")) {
						    	s += "Id field must only contain positive numbers.";
								JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
						    }else {
		            			int id_tcountry = Integer.parseInt(view.getId_torderOTF().getText());
								   
		            			TOrderBL tOrderBL = new TOrderBL();
		            			TOrder c= null;
				        		int found = 1;
				        		try {
				        			c = tOrderBL.findOrderById(id_tcountry);
				        		} catch (Exception ex) {
				        			found--;
				        		}
				        		if (found==1) {
				        			JOptionPane.showMessageDialog(view,ReflectionExample.retrieveProperties(c) , "Result", JOptionPane.PLAIN_MESSAGE);		
				        		}else {
				        			s += "Client not found.";
									JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
				        		}
		            		}
		            	} catch(Exception ex) {
							JOptionPane.showMessageDialog(view, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
						}
		            }else if(e.getSource() == buttons[20]){
		            	try {
		            		if (!view.getId_tclientCTF().getText().matches("[0-9]*")) {
						    	s += "Id field must only contain positive numbers.";
								JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
						    }else {
		            			int id_tclient = Integer.parseInt(view.getId_tclientCTF().getText());
								   
				            	TClientBL tClientBL = new TClientBL();
				        		TClient c = null;
				        		int found = 1;
				        		try {
				        			c = tClientBL.findClientById(id_tclient);
				        		} catch (Exception ex) {
				        			found--;
				        		}
				        		if (found==1) {
				        			String filename = "order_of_client_" + Integer.toString(id_tclient) + ".txt";
				        			PrintWriter writer = null;
				        			try {
				        				writer = new PrintWriter(filename, "UTF-8");
				        				writer.println("client_information: ");
				        				writer.print(ReflectionExample.retrieveProperties(c));
				        				TCountryBL tCountryBL = new TCountryBL();
				            			TCountry co= null;	
						        		try {
						        			co = tCountryBL.findCountryById(c.getId_tcountry());
						        		} catch (Exception ex) {}
						        		writer.println("country_of_destination: "+co.getCountry());
						        		writer.println();

				        				writer.println("list_of_products: ");
				        				
				        				TOrderBL tOrderBL = new TOrderBL();
					            		List<TOrder> orders = tOrderBL.findAllOrders();
					            		ArrayList<Object> objOrd = new ArrayList<Object>();
					            		for(TOrder o : orders) {
					            			objOrd.add(o);
					            		}
					            		JTable infoTableO = view.createTable(objOrd);
					            		
					            		TProductBL tProductBL = new TProductBL();
					            		List<TProduct> products = tProductBL.findAllProducts();
					            		ArrayList<Object> objProd = new ArrayList<Object>();
					            		for(TProduct p : products) {
					            			objProd.add(p);
					            		}
					            		JTable infoTableP = view.createTable(objProd);
					            		
					            		int sum = 0;
					            		int totalSum = 0;
					            		for(int i=0; i<infoTableO.getRowCount();i++) {
					            			if ((Integer)infoTableO.getModel().getValueAt(i, 1)==id_tclient) {
					            				int row = (Integer)infoTableO.getModel().getValueAt(i, 2);
					            				int quantity = (Integer)infoTableO.getModel().getValueAt(i, 3);
					            				for(int j=0; j<infoTableP.getRowCount();j++) {
					            					if ((Integer)infoTableP.getModel().getValueAt(j, 0)==row) {
					            						String product_name = (String) infoTableP.getModel().getValueAt(j, 1);
							            				int price = (Integer)infoTableP.getModel().getValueAt(j, 3);
							            				
							            				sum=price*quantity;
							            				totalSum+=sum;
							            				writer.println(product_name+",	 amount: "+quantity+", 	price_per_unit: "+price+",	 total_price: "+sum);
					            					}
					            				}					            				
					            			}
					            		}
					            		writer.println("total_amount_to_pay: "+totalSum);
				        			} catch (Exception ex) {
				        				System.out.println(ex.getMessage());
				        			} finally {
				        				writer.close();
				        			}		
				        		}else {
				        			s += "Client not found.";
									JOptionPane.showMessageDialog(view, s, "Error", JOptionPane.ERROR_MESSAGE);		
				        		}
		            		}
		            	} catch(Exception ex) {
							JOptionPane.showMessageDialog(view, ex.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
						}
		            }
		        }
		    });
	}
	
	/**
	 * Main method
	 * Starts the app
	 * @param args
	 */
	 public static void main(String[] args) {
	       View view = new View();
	        Controller controller = new Controller(view);
	        view.setVisible(true);
	    }
}
