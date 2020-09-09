/**This is a helper function to convert an Icon to an Image
 * This is used primarily in rotating Tiles.
 */

package gui;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class IconToImage
{
	private IconToImage() {}
	
	public static Image convert(Icon icon) {
	   if (icon instanceof ImageIcon) {
	      return ((ImageIcon)icon).getImage();
	   } 
	   else {
	      int w = icon.getIconWidth();
	      int h = icon.getIconHeight();
	      GraphicsEnvironment ge = 
	        GraphicsEnvironment.getLocalGraphicsEnvironment();
	      GraphicsDevice gd = ge.getDefaultScreenDevice();
	      GraphicsConfiguration gc = gd.getDefaultConfiguration();
	      BufferedImage image = gc.createCompatibleImage(w, h);
	      Graphics2D g = image.createGraphics();
	      icon.paintIcon(null, g, 0, 0);
	      g.dispose();
	      return image;
	   }
	 }
}