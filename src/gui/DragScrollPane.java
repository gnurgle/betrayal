/**
 * 
 * ScrollPane modified to use click dragging 
 * Includes limits to restrict areas of scrolling
 */

package gui;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

public class DragScrollPane extends JScrollPane {

	//Set limits of ScrollPane
	private int limitx1;
	private int limitx2;
	private int limity1;
	private int limity2;
	
	//Extends JScrollPane
    public DragScrollPane(JComponent objectToMove) {
        super(objectToMove);
        ViewportDragScrollListener l = new ViewportDragScrollListener(
                objectToMove, false);
        JViewport gridScrollPaneViewport = getViewport();
        gridScrollPaneViewport.addMouseMotionListener(l);
        gridScrollPaneViewport.addMouseListener(l);
        gridScrollPaneViewport.addHierarchyListener(l);
        
    }
    
    //Set limits to viewports
    public void setLimits(int x1,int x2,int y1,int y2)
    {
    	this.limitx1 = x1;
    	this.limitx2 = x2;
    	this.limity1 = y1;
    	this.limity2 = y2;
    }
    
    //Sync mouse movement to viewport position
    class ViewportDragScrollListener extends MouseAdapter implements
            HierarchyListener {
        private static final int SPEED = 4;
        private static final int DELAY = 10;
        private final Cursor dc;
        private final Cursor hc = Cursor
                .getPredefinedCursor(Cursor.HAND_CURSOR);
        private final javax.swing.Timer scroller;
        private final JComponent label;
        private final Point startPt = new Point();
        private final Point move = new Point();
        private boolean autoScroll = false;

        public ViewportDragScrollListener(JComponent comp, boolean autoScroll) {
        
        	this.label = comp;
            this.autoScroll = autoScroll;
            this.dc = comp.getCursor();
            this.scroller = new javax.swing.Timer(DELAY, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JViewport vport = (JViewport) label.getParent();
                    
                    Point vp = vport.getViewPosition();
                    vp.translate(move.x, move.y);
                    label.scrollRectToVisible(new Rectangle(vp, vport.getSize()));
                }
            });
        }
        
        //Check for changes
        public void hierarchyChanged(HierarchyEvent e) {
            JComponent c = (JComponent) e.getSource();
            if ((e.getChangeFlags() & HierarchyEvent.DISPLAYABILITY_CHANGED) != 0
                    && !c.isDisplayable() && autoScroll) {
                scroller.stop();
            }
        }
        
        //Set mousedrag to move viewport within limits
        @Override
        public void mouseDragged(MouseEvent e) {
            JViewport vport = (JViewport) e.getSource();
           
            Point pt = e.getPoint();
            int dx = startPt.x - pt.x;
            int dy = startPt.y - pt.y;
            Point vp = vport.getViewPosition();
            vp.translate(dx, dy);
            if (vp.getX() <= limitx1 && vp.getX() >= limitx2 && vp.getY() <= limity1 && vp.getY() >= limity2)
            {
            label.scrollRectToVisible(new Rectangle(vp, vport.getSize()));
            move.setLocation(SPEED * dx, SPEED * dy);
            startPt.setLocation(pt);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            ((JComponent) e.getSource()).setCursor(hc);
            startPt.setLocation(e.getPoint());
            move.setLocation(0, 0);
            if (autoScroll) {
                scroller.stop();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            ((JComponent) e.getSource()).setCursor(dc);
            if (autoScroll) {
                scroller.start();
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ((JComponent) e.getSource()).setCursor(dc);
            move.setLocation(0, 0);
            if (autoScroll) {
                scroller.stop();
            }
        }
    }
}