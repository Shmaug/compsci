import java.awt.Color;
import javax.swing.JFrame;

public class BrighterDemo {  
	public static void main(String[] args){
		Color color = new Color(50, 100, 150);
		Color brighterColor = color.brighter();
		
		JFrame frame = new JFrame();
		frame.setSize(200, 200);
		frame.getContentPane().setBackground(color);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		JFrame bframe = new JFrame();
		bframe.setSize(200, 200);
		bframe.setLocation(200, 0);
		bframe.getContentPane().setBackground(brighterColor);
		bframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bframe.setVisible(true);
	}
}