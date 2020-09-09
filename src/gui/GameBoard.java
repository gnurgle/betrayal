package gui;

import tiles.*;
import tiles.Room.Direction;
import tiles.Room.Type;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Events.*;
import Omens.*;
import Items.*;
import actors.Characters;
import actors.Player;
import actors.Token;
import actors.Character_Populate;
import game.Attack;
import game.Events;
import game.Haunt;
import game.Items;
import game.Omens;
import game.ResourceLoad;
import game.SoundEffect;
import game.TurnSystem;


public class GameBoard extends JPanel implements ActionListener, MouseListener, MouseMotionListener{
	
		private boolean clickable = true;				//Bool for if buttons are clickable
	 	private JLayeredPane layeredPane;				//Main Pane for Gameboard
	 	private Direction dirmove = Direction.NORTH;	//Direction token moved in
	    private JLabel bglabel;							//Gameboard bg label
	    private JLabel overlayLabel; 					//Token overlay drawing label
	    private DragScrollPane scroll;					//Scroll Pane to hold bgLabel
	    private JViewport jvp;							//Viewport of main scrollpane
	    private JLabel menuLabel;						//Menu Buttons
	    private ImageIcon border;						//Border around gameboard area
	    private JPanel token_scroll;					//ScrollPane for overlayLabel
	    private HouseMap bgPanel; 						//Main map of tiles
		private HouseTokens housetokens;				//Map of Tokens
		private TileDeck tiledeck;						//Deck of tiles to be chosen from
		private TileGui rotatedTile;					//Tile that rotates 
		private TurnSystem turnsystem;					//Main turn system
		private int numOfOmens = 0;					//Default number of Omens to start with
		private boolean hauntActive = false;			//Bool for if the haunt has started
		private static String[] playerinput = new String[6]; //Input of player choices
		private static int passcount;					//Input number of players				
		private JButton btn_action;						//Action Button
		private boolean attacked = false;				//If player has attacked this turn
		private boolean searched = false;				//If player has searched this turn
		private int extra = 0;							//Used for checking an extra character
		
	    
		//Resource loaders
	    private ResourceLoad loadstuff = new ResourceLoad();
	    private Character_Populate charpop = new Character_Populate(); 
	    private Tile_Populate tilepop = new Tile_Populate();
	    
	    //Popup move panel pieces
	    private MovePanel move_popup_panel;
	    //Popup rotate panel pieces
	    private RotatePanel rotate_popup_panel;
	    //Event panel
	    private EventsPanel events_popup_panel;
	    private OmensPanel omens_popup_panel;
	    private ItemsPanel items_popup_panel;
	    private DicePanel dice_popup_panel;
	    private TurnPanel turn_popup_panel;
	    private TextPop text_popup_panel;
	    //Rules Panel
	    private ImagePanel rulesPanel;
	    private ImagePanel hauntRules;
	    //Ending Panels
	    private ImagePanel wscreen1;
		private ImagePanel wscreen2;
		private ImagePanel lscreen1;
		private ImagePanel lscreen2;
		private JButton btn_exit;
	    
	    //Upper Right log window
	    private JPanel upperLog;
	    private JPanel bottomLog;
	    
	    int movesleft = 0;

	    private TokenMap tokenmap;
	    private Attack attacksystem = new Attack();
	    private Haunt hauntsystem = new Haunt();
	    
	    //Players
	    private Player player1;
	    private Player player2;
	    private Player player3;
	    private Player player4;
	    private Player player5;
	    private Player player6;
	    
