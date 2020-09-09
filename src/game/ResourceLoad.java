package game;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class  ResourceLoad {
	
	public ResourceLoad()
	{
		
	}
	
	public void LoadResources()
	{
		try {
		     GraphicsEnvironment ge = 
		         GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("/res/fonts/Letter_Gothic.ttf")));
		} catch (IOException|FontFormatException e) {
		     //Handle exception
		}
	}
}
