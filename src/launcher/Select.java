package launcher;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.ImageButton;

public class Select extends JPanel{

	//buttons
	public JButton btn_father;
	public JButton btn_longfellow;
	public JButton btn_jenny;
	public JButton btn_heather;
	public JButton btn_zostra;
	public JButton btn_vivian;
	public JButton btn_zoe;
	public JButton btn_missy;
	public JButton btn_peter;
	public JButton btn_brandon;
	public JButton btn_ox;
	public JButton btn_darrin;
	public JButton btn_confirm;
	public JButton btn_end;
	public JLabel bgLabel;
	
	public Select(int num)
	{
		//Create buttons
		btn_father = new ImageButton("father").getButton();
		btn_longfellow = new ImageButton("longfellow").getButton();
		btn_jenny = new ImageButton("jenny").getButton();
		btn_heather = new ImageButton("heather").getButton();
		btn_zostra = new ImageButton("zostra").getButton();
		btn_vivian = new ImageButton("vivian").getButton();
		btn_zoe = new ImageButton("zoe").getButton();
		btn_missy = new ImageButton("missy").getButton();
		btn_peter = new ImageButton("peter").getButton();
		btn_brandon = new ImageButton("brandon").getButton();
		btn_ox = new ImageButton("ox").getButton();
		btn_darrin = new ImageButton("darrin").getButton();
		btn_confirm = new ImageButton("confirm").getButton();
		btn_end = new ImageButton("end").getButton();
		
		setLayout(null);
		
		btn_father.setBounds(45,126+66*0,btn_father.getIcon().getIconWidth(), btn_father.getIcon().getIconHeight());
		btn_longfellow.setBounds(45,126+66*1,btn_father.getIcon().getIconWidth(), btn_father.getIcon().getIconHeight());
		btn_jenny.setBounds(45,126+66*2,btn_father.getIcon().getIconWidth(), btn_father.getIcon().getIconHeight());
		btn_heather.setBounds(45,126+66*3,btn_father.getIcon().getIconWidth(), btn_father.getIcon().getIconHeight());
		btn_zostra.setBounds(45,126+66*4,btn_father.getIcon().getIconWidth(), btn_father.getIcon().getIconHeight());
		btn_vivian.setBounds(45,126+66*5,btn_father.getIcon().getIconWidth(), btn_father.getIcon().getIconHeight());
		btn_zoe.setBounds(45,126+66*6,btn_father.getIcon().getIconWidth(), btn_father.getIcon().getIconHeight());
		btn_missy.setBounds(45,126+66*7,btn_father.getIcon().getIconWidth(), btn_father.getIcon().getIconHeight());
		btn_peter.setBounds(45,126+66*8,btn_father.getIcon().getIconWidth(), btn_father.getIcon().getIconHeight());
		btn_brandon.setBounds(45,126+66*9,btn_father.getIcon().getIconWidth(), btn_father.getIcon().getIconHeight());
		btn_ox.setBounds(45,126+66*10,btn_father.getIcon().getIconWidth(), btn_father.getIcon().getIconHeight());
		btn_darrin.setBounds(45,126+66*11,btn_father.getIcon().getIconWidth(), btn_father.getIcon().getIconHeight());
		btn_confirm.setBounds(1500, 900, btn_father.getIcon().getIconWidth(), btn_father.getIcon().getIconHeight());
		btn_end.setBounds(1500, 970, btn_father.getIcon().getIconWidth(), btn_father.getIcon().getIconHeight());
		
		add(btn_father);
		add(btn_longfellow);
		add(btn_jenny);
		add(btn_heather);
		add(btn_zostra);
		add(btn_vivian);
		add(btn_zoe);
		add(btn_missy);
		add(btn_peter);
		add(btn_brandon);
		add(btn_ox);
		add(btn_darrin);
		add(btn_confirm);
		add(btn_end);
	}
}
