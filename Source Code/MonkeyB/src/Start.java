import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class Start  {

	private JFrame frame;
	private  JLabel status;
    public Start() {

    	initialize();
        
    }

    public void initialize()
    {
    	
    	
    	//Create new Panel 
    	JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusBar.setBorder(new CompoundBorder(new LineBorder(Color.DARK_GRAY),
            new EmptyBorder(4, 4, 4, 4)));
        
        //Create new Label and add to the Panel
        status= new JLabel();
        statusBar.add(status);
        statusBar.setBackground(new Color(10, 100, 113));
    	status.setText("Timer");
    	status.setForeground(Color.RED);
    	
    	
    	//Set the frame Properties
    	frame=new JFrame();
    	frame.setLayout(new BorderLayout());
    	frame.add(statusBar, BorderLayout.NORTH);
    	frame.add(new WonderLand(status));
        frame.setResizable(false);
        frame.pack();
        frame.setTitle("Monkey-Banana Game");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {                
            	Start window = new Start();
				window.frame.setVisible(true);             
            }
        });
    }
}