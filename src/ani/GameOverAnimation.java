package ani;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Reference: http://openhome.cc/Gossip/ComputerGraphics/SkeletonOfAnimation.htm
 */

@SuppressWarnings("serial")
public class GameOverAnimation extends JPanel implements Runnable {
	private Thread thread;
	private JLabel jLabel;
	private int picId = 0;

	public void start () {
		try
        {
			this.setVisible(true);
			this.setLayout(new FlowLayout());
			this.setBounds(new Rectangle(0,0,1000,800));
			ImageIcon icon = new ImageIcon( ImageIO.read( getClass().getResourceAsStream("/res/gameOverAni/2.gif") ) );
	        jLabel = new JLabel(icon);
	        jLabel.setSize(1000, 800);
	        this.setLayout(null);
	        this.add(jLabel);
	        
	        thread = new Thread(this);
	        thread.start();
        }
        catch (Exception e) {}
	}

    public void run() {
		try
        {
			// �ʵe�j��
	        while (true) {
	        	if (picId<935)
	        		picId++;
	        	else
	        		break;
	            // �ʵe�����A���ܡB�w�İ�ø��
	        	ImageIcon icon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/res/gameOverAni/" + (picId+1) + ".gif")));
	            if (jLabel!=null)
	            	jLabel.setIcon(icon);
	            this.repaint();  // ��ø�e��
	        }  // while����
        }
        catch (Exception e) {}
    }  // run()���� 
 
    // ��gupdate()�A�קK�e�����s��
	@Override
    public void update (Graphics g) {
    	super.paint(g); // ø�ϰʧ@
    }
} 