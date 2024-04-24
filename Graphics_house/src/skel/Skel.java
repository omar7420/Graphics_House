package skel;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import javax.swing.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.ColorConvertOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.LookupOp;
import java.awt.image.LookupTable;
import java.awt.image.RescaleOp;
import java.awt.image.ShortLookupTable;





/**
 *
 * @author eid.emary
 */
public class Skel extends JApplet{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame=new JFrame();
        frame.setTitle("hello");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JApplet applete =new Skel();
        applete.init();
        frame.getContentPane().add(applete);
        frame.pack();
        frame.setVisible(true);
    }
    public void init(){
        JPanel panel=new JApp1Panel();
        getContentPane().add(panel);
    }
    
}
class JApp1Panel extends JPanel implements Runnable {
    
    int stx=1000;
    int sty=1000;
    int ang=360;
    int r=0;
    int w=1;
    int lw=1;
    
    
public JApp1Panel(){
    setPreferredSize(new Dimension(640,480));
    Thread thread=new Thread(this);
    thread.start();
}

public void run()
{
    while(true)
    {
        //update data
        stx-=5;
        sty-=6;
        ang-=5;
        r+=1;
        w+=5;
        lw+=1;
        
        repaint();
    try{
        Thread.sleep(100);
    }
    catch(InterruptedException e){}
    }
}

public void paintComponent(Graphics g){
super.paintComponent(g);
Graphics2D g2=(Graphics2D) g;



g2.translate(100, 100);

BufferedImage bf=null;
try
{
    bf=ImageIO.read(new File("E:\\AOU\\3rd year aou\\Aou 2nd\\TM240\\TMA\\q2\\home3.png"));
}
catch(IOException ee)
{  
}
g2.drawLine(50, 0, 90, 0);
g2.drawLine(50, 0, 50, 50);
g2.drawLine(70, 0, 70, 30);
g2.drawLine(90, 0, 100, 20);
g2.drawLine(300, 20, 360, 100);
g2.drawLine(350, 100, 360, 100);

GeneralPath roof=new GeneralPath();
roof.moveTo(80, 20);
roof.lineTo(300, 20);
roof.lineTo(220, 100);
roof.lineTo(0, 100);
roof.closePath();
g2.draw(roof);

Ellipse2D eside= new Ellipse2D.Double(280,40,25,15);
g2.draw(eside);
GeneralPath side=new GeneralPath();
side.moveTo(200, 100);
side.lineTo(200, 180);
side.lineTo(260, 180);
side.moveTo(290, 180);
side.lineTo(350, 180);
side.lineTo(350, 100);
side.lineTo(295, 25);
g2.draw(side);

Ellipse2D e1bot= new Ellipse2D.Double(260,170,30,30);
g2.draw(e1bot);
GeneralPath e2bot=new GeneralPath();
e2bot.moveTo(270, 200);
e2bot.lineTo(270, 210);
e2bot.lineTo(280, 210);
e2bot.lineTo(280, 200);
g2.draw(e2bot);

Ellipse2D s1=new Ellipse2D.Double(265, 205, 20, 10);
Ellipse2D s2=new Ellipse2D.Double(265, 200, 20, 10);
Area a1=new Area(s1);
Area a2=new Area(s2);
a1.subtract(a2);
g2.draw(a1);

Rectangle2D sideWin= new Rectangle2D.Double(240,120,80,30);
g2.draw(sideWin);
g2.drawLine(260, 120,260, 150);
g2.drawLine(280, 120,280, 150);
g2.drawLine(300, 120,300, 150);
g2.drawLine(260, 135,300, 135);

GeneralPath front=new GeneralPath();
front.moveTo(200,180);
front.lineTo(200, 100);
front.lineTo(10, 100);
front.lineTo(10, 180);
front.lineTo(40, 180);
front.moveTo(60,180);
front.lineTo(200, 180);
front.closePath();
g2.draw(front);

AffineTransform af=new AffineTransform();

Rectangle2D steps1= new Rectangle2D.Double(145,185,40,20);
af.translate(145, 185);
af.shear(0, 0.1);
af.translate(-145, -185);
g2.draw(af.createTransformedShape(steps1));
Rectangle2D steps2= new Rectangle2D.Double(140,210,40,20);
af.translate(140, 210);
af.translate(-140, -210);
g2.draw(af.createTransformedShape(steps2));
Rectangle2D steps3= new Rectangle2D.Double(135,235,40,20);
af.translate(135, 235);
af.translate(-135, -235);
g2.draw(af.createTransformedShape(steps3));
Rectangle2D steps4= new Rectangle2D.Double(130,260,40,20);
af.translate(130, 260);
af.translate(-130, -260);
g2.draw(af.createTransformedShape(steps4));

g2.drawLine(50, 160, 30, 200);
g2.drawLine(50, 160, 70, 200);
QuadCurve2D fbot=new QuadCurve2D.Double(30,200,50,210,70,200);
g2.draw(fbot);
g2.drawLine(45, 205, 45, 215);
g2.drawLine(45, 215, 55, 215);
g2.drawLine(55, 215, 55, 205);
Ellipse2D e1=new Ellipse2D.Double(40, 210, 20, 10);
Ellipse2D e2=new Ellipse2D.Double(40, 205, 20, 10);
Area b1=new Area(e1);
Area b2=new Area(e2);
b1.subtract(b2);
g2.draw(b1);
Rectangle2D door= new Rectangle2D.Double(150,120,40,55);
g2.draw(door);
Rectangle2D doorWin= new Rectangle2D.Double(165,130,10,5);
g2.draw(doorWin);
Ellipse2D doorHand= new Ellipse2D.Double(155,150,5,3);
g2.draw(doorHand);
Rectangle2D frontWin= new Rectangle2D.Double(50,120,80,30);
g2.draw(frontWin);
g2.drawLine(70, 120,70, 150);
g2.drawLine(90, 120,90, 150);
g2.drawLine(110, 120,110, 150);
g2.drawLine(70, 135,110, 135);
Rectangle2D r2=new Rectangle2D.Double(0,0,360,285);
TexturePaint tp=new TexturePaint(bf,r2);
g2.setPaint(tp);
g2.fill(r2);

}
}
