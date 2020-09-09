//This provides the first title screen for the Launcher
package launcher;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import game.SoundEffect;
import gui.ImageButton;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitleScroll extends JPanel implements ActionListener 
{
	
	
	public JButton btn_start = new ImageButton("start").getButton();
	public JButton btn_exit = new ImageButton("exit").getButton();
	ImageIcon icon = new ImageIcon(getClass().getResource("/res/gui/logo.png"));
	
	
	private int delay = 10;
	protected Timer timer;

	private int x = 0;		// x position
	private int y = -300;		// y position
	private int dy = 3;		// increment amount (y coord)
	boolean done = false;
	int num = 0;
	int a = 2;
	int da = 3;
	
	public TitleScroll()
	{
	SoundEffect.init();
	setLayout(null);
	//Set Buttons
	btn_start.setBounds(960-btn_start.getIcon().getIconWidth()/2, 660, btn_start.getIcon().getIconWidth(),btn_start.getIcon().getIconHeight());
	btn_start.setVisible(false);
	this.add(btn_start);
	
	btn_exit.setBounds(960-btn_exit.getIcon().getIconWidth()/2, 740, btn_exit.getIcon().getIconWidth(),btn_exit.getIcon().getIconHeight());
	btn_exit.setVisible(false);
	this.add(btn_exit);
	//Start title drop
	num = 1;
	timer = new Timer(delay, this);
	timer.start();
	}
	public void actionPerformed(ActionEvent e)
	   // will run when the timer fires
	 {
		repaint();
		//run after title
		if (y > 100 && num == 1)
		{
			timer.stop();
			
			JLabel titlelabel = new JLabel(icon);
			titlelabel.setBounds(960-icon.getIconWidth()/2, 100, icon.getIconWidth(), icon.getIconHeight());
			this.add(titlelabel);
			
			revalidate();
			repaint();
			num = 2;
			timer = new Timer(delay, this);
			timer.start();
			
		}
		//Run after flash
		if (a == 0 && num == 2)
		{
			timer.stop();
			btn_start.setVisible(true);
			btn_exit.setVisible(true);
			revalidate();
			repaint();
			num = 3;
		}
		
	 }
	public void paintComponent( Graphics g )
	{
		super.paintComponent( g ); // call superclass's paintComponent 
		
		// adjust Title Position
		if (y < 100 && num == 1)
		{
			y += dy;
			g.drawImage(icon.getImage(), 960-icon.getIconWidth()/2, y, null);
		}
		//run flash after title moves
		if ((a < 100 || a > 1 )&& num == 2)
		{
			//opacity down after up
			if (a > 95)
			{
				da = - 6;
				SoundEffect.LIGHTNING.play();
			}
			a += da;
			if (a < 1)
				a =0;
			g.setColor(new Color(255,255,255,a));
			g.fillRect(0, 0, 1920, 1080);
		}
	}
	
	public boolean getDone()
	{
		return done;
	}

}
