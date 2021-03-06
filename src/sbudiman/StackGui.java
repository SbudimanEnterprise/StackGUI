package sbudiman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *  By Torrisi Corp.. v2
 */

public class StackGui 
{
	TextField tf[]; // non uso label perch� con .awt non si pu� metter il bordo alle label
	boolean controllo = false;
	int top = -1;
	boolean controllo2 = false;
	String Vstring;
	String[] parti;
	TextField txtValue = new TextField();
	TextField txtStack = new TextField();
	int a = 0;
	int k = 0;
	int coda[];
	int queue = -1;
	
	public StackGui()  
	{
		JFrame frame;
		
		JOptionPane.showMessageDialog(null, "COMANDI \n push + numero che esegue il push \n pop che estrae l'elemento. \n ESEMPIO \n push22, push45, pop ,push1 ,pop,inverti");
		
		//dichiarazione ed inizializzazione dei componenti
		frame = new JFrame("Torri'Stack By Torrisi Corp., Sbudiman Enterprise & GenOS.");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Onorevole Torrisi\\Desktop\\programmi fatti da me\\logo.png"));
		frame.setBounds(100, 100, 650, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);//SETTO il layout ablosutelayout per spostare i panel a piacimento
		
		Panel panel = new Panel(null);
		panel.setForeground(Color.MAGENTA);
		panel.setBackground(new Color(138, 43, 226));
		panel.setBounds(0, 0, 265, 311);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
	
		Panel panel2 = new Panel(null);
		panel2.setForeground(Color.WHITE);
		panel2.setFont(new Font("Source Code Pro Black", Font.PLAIN, 13));
		panel2.setBackground(Color.WHITE);
		panel2.setBounds(263, 0, 381, 311);
		frame.getContentPane().add(panel2);
		
		Label lbInfo = new Label("l' azzurro indica il top");
		lbInfo.setFont(new Font("Ink Free", Font.BOLD, 14));
		lbInfo.setForeground(new Color(138, 43, 226));
		lbInfo.setBackground(Color.WHITE);
		lbInfo.setAlignment(Label.CENTER);
		lbInfo.setSize(245, 27);
		lbInfo.setLocation(60, 135);
		panel2.add(lbInfo);
		
		Label label = new Label("max stack 10 ");
		label.setForeground(new Color(138, 43, 226));
		label.setBackground(new Color(255, 255, 255));
		label.setFont(new Font("Ink Free", Font.BOLD, 14));
		label.setAlignment(Label.CENTER);
		label.setBounds(124, 10, 131, 27);
		panel2.add(label);
		
		
		txtStack.setForeground(Color.WHITE);
		txtStack.setBackground(new Color(138, 43, 226));
		txtStack.setFont(new Font("Ink Free", Font.BOLD, 14));
		txtStack.setText("inserisci il numero degli elementi");
		txtStack.setBounds(60, 43, 245, 27);
		panel2.add(txtStack);
		
		Button bCrea = new Button("Crea lo stack");
		bCrea.setForeground(Color.WHITE);
		bCrea.setBackground(new Color(138, 43, 226));
		bCrea.setFont(new Font("Ink Free", Font.BOLD, 14));
		bCrea.setBounds(124, 90, 131, 27);
		panel2.add(bCrea);
		
		txtValue = new TextField();
		txtValue.setForeground(Color.WHITE);
		txtValue.setBackground(new Color(138, 43, 226));
		txtValue.setFont(new Font("Ink Free", Font.BOLD, 14));
		txtValue.setText("inserisci i comandi");
		txtValue.setBounds(60, 180, 245, 27);
		panel2.add(txtValue);
		
		Button bAdd = new Button("Esegui");
		bAdd.setForeground(Color.WHITE);
		bAdd.setBackground(new Color(138, 43, 226));
		bAdd.setFont(new Font("Ink Free", Font.BOLD, 14));
		bAdd.setBounds(60, 228, 245, 27);
		panel2.add(bAdd);
		
		Button bGuida = new Button("GUIDA");
		bGuida.setForeground(Color.WHITE);
		bGuida.setBackground(new Color(138, 43, 226));
		bGuida.setFont(new Font("Ink Free", Font.BOLD, 14));
		bGuida.setBounds(280, 273, 91, 27);
		panel2.add(bGuida);
		
		txtStack.addMouseListener(new MouseListener() //listener del mouse
		{
			
			public void mousePressed(MouseEvent e) 
			{
				txtStack.setText(null);
				lbInfo.setVisible(false);
				label.setVisible(false);
			}

			public void mouseClicked(MouseEvent e)
			{
				txtStack.setText(null);
				lbInfo.setVisible(false);
				label.setVisible(false);
			}

			public void mouseEntered(MouseEvent e){}

			public void mouseExited(MouseEvent e){}

			public void mouseReleased(MouseEvent e){}

		});
		
		txtValue.addMouseListener(new MouseListener()
		{
			int i;
			
			public void mousePressed(MouseEvent e) 
			{
				txtValue.setText(null);
				
				if(controllo)
				{
					for(i = 0; i < tf.length; i++)
					{
						tf[i].setBackground(Color.WHITE);
					}
					
					if(top >= 0)
						tf[top].setBackground(Color.CYAN);
				}
				
			}

			public void mouseClicked(MouseEvent e)
			{
				txtValue.setText(null);
				
				if(controllo)
				{
					for(i = 0; i < tf.length; i++)
					{
						tf[i].setBackground(Color.WHITE);
					}
					
					if(top >= 0)
						tf[top].setBackground(Color.CYAN);
				}
				
			}

			public void mouseEntered(MouseEvent e){}

			public void mouseExited(MouseEvent e){}

			public void mouseReleased(MouseEvent e){}
		});
		
		//listener
		bCrea.addActionListener(new ActionListener()
		{
			int a;
			//controllori
			boolean flag;
			boolean flag2;
			int w = 70; //width
			int h = 55; //heigth
			int alt = 248;
			
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("[DEBUG] hai cliccato crea");

				if(flag2)
				{
					for(int i = 0; i < tf.length; i++)
					{
						tf[i].setVisible(false);
					}
					
					w = 70;
					h = 55;
					top = -1;

				}
				
				//provo l input
				try
				{
					a = Integer.parseInt(txtStack.getText());
					flag = false;
				} catch (Exception e2) 
				{
					txtStack.setText("Inserire solo valori interi");
					flag = true;
				}
				
				//se va bene entro nell if
				if(flag == false)
				{
					int b = 55;
					
					//verifico che sia entro i 10 elementi
					if(a > 10)
						txtStack.setText("Massimo 10 elementi"); //10 per una questione di spazio
					else
					{
						tf = new TextField[a];
						int y = 10; //setto una costante
						
						if(a > 5 && a <= 8)
						{
							w = 60;
							h = 35;
							y = 0;
							b = 35;
							alt = 250;
						}
						else if(a > 8)
						{
							w = 60;
							h = 35;
							y = -10;
							b = 30;
							alt = 263;
						}
						
						for(int i = 0; i < tf.length; i++)
						{
							try
							{
								Thread.sleep(100);
							} catch (InterruptedException e1) 
							{
								e1.printStackTrace();
							}
							
							
							tf[i] = new TextField();
							/**
							 * per la posizione ho fatto dei test e parto da 245 
							 * e ogni nuovo txtfield sottraggo la y che va sempre ad aumentare di 55
							 * 
							 */
							tf[i].setFont(new Font("Ink Free", Font.BOLD, 14));
							tf[i].setForeground(new Color(138, 43, 226));
							tf[i].setBounds(100, alt-y, w, h);
							tf[i].setEditable(false);
							panel.add(tf[i]);
							
							y+= b;
						}
						
						controllo = true;	
						flag2 = true;

					}
				}
			}
		});

		
		bAdd.addActionListener(new ActionListener() 
		{
		
			boolean fix = false; 
			String supporto;
			
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("[DEBUG] hai cliccato esegui");
				
				if(!txtStack.getText().equals("inserisci il numero degli elementi"))
				{

					if(txtValue.getText().contains("push") || txtValue.getText().contains("pop") ||txtValue.getText().contains("inverti"))
					{
						if(txtValue.getText().contains(","))
						{
							Vstring = txtValue.getText(); //vstring assume il valore del campo testo
							parti = Vstring.split(","); //array di stringhe separate dalla virgola
							
							for(int i = 0; i < parti.length; i++) //separazione di ogni segmento di stringa
							{
								if(parti[i].contains("push"))
								{
									supporto = parti[i].trim();
									Vstring = supporto.substring(4);
									System.out.println("[DEBUG] substring: " + Vstring);
									addValueStack(Vstring);
									controllo2 = true;
								}
								else if(parti[i].contains("inverti"))
								{
									System.out.println("[DEBUG] eseguo l'inversione");
									supporto = parti[i].trim();
									Vstring = supporto.substring(7);
									if(controllo == true && controllo2 == true)
									{
										coda = new int[k];
										do 
										{
											addValueCoda();
										} while (top != -1 );
										
										do 
										{
											addValueStack(String.valueOf(addScodaCoda()));
										} while (queue != -1);
									}
									else
									{
										
									}
								}
								else if(parti[i].contains("pop"))
								{
									supporto = parti[i].trim();
									
									if(k == 0)
									{
										for(i = 0; i < tf.length; i++)
										{
											tf[i].setText(null);
											tf[i].setBackground(Color.RED);
										}
										
										txtValue.setText("Non puoi estrarre senza inserimenti");
									}
									else	
									{
										if(supporto.equals("pop"))
										{
											controllo2 = true;
											addPopStack();
										}
											
										
									}
										
								}
								else
								{
									txtValue.setText("Comando errato. Visiona la guida");
								}
								
								
							}

							if(top > tf.length && fix == false)
							{
								for(int i = 0; i < tf.length; i++)
								{
									tf[i].setBackground(Color.RED);
	
								}

								try 
								{
									Thread.sleep(1000);
								} catch (InterruptedException e) 
								{
									e.printStackTrace();
								}
								
								for(int i = 0; i < tf.length; i++)
								{
									tf[i].setBackground(Color.WHITE);
	
								}
								
								fix = true;
								txtValue.setText("Stack pieno");
							}
							
						}
						else
						{
							if(txtValue.getText().equalsIgnoreCase("inverti"))
							{	
								if(k == 0)
								{
									for(int i = 0; i < tf.length; i++)
									{
										tf[i].setText(null);
										tf[i].setBackground(Color.RED);
									}
									txtValue.setText("Non puoi invertire");
								}
								else
								{
									System.out.println("[DEBUG] hai cliccato inverti");
									
									if(controllo == true && controllo2 == true)
									{
										coda = new int[k];
										do 
										{
											addValueCoda();
										} while (top != -1 );
										
										do 
										{
											addValueStack(String.valueOf(addScodaCoda()));
										} while (queue != -1);
										
										
									}
								}
							}
								
							else if(txtValue.getText().contains("push"))
							{
								Vstring = txtValue.getText().substring(4);
								System.out.println("[DEBUG] substring: " + Vstring);
								
								addValueStack(Vstring);
							}
							else if(txtValue.getText().equals("pop"))
							{	
								if(k == 0)
								{
									for(int i = 0; i < tf.length; i++)
									{
										tf[i].setText(null);
										tf[i].setBackground(Color.RED);
									}
									txtValue.setText("Non puoi estrarre");
								}
								else
								{
									addPopStack();
								}									
							}
							else
							{
								txtValue.setText("Comando errato. Visiona la guida");
							}
							
						}

						if(top != -1)
							tf[top].setBackground(Color.CYAN);
						
						
					}
					else
					{
						txtValue.setText("VISIONA LA GUIDA");
					}
				}
		
			}
				
		});
		
		
		bGuida.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("[DEBUG] hai cliccato la guida");
				JOptionPane.showMessageDialog(null, "COMANDI \n push + numero che esegue il push \n pop che estrae l'elemento \n ESEMPIO \n push22, push45, pop ,push1 ,pop, inverti");
			}
		});

	}
	
	public void addValueStack(String parti)
	{
		boolean check;
		
		System.out.println("[DEBUG] eseguo push");
		
		if(controllo)
		{
			System.out.println("[DEBUG] numero parti: " + parti);
			
			try //per vedere se la parte di stringa contiene solo int
			{
				a = Integer.parseInt(parti);
				check = true;
			} catch (Exception e) 
			{
		
				txtValue.setText("Comando errato. Visiona la guida"); //o non si inseriscono numeri o dopo i numeri sono presenti caratteri es. push22jdabwaj o push
				check = false;
			}
			
			if(check)
			{
				/**ho semplicemente trasferito cio che ho scritto sul quad qui 
				 * e al posto di int v[] c � textField tf[]
				 * stessa cosa ho fatto per sottrai
				 */
				k++;
				
				if(top == tf.length -1)
				{
					txtValue.setText("Stack pieno");
				}
				else
				{
					try //per creare una sorta di animazione
					{
						Thread.sleep(500);
					} catch (InterruptedException e) 
					{
						
						e.printStackTrace();
					}
					
					if(top >= 0)
						tf[top].setBackground(Color.white);
					
					System.out.println("[DEBUG] top: "+top);
					top++;
					System.out.println("[DEBUG] top: "+top);
					tf[top].setText(String.valueOf(parti));
					System.out.println("[DEBUG] la parte dell'intera stringa: " + a);
					tf[top].setBackground(Color.CYAN);	
					
					
					controllo2 = true;
				}
			}
		}
	}
	
	public int addPopStack()
	{
		int b;

		System.out.println("[DEBUG] eseguo pop");
	
		
		
		if(top != -1)
		{
			k--;
			
			try 
			{
				Thread.sleep(500);
			} catch (InterruptedException e)
			{
				
				e.printStackTrace();
			}
			
			b = Integer.parseInt(tf[top].getText());
			tf[top].setText(null);
			tf[top].setBackground(Color.white);
			top--;
			if(top >= 0)
				tf[top].setBackground(Color.CYAN);
			
			return b;
				
		}
		else
		{
			for(int i = 0; i < tf.length; i++)
			{
				tf[i].setText(null);
				tf[i].setBackground(Color.RED);
			}
			
			txtValue.setText("Non puoi estrarre");
			
			b = (Integer)null;
			return b;
		}
		
			
	}
	
	public void addValueCoda()
	{
		int b = addPopStack();
		
		if(queue != tf.length - 1)
		{
			queue++;
			System.out.println("[DEBUG] queue: " + queue);
			coda[queue] = b;
			System.out.println("[DEBUG] ordine: " + coda[queue]);
		}
		else
		{
			System.out.println("[DEBUG] la coda � piena");
		}
		
	}
	
	public int addScodaCoda()
	{
		int b;
		int j = queue;
		System.out.println("[DEBUG] queue = " + queue);
		
		if(queue != - 1)
		{
			b = coda[0];
			
			for(int i = 1; i <= j ; i++)
			{
				coda[i - 1] = coda[i];
				System.out.println("[DEBUG] coda[" + i +"] = " + coda[i]);
			}
			
			queue--;

			return b;
		}
		else
		{
			System.out.println("[DEBUG] la coda � vuota ");
			return 0;
		}
	}
	
}