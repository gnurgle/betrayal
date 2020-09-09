package gui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JViewport;
import java.awt.Rectangle;

public class MenuButton extends JButton{

	private JButton button;
	private int type = 0; //used to determine which type is passed to event handler
	private DragScrollPane scroll;
	
	public MenuButton(String name, ImageIcon icon, ImageIcon hover, ImageIcon press, DragScrollPane scroll)
	{
		super();
		this.scroll = scroll;
		button = new JButton();
		//Check name and match for purposebuilt event handle
		switch(name)
		{
			case "basement":
				type = 0;
				break;
			case "ground":
				type = 1;
				break;
			case "upper":
				type = 2;
				break;
			case "attic":
				type = 3;
				break;
		}
		
		//Set ImageIcons to button state
		button.setIcon(icon);
		button.setRolloverIcon(hover);
		button.setPressedIcon(press);
		
		//Set properties of button to display only ImageIcon
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		
		//Create ButtonHandler for event handling
		ButtonHandler handler = new ButtonHandler();
		button.addActionListener(handler);
		
		
	}
	
	//Inner class for button even handling
	private class ButtonHandler implements ActionListener
	{
		//handle button event
		public void actionPerformed(ActionEvent event)
		{
			JViewport jvp = scroll.getViewport();
			
			switch(MenuButton.this.type)
			{
				case 0:
					
					MenuButton.this.scroll.setLimits(0,0,2304,2304);
					MenuButton.this.scroll.setViewport(jvp);
					jvp.scrollRectToVisible(new Rectangle(0,0,1920,760));
					break;
			}
			
		}
	}
	
}