	    //Event loading
	    private EventGui eventsgui = new EventGui();
	    private OmenGui omensgui = new OmenGui();
	    private ItemGui itemsgui = new ItemGui();
	
	    
	    //Some additional x y locators for special titles
	    private int ballroomx = 0;
	    private int ballroomy = 0;
	    private int stairsfrombasementx = 0;
	    private int stairsfrombasementy = 0;
	    private int galleryx =0;
	    private int galleryy =0;
	    
	    
	    //Action commands
	    private static String BASEMENT_COMMAND = "basement";
	    private static String GROUND_COMMAND = "ground";
	    private static String UPPER_COMMAND = "upper";
	    private static String MOVE_COMMAND = "move";
	    private static String NORTH_COMMAND = "north";
	    private static String SOUTH_COMMAND = "south";
	    private static String EAST_COMMAND = "east";
	    private static String WEST_COMMAND = "west";
	    private static String UP_COMMAND = "up";
	    private static String DOWN_COMMAND = "down";
	    private static String CANCEL_MOVE_COMMAND = "cancel_move";
	    private static String ROTATE_COMMAND = "rotate";
	    private static String CONFIRM_ROTATE_COMMAND = "confirm_rotate";
	    private static String END_TURN_COMMAND  = "end_turn";
	    private static String ACTION_COMMAND  = "action";
	    private static String CONFIRM_EVENT_COMMAND = "event_confirm_command";
	    private static String CONFIRM_OMEN_COMMAND = "omen_confirm_command";
	    private static String CONFIRM_ITEM_COMMAND = "item_confirm_command";
	    private static String CONFIRM_DICE_COMMAND = "dice_confirm_command";
	    private static String CONFIRM_DICEOMEN_COMMAND = "diceomen_confirm_command";
	    private static String CONFIRM_TURN_COMMAND = "turn_confirm_command";
	    private static String CONFIRM_RULES_COMMAND = "rules_confirm_command";
	    private static String CONFIRM_TEXT_COMMAND = "text_confirm_command";
	    private static String CONFIRM_HAUNT_COMMAND = "text_haunt_command";
	    private static String EXIT_COMMAND = "exit_command";
	    
	    
		public GameBoard() {
			
		//Load initial resources and populate rooms, tiles, characters
		SoundEffect.init();
		loadstuff.LoadResources();
		
		//Loading Screeo
		charload.setVisible(true);
		
		charpop.populate();
		tilepop.populate();
		eventsgui.populate();
		omensgui.populate();
		itemsgui.populate();
		tiledeck = new TileDeck(tilepop);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		//Loading Screen
		roomload.setVisible(true);
		
		//Initialize rotatedTile to avoid nullpointer error
		rotatedTile = new TileGui(tilepop.blank_tile);
		
		//Load images
		final ImageIcon bg = new ImageIcon( getClass().getResource("/res/gui/bg.jpg"));
		border = new ImageIcon(getClass().getResource("/res/gui/border.png"));

		final ImageIcon menuPanel = new ImageIcon(getClass().getResource("/res/gui/panel.png"));		
		
		//Create and step the layered pane.
		layeredPane = new JLayeredPane();
		
		
		//Add mouse funcitonality
		layeredPane.addMouseMotionListener(this);
		layeredPane.addMouseListener(this);
	
		//Add elements to layered pane
		bglabel = new JLabel(bg);
		//JPanel bgPanel = new JPanel(); //this
		ImagePanel bgPanel2 = new ImagePanel(new ImageIcon(bg.getImage()));
		bgPanel = new HouseMap();
		housetokens = new HouseTokens();
	
		
		bglabel.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
		
		
		//====ScrollPanes===
	
		token_scroll = new JPanel();
		token_scroll.setSize(3072,9216);
		token_scroll.setPreferredSize(new Dimension(3072, 9216));
		token_scroll.setBounds(0, 0, 3072,9216);
		token_scroll.setOpaque(false);
		
		layeredPane.add(bglabel,new Integer(0),0);

		tokenmap = new TokenMap();
		scroll = new DragScrollPane(tokenmap);
		scroll.setBounds(0, 0, 1920, 760);
		scroll.setWheelScrollingEnabled(false);
		scroll.setAutoscrolls(true);
		
		//Hide scrollbars
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		
		
		//Set viewport to constraints
		
		scroll.setLimits(998, 256, 3848, 1545);
		jvp = scroll.getViewport();
		scroll.setViewport(jvp);
		scroll.setOpaque(false);
		
		jvp.scrollRectToVisible(new Rectangle(256,3080,1920,760));
		scroll.getViewport().setOpaque(false);
		
		//2nd under scroll pane
		JScrollPane scrollunder = new JScrollPane(bgPanel);
		JScrollBar scroll1v = scroll.getVerticalScrollBar();
		JScrollBar scroll1h = scroll.getHorizontalScrollBar();
		JScrollBar scroll2v = scrollunder.getVerticalScrollBar();
		JScrollBar scroll2h = scrollunder.getHorizontalScrollBar();
		scroll2v.setModel(scroll1v.getModel());
		scroll2h.setModel(scroll1h.getModel());
		scrollunder.setBounds(0, 0, 1920, 760);
		scrollunder.getViewport().setOpaque(false);
		scrollunder.setOpaque(false);
		scrollunder.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollunder.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		
		layeredPane.add(scroll, new Integer(20), 0);
		layeredPane.add(scrollunder, new Integer(10), 0);
		
		//Background panning
		JScrollPane scrollbottom = new JScrollPane(bgPanel2);
		JScrollBar scroll0v = scrollbottom.getVerticalScrollBar();
		JScrollBar scroll0h = scrollbottom.getHorizontalScrollBar();
		scroll0v.setModel(scroll1v.getModel());
		scroll0h.setModel(scroll1h.getModel());
		scrollbottom.setBounds(0, 0, 1920, 760);
		scrollbottom.getViewport().setOpaque(false);
		scrollbottom.setOpaque(false);
		scrollbottom.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollbottom.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		layeredPane.add(scrollbottom, new Integer(5), 0);
		
		//Set view to initial
		scroll.setLimits(998, 256, 3848, 1545);
		scroll.getVerticalScrollBar().setValue(3072);
		scroll.getHorizontalScrollBar().setValue(512);
		scroll.getViewport().setOpaque(false);
		
		
		
		//=====Tile testing
		load1.setVisible(true);
	
		//Fill house map with blank tiles
		for (int i = 0; i < 12; ++i)
		{
			for(int j = 0; j < 36; ++j)
			{
			//pull from arraylist of rooms
			bgPanel.drawTile(new TileGui(tilepop.blank_tile), i, j);
			//bgPanel.drawTile(dusty_gui, i, j);
			//dusty_gui.drawToken(zoe);
			
		}
		}
		
		
		//draw landings
		bgPanel.drawTile(new TileGui(tilepop.basement_tile), 5, 4);
		bgPanel.drawTile(new TileGui(tilepop.grand_tile), 4,13);
		bgPanel.drawTile(new TileGui(tilepop.foyer_tile), 5, 13);
		bgPanel.drawTile(new TileGui(tilepop.entrance_tile), 6, 13);
		bgPanel.drawTile(new TileGui(tilepop.door_tile), 7, 13);
		bgPanel.drawTile(new TileGui(tilepop.landing_upper_tile), 5, 22);
		tileload.setVisible(true);
		//Add border
		overlayLabel = new JLabel(border);
		overlayLabel.setBounds(0,0,border.getIconWidth(), border.getIconHeight());
		layeredPane.add(overlayLabel,new Integer(30), 0);
		
		
		//====PlayerPanels and turn System
		turnsystem = new TurnSystem(passcount); //full 6 players
		
		//Player and Turn Initilization
		player1 = new Player(setPlayers(0), new Token(setPlayers(0)), 1);
		player2 = new Player(setPlayers(1), new Token(setPlayers(1)), 2);
		player3 = new Player(setPlayers(2), new Token(setPlayers(2)), 3);
		player4 = new Player(setPlayers(3), new Token(setPlayers(3)), 4);
		player5 = new Player(setPlayers(4), new Token(setPlayers(4)), 5);
		player6 = new Player(setPlayers(5), new Token(setPlayers(5)), 6);
		
		//Add Player to turn roster
		turnsystem.addPlayer(player1);
		turnsystem.addPlayer(player2);
		turnsystem.addPlayer(player3);
		turnsystem.addPlayer(player4);
		turnsystem.addPlayer(player5);
		turnsystem.addPlayer(player6);
		
		//Start Turns
		turnsystem.startTurns();
	
		load2.setVisible(true);	
		
		//Initialize Player Stat Panels
		PlayerStatsPanel play1 = new PlayerStatsPanel(player1.getCharacter());
		play1.setBounds(-800+0*320,520,border.getIconWidth(), border.getIconHeight());
		layeredPane.add(play1,new Integer(30), 0);
		
		PlayerStatsPanel play2 = new PlayerStatsPanel(player2.getCharacter());
		play2.setBounds(-800+1*320,520,border.getIconWidth(), border.getIconHeight());
		layeredPane.add(play2,new Integer(30), 0);
		
		PlayerStatsPanel play3 = new PlayerStatsPanel(player3.getCharacter());
		play3.setBounds(-800+2*320,520,border.getIconWidth(), border.getIconHeight());
		layeredPane.add(play3,new Integer(30), 0);
		
		PlayerStatsPanel play4 = new PlayerStatsPanel(player4.getCharacter());
		play4.setBounds(-800+3*320,520,border.getIconWidth(), border.getIconHeight());
		layeredPane.add(play4,new Integer(30), 0);
		
		PlayerStatsPanel play5 = new PlayerStatsPanel(player5.getCharacter());
		play5.setBounds(-800+4*320,520,border.getIconWidth(), border.getIconHeight());
		layeredPane.add(play5,new Integer(30), 0);
		
		PlayerStatsPanel play6 = new PlayerStatsPanel(player6.getCharacter());
		play6.setBounds(-800+5*320,520,border.getIconWidth(), border.getIconHeight());
		layeredPane.add(play6,new Integer(30), 0);
		load3.setVisible(true);
		//Draw Starting Tokens
		housetokens.drawToken(bgPanel, tokenmap, tiledeck, player1.getToken(), 6, 13);
		housetokens.drawToken(bgPanel, tokenmap, tiledeck, player2.getToken(), 6, 13);
		housetokens.drawToken(bgPanel, tokenmap, tiledeck, player3.getToken(), 6, 13);
		housetokens.drawToken(bgPanel, tokenmap, tiledeck, player4.getToken(), 6, 13);
		housetokens.drawToken(bgPanel, tokenmap, tiledeck, player5.getToken(), 6, 13);
		housetokens.drawToken(bgPanel, tokenmap, tiledeck, player6.getToken(), 6, 13);
		
		//Draw Menu
		menuLabel = new JLabel(menuPanel);
		menuLabel.setBounds(1562,6,menuPanel.getIconWidth(), menuPanel.getIconHeight());
		layeredPane.add(menuLabel,new Integer(40), 0);
		
		
		
		
		//==========Buttons=============
		final ImageIcon btn_basement_default = new ImageIcon(getClass().getResource("/res/gui/button/btn_basement_default.png"));
		final ImageIcon btn_ground_default = new ImageIcon(getClass().getResource("/res/gui/button/btn_ground_default.png"));
		final ImageIcon btn_upper_default = new ImageIcon(getClass().getResource("/res/gui/button/btn_upper_default.png"));
		final ImageIcon btn_move_default = new ImageIcon(getClass().getResource("/res/gui/button/btn_move_default.png"));
		final ImageIcon btn_itemomen_default = new ImageIcon(getClass().getResource("/res/gui/button/btn_itemomen_default.png"));
		final ImageIcon btn_endturn_default = new ImageIcon(getClass().getResource("/res/gui/button/btn_endturn_default.png"));
		
		//Menu button initilization
		JButton btn_basement = new ImageButton("basement").getButton();
		btn_basement.setBounds((int)(menuLabel.getWidth()/2+menuLabel.getLocation().getX()-btn_basement_default.getIconWidth()/2),(int) (menuLabel.getLocation().getY()+menuLabel.getHeight()-36-btn_basement_default.getIconHeight()), btn_basement_default.getIconWidth(), btn_basement_default.getIconHeight());
		layeredPane.add(btn_basement, new Integer(50), 0);
		
		btn_basement.setActionCommand(BASEMENT_COMMAND);
		btn_basement.addActionListener(this);
		

		JButton btn_ground = new ImageButton("ground").getButton();
		btn_ground.setBounds((int)(menuLabel.getWidth()/2+menuLabel.getLocation().getX()-btn_ground_default.getIconWidth()/2),(int) (btn_basement.getLocation().getY()-8-btn_ground_default.getIconHeight()), btn_ground_default.getIconWidth(), btn_ground_default.getIconHeight());
		layeredPane.add(btn_ground, new Integer(60), 0);
		
		btn_ground.setActionCommand(GROUND_COMMAND);
		btn_ground.addActionListener(this);
		
		JButton btn_upper = new ImageButton("upper").getButton();
		btn_upper.setBounds((int)(menuLabel.getWidth()/2+menuLabel.getLocation().getX()-btn_upper_default.getIconWidth()/2),(int) (btn_ground.getLocation().getY()-8-btn_upper_default.getIconHeight()), btn_upper_default.getIconWidth(), btn_upper_default.getIconHeight());
		layeredPane.add(btn_upper, new Integer(70), 0);
		
		btn_upper.setActionCommand(UPPER_COMMAND);
		btn_upper.addActionListener(this);
	
		JButton btn_endturn = new ImageButton("endturn").getButton();
		btn_endturn.setBounds((int)(menuLabel.getWidth()/2+menuLabel.getLocation().getX()-btn_endturn_default.getIconWidth()/2),(int) (btn_upper.getLocation().getY()-107-btn_upper_default.getIconHeight()), btn_endturn_default.getIconWidth(), btn_endturn_default.getIconHeight());
		layeredPane.add(btn_endturn, new Integer(80), 0);
		btn_endturn.setActionCommand(END_TURN_COMMAND);
		btn_endturn.addActionListener(this);
		
		
		btn_action = new ImageButton("action").getButton();
		btn_action.setBounds((int)(menuLabel.getWidth()/2+menuLabel.getLocation().getX()-btn_itemomen_default.getIconWidth()/2),(int) (btn_endturn.getLocation().getY()-8-btn_itemomen_default.getIconHeight()), btn_itemomen_default.getIconWidth(), btn_itemomen_default.getIconHeight());
		layeredPane.add(btn_action, new Integer(80), 0);
		btn_action.setVisible(false);
		btn_action.setActionCommand(ACTION_COMMAND);
		btn_action.addActionListener(this);
		
		JButton btn_move = new ImageButton("move").getButton();
		btn_move.setBounds((int)(menuLabel.getWidth()/2+menuLabel.getLocation().getX()-btn_move_default.getIconWidth()/2),(int) (btn_action.getLocation().getY()-8-btn_move_default.getIconHeight()), btn_move_default.getIconWidth(), btn_move_default.getIconHeight());
		layeredPane.add(btn_move, new Integer(80), 0);
		
		btn_move.setActionCommand(MOVE_COMMAND);
		btn_move.addActionListener(this);
		
		
		PopupPanel test = new PopupPanel();
		test.setBounds(100,100,620,310);

		
		//============Popup Panels========================
		
		//Move popup menu
		move_popup_panel = new MovePanel(bgPanel, turnsystem.getCurrentPlayer().getToken(),bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()));
		move_popup_panel.btn_north.setActionCommand(NORTH_COMMAND);
		move_popup_panel.btn_north.addActionListener(this);
		move_popup_panel.btn_south.setActionCommand(SOUTH_COMMAND);
		move_popup_panel.btn_south.addActionListener(this);
		move_popup_panel.btn_east.setActionCommand(EAST_COMMAND);
		move_popup_panel.btn_east.addActionListener(this);
		move_popup_panel.btn_west.setActionCommand(WEST_COMMAND);
		move_popup_panel.btn_west.addActionListener(this);
		move_popup_panel.btn_up.setActionCommand(UP_COMMAND);
		move_popup_panel.btn_up.addActionListener(this);
		move_popup_panel.btn_down.setActionCommand(DOWN_COMMAND);
		move_popup_panel.btn_down.addActionListener(this);
		move_popup_panel.btn_cancel.setActionCommand(CANCEL_MOVE_COMMAND);
		move_popup_panel.btn_cancel.addActionListener(this);
		
		move_popup_panel.setBounds(menuLabel.getX()-284, 147, 300, 481);
		move_popup_panel.setOpaque(false);
		move_popup_panel.setVisible(false);
		layeredPane.add(move_popup_panel, new Integer(60), 0);
		
