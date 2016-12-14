package demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by hcq on 2016/10/27.
 */
public class DrawlerDemo extends JPanel implements MouseListener, MouseMotionListener{
    int x1, x2;
    int y1, y2;

    public DrawlerDemo() {
        super();
        JButton jButton = new JButton("点一下");
    }


    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button is pressed on a component and then
     * dragged.  <code>MOUSE_DRAGGED</code> events will continue to be
     * delivered to the component where the drag originated until the
     * mouse button is released (regardless of whether the mouse position
     * is within the bounds of the component).
     * <p>
     * Due to platform-dependent Drag&amp;Drop implementations,
     * <code>MOUSE_DRAGGED</code> events may not be delivered during a native
     * Drag&amp;Drop operation.
     *
     * @param e
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        if (Math.abs(x2-x1)>0 || Math.abs(y2-y1)>0) {
//            x2 = e.getX();
//            y2 = e.getY();
            int xtmp = x1>x2?x2:x1;
            int ytmp = y1>y2?y2:y1;
            Graphics2D g2d = (Graphics2D) getGraphics();
//            g2d.setClip(xtmp,ytmp,Math.abs(x1-x2),Math.abs(y1-y2));
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2.0f));

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawLine(x1,y1,x2,y2);
//            g2d.fillRect(xtmp,ytmp,Math.abs(x1-x2),Math.abs(y1-y2));
            x1 = x2;
            y1 = y2;
//            repaint();
        }
    }

    /**
     * Invoked when the mouse cursor has been moved onto a component
     * but no buttons have been pushed.
     *
     * @param e
     */
    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("画图板");
        frame.setBounds(0,0,1920,1080);
        frame.setLayout(null);
        DrawlerDemo drawler = new DrawlerDemo();
        drawler.addMouseListener(drawler);
        drawler.addMouseMotionListener(drawler);
        drawler.setBackground(Color.cyan);
        frame.getContentPane().add(drawler);
        drawler.setBounds(0,0,1920,1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
