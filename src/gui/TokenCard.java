//This class is responsible for holding all different possibilities
//of token facings for drawing over the tiles. Naming convention
//is to be used with Token.getName()

package gui;

import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import actors.TokenImages;

public class TokenCard implements ItemListener {
	private CardLayout cardLayout;
	private ImagePanel cardPanel;
	public TokenCard()
	{
		cardPanel = new ImagePanel(new ImageIcon(getClass().getResource("/res/objects/block.png")));
		//=====Initialize all tokens====
		//Blank Token
		ImagePanel Blank = new ImagePanel(TokenImages.Blank_Token);
		ImagePanel Brandon = new ImagePanel(TokenImages.Brandon_Token);
		ImagePanel Darrin = new ImagePanel(TokenImages.Darrin_Token);
		ImagePanel Father = new ImagePanel(TokenImages.Father_Token);
		ImagePanel Heather = new ImagePanel(TokenImages.Heather_Token);
		ImagePanel Jenny = new ImagePanel(TokenImages.Jenny_Token);
		ImagePanel Madame = new ImagePanel(TokenImages.Madame_Token);
		ImagePanel Missy = new ImagePanel(TokenImages.Missy_Token);
		ImagePanel Ox = new ImagePanel(TokenImages.Ox_Token);
		ImagePanel Peter = new ImagePanel(TokenImages.Peter_Token);
		ImagePanel Professor = new ImagePanel(TokenImages.Professor_Token);
		ImagePanel Vivian = new ImagePanel(TokenImages.Vivian_Token);
		ImagePanel Zoe = new ImagePanel(TokenImages.Zoe_Token);
		//ImagePanel Test = new ImagePanel(TokenImages.Test_Token);
		
		
		//Panel for displaying?
		
		//Card Layout
		cardLayout = new CardLayout();
		cardPanel.setLayout(cardLayout);
	
		//Add components to Card Layout
		cardPanel.add(Blank, "Blank");
		cardPanel.add(Brandon, "Brandon");
		cardPanel.add(Darrin, "Darrin");
		cardPanel.add(Father, "Father");
		cardPanel.add(Heather, "Heather");
		cardPanel.add(Jenny, "Jenny");
		cardPanel.add(Madame, "Madame");
		cardPanel.add(Missy, "Missy");
		cardPanel.add(Ox, "Ox");
		cardPanel.add(Peter, "Peter");
		cardPanel.add(Professor, "Professor");
		cardPanel.add(Vivian, "Vivian");
		cardPanel.add(Zoe, "Zoe");
		//cardPanel.add(Test, "Test");
		
		cardLayout.show(cardPanel, "Blank");
	}
	
	public void setCard(String str)
	{
		cardLayout.show(cardPanel, str);
	}
	
	
	
	public ImagePanel getCardPanel() {
		return cardPanel;
	}

	public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cardPanel.getLayout());
        cl.show(cardPanel, (String)evt.getItem());
    }
}