		//Tile Rotate Panel
		rotate_popup_panel = new RotatePanel(bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()) , Direction.NORTH);
		rotate_popup_panel.btn_rotate.setActionCommand(ROTATE_COMMAND);
		rotate_popup_panel.btn_rotate.addActionListener(this);
		
		rotate_popup_panel.btn_confirm_rotate.setActionCommand(CONFIRM_ROTATE_COMMAND);
		rotate_popup_panel.btn_confirm_rotate.addActionListener(this);
		
		
		rotate_popup_panel.setBounds(0,0,310,492);
		rotate_popup_panel.setOpaque(false);
		
		rotate_popup_panel.setBounds(menuLabel.getX()-484, 147, 300,481);
		rotate_popup_panel.setVisible(false);
		
		layeredPane.add(rotate_popup_panel, new Integer(60),0);
		
		//Event Panel
		Events currentEvents = new EmptyEvent();
		currentEvents.activate(turnsystem.getCurrentPlayer());
		events_popup_panel = new EventsPanel(currentEvents);
		events_popup_panel.btn_event_confirm.setActionCommand(CONFIRM_EVENT_COMMAND);
		events_popup_panel.btn_event_confirm.addActionListener(this);
		events_popup_panel.setBounds(menuLabel.getX()-754, 147, events_popup_panel.getWidth(),events_popup_panel.getHeight());
		events_popup_panel.setVisible(false);
		
		layeredPane.add(events_popup_panel, new Integer(60),0);
		
		//Omen Panel
		Omens currentOmens = new EmptyOmen();
		currentOmens.activate(turnsystem.getCurrentPlayer());
		omens_popup_panel = new OmensPanel(currentOmens);
		omens_popup_panel.btn_omen_confirm.setActionCommand(CONFIRM_OMEN_COMMAND);
		omens_popup_panel.btn_omen_confirm.addActionListener(this);
		omens_popup_panel.setBounds(menuLabel.getX()-754, 147, omens_popup_panel.getWidth(),omens_popup_panel.getHeight());
		omens_popup_panel.setVisible(false);
		
		layeredPane.add(omens_popup_panel, new Integer(60),0);
		
		//Items Panel
		Items currentItems = new EmptyItem();
		currentItems.activate(turnsystem.getCurrentPlayer());
		items_popup_panel = new ItemsPanel(currentItems);
		items_popup_panel.btn_item_confirm.setActionCommand(CONFIRM_ITEM_COMMAND);
		items_popup_panel.btn_item_confirm.addActionListener(this);
		items_popup_panel.setBounds(menuLabel.getX()-754, 147, items_popup_panel.getWidth(),items_popup_panel.getHeight());
		items_popup_panel.setVisible(false);
		
		layeredPane.add(items_popup_panel, new Integer(60),0);
		
		//Upper Log panel
		upperLog = new ImagePanel(new ImageIcon(getClass().getResource("/res/gui/log.png")));
		upperLog.setBounds(0, 0, upperLog.getWidth(), upperLog.getHeight());
		upperLog.setLayout(null);
		JLabel text = new JLabel();
		text.setFont(new Font("Letter Gothic", Font.PLAIN, 26));
		text.setForeground(Color.WHITE);
		String numOmen = "Number of Omens Discovered: " + numOfOmens;
		text.setText(numOmen);
		text.setBounds(30,20,420,30);
		upperLog.add(text);
		layeredPane.add(upperLog, new Integer(28),0);
		
		//Bottom Log panel
		bottomLog = new ImagePanel(new ImageIcon(getClass().getResource("/res/gui/moveleftpanel.png")));
		bottomLog.setBounds(0, 760-bottomLog.getHeight(), bottomLog.getWidth(), bottomLog.getHeight());
		bottomLog.setLayout(null);
		JLabel textmove = new JLabel();
		textmove.setFont(new Font("Letter Gothic", Font.PLAIN, 30));
		textmove.setForeground(Color.WHITE);
		String moves = "Moves Remaining: " + movesleft;
		textmove.setText(moves);
		textmove.setBounds(30,45,420,40);
		bottomLog.add(textmove);
		layeredPane.add(bottomLog, new Integer(28),0);
		
		//DicePanel
		dice_popup_panel = new DicePanel(numOfOmens);
		dice_popup_panel.btn_dice_confirm.setActionCommand(CONFIRM_DICE_COMMAND);
		dice_popup_panel.btn_dice_confirm.addActionListener(this);
		dice_popup_panel.btn_diceomen_confirm.setActionCommand(CONFIRM_DICEOMEN_COMMAND);
		dice_popup_panel.btn_diceomen_confirm.addActionListener(this);
		dice_popup_panel.setBounds(menuLabel.getX()-754, 147, items_popup_panel.getWidth(),items_popup_panel.getHeight());
		dice_popup_panel.setVisible(false);
		
		layeredPane.add(items_popup_panel, new Integer(60),0);
		
		//Turn Popup panel
		turn_popup_panel = new TurnPanel(turnsystem.getCurrentPlayer().getCharacter().getfName());
		turn_popup_panel.btn_turn_confirm.setActionCommand(CONFIRM_TURN_COMMAND);
		turn_popup_panel.btn_turn_confirm.addActionListener(this);
		turn_popup_panel.setBounds(menuLabel.getX()-754, 147, turn_popup_panel.getWidth(),turn_popup_panel.getHeight());
		turn_popup_panel.setVisible(false);
		
		layeredPane.add(turn_popup_panel, new Integer(60),0);
		
		load4.setVisible(true);
		load5.setVisible(true);
		
		//How to Play Panel
		rulesPanel = new ImagePanel(new ImageIcon(getClass().getResource("/res/gui/rules.png")));
		rulesPanel.setSize(1920, 1080);
		rulesPanel.setBounds(0, 0, 1920, 1080);
		rulesPanel.setLayout(null);
		JButton btn_rule_confirm = new ImageButton("confirm").getButton();
		btn_rule_confirm.setBounds(960-btn_rule_confirm.getIcon().getIconWidth()/2, 700, btn_rule_confirm.getIcon().getIconWidth(), btn_rule_confirm.getIcon().getIconHeight());
		btn_rule_confirm.setActionCommand(CONFIRM_RULES_COMMAND);
		btn_rule_confirm.addActionListener(this);
		rulesPanel.add(btn_rule_confirm);
		layeredPane.add(rulesPanel, new Integer(150),0);
		
		//How to Play Panel
		hauntRules = new ImagePanel(new ImageIcon(getClass().getResource("/res/gui/Hauntrules.png")));
		hauntRules.setSize(1920, 1080);
		hauntRules.setBounds(0, 0, 1920, 1080);
		hauntRules.setLayout(null);
		JButton btn_haunt_confirm = new ImageButton("confirm").getButton();
		btn_haunt_confirm.setBounds(960-btn_haunt_confirm.getIcon().getIconWidth()/2, 700, btn_haunt_confirm.getIcon().getIconWidth(), btn_haunt_confirm.getIcon().getIconHeight());
		btn_haunt_confirm.setActionCommand(CONFIRM_HAUNT_COMMAND);
		btn_haunt_confirm.addActionListener(this);
		hauntRules.add(btn_haunt_confirm);
		layeredPane.add(hauntRules, new Integer(150),0);
		hauntRules.setVisible(false);
		
		//Generic text display panel
		
		text_popup_panel = new TextPop("Blank");
		text_popup_panel.btn_text_confirm.setActionCommand(CONFIRM_TEXT_COMMAND);
		text_popup_panel.btn_text_confirm.addActionListener(this);
		text_popup_panel.setVisible(false);
		layeredPane.add(text_popup_panel, new Integer (60), 0);
		
		//Win Screen
		
		wscreen1 = new ImagePanel(new ImageIcon(getClass().getResource("/res/gui/win.jpg")));
		wscreen1.setBounds(0, 0, 1920, 1080);
		wscreen1.setOpaque(false);
		wscreen1.setVisible(false);
		layeredPane.add(wscreen1, new Integer(190), 0);
		
		
		wscreen2 = new ImagePanel(new ImageIcon(getClass().getResource("/res/gui/winpanel.png")));
		wscreen2.setBounds(0, 0, 1920, 1080);
		wscreen2.setOpaque(false);
		wscreen2.setVisible(false);
		layeredPane.add(wscreen2, new Integer(195), 0);
		
		//Lose Screen
		lscreen1 = new ImagePanel(new ImageIcon(getClass().getResource("/res/gui/lose.jpg")));
		lscreen1.setBounds(0, 0, 1920, 1080);
		lscreen1.setOpaque(false);
		lscreen1.setVisible(false);
		layeredPane.add(lscreen1, new Integer(190), 0);
		
		lscreen2 = new ImagePanel(new ImageIcon(getClass().getResource("/res/gui/losspanel.png")));
		lscreen2.setBounds(0, 0, 1920, 1080);
		lscreen2.setOpaque(false);
		lscreen2.setVisible(false);
		layeredPane.add(lscreen2, new Integer(195), 0);
		
		//exit Game button
		btn_exit = new ImageButton("exit").getButton();
		btn_exit.setBounds(780, 880, 361, 51);
		btn_exit.setVisible(false);
		btn_exit.setActionCommand(EXIT_COMMAND);
		btn_exit.addActionListener(this);
		layeredPane.add(btn_exit, new Integer(200), 0);
		
		
		add(layeredPane);
		
		launcher.Launcher.closeFrame();
		}
		
		//Set Players with passed information
		private Characters setPlayers(int num)
		{
			Characters output = null;
			switch (playerinput[num])
				{
				case "Jenny":
					output = charpop.jenny;
					break;
				case "Darrin":
					output = charpop.darrin;
					break;
				case "Ox":
					output = charpop.ox;
					break;
				case "Zoe":
					output = charpop.zoe;
					break;
				case "Missy":
					output = charpop.missy;
					break;
				case "Brandon":
					output = charpop.brandon;
					break;
				case "Peter":
					output = charpop.peter;
					break;
				case "Zostra":
					output = charpop.zostra;
					break;
				case "Vivian":
					output = charpop.vivian;
					break;
				case "Heather":
					output = charpop.heather;
					break;
				case "Father":
					output = charpop.rhinehardt;
					break;
				case "Longfellow":
					output = charpop.longfellow;
					break;
				case "Blank":
					output = charpop.blank;
					break;
				};
			
			return output;
		}
		
		//===============Reset Popup Menus================
		/**
		 * 
		 * These reset various menus and popups to display correctly with the 
		 * updated values 
		 */
		private void resetMoveMenu()
		{
			move_popup_panel.setVisible(false);
			move_popup_panel = new MovePanel(bgPanel, turnsystem.getCurrentPlayer().getToken(),bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()));
			move_popup_panel.setVisible(false);
			move_popup_panel.setBounds(menuLabel.getX()-284, 147, 300, 481);
			
			move_popup_panel.btn_north.setActionCommand(NORTH_COMMAND);
			move_popup_panel.btn_north.addActionListener(this);
			
			move_popup_panel.btn_south.setActionCommand(SOUTH_COMMAND);
			move_popup_panel.btn_south.addActionListener(this);
			
			move_popup_panel.btn_east.setActionCommand(EAST_COMMAND);
			move_popup_panel.btn_east.addActionListener(this);
			
			move_popup_panel.btn_west.setActionCommand(WEST_COMMAND);
			move_popup_panel.btn_west.addActionListener(this);
			
			move_popup_panel.btn_up.setActionCommand(UP_COMMAND);
			move_popup_panel.btn_up.addActionListener(this);
			
			move_popup_panel.btn_down.setActionCommand(DOWN_COMMAND);
			move_popup_panel.btn_down.addActionListener(this);
			
			move_popup_panel.btn_cancel.setActionCommand(CANCEL_MOVE_COMMAND);
			move_popup_panel.btn_cancel.addActionListener(this);
			
		
			layeredPane.add(move_popup_panel, new Integer(60), 0);
				
		}
		
		private void resetRotateMenu(TileGui rotatetile, Direction dir)
		{
			clickable = false;
			rotate_popup_panel = new RotatePanel(rotatetile , dir);
			rotate_popup_panel.btn_rotate.setActionCommand(ROTATE_COMMAND);
			rotate_popup_panel.btn_rotate.addActionListener(this);
			
			rotate_popup_panel.btn_confirm_rotate.setActionCommand(CONFIRM_ROTATE_COMMAND);
			rotate_popup_panel.btn_confirm_rotate.addActionListener(this);
			layeredPane.add(rotate_popup_panel, new Integer(60),0);
			SoundEffect.DOOROPEN.play();
			clickable = false;
			
		}
		
		private void resetEventMenu()
		{
		clickable = false;
		eventsgui.getEvent(turnsystem.getCurrentPlayer());
		Events currentEvents = eventsgui.getCurrentEvent();
		currentEvents.activate(turnsystem.getCurrentPlayer());
		events_popup_panel = new EventsPanel(currentEvents);
		events_popup_panel.btn_event_confirm.setActionCommand(CONFIRM_EVENT_COMMAND);
		events_popup_panel.btn_event_confirm.addActionListener(this);
		events_popup_panel.setBounds(menuLabel.getX()-754, 147, events_popup_panel.getWidth(),events_popup_panel.getHeight());
		
		
		layeredPane.add(events_popup_panel, new Integer(60),0);
		}
		
		private void resetOmenMenu()
		{
			clickable = false;
			omensgui.getOmen(turnsystem.getCurrentPlayer());
			Omens currentOmens = omensgui.getCurrentOmen();
			currentOmens.activate(turnsystem.getCurrentPlayer());
			omens_popup_panel = new OmensPanel(currentOmens);
			omens_popup_panel.btn_omen_confirm.setActionCommand(CONFIRM_OMEN_COMMAND);
			omens_popup_panel.btn_omen_confirm.addActionListener(this);
			omens_popup_panel.setBounds(menuLabel.getX()-754, 147, omens_popup_panel.getWidth(),omens_popup_panel.getHeight());
			//omens_popup_panel.setVisible(false);
		
			layeredPane.add(omens_popup_panel, new Integer(60),0);
		}
		
		private void resetItemMenu()
		{
			clickable = false;
			itemsgui.getItem(turnsystem.getCurrentPlayer());
			Items currentItems = itemsgui.getCurrentItem();
			currentItems.activate(turnsystem.getCurrentPlayer());
			items_popup_panel = new ItemsPanel(currentItems);
			items_popup_panel.btn_item_confirm.setActionCommand(CONFIRM_ITEM_COMMAND);
			items_popup_panel.btn_item_confirm.addActionListener(this);
			items_popup_panel.setBounds(menuLabel.getX()-754, 147, items_popup_panel.getWidth(),items_popup_panel.getHeight());
			//items_popup_panel.setVisible(false);
		
			layeredPane.add(items_popup_panel, new Integer(60),0);
		}
		
		private void resetUpperLog()
		{
			upperLog.setVisible(false);
			upperLog = new ImagePanel(new ImageIcon(getClass().getResource("/res/gui/log.png")));
			upperLog.setBounds(0, 0, upperLog.getWidth(), upperLog.getHeight());
			upperLog.setLayout(null);
			JLabel text = new JLabel();
			text.setFont(new Font("Letter Gothic", Font.PLAIN, 26));
			text.setForeground(Color.WHITE);
			String numOmen = "";
			if (!hauntActive)
				numOmen = "Number of Omens Discovered: " + numOfOmens;
			else
				numOmen = turnsystem.getCurrentTraitor().getCharacter().getfName() + " is the traitor.";
			text.setText(numOmen);
			text.setBounds(30,20,420,30);
			upperLog.add(text);
			layeredPane.add(upperLog, new Integer(28),0);
			upperLog.setVisible(true);
		}
		
		private void resetBottomLog()
		{
			bottomLog.setVisible(false);
			bottomLog = new ImagePanel(new ImageIcon(getClass().getResource("/res/gui/moveleftpanel.png")));
			bottomLog.setBounds(0, 760-bottomLog.getHeight(), bottomLog.getWidth(), bottomLog.getHeight());
			bottomLog.setLayout(null);
			JLabel textmove = new JLabel();
			textmove.setFont(new Font("Letter Gothic", Font.PLAIN, 30));
			textmove.setForeground(Color.WHITE);
			String moves = "Moves Remaining: " + movesleft;
			textmove.setText(moves);
			textmove.setBounds(30,45,420,40);
			bottomLog.add(textmove);
			layeredPane.add(bottomLog, new Integer(28),0);
			bottomLog.setVisible(true);
		}
		private void resetTurnPopup()
		{
			clickable = false;
			turn_popup_panel = new TurnPanel(turnsystem.getCurrentPlayer().getCharacter().getfName());
			turn_popup_panel.btn_turn_confirm.setActionCommand(CONFIRM_TURN_COMMAND);
			turn_popup_panel.btn_turn_confirm.addActionListener(this);
			turn_popup_panel.setBounds(menuLabel.getX()-754, 147, turn_popup_panel.getWidth(),turn_popup_panel.getHeight());
			turn_popup_panel.setVisible(false);
			
			layeredPane.add(turn_popup_panel, new Integer(60),0);
			turn_popup_panel.setVisible(true);
			clickable = false;
		}
		
		private void resetDicePanel()
		{
			clickable = false;
			dice_popup_panel = new DicePanel(numOfOmens);
			dice_popup_panel.btn_dice_confirm.setActionCommand(CONFIRM_DICE_COMMAND);
			dice_popup_panel.btn_dice_confirm.addActionListener(this);
			dice_popup_panel.btn_diceomen_confirm.setActionCommand(CONFIRM_DICEOMEN_COMMAND);
			dice_popup_panel.btn_diceomen_confirm.addActionListener(this);
			dice_popup_panel.setBounds(menuLabel.getX()-754, 147, dice_popup_panel.getWidth(),dice_popup_panel.getHeight());
			
			
			layeredPane.add(dice_popup_panel, new Integer(60),0);
			
		}
		private void resetPlayerPanel()
		{
			if (turnsystem.getCurrentPlayer().getPlayerNum() == 1 || extra == 1)
			{
				PlayerStatsPanel play1 = new PlayerStatsPanel(player1.getCharacter());
				play1.setBounds(-800+0*320,520,border.getIconWidth(), border.getIconHeight());
				layeredPane.add(play1,new Integer(30), 0);
			}
			if (turnsystem.getCurrentPlayer().getPlayerNum() == 2 || extra == 2)
			{
				PlayerStatsPanel play2 = new PlayerStatsPanel(player2.getCharacter());
				play2.setBounds(-800+1*320,520,border.getIconWidth(), border.getIconHeight());
				layeredPane.add(play2,new Integer(30), 0);
			}
			if (turnsystem.getCurrentPlayer().getPlayerNum() == 3 || extra == 3)
			{
				PlayerStatsPanel play3 = new PlayerStatsPanel(player3.getCharacter());
				play3.setBounds(-800+2*320,520,border.getIconWidth(), border.getIconHeight());
				layeredPane.add(play3,new Integer(30), 0);
			}	
			if (turnsystem.getCurrentPlayer().getPlayerNum() == 4 || extra == 4)
			{
				PlayerStatsPanel play4 = new PlayerStatsPanel(player4.getCharacter());
				play4.setBounds(-800+3*320,520,border.getIconWidth(), border.getIconHeight());
				layeredPane.add(play4,new Integer(30), 0);
			}
			if (turnsystem.getCurrentPlayer().getPlayerNum() == 5 ||  extra == 5)	
			{
				PlayerStatsPanel play5 = new PlayerStatsPanel(player5.getCharacter());
				play5.setBounds(-800+4*320,520,border.getIconWidth(), border.getIconHeight());
				layeredPane.add(play5,new Integer(30), 0);
			}
			if (turnsystem.getCurrentPlayer().getPlayerNum() == 6 || extra == 6)
			{
				PlayerStatsPanel play6 = new PlayerStatsPanel(player6.getCharacter());
				play6.setBounds(-800+5*320,520,border.getIconWidth(), border.getIconHeight());
				layeredPane.add(play6,new Integer(30), 0);
			}
				
		}
		public void resetTextPop(String input)
		{
			text_popup_panel.setVisible(false);
			text_popup_panel = new TextPop(input);
			text_popup_panel.btn_text_confirm.setActionCommand(CONFIRM_TEXT_COMMAND);
			text_popup_panel.btn_text_confirm.addActionListener(this);
			layeredPane.add(text_popup_panel, new Integer (60), 0);
			text_popup_panel.setBounds(menuLabel.getX()-754, 147, text_popup_panel.getWidth(),text_popup_panel.getHeight());
			text_popup_panel.setVisible(false);
		}
		
		//=================End Reset Menus==============
		
		//Check exit of room with special cases
		private boolean checkExit()
		{
			boolean output = true;
			if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(),turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Attic")
			{
				if (turnsystem.getCurrentPlayer().getCharacter().traitRoll(turnsystem.getCurrentPlayer().getCharacter().getSpeed()) < 3)
				{
					turnsystem.getCurrentPlayer().playFall();
					turnsystem.getCurrentPlayer().getCharacter().decrementMight();
					turnsystem.getCurrentPlayer().getCharacter().setInjured(false);
				}
			}
			else if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(),turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Junk Room")
			{
				if (turnsystem.getCurrentPlayer().getCharacter().traitRoll(turnsystem.getCurrentPlayer().getCharacter().getMight()) < 3)
				{
					turnsystem.getCurrentPlayer().playFall();
					turnsystem.getCurrentPlayer().getCharacter().decrementSpeed();
					turnsystem.getCurrentPlayer().getCharacter().setInjured(false);
				}
			}
			else if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(),turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Graveyard" && !turnsystem.getCurrentPlayer().isHasAmulet())
			{
				if (turnsystem.getCurrentPlayer().getCharacter().traitRoll(turnsystem.getCurrentPlayer().getCharacter().getSanity()) < 4)
				{
					turnsystem.getCurrentPlayer().playFall();
					turnsystem.getCurrentPlayer().getCharacter().decrementKnowledge();
					turnsystem.getCurrentPlayer().getCharacter().setInjured(false);
				}
			}
			
			else if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(),turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Pentagram Chamber" && !turnsystem.getCurrentPlayer().isHasAmulet())
			{
				if (turnsystem.getCurrentPlayer().getCharacter().traitRoll(turnsystem.getCurrentPlayer().getCharacter().getKnowledge()) < 4)
				{
					turnsystem.getCurrentPlayer().playFall();
					turnsystem.getCurrentPlayer().getCharacter().decrementSanity();
					turnsystem.getCurrentPlayer().getCharacter().setInjured(false);
				}
			}
			
			else if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(),turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Chasm")
			{
				if (turnsystem.getCurrentPlayer().getCharacter().traitRoll(turnsystem.getCurrentPlayer().getCharacter().getSpeed()) < 3)
				{
					turnsystem.getCurrentPlayer().playFall();
					output = false;
					movesleft--;
					resetBottomLog();
				}
			}
			
			else if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(),turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Tower")
			{
				if (turnsystem.getCurrentPlayer().getCharacter().traitRoll(turnsystem.getCurrentPlayer().getCharacter().getMight()) < 3)
				{
					turnsystem.getCurrentPlayer().playFall();
					output = false;
					movesleft--;
					resetBottomLog();
				}
			}
			
			else if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(),turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Catacombs")
			{
				if (turnsystem.getCurrentPlayer().getCharacter().traitRoll(turnsystem.getCurrentPlayer().getCharacter().getSanity()) < 6)
				{
					turnsystem.getCurrentPlayer().playFall();
					output = false;
					movesleft--;
					resetBottomLog();
				}
			}
			
			return output;
		}
		
		//Increment number of omens
		private void increaseOmen()
		{
			numOfOmens++;
			
		}
		
		//Interfaces players and haunts to resolve stat checks
		private void setHaunt()
		{
			player1.setHauntActive(true);
			player2.setHauntActive(true);
			player3.setHauntActive(true);
			player4.setHauntActive(true);
			player5.setHauntActive(true);
			player6.setHauntActive(true);
		}
		
		//Check if room is one of the ones important to haunt
		private boolean roomCheck()
		{
			if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName().equals("Master Bedroom") )
				return true;
			else if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName().equals("Operating Laboratory") )
				return true;
			else if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName().equals("Furnace Room") )
				return true;
			
			return false;
			
		}
		
		//Check if ending conditions have been met and end game if true
		private boolean checkEnd()
		{
			if(hauntActive)
			{
			if (hauntsystem.checkConditions(turnsystem.getNumPlayers()).contentEquals("Win") || turnsystem.getCurrentTraitor().isDead())
			{
				//Play sounds;
				SoundEffect.HAUNT.stop();
				SoundEffect.BACKGROUND.stop();
				SoundEffect.BELL3.play();
				SoundEffect.GOODEND.loop();
				
				//Display ending screen and exit button
				wscreen1.setVisible(true);
				wscreen2.setVisible(true);
				btn_exit.setVisible(true);
				
				clickable = false;
				return true;
			}
			else if (hauntsystem.checkConditions(turnsystem.getNumPlayers()).contentEquals("Lose"))
			{
				//Play sounds
				SoundEffect.HAUNT.stop();
				SoundEffect.BELL3.play();
				SoundEffect.BADEND.loop();
				
				//Display ending screen and exit button
				lscreen1.setVisible(true);
				lscreen2.setVisible(true);
				btn_exit.setVisible(true);
				
				clickable = false;
				return true;
			}
			else 
				return false;
			}
			else
				return false;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			
			
			String cmd = e.getActionCommand();
			
			//Scroll to Basement view
			if (BASEMENT_COMMAND.contentEquals(cmd))
			{
				if(clickable)
				{
				scroll.setLimits(998, 256, 1544, 0);
				scroll.getVerticalScrollBar().setValue(768);
				scroll.getHorizontalScrollBar().setValue(512);
				scroll.getViewport().setOpaque(false);
				SoundEffect.CLICK.play();
				}
			}
			
			//Scroll to Ground View
			else if (GROUND_COMMAND.contentEquals(cmd))
			{
				if(clickable)
				{
				scroll.setLimits(998, 256, 3848, 1545);
				scroll.getVerticalScrollBar().setValue(3072);
				scroll.getHorizontalScrollBar().setValue(512);
				scroll.getViewport().setOpaque(false);
				SoundEffect.CLICK.play();
				}
			}
			
			//Scroll to Upper Panel view
			else if (UPPER_COMMAND.contentEquals(cmd))
			{
				if(clickable)
				{
				scroll.setLimits(998, 256, 9216, 3845);
				scroll.getVerticalScrollBar().setValue(5376);
				scroll.getHorizontalScrollBar().setValue(512);
				scroll.getViewport().setOpaque(false);
				SoundEffect.CLICK.play();
				}
			}
			
			//Display Move popup
			else if (MOVE_COMMAND.contentEquals(cmd))
			{
				if(clickable)
				{
				SoundEffect.CLICK.play();
				move_popup_panel.setVisible(true);
				clickable = false;
				}
			}
		
			//Close Move Popup w/o choice
			else if (CANCEL_MOVE_COMMAND.contentEquals(cmd))
			{
				//move_popup.hide();
				move_popup_panel.setVisible(false);;
				SoundEffect.CLICK.play();
				clickable = true;
			}
			
			/**
			 * Confirm rotate works by getting the current tile from the rotate panel.
			 * this is then double checked to make sure it's a valid exit for redundancy
			 * It also does a double check to make sure it's in bounds.
			 * If all conditions are met it draws the tile, moves the Token, and resets the MoveMenu
			 * for the new room location.
			 */
			else if (CONFIRM_ROTATE_COMMAND.contentEquals(cmd))
			{
				
				//rotate_popup.hide();
				rotate_popup_panel.setVisible(false);
				rotatedTile=rotate_popup_panel.getTileRotatePanel().getCurrentTile();
				
				
				//North Solution
				if (dirmove.equals(Direction.NORTH))
				{
					bgPanel.drawTile(rotatedTile, turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()-1);
					
					if(!bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()-1).getTile().getRoom().getName().contentEquals("Blank") && (turnsystem.getCurrentPlayer().getToken().getRoomy()-1 != 8 || turnsystem.getCurrentPlayer().getToken().getRoomy()-1 != 17))
					{
						if(bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()-1).getTile().getRoom().getExits().contains(Direction.SOUTH))
							housetokens.moveToken(bgPanel, tokenmap, tiledeck, turnsystem.getCurrentPlayer().getToken(), turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy(), turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()-1);
					}
					resetMoveMenu();
					clickable = true;
				}
				
				//South Move confirm
				else if (dirmove.equals(Direction.SOUTH))
				{
					bgPanel.drawTile(rotatedTile, turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()+1);
				
					if(!bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()+1).getTile().getRoom().getName().contentEquals("Blank") && (turnsystem.getCurrentPlayer().getToken().getRoomy()+1 != 9 || turnsystem.getCurrentPlayer().getToken().getRoomy()+1 != 18 || turnsystem.getCurrentPlayer().getToken().getRoomy()+1 !=27))
					{
						if(bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()+1).getTile().getRoom().getExits().contains(Direction.NORTH))
							housetokens.moveToken(bgPanel, tokenmap, tiledeck, turnsystem.getCurrentPlayer().getToken(), turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy(), turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()+1);
					}
					resetMoveMenu();
					clickable = true;
				}
				
				//East Move confirm
				else if (dirmove.equals(Direction.EAST))
				{
					bgPanel.drawTile(rotatedTile, turnsystem.getCurrentPlayer().getToken().getRoomx()+1, turnsystem.getCurrentPlayer().getToken().getRoomy());
			
					if(!bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx()+1, turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName().contentEquals("Blank") && turnsystem.getCurrentPlayer().getToken().getRoomx()+1 != 10)
					{
						if(bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx()+1, turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getExits().contains(Direction.WEST))
							housetokens.moveToken(bgPanel, tokenmap, tiledeck, turnsystem.getCurrentPlayer().getToken(), turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy(), turnsystem.getCurrentPlayer().getToken().getRoomx()+1, turnsystem.getCurrentPlayer().getToken().getRoomy());
					}
					resetMoveMenu();
					clickable = true;
				}
				
				//West Move confirm
				else if (dirmove.equals(Direction.WEST))
				{
					bgPanel.drawTile(rotatedTile, turnsystem.getCurrentPlayer().getToken().getRoomx()-1, turnsystem.getCurrentPlayer().getToken().getRoomy());
				
					if(!bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx()-1, turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName().contentEquals("Blank") && turnsystem.getCurrentPlayer().getToken().getRoomx()-1 != 0)
					{
						if(bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx()-1, turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getExits().contains(Direction.EAST))
						housetokens.moveToken(bgPanel, tokenmap, tiledeck, turnsystem.getCurrentPlayer().getToken(), turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy(), turnsystem.getCurrentPlayer().getToken().getRoomx()-1, turnsystem.getCurrentPlayer().getToken().getRoomy());
					}
					resetMoveMenu();
					clickable = true;
				}
				
				/**
				 * 
				 * This section checks the new room's type and calls the appropriate popup menu.
				 * 
				 */
				
				if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(),turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getType().contains(Type.EVENT))
				{
					SoundEffect.EVENT.play();
					clickable = false;
					resetEventMenu();
					events_popup_panel.setVisible(true);
					turnsystem.getCurrentPlayer().playEvent();
					clickable = false;
				}
				else if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(),turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getType().contains(Type.OMEN))
				{
					SoundEffect.OMEN.play();
					clickable = false;
					resetOmenMenu();
					omens_popup_panel.setVisible(true);
					turnsystem.getCurrentPlayer().playOmen();
					clickable = false;
				}
				else if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(),turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getType().contains(Type.ITEM))
				{
					SoundEffect.ITEM.play();
					clickable = false;
					resetItemMenu();
					items_popup_panel.setVisible(true);
					turnsystem.getCurrentPlayer().playItem();
					clickable = false;
				}
				else
				{
					SoundEffect.FOOTSTEPS.play();
				}
				
				//Check some edge case stuff
				//Set XY for Stairs
				if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Stairs from Basement")
				{
					stairsfrombasementx = turnsystem.getCurrentPlayer().getToken().getRoomx();
					stairsfrombasementy = turnsystem.getCurrentPlayer().getToken().getRoomy();
					bgPanel.getTile(5, 13).getTile().getRoom().addType(Type.DOWN);
				}
				//Set XY for ballroom
				if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Ballroom")
				{
					ballroomx = turnsystem.getCurrentPlayer().getToken().getRoomx();
					ballroomy = turnsystem.getCurrentPlayer().getToken().getRoomy();
					//edit gallery if already on board
					if (galleryx != 0)
						bgPanel.getTile(galleryx, galleryy).getTile().getRoom().addType(Type.DOWN);
				}
				//Set XY for Gallery
				if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Gallery")	
				{
					ballroomx = turnsystem.getCurrentPlayer().getToken().getRoomx();
					ballroomy = turnsystem.getCurrentPlayer().getToken().getRoomy();
					//edit gallery if ballroom already on board
					if (ballroomx != 0)
						bgPanel.getTile(galleryx, galleryy).getTile().getRoom().addType(Type.DOWN);
				}
				
				//Drop from Coal Chute
				if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Coal Chute")
				{
					housetokens.moveToken(bgPanel, tokenmap, tiledeck, turnsystem.getCurrentPlayer().getToken(), turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy(), 5, 4);
					turnsystem.getCurrentPlayer().playFall();
					resetMoveMenu();
					clickable = true;
				}
			
				
				
			}
			else if (ROTATE_COMMAND.contentEquals(cmd))
			{
				SoundEffect.CLICK.play();
				rotate_popup_panel.nextCard();
				
			}
			else if (UP_COMMAND.contentEquals(cmd))
			{
				clickable  = true;
				move_popup_panel.setVisible(false);
				SoundEffect.CLICK.play();
				dirmove = null;
				dirmove = Direction.NORTH;
				
				
				if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Grand Staircase")
					housetokens.moveToken(bgPanel, tokenmap, tiledeck, turnsystem.getCurrentPlayer().getToken(), turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy(), 5, 22);
				else if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Stairs from Basement")
					housetokens.moveToken(bgPanel, tokenmap, tiledeck, turnsystem.getCurrentPlayer().getToken(), turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy(), 5, 13);
				
				SoundEffect.FOOTSTEPS.play();
			
				resetMoveMenu();
				clickable = true;
			}
			else if (DOWN_COMMAND.contentEquals(cmd))
			{
				clickable = true;
				move_popup_panel.setVisible(false);
				SoundEffect.CLICK.play();
				dirmove = null;
				dirmove = Direction.NORTH;
				
				if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Foyer" && stairsfrombasementy!=0)
					housetokens.moveToken(bgPanel, tokenmap, tiledeck, turnsystem.getCurrentPlayer().getToken(), turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy(), stairsfrombasementx, stairsfrombasementy);
				else if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Upper Landing")
					housetokens.moveToken(bgPanel, tokenmap, tiledeck, turnsystem.getCurrentPlayer().getToken(), turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy(), 4, 13);
				else if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Gallery" && ballroomy!=0)
				{
					turnsystem.getCurrentPlayer().getCharacter().decrementMight();
					turnsystem.getCurrentPlayer().playFall();
					resetMoveMenu();
				}
				
				SoundEffect.FOOTSTEPS.play();
				//	}
				//}
				resetMoveMenu();
				clickable = true;
			}
			
			else if (NORTH_COMMAND.contentEquals(cmd))
			{
				
				move_popup_panel.setVisible(false);
				SoundEffect.CLICK.play();
				dirmove = null;
				dirmove = Direction.NORTH;
				//If tile is empty, get new tile
				if (checkExit() && movesleft > 0)
				{
				if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()-1).getName().contentEquals("Blank") && !tiledeck.deckEmpty(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()-1))
				{
					TileGui testtile = tiledeck.fetchTile(bgPanel, turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()-1);	
					resetRotateMenu(testtile,Direction.NORTH);
					rotate_popup_panel.setVisible(true);
					clickable = false;
					movesleft--;
					resetBottomLog();
					
				}
				
				else if(!bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()-1).getTile().getRoom().getName().contentEquals("Blank") && (turnsystem.getCurrentPlayer().getToken().getRoomy()-1 != 8 || turnsystem.getCurrentPlayer().getToken().getRoomy()-1 != 17))
				{
					if(bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()-1).getTile().getRoom().getExits().contains(Direction.SOUTH))
					{
						housetokens.moveToken(bgPanel, tokenmap, tiledeck, turnsystem.getCurrentPlayer().getToken(), turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy(), turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()-1);
						SoundEffect.FOOTSTEPS.play();
						movesleft--;
						resetBottomLog();
						clickable = true;
					}
				}
					
				resetMoveMenu();
				
				//Drop from Coal Chute
				if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Coal Chute")
				{
					housetokens.moveToken(bgPanel, tokenmap, tiledeck, turnsystem.getCurrentPlayer().getToken(), turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy(), 5, 4);
					turnsystem.getCurrentPlayer().playFall();
					resetMoveMenu();
					clickable = true;
				}
				//Drop from Collapsed
				if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Collapsed Room" && clickable) 
				{
					if (turnsystem.getCurrentPlayer().getCharacter().traitRoll(turnsystem.getCurrentPlayer().getCharacter().getSpeed()) < 5)
					{
						housetokens.moveToken(bgPanel, tokenmap, tiledeck, turnsystem.getCurrentPlayer().getToken(), turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy(), 5, 4);
						turnsystem.getCurrentPlayer().playFall();
						resetMoveMenu();
						clickable = true;
					}
				}
				}
				else
					clickable = true;
				
			}
			else if (SOUTH_COMMAND.contentEquals(cmd))
			{
				
				move_popup_panel.setVisible(false);
				SoundEffect.CLICK.play();
				dirmove = null;
				dirmove = Direction.SOUTH;
				if (checkExit() && movesleft > 0)
				{
				if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()+1).getName().contentEquals("Blank") && !tiledeck.deckEmpty(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()+1))
				{
					TileGui testtile = tiledeck.fetchTile(bgPanel, turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()+1);	
					resetRotateMenu(testtile,Direction.SOUTH);
					rotate_popup_panel.setVisible(true);
					clickable = false;
					movesleft--;
					resetBottomLog();
				}
				else if(!bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()+1).getTile().getRoom().getName().contentEquals("Blank") && (turnsystem.getCurrentPlayer().getToken().getRoomy()+1 != 9 || turnsystem.getCurrentPlayer().getToken().getRoomy()+1 != 18 || turnsystem.getCurrentPlayer().getToken().getRoomy()+1 !=27))
				{
					if(bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()+1).getTile().getRoom().getExits().contains(Direction.NORTH))
					{
						housetokens.moveToken(bgPanel, tokenmap, tiledeck, turnsystem.getCurrentPlayer().getToken(), turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy(), turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()+1);
						SoundEffect.FOOTSTEPS.play();
						movesleft--;
						resetBottomLog();
						clickable = true;
					}
				}
				resetMoveMenu();
				
				//Drop from Coal Chute
				if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Coal Chute")
				{
					housetokens.moveToken(bgPanel, tokenmap, tiledeck, turnsystem.getCurrentPlayer().getToken(), turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy(), 5, 4);
					turnsystem.getCurrentPlayer().playFall();
					resetMoveMenu();
					clickable = true;
				}
				//Drop from Collapsed
				if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Collapsed Room" && clickable) 
				{
					if (turnsystem.getCurrentPlayer().getCharacter().traitRoll(turnsystem.getCurrentPlayer().getCharacter().getSpeed()) < 5)
					{
						housetokens.moveToken(bgPanel, tokenmap, tiledeck, turnsystem.getCurrentPlayer().getToken(), turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy(), 5, 4);
						turnsystem.getCurrentPlayer().playFall();
						resetMoveMenu();
						clickable = true;
					}
				}
				}
				else
					clickable = true;

			}
			else if (EAST_COMMAND.contentEquals(cmd))
			{
				
				//move_popup.hide();
				
				move_popup_panel.setVisible(false);
				SoundEffect.CLICK.play();
				dirmove = null;
				dirmove = Direction.EAST;
				if (checkExit() && movesleft > 0)
				{
				if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx()+1, turnsystem.getCurrentPlayer().getToken().getRoomy()).getName().contentEquals("Blank") && !tiledeck.deckEmpty(turnsystem.getCurrentPlayer().getToken().getRoomx()+1, turnsystem.getCurrentPlayer().getToken().getRoomy()) )
				{
					TileGui testtile = tiledeck.fetchTile(bgPanel, turnsystem.getCurrentPlayer().getToken().getRoomx()+1, turnsystem.getCurrentPlayer().getToken().getRoomy());	
					resetRotateMenu(testtile,Direction.EAST);
					rotate_popup_panel.setVisible(true);
					clickable = false;
					movesleft--;
					resetBottomLog();
				}
				
				else if(!bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx()+1, turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName().contentEquals("Blank") && turnsystem.getCurrentPlayer().getToken().getRoomx()+1 != 10)
				{
					if(bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx()+1, turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getExits().contains(Direction.WEST))
					{
						housetokens.moveToken(bgPanel, tokenmap, tiledeck, turnsystem.getCurrentPlayer().getToken(), turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy(), turnsystem.getCurrentPlayer().getToken().getRoomx()+1, turnsystem.getCurrentPlayer().getToken().getRoomy());
						SoundEffect.FOOTSTEPS.play();
						movesleft--;
						resetBottomLog();
						clickable = true;
					}
				}
				resetMoveMenu();
				
				//Drop from Coal Chute
				if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Coal Chute")
				{
					housetokens.moveToken(bgPanel, tokenmap, tiledeck, turnsystem.getCurrentPlayer().getToken(), turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy(), 5, 4);
					turnsystem.getCurrentPlayer().playFall();
					resetMoveMenu();
					clickable = true;
				}
				//Drop from Collapsed
				if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Collapsed Room" && clickable) 
				{
					if (turnsystem.getCurrentPlayer().getCharacter().traitRoll(turnsystem.getCurrentPlayer().getCharacter().getSpeed()) < 5)
					{
						housetokens.moveToken(bgPanel, tokenmap, tiledeck, turnsystem.getCurrentPlayer().getToken(), turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy(), 5, 4);
						turnsystem.getCurrentPlayer().playFall();
						resetMoveMenu();
						clickable = true;
					}
				}
				}
				else
					clickable = true;
			}
			else if (WEST_COMMAND.contentEquals(cmd))
			{
				
				move_popup_panel.setVisible(false);
				SoundEffect.CLICK.play();
				dirmove = null;
				dirmove = Direction.WEST;
				//Exit 
				if (checkExit() && movesleft > 0)
				{
				if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx()-1, turnsystem.getCurrentPlayer().getToken().getRoomy()).getName().contentEquals("Blank") && !tiledeck.deckEmpty(turnsystem.getCurrentPlayer().getToken().getRoomx()-1, turnsystem.getCurrentPlayer().getToken().getRoomy()) )
				{
		
					TileGui testtile = tiledeck.fetchTile(bgPanel, turnsystem.getCurrentPlayer().getToken().getRoomx()-1, turnsystem.getCurrentPlayer().getToken().getRoomy());	
					resetRotateMenu(testtile,Direction.WEST);
					rotate_popup_panel.setVisible(true);
					clickable = false;
					movesleft--;
					resetBottomLog();
				}
				else if(!bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx()-1, turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName().contentEquals("Blank") && turnsystem.getCurrentPlayer().getToken().getRoomx()-1 != 0)
				{
					if(bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx()-1, turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getExits().contains(Direction.EAST))
					{
						housetokens.moveToken(bgPanel, tokenmap, tiledeck, turnsystem.getCurrentPlayer().getToken(), turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy(), turnsystem.getCurrentPlayer().getToken().getRoomx()-1, turnsystem.getCurrentPlayer().getToken().getRoomy());
						SoundEffect.FOOTSTEPS.play();
						movesleft--;
						resetBottomLog();
						clickable = true;
					}
				}
				resetMoveMenu();
				
				//Drop from Coal Chute
				if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Coal Chute")
				{
					housetokens.moveToken(bgPanel, tokenmap, tiledeck, turnsystem.getCurrentPlayer().getToken(), turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy(), 5, 4);
					turnsystem.getCurrentPlayer().playFall();
					resetMoveMenu();
					clickable = true;
				}
				//Drop from Collapsed
				if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Collapsed Room" && clickable) 
				{
					if (turnsystem.getCurrentPlayer().getCharacter().traitRoll(turnsystem.getCurrentPlayer().getCharacter().getSpeed()) < 5)
					{
						housetokens.moveToken(bgPanel, tokenmap, tiledeck, turnsystem.getCurrentPlayer().getToken(), turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy(), 5, 4);
						turnsystem.getCurrentPlayer().playFall();
						resetMoveMenu();
						clickable = true;
					}
				}
				}
				else
					clickable = true;
				
			}
			else if (END_TURN_COMMAND.contentEquals(cmd))
			{
				
				if(clickable)
				{
					SoundEffect.CLICK.play();
				//---------Perform room check for edge cases-------
				
				//Stat Rooms
				if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Library" && !turnsystem.getCurrentPlayer().isGainedKnowledge())
				{
					turnsystem.getCurrentPlayer().getCharacter().incrementKnowledge();
					turnsystem.getCurrentPlayer().setGainedKnowledge(true);
					//turnsystem.getCurrentPlayer().playHeal();
				}
				else if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Chapel" && !turnsystem.getCurrentPlayer().isGainedSanity())
				{
					
					turnsystem.getCurrentPlayer().getCharacter().incrementSanity();
					turnsystem.getCurrentPlayer().setGainedSanity(true);
					//turnsystem.getCurrentPlayer().playHeal();
				}
				else if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Gymnasium" && !turnsystem.getCurrentPlayer().isGainedSpeed())
				{
					turnsystem.getCurrentPlayer().getCharacter().incrementSpeed();
					turnsystem.getCurrentPlayer().setGainedSpeed(true);
					//turnsystem.getCurrentPlayer().playHeal();
				}
				else if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Larder" && !turnsystem.getCurrentPlayer().isGainedMight())
				{
					turnsystem.getCurrentPlayer().getCharacter().incrementMight();
					turnsystem.getCurrentPlayer().setGainedMight(true);
					//turnsystem.getCurrentPlayer().playHeal();
				}
				
				//Pain Rooms
				else if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Crypt")
				{
					if (!turnsystem.getCurrentPlayer().isHasAmulet())
					{
						turnsystem.getCurrentPlayer().getCharacter().decrementSanity();
						turnsystem.getCurrentPlayer().playHurt();
					}
				}
				else if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName() == "Furnace Room")
				{
						turnsystem.getCurrentPlayer().getCharacter().decrementMight();
						turnsystem.getCurrentPlayer().playHurt();
				}
				//
				
				
				
				if (turnsystem.getCurrentPlayer().isDead())
				{
					turnsystem.getCurrentPlayer().playDeath();
					turnsystem.getCurrentPlayer().getCharacter().setDeadIcon();
					turnsystem.getCurrentPlayer().setCheckedDead(true);
					hauntsystem.increaseDead();
				}
				
				
				resetPlayerPanel();
				
				//If Haunt active buff traitor
				if(hauntActive)
				{
					if(turnsystem.getCurrentPlayer().getPlayerNum() == turnsystem.getCurrentTraitor().getPlayerNum())
					{
						turnsystem.getCurrentPlayer().getCharacter().incrementKnowledge();
						turnsystem.getCurrentPlayer().getCharacter().incrementMight();
						turnsystem.getCurrentPlayer().getCharacter().incrementSpeed();
						turnsystem.getCurrentPlayer().getCharacter().incrementSanity();
					}
				}
				
				//Check if game is over and end turn
				turnsystem.endTurn(checkEnd());
				
				//reset injuries
				turnsystem.getCurrentPlayer().getCharacter().setInjured(false);
				turnsystem.getCurrentPlayer().getCharacter().setHealed(false);
				resetTurnPopup();
				movesleft = turnsystem.getCurrentPlayer().getCharacter().getSpeed();
				resetBottomLog();
				clickable = false;
				
				resetMoveMenu();
				turn_popup_panel.setVisible(true);
				clickable = false;
				attacked = false;
				searched = false;
				
				}
			}
			else if (CONFIRM_EVENT_COMMAND.contentEquals(cmd))
			{
				events_popup_panel.setVisible(false);
				SoundEffect.CLICK.play();
				clickable = true;
				if(turnsystem.getCurrentPlayer().getCharacter().isInjured())
				{
					turnsystem.getCurrentPlayer().getCharacter().setInjured(false);
					turnsystem.getCurrentPlayer().playHurt();
				}
				else if(turnsystem.getCurrentPlayer().getCharacter().isHealed())
				{
					turnsystem.getCurrentPlayer().getCharacter().setHealed(false);
					turnsystem.getCurrentPlayer().playHeal();
				}
				resetPlayerPanel();
				movesleft = 0;
				resetBottomLog();
			}
			else if (CONFIRM_OMEN_COMMAND.contentEquals(cmd))
			{
				omens_popup_panel.setVisible(false);
				SoundEffect.CLICK.play();
				clickable = true;
				if(turnsystem.getCurrentPlayer().getCharacter().isInjured())
				{
					turnsystem.getCurrentPlayer().getCharacter().setInjured(false);
					//turnsystem.getCurrentPlayer().playHurt();
				}
				else if(turnsystem.getCurrentPlayer().getCharacter().isHealed())
				{
					turnsystem.getCurrentPlayer().getCharacter().setHealed(false);
					//turnsystem.getCurrentPlayer().playHeal();
				}
				resetPlayerPanel();
				if (!hauntActive)
				{
				increaseOmen();
				resetUpperLog();
				resetDicePanel();
				dice_popup_panel.setVisible(true);
				clickable = false;
				SoundEffect.DICE.play();
				}
				movesleft = 0;
				resetBottomLog();
				
			}
			else if (CONFIRM_ITEM_COMMAND.contentEquals(cmd))
			{
				items_popup_panel.setVisible(false);
				SoundEffect.CLICK.play();
				clickable = true;
				if(turnsystem.getCurrentPlayer().getCharacter().isInjured())
				{
					turnsystem.getCurrentPlayer().getCharacter().setInjured(false);
					turnsystem.getCurrentPlayer().playHurt();
				}
				else if(turnsystem.getCurrentPlayer().getCharacter().isHealed())
				{
					turnsystem.getCurrentPlayer().getCharacter().setHealed(false);
					turnsystem.getCurrentPlayer().playHeal();
				}
				resetPlayerPanel();
				movesleft = 0;
				resetBottomLog();
			}
			else if (CONFIRM_DICE_COMMAND.contentEquals(cmd))
			{
				SoundEffect.CLICK.play();
				SoundEffect.BELL1.play();
				dice_popup_panel.setVisible(false);
				clickable = true;
			}
			else if (CONFIRM_DICEOMEN_COMMAND.contentEquals(cmd))
			{
				SoundEffect.CLICK.play();
				dice_popup_panel.setVisible(false);
				clickable = true;
				hauntActive = true;
				hauntRules.setVisible(true);
				clickable = false;
				SoundEffect.BACKGROUND.stop();
				SoundEffect.BELL2.play();
				SoundEffect.HAUNT.loop();
				setHaunt();
				turnsystem.setCurrentTraitor(turnsystem.getCurrentPlayer());
				resetUpperLog();
				btn_action.setVisible(true);
			}
			else if (CONFIRM_TURN_COMMAND.contentEquals(cmd))
			{
				SoundEffect.CLICK.play();
				turn_popup_panel.setVisible(false);
				clickable = true;
			}
			else if (CONFIRM_RULES_COMMAND.contentEquals(cmd))
			{
				SoundEffect.CLICK.play();
				rulesPanel.setVisible(false);
				clickable = true;
				
				//End turn to start 1st player's turn
				resetPlayerPanel();
				turnsystem.endTurn(false);
				turnsystem.getCurrentPlayer().getCharacter().setInjured(false);
				turnsystem.getCurrentPlayer().getCharacter().setHealed(false);
				resetTurnPopup();
				movesleft = turnsystem.getCurrentPlayer().getCharacter().getSpeed();
				resetBottomLog();
				//clickable = false;
				resetMoveMenu();
				turn_popup_panel.setVisible(true);
			}
			else if (CONFIRM_HAUNT_COMMAND.contentEquals(cmd))
			{
				SoundEffect.CLICK.play();
				hauntRules.setVisible(false);
				clickable = true;
			}
			else if (ACTION_COMMAND.contentEquals(cmd))
			{
				SoundEffect.CLICK.play();
				if(clickable && hauntActive && roomCheck() && !searched && (turnsystem.getCurrentPlayer().getPlayerNum() != turnsystem.getCurrentTraitor().getPlayerNum()))
				{
					if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName().equals("Master Bedroom") && !hauntsystem.isHeart())
					{
						if (turnsystem.getCurrentPlayer().getCharacter().traitRoll(turnsystem.getCurrentPlayer().getCharacter().getMight()) >= 3)
						{
							hauntsystem.setHeart(true);
							resetTextPop(turnsystem.getCurrentPlayer().getCharacter().getfName() + " managed to find and destroy the heart! The house groans in agony.");
							text_popup_panel.setVisible(true);
							clickable = false;
							SoundEffect.HEART.play();
						}
						else
						{
							resetTextPop(turnsystem.getCurrentPlayer().getCharacter().getfName() + " couldn't seem to find the heart....");
							text_popup_panel.setVisible(true);
							clickable = false;
							turnsystem.getCurrentPlayer().playHmm();
						}
						searched = true;
					}
					
					else if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName().equals("Operating Laboratory") && !hauntsystem.isBrain())
					{
						if (turnsystem.getCurrentPlayer().getCharacter().traitRoll(turnsystem.getCurrentPlayer().getCharacter().getKnowledge()) >= 3)
						{
							hauntsystem.setBrain(true);
							resetTextPop(turnsystem.getCurrentPlayer().getCharacter().getfName() + " found the brain in a jar and smashed it! The house rumbles and shakes.");
							text_popup_panel.setVisible(true);
							clickable = false;
							SoundEffect.GLASS.play();
						}
						else
						{
							resetTextPop(turnsystem.getCurrentPlayer().getCharacter().getfName() + " couldn't seem to find the brain....");
							text_popup_panel.setVisible(true);
							clickable = false;
							turnsystem.getCurrentPlayer().playHmm();
						}
						searched = true;
					}
					
					else if (bgPanel.getTile(turnsystem.getCurrentPlayer().getToken().getRoomx(), turnsystem.getCurrentPlayer().getToken().getRoomy()).getTile().getRoom().getName().equals("Furnace Room") && !hauntsystem.isFurnace())
					{
						if (turnsystem.getCurrentPlayer().getCharacter().traitRoll(turnsystem.getCurrentPlayer().getCharacter().getMight()) >= 3)
						{
							hauntsystem.setFurnace(true);
							resetTextPop(turnsystem.getCurrentPlayer().getCharacter().getfName() + " managed to set the furnace ablaze! The heat is overwhelming!");
							text_popup_panel.setVisible(true);
							clickable = false;
							SoundEffect.FURNACE.play();
						}
						else
						{
							resetTextPop(turnsystem.getCurrentPlayer().getCharacter().getfName() + " couldn't seem to get the fire hot enough....");
							text_popup_panel.setVisible(true);
							clickable = false;
							turnsystem.getCurrentPlayer().playHmm();
						}
						searched = true;
					}
				}
				
				
				
				if(clickable && hauntActive && !roomCheck())
				{
					//Attacks for non traitor
					if (turnsystem.getCurrentPlayer().getPlayerNum() != turnsystem.getCurrentTraitor().getPlayerNum())
					{
						if ((turnsystem.getCurrentPlayer().getToken().getRoomx() == turnsystem.getCurrentTraitor().getToken().getRoomx()) && (turnsystem.getCurrentPlayer().getToken().getRoomy() == turnsystem.getCurrentTraitor().getToken().getRoomy()) && (!attacked))
						{
							resetTextPop(attacksystem.playerattack(turnsystem.getCurrentPlayer(), turnsystem.getCurrentTraitor()));
							text_popup_panel.setVisible(true);
							clickable = false;
							clickable = false;
							attacked = true;
							extra = turnsystem.getCurrentTraitor().getPlayerNum();
							resetPlayerPanel();
							extra = 0;
						}
					}
					//Attacks for traitor
					else if (turnsystem.getCurrentPlayer().getPlayerNum() == turnsystem.getCurrentTraitor().getPlayerNum())
					{
						int skip = turnsystem.getCurrentTraitor().getPlayerNum()-1;
						
						for(int i = 0; i < turnsystem.getNumPlayers(); ++i)
						{
						if ((turnsystem.getPlayer(i).getToken().getRoomx() == turnsystem.getCurrentTraitor().getToken().getRoomx()) && (turnsystem.getPlayer(i).getToken().getRoomy() == turnsystem.getCurrentTraitor().getToken().getRoomy()) && (!attacked) && i!=skip && !turnsystem.getPlayer(i).isDead())
						{
							resetTextPop(attacksystem.playerattack(turnsystem.getCurrentPlayer(), turnsystem.getPlayer(i)));
							text_popup_panel.setVisible(true);
							clickable = false;
							clickable = false;
							attacked = true;
							extra = i+1;
							resetPlayerPanel();
							extra = 0;
						}
						}
					}
				}
			}
			else if (CONFIRM_TEXT_COMMAND.contentEquals(cmd))
			{
				SoundEffect.CLICK.play();
				clickable = true;
				text_popup_panel.setVisible(false);
			}
			else if (EXIT_COMMAND.contentEquals(cmd))
			{
				SoundEffect.CLICK.play();
				frame.setVisible(false);
				SoundEffect.BACKGROUND.stop();
				SoundEffect.HAUNT.stop();
				SoundEffect.BADEND.stop();
				SoundEffect.GOODEND.stop();
				System.exit(0);
			}
		}
		
		private static JFrame frame;
	private static void createAndShowGUI() {
		frame = new JFrame("Betrayal at House on the Hill");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		 //Create and set up the content pane.
		 JComponent newContentPane = new GameBoard();
		 newContentPane.setOpaque(true); //content panes must be opaque
		 frame.setContentPane(newContentPane);
		 frame.setBackground(Color.black);
		 ImageIcon gameicon = new ImageIcon(GameBoard.class.getResource("/res/objects/gameicon.png"));
		 frame.setIconImage(gameicon.getImage());
		 //Display the window.
	
		 frame.setSize(1920,1080);
		 frame.setVisible(true);
		 //loadFrame.setVisible(false);
		 
	}
		   
		   public void mousePressed(MouseEvent e)
		   {

		   }
		   
		   
		   public void mouseReleased(MouseEvent e)
		   {
			   //drag = false;
				   
		   }
		   
		   public void mouseMoved(MouseEvent e) {
		   }
		   
		
		   public void mouseEntered(MouseEvent e) {}
		   public void mouseExited(MouseEvent e) {}
		   public void mouseClicked(MouseEvent e) {}
		   
		   public void mouseDragged(MouseEvent e) {
		    
			  
		   } //do nothing

	//Stop sound on window Close
	public void windowClosing(WindowEvent e)
	{
		frame.setVisible(false);
		SoundEffect.BACKGROUND.stop();
		SoundEffect.HAUNT.stop();
		SoundEffect.BADEND.stop();
		SoundEffect.GOODEND.stop();
		System.exit(0);
	}
	
	private static JFrame loadFrame;
	//JLabels for loading stuff....
	
	private static JLabel load = textbox("Loading Game . . . . .", 26);
	private static JLabel charload = textbox("Researching player backgrounds. . . . . .", 26);
	private static JLabel roomload = textbox("        Building Rooms. . . . . .", 26);
	private static JLabel tileload = textbox("      Constructing House. . . .", 26);
	private static JLabel load1 = textbox("         Hanging cobwebs. . . . .", 26);
	private static JLabel load2 = textbox("        Summoning spirits. . . . .", 26);
	private static JLabel load3 = textbox("     Hiding Secret Passages. . . . .", 26);
	private static JLabel load4 = textbox("            Finished Loading!         ", 26);
	private static JLabel load5 = textbox("Entering the House...", 26);
	
	private static void loadingFrame() {
		//Create and set up the window.
		loadFrame = new JFrame("LOADING");
		loadFrame.setUndecorated(true);
		loadFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		 //Create and set up the content pane.
		 
		 loadFrame.setBackground(Color.black);
		 
		 ImageIcon gameicon = new ImageIcon(GameBoard.class.getResource("/res/gui/popup.png"));
		 loadFrame.setIconImage(gameicon.getImage());
		 //Display the window.
		 
		
		
		 JPanel loadPanel = new ImagePanel(gameicon);
		 loadPanel.setBackground(Color.black);
		 loadPanel.setSize(512, 512);
		 loadPanel.setBounds(0,0,512,512);
		 loadPanel.setVisible(true);
		 loadPanel.add(load);
		 loadPanel.add(charload);
		 charload.setVisible(false);
		 loadPanel.add(roomload);
		 roomload.setVisible(false);
		 loadPanel.add(load1);
		 loadPanel.add(tileload);
		 tileload.setVisible(false);
		 
		 load1.setVisible(false);
		 loadPanel.add(load3);
		 load2.setVisible(false);
		 loadPanel.add(load2);
		 load3.setVisible(false);
		 loadPanel.add(load4);
		 load4.setVisible(false);
		 loadPanel.add(load5);
		 load5.setVisible(false);
		 JComponent newContentPane = loadPanel;
		 newContentPane.setOpaque(true);
		 loadFrame.setContentPane(newContentPane);
		 
		 loadFrame.setSize(gameicon.getIconWidth(),gameicon.getIconHeight());
		 loadFrame.setBounds(960-gameicon.getIconWidth()/2, 540-gameicon.getIconHeight()/2, gameicon.getIconWidth(), gameicon.getIconHeight());
		 loadFrame.setVisible(true);
		 
		 
	}
	
	//Short method for texboxes
	private static JLabel textbox(String str, int size) 
	{
		JLabel text = new JLabel();
		text.setFont(new Font("Letter Gothic", Font.PLAIN, size));
		text.setForeground(Color.WHITE);
		text.setText("<html><div style='text-align: left;'>" + str + "</div></html>");
		
		return text;
	}
	public static void game(String[] args, int num)
	//public static void main(String[] args) //Alternate main for quickstart if needed
	{
		SoundEffect.BACKGROUND.loop();
		//loadingFrame();
	
		playerinput = args;
		passcount = num;
		
		/*
		 * This is left in for a quick start if needed.
		 *
		 */
		/*
		playerinput[0]  = "Darrin";
		playerinput[1]  = "Zoe";
		playerinput[2]  = "Brandon";
		playerinput[3]  = "Jenny";
		playerinput[4]  = "Blank";
		playerinput[5]  = "Blank";
		passcount = 4;
		*/
		createAndShowGUI();
		
	}
}
