package launcher;
/* *
 * 
 * Manages the opening frame before game launch
 * 
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.SoundEffect;

import gui.ImagePanel;
import gui.GameBoard;

public class Launcher extends JPanel implements ActionListener{
	
	
	
	//Layered Pane
	private JLabel bgLabel;
	private JPanel loading;
	private Select buttonPanel;
	private CharPanel cardPanel;
	private JLayeredPane layeredPane;
	private ImagePanel charbg;
	private ImagePanel charselect;
	private String str_name;
	private int select_num;
	private int total_num;
	private boolean clickable;
	private String[] players = new String[6];
	private int count = 0;
	
	TitleScroll titlescroll;
	
	//Action Commands
	private static String START_COMMAND = "start";
	private static String END_COMMAND = "end";
	private static String FATHER_COMMAND = "Father";
	private static String LONGFELLOW_COMMAND = "Longfellow";
	private static String JENNY_COMMAND = "Jenny";
	private static String HEATHER_COMMAND = "Heather";
	private static String ZOSTRA_COMMAND = "Zostra";
	private static String VIVIAN_COMMAND = "Vivian";
	private static String ZOE_COMMAND = "Zoe";
	private static String MISSY_COMMAND = "Missy";
	private static String PETER_COMMAND = "Peter";
	private static String BRANDON_COMMAND = "Brandon";
	private static String OX_COMMAND = "Ox";
	private static String DARRIN_COMMAND = "Darrin";
	private static String CONFIRM_COMMAND = "Confirm";
	private static String END_SELECT_COMMAND = "End";
	
	
	
	
	private Launcher() 
	{
		SoundEffect.init();		//Initialize sounds
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
	
		//Load up additional images
		//Background stuff
		final ImageIcon bg = new ImageIcon(getClass().getResource("/res/gui/title.jpg"));
		//create new layeredPane
		layeredPane = new JLayeredPane();
		
		//Set backround image
		bgLabel = new JLabel(bg);
		bgLabel.setSize(1920,1080);
		bgLabel.setBounds(0, 0, 1920, 1080);
		bgLabel.setVisible(true);
		bgLabel.setOpaque(false);
		
		layeredPane.add(bgLabel, new Integer(1), 0);
		
		//Set title graphics
		titlescroll = new TitleScroll();
		titlescroll.setOpaque(false);
		titlescroll.setBounds(0, 0, 1920, 1080);
		
		titlescroll.btn_exit.setActionCommand(END_COMMAND);
		titlescroll.btn_exit.addActionListener(this);
		titlescroll.btn_start.setActionCommand(START_COMMAND);
		titlescroll.btn_start.addActionListener(this);
		layeredPane.add(titlescroll, new Integer(10), 0);
		
		//Set panel of character buttons
		buttonPanel = new Select(0);
		buttonPanel.setBounds(0,0,1920,1080);
		buttonPanel.setVisible(false);
		buttonPanel.setOpaque(false);
		layeredPane.add(buttonPanel, new Integer(20), 0);
		
		//Set panel to display characters
		cardPanel = new CharPanel();
		cardPanel.setBounds(420, 20, 1300, 1000);
		cardPanel.setVisible(false);
		cardPanel.setOpaque(false);
		layeredPane.add(cardPanel, new Integer(30), 0);
		
		//Set background image for character information
		charbg = new ImagePanel(new ImageIcon(getClass().getResource("/res/gui/storyback.png")));
		charbg.setBounds(410,160,charbg.getImageIcon().getIconWidth(), charbg.getImageIcon().getIconHeight());
		charbg.setVisible(false);
		charbg.setOpaque(false);
		layeredPane.add(charbg, new Integer(25), 0);
		
		//Set title for character select
		charselect = new ImagePanel(new ImageIcon(getClass().getResource("/res/gui/select.png")));
		charselect.setBounds(1120-charselect.getImageIcon().getIconWidth()/2,24,charselect.getImageIcon().getIconWidth(), charselect.getImageIcon().getIconHeight());
		charselect.setVisible(false);
		charselect.setOpaque(false);
		layeredPane.add(charselect, new Integer(25), 0);
		
		//Set ImagePanel for Loading Screen
		loading = new ImagePanel(new ImageIcon(getClass().getResource("/res/gui/load.png")));
		loading.setBounds(0,0,1920,1080);
		loading.setVisible(false);
		loading.setOpaque(false);
		layeredPane.add(loading, new Integer(100), 0);
		
		
		
		//Character button action listeners
		buttonPanel.btn_father.setActionCommand(FATHER_COMMAND);
		buttonPanel.btn_father.addActionListener(this);
		buttonPanel.btn_longfellow.setActionCommand(LONGFELLOW_COMMAND);
		buttonPanel.btn_longfellow.addActionListener(this);
		buttonPanel.btn_heather.setActionCommand(HEATHER_COMMAND);	
		buttonPanel.btn_heather.addActionListener(this);
		buttonPanel.btn_jenny.setActionCommand(JENNY_COMMAND);
		buttonPanel.btn_jenny.addActionListener(this);
		buttonPanel.btn_zostra.setActionCommand(ZOSTRA_COMMAND);
		buttonPanel.btn_zostra.addActionListener(this);
		buttonPanel.btn_vivian.setActionCommand(VIVIAN_COMMAND);
		buttonPanel.btn_vivian.addActionListener(this);
		buttonPanel.btn_zoe.setActionCommand(ZOE_COMMAND);
		buttonPanel.btn_zoe.addActionListener(this);
		buttonPanel.btn_missy.setActionCommand(MISSY_COMMAND);
		buttonPanel.btn_missy.addActionListener(this);
		buttonPanel.btn_peter.setActionCommand(PETER_COMMAND);
		buttonPanel.btn_peter.addActionListener(this);
		buttonPanel.btn_brandon.setActionCommand(BRANDON_COMMAND);
		buttonPanel.btn_brandon.addActionListener(this);
		buttonPanel.btn_ox.setActionCommand(OX_COMMAND);
		buttonPanel.btn_ox.addActionListener(this);
		buttonPanel.btn_darrin.setActionCommand(DARRIN_COMMAND);
		buttonPanel.btn_darrin.addActionListener(this);
		buttonPanel.btn_confirm.setActionCommand(CONFIRM_COMMAND);
		buttonPanel.btn_confirm.addActionListener(this);
		buttonPanel.btn_end.setActionCommand(END_SELECT_COMMAND);
		buttonPanel.btn_end.addActionListener(this);
		
		add(layeredPane);
	}
	
	//Reset Button Panel
	private void buttonPanelReset(int num)
	{
		buttonPanel.setVisible(false);
		buttonPanel = new Select(num);
		buttonPanel.setBounds(0,0,1920,1080);
		buttonPanel.setOpaque(false);
		layeredPane.add(buttonPanel, new Integer(20), 0);
		buttonPanel.setVisible(true);
	}
	
	//Remove buttons when a character is chosen
	private void removeButtons(int num)
	{
		if (num >= 2048)
		{
			num -= 2048;
			buttonPanel.btn_darrin.setVisible(false);
			buttonPanel.btn_ox.setVisible(false);
			//players[count] = "Darrin";
			
		}
		if (num >= 1024)
		{
			num -=1024;
			buttonPanel.btn_darrin.setVisible(false);
			buttonPanel.btn_ox.setVisible(false);
			//players[count] = "Ox";
			
		}
		if (num >= 512)
		{
			num -= 512;
			buttonPanel.btn_brandon.setVisible(false);
			buttonPanel.btn_peter.setVisible(false);
			//players[count] = "Brandon";
			
	
		}
		if (num >= 256)
		{
			num -= 256;
			buttonPanel.btn_brandon.setVisible(false);
			buttonPanel.btn_peter.setVisible(false);
			//players[count] = "Peter";
			
		}
		if (num >= 128)
		{
			num -= 128;
			buttonPanel.btn_missy.setVisible(false);
			buttonPanel.btn_zoe.setVisible(false);
			//players[count] = "Missy";
			
		}
		if (num >= 64)
		{
			num-=64;
			buttonPanel.btn_missy.setVisible(false);
			buttonPanel.btn_zoe.setVisible(false);
			//players[count] = "Zoe";
			
		}
		if(num >= 32)
		{
			num-=32;
			buttonPanel.btn_vivian.setVisible(false);
			buttonPanel.btn_zostra.setVisible(false);
			//players[count] = "Vivian";
			
		}
		if(num >= 16)
		{
			num-=16;
			buttonPanel.btn_vivian.setVisible(false);
			buttonPanel.btn_zostra.setVisible(false);
			//players[count] = "Zostra";
			
		}
		if (num >= 8)
		{
			num -= 8;
			buttonPanel.btn_heather.setVisible(false);
			buttonPanel.btn_jenny.setVisible(false);
			//players[count] = "Heather";
			
		}
		if (num >= 4)
		{
			num -=4;
			buttonPanel.btn_heather.setVisible(false);
			buttonPanel.btn_jenny.setVisible(false);
			//players[count] = "Jenny";
			
		}
		if (num >=2)
		{
			num -= 2;
			buttonPanel.btn_longfellow.setVisible(false);
			buttonPanel.btn_father.setVisible(false);
			//players[count] = "Professor";
			
		}
		if (num >=1)
		{
			num -=1;
			buttonPanel.btn_longfellow.setVisible(false);
			buttonPanel.btn_father.setVisible(false);
			//players[count] = "Father";
			
		}
	}
	
	// A few variables for just actionPerformed Timer
	private int time = 0;
	private boolean end = false; //Ready to launch main program
	Timer testtimer;
	
	//Actions based on buttons
	public void actionPerformed(ActionEvent e)
	{
		repaint();
		String cmd = "";
		cmd = e.getActionCommand();
		if (time >= 3)
		{
			launch();
			testtimer.stop();
			end = false;
			time = 0;
			
		}
		else if (time > 0)
		{
			repaint();
		}
		else if (END_COMMAND.contentEquals(cmd))
		{
			SoundEffect.CLICK.play();
			frame2.setVisible(false);
			SoundEffect.TITLE_LOOP.stop();
			System.exit(0);
		}
		else if(START_COMMAND.contentEquals(cmd))
		{
			SoundEffect.CLICK.play();
			titlescroll.setVisible(false);
			buttonPanel.setVisible(true);
			buttonPanel.btn_end.setVisible(false);
			cardPanel.setVisible(true);
			charbg.setVisible(true);
			charselect.setVisible(true);
			this.revalidate();
			this.repaint();
		}
	
		else if(FATHER_COMMAND.contentEquals(cmd))
		{
			
			SoundEffect.CLICK.play();
			str_name = cmd;
			cardPanel.show(str_name);
			select_num = 1;
			clickable = true;
		}
		else if(LONGFELLOW_COMMAND.contentEquals(cmd))
		{
			SoundEffect.CLICK.play();
			str_name = cmd;
			cardPanel.show(str_name);
			select_num = 2;
			clickable = true;
		}
		else if(JENNY_COMMAND.contentEquals(cmd))
		{
			SoundEffect.CLICK.play();
			str_name = cmd;
			cardPanel.show(str_name);
			select_num = 4;
			clickable = true;
		}
		else if(HEATHER_COMMAND.contentEquals(cmd))
		{
			SoundEffect.CLICK.play();
			str_name = cmd;
			cardPanel.show(str_name);
			select_num = 8;
			clickable = true;
		}
		else if(ZOSTRA_COMMAND.contentEquals(cmd))
		{
			SoundEffect.CLICK.play();
			str_name = cmd;
			cardPanel.show(str_name);
			select_num = 16;
			clickable = true;
		}
		else if(VIVIAN_COMMAND.contentEquals(cmd))
		{
			SoundEffect.CLICK.play();
			str_name = cmd;
			cardPanel.show(str_name);
			select_num = 32;
			clickable = true;
		}
		else if(ZOE_COMMAND.contentEquals(cmd))
		{
			SoundEffect.CLICK.play();
			str_name = cmd;
			cardPanel.show(str_name);
			select_num = 64;
			clickable = true;
		}
		else if(MISSY_COMMAND.contentEquals(cmd))
		{
			SoundEffect.CLICK.play();
			str_name = cmd;
			cardPanel.show(str_name);
			select_num = 128;
			clickable = true;
		}
		else if(PETER_COMMAND.contentEquals(cmd))
		{
			SoundEffect.CLICK.play();
			str_name = cmd;
			cardPanel.show(str_name);
			select_num = 256;
			clickable = true;
		}
		else if(BRANDON_COMMAND.contentEquals(cmd))
		{
			SoundEffect.CLICK.play();
			str_name = cmd;
			cardPanel.show(str_name);
			select_num = 512;
			clickable = true;
		}
		else if(OX_COMMAND.contentEquals(cmd))
		{
			SoundEffect.CLICK.play();
			str_name = cmd;
			cardPanel.show(str_name);
			select_num = 1024;
			clickable = true;
		}
		else if(DARRIN_COMMAND.contentEquals(cmd))
		{
			SoundEffect.CLICK.play();
			str_name = cmd;
			cardPanel.show(str_name);
			select_num = 2048;
			clickable = true;
		}
		else if(END_SELECT_COMMAND.contentEquals(cmd))
		{
			SoundEffect.CLICK.play();
			loading.setVisible(true);
			repaint();
			frame2.revalidate();
			frame2.repaint();
			str_name = cmd;
			cardPanel.show("Blank");
			select_num = -9000;
			clickable = true;
			
			//Set rest to blank
			for (int i = count; i < 6; ++i)
			{
				players[i] = "Blank";
			}
			
			SoundEffect.TITLE_LOOP.stop();
			time = 1;
			end = true;
			testtimer = new Timer(400, this);
			testtimer.start();
			
			
		}
		else if(CONFIRM_COMMAND.contentEquals(cmd))
		{
			SoundEffect.CLICK.play();
			
			//Show end selection button after 3 have been chosen
			if (count == 2)
			{
				buttonPanel.btn_end.setVisible(true);
				revalidate();
				repaint();
			}
			//Remove chosen character pair
			if (clickable == true && count < 6)
			{
				total_num += select_num;
				players[count] = str_name;
				removeButtons(total_num);
				cardPanel.show("Blank");
				count++;
				revalidate();
				repaint();
			}
			
			//If 6 characters chosen launch game
			if (count == 6)
			{
				
				//frame2.setVisible(false);
				SoundEffect.TITLE_LOOP.stop();
				loading.setVisible(true);
				frame2.revalidate();
				frame2.repaint();
				time = 1;
				end = true;
				testtimer = new Timer(400, this);
				testtimer.start();
				
			}
			clickable = false;
		}
		
		
	}
	
	public void paintComponent( Graphics g )
	{
		super.paintComponent( g ); // call superclass's paintComponent 
		if (end)
			time++;
	}
	
	
	private void launch()
	{
		gui.GameBoard.game(players, count);
	}
	
	//Static method to close frame
	public static void closeFrame()
	{
		frame2.setVisible(false);
	}
	//Stop sound on window Close
	public void windowClosing(WindowEvent e)
	{
		frame2.setVisible(false);
		SoundEffect.TITLE_LOOP.stop();
		//System.exit(0);
	}
	
	private static JFrame frame2;
	private static void createAndShowGUI2(){
	        //Create and set up the window.
	        frame2 = new JFrame("Betrayal at House on the Hill");
	        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        //Create and set up the content pane.
	        JComponent newContentPane = new Launcher();
	        newContentPane.setOpaque(true); //content panes must be opaque
	        frame2.setContentPane(newContentPane);
	        frame2.setBackground(Color.black);
	        ImageIcon gameicon = new ImageIcon(GameBoard.class.getResource("/res/objects/gameicon.png"));
	        frame2.setIconImage(gameicon.getImage());
	        //Display the window.
	        frame2.setSize(1920,1080);
	        
	        frame2.setVisible(true);
	        
	        SoundEffect.TITLE_LOOP.loop();
	        
	        
	  }

	public static void main(String[] args)
	{
		createAndShowGUI2();
		
		
		//System.out.println("I launched the game");
		//TestGui.main(null);
	}
}
