// ViewData-FRAME OF PROJECT
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import sun.audio.*;
import java.io.*;

class ViewData extends JFrame
{
	Container c;
	
	JButton btnback;
	
	public void SoundActionPerformed1()
	{
		InputStream in;
		try
		{
			in=new FileInputStream(new File("C:\\Users\\Aakash\\Downloads\\okay-1.wav"));
			AudioStream audios=new AudioStream(in);
			AudioPlayer.player.start(audios);
				
		}
		catch(Exception e)
		{
			System.out.println("error");
				
		}
			
	}
	
	ViewData()
	{
		//start of frame design
		c=getContentPane();
		c.setLayout(new FlowLayout());
		
		TextArea txtview;
		JButton btnback;
		
		txtview=new TextArea(15,30);
		btnback=new JButton(" BACK  ");
		
		
		c.add(txtview);
		c.add(btnback);
		
		DbHandler db=new DbHandler();
		String data=db.viewData();
		txtview.setText(data);
		
		
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle(" * VIEW PAGE *");
		// end of frame design
		
		//start of actionlistner code
		ActionListener aback = (ae)->
		{
			SoundActionPerformed1();
			HomeFrame h1=new HomeFrame();
			dispose();		
		};
		btnback.addActionListener(aback);
	}
	
	/*public static void main(String args[])
	{
		ViewData f=new ViewData();
	}*/
	
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
	
	
	
	
	