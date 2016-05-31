package wet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Birdmane extends JFrame{
	private String nuudle;
	private Birdmanedraw bird;
	private Maney maner;
	private JPanel panel;
	private JLabel statusbar;
	
	private JButton readtext;
	private JButton opentext;
	private JButton getshapes;
	private JCheckBox rect;
	private JCheckBox oval;
	private JCheckBox text;
	private JTextField textfield1;
	private JTextField textfield2;
	private JTextField textfield3;
	private JTextField textfield4;
	private JTextField textfield5;
	private JTextField textfield6;
	private JTextField textfield7;
	private JRadioButton pf;
	private JRadioButton bf;
	private JRadioButton itf;
	private JRadioButton bif;
	

	private int counter=0;
	private ButtonGroup group;
	//private static String[] photoname= {"tom.png", "han.jpg"};
	private  Color[] color= {Color.black, Color.blue, Color.red, Color.DARK_GRAY };
	
	private JList list;
	private String[] colornames= {"black", "blue;","red","gray"};
	
	public Birdmane(){
		super("wet");
		setLayout(new FlowLayout());
		//panel= new JPanel();
		statusbar= new JLabel("nothing yet");
		//add(panel);
		statusbar.setSize(30,30);
		add(statusbar,BorderLayout.SOUTH);
		Mousey mousehandler= new Mousey();
		this.addMouseListener(mousehandler);
		this.addMouseMotionListener(mousehandler);
		textfield1= new JTextField("Enter one of five");
		textfield1.setFont(new Font("Serif", Font.PLAIN,14));
		textfield2= new JTextField("Enter two of five");
		textfield2.setFont(new Font("Serif", Font.PLAIN,14));
		textfield3= new JTextField("Enter three of five");
		textfield3.setFont(new Font("Serif", Font.PLAIN,14));
		textfield4= new JTextField("Enter four of five");		
		textfield4.setFont(new Font("Serif", Font.PLAIN,14));
		textfield5= new JTextField("Enter five of five");
		textfield5.setFont(new Font("Serif", Font.PLAIN,14));
		add(textfield1);
		add(textfield2);
		add(textfield3);
		add(textfield4);
		add(textfield5);
		textfield7= new JTextField("Enter file fagit");
		add(textfield7);
		Icon tom = new ImageIcon(getClass().getResource("tom.png"));
		Icon han= new ImageIcon(getClass().getResource("han.jpg"));
		readtext = new JButton("Collect", tom);
		readtext.setRolloverIcon(han);
		readtext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				statusbar.setText("Readtextfileclicked");
				nuudle= String.format("%s%s%s%s%s", textfield1.getText(),textfield2.getText(),textfield3.getText(),textfield4.getText(),textfield5.getText());
			bird.open("hi",nuudle);
				bird.closeFile();
				}
				
			});
	add(readtext); 
		opentext = new JButton("open", new ImageIcon(getClass().getResource("tom.png")));
		opentext.setRolloverIcon(new ImageIcon(getClass().getResource("han.jpg")));
		opentext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event){
				statusbar.setText("openfileclik");
				bird.openFile("hi");
				}
				
			});
		add(opentext);
		
		
		textfield6=new JTextField("Enter text to enter fagit");
		rect= new JCheckBox("Rectangle");
		oval= new JCheckBox("oval");
		text= new JCheckBox("text");
		add(rect);
		add(oval);
		add(text);
		add(textfield6);
		getshapes= new JButton("getshape", new ImageIcon(getClass().getResource("han.jpg")));
		getshapes.setRolloverIcon(new ImageIcon(getClass().getResource("tom.png")));
		getshapes.addActionListener(
				(new ActionListener(){ 
					public void actionPerformed(ActionEvent event){
					maner= new Maney();
					JFrame j= new JFrame("Title");
					j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					j.add(maner);
					j.setSize(1000, 1000);
					j.setVisible(true);
					int num=0;
		
					if (rect.isSelected())
					{
						maner.rect();
						num=1;
					}
					if (oval.isSelected())
					{
					maner.oval();
					num+=1;
					}
					if (text.isSelected())
					{
						num+=1;
						maner.text(textfield6.getText());
					}
					
					if (num>0)
					{
						
						
					}
					}
			
		}));
		add(getshapes);
		list = new JList(colornames);
		list.setVisibleRowCount(4);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(
				new ListSelectionListener(){
					public void valueChanged(ListSelectionEvent event)
					{
					getContentPane().setBackground(color[list.getSelectedIndex()]);
					}
				}
				);
		add(new JScrollPane(list));
		 pf= new JRadioButton("plain",true);
		 bf= new JRadioButton("bold",true);
		 itf= new JRadioButton("italic",true);
		 bif= new JRadioButton("bold and italic", true);
		 add(pf);
		 add(bf);
		 add(itf);
		 add(bif);
		 group= new ButtonGroup();
		 group.add(pf);
		 group.add(bf);
		 group.add(itf);
		 group.add(bif);
		 pf.addItemListener(new joe(new Font("Serif", Font.PLAIN,14)));
		 bf.addItemListener(new joe(new Font("Serif", Font.BOLD,14)));
		 itf.addItemListener(new joe(new Font("Serif",Font.ITALIC,14)));
		 bif.addItemListener(new joe(new Font("Serif", Font.BOLD+ Font.ITALIC,14)));
	}

	private class joe implements ItemListener { 
		private Font font;
		public joe(Font f){
			font= f;}
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			textfield1.setFont(font);
			textfield2.setFont(font);
			textfield3.setFont(font);
			textfield4.setFont(font);
			textfield5.setFont(font);
			textfield6.setFont(font);
			pf.setFont(font);
			bf.setFont(font);
			itf.setFont(font);
			bif.setFont(font);
			rect.setFont(font);
			oval.setFont(font);
			text.setFont(font);
			opentext.setFont(font);
			readtext.setFont(font);
			text.setFont(font);
			getshapes.setFont(font);
		}}
	
	private class Mousey implements MouseListener, MouseMotionListener
	{

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			statusbar.setText("dragging mouse");
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
		statusbar.setText("moving mouse");	
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			counter+=1;
			statusbar.setText((String.format("%d%d%s%d%s",arg0.getX(),arg0.getY(),"clicked", counter,"times")));
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			statusbar.setText("mouse enter screen");
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			statusbar.setText("mouse leave screen");
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			statusbar.setText("Mouse is bieng pressed");
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			statusbar.setText("You released the mouse");
		}
		
	
	
	
	}
	
		
		
		
		
		
		
		
	
	
	
	
	
	}
	

	

	
