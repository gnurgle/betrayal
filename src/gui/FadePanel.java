/*
 * 
 * A Basic Panel that fades to black;
 * 
 */

package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.SoundEffect;

public class FadePanel extends JPanel implements ActionListener{

	private int delay = 10;
	protected Timer timer;
	
	public JButton btn_exit = new ImageButton("exit").getButton();
	
	private int a = 0;
	private int da = 2;

	
	public FadePanel()
	{
		SoundEffect.init();
		setLayout(null);
		
		//Start Fade In
		timer = new Timer(delay, this);
		timer.start();
	}
	
	public void actionPerformed(ActionEvent e)
	   // will run when the timer fires
	 {
		repaint();
		if (a <= 100)
		{
			timer.stop();
			this.setVisible(false);
		}
	 }
	public void paintComponent( Graphics g )
	{
		super.paintComponent( g ); // call superclass's paintComponent 
		
		//Fade in
		if (a<100)
		{
			a += da;
			g.setColor(new Color(0,0,0,a));
			g.fillRect(0, 0, 1920, 1080);
		}
	}
}
