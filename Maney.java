package wet;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Maney extends JPanel{

	public Graphics go;
	
	
public void paintComponent(Graphics g)

{
	
	super.paintComponent(g);
	this.setBackground(Color.RED);
	
}
public void rect()
{
go.setColor(Color.BLUE);
go.drawRect(30, 30, 50, 50);

}
public void oval()
{
	go.setColor(Color.BLUE);
	go.drawOval(70,70,40,40);
	
}
public void text(String t)
{
 go.setColor(Color.GREEN);
 go.drawString(t,200,200);
}

}
