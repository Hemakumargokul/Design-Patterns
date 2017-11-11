import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;







public class WonderLand extends JPanel {
	
	
	private Image ibanana;
	private Image imonkey;
	private int hit=0;
	private  int GameOver=0; 	
	private   JLabel label=null;
	private   JLabel status=null;
	private Timer t=null;
	private int GameWon=0;
	private Monkey monkey;
	private Banana banana;
	private String padded=null;
	public WonderLand(JLabel status)
	{
		
		//Create new Instances of the Subject Monkey
		monkey = new Monkey();
		
		//Create new Instances of the Banana
		banana = new Banana();
		
		this.status=status;
		int val=0;
		label=new JLabel();
		setTimer();
		setFocusable(true);
		setBackground(new Color(60, 179, 113));
        setPreferredSize(new Dimension(Utils.P_WIDTH, Utils.P_HEIGHT));
        
        loadImages();
        getKeys();
        placeBanana();
        placeMonkey();
      
	}
	
public void setTimer()
{
	t=new Timer(1000, new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		  		
    		
    		padded = String.format("   BANANA'S ATE:%5d  %20s  CATCH 5 TO WIN !!!                This Banana disappears in : %1s Secs",hit,"", Utils.GAMETIMER_TEMP-- );
    		status.setText("GAME ENDS IN: "+ Utils.GAMETIMER-- +" Secs"+padded);
    		if(Utils.GAMETIMER_TEMP==0)
    		{   			
    			Utils.GAMETIMER_TEMP=5;
    			placeBanana();
    		}
    		
    		if(GameWon==1)
    		{
    			GameOver=1;
				setLayout(new GridBagLayout());
				label.setText("You Won - Your Score:"+hit);
				label.setFont(new Font("Serif", Font.PLAIN, 50));
			    add(label);
			    stopTimer();   
    		}
    		
    		if(Utils.GAMETIMER==-1)
    		{
    			
    			GameOver=1;
				setLayout(new GridBagLayout());
				label.setText("Game Over- Score:"+hit);
				label.setFont(new Font("Serif", Font.PLAIN, 50));
			    add(label);
			    stopTimer();   
    			//game over
    		}
    		
    		
    	}
    
    });
	t.start();
	
	
}
 

	public void placeBanana()
	{
		int r = (int) (Math.random() * 10);
        banana.setBananaX((r*60)+100);

        r = (int) (Math.random() * 10);
        banana.setBananaY(r*60);
        repaint();
	}
	
	public void placeMonkey()
	{
		do{
		int r = (int) (Math.random() * 10);
		monkey.setX((r*60)+100);

		r = (int) (Math.random() * 10);
        monkey.setY((r*60));
        
        if(monkey.getX()!=banana.getBananaX() || monkey.getY()!=banana.getBananaY())
        	break;
        
		}while(true);
        
	}
	@Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		Graphics2D g2d = (Graphics2D) g.create();
		
		if(GameOver==0){
			g2d.drawImage(ibanana, banana.getBananaX(), banana.getBananaY(), this);
	        g2d.drawImage(imonkey,monkey.getX(), monkey.getY(), this);	
	        g2d.dispose();
		}
		
        
	}
	
	
	
	private void loadImages() {

		URL monkey = getClass().getResource("/image/monkey.png");
		URL banana = getClass().getResource("/image/banana.png");
		try {
			ImageIcon monkeyIcon = new ImageIcon(ImageIO.read(monkey));
			ImageIcon bananaIcon = new ImageIcon(ImageIO.read(banana));
			 ibanana= bananaIcon.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		        
		        //ImageIcon monkeyIcon = new ImageIcon("monkey.png");
		        imonkey = monkeyIcon.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
       
    }
	
	public void stopTimer()
	{
		t.stop();	
	}
	
	private void getKeys() {
		Action leftAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	monkey.moveLeft(monkey);
            	            	
                if (checkPosition())	
                    placeBanana();
                
                if (monkey.getX() < 0) {
                	monkey.setX(getWidth()-20);
                	               	
                }
                repaint();
            }
        };
        Action rightAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	monkey.moveRight(monkey);
            	            	
                if (checkPosition())	
                    placeBanana();
                
                if (monkey.getX() + 20 > getWidth()) {
                	monkey.setX(0);
                	
                }
                repaint();
            }
        };
        
        Action downAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	monkey.moveDown(monkey);
            	
            	
                if (checkPosition())	
                    placeBanana();
                if (monkey.getY()+20 > getHeight()) {
                	monkey.setY(0);
                	
                }
                repaint();
            }
        };
        Action upAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	monkey.moveUp(monkey);
                
                if (checkPosition())	
                placeBanana();
                	
                if (monkey.getY() <0) {
                	monkey.setY(getHeight() - 20);
                	}
                repaint();
            }
        };
        
        
        
        bind(WHEN_IN_FOCUSED_WINDOW, "move.left", KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,0), leftAction);
        bind(WHEN_IN_FOCUSED_WINDOW, "move.right", KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,0), rightAction);
        bind(WHEN_IN_FOCUSED_WINDOW, "move.up", KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), upAction);
        bind(WHEN_IN_FOCUSED_WINDOW, "move.down", KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), downAction);
        
    }

    protected void bind(int condition, String name, KeyStroke keyStroke, Action action) {
        InputMap im = getInputMap(condition);
        ActionMap am = getActionMap();

        im.put(keyStroke, name);
        am.put(name, action);
    }
	
	public Boolean checkPosition()
	{
		if (monkey.getX() == banana.getBananaX() && banana.getBananaY() == monkey.getY()) //banana at right
		{
			hit++;
			Utils.GAMETIMER_TEMP=5;
			if(hit==Utils.MAX_BANANA)
			{
				GameOver=1;
				GameWon=1;
			}

			return true;
		}
		
	    return false;			
	}

	
    
}
