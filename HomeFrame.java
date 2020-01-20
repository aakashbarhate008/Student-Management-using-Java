// Home-FRAME OF PROJECT
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import sun.audio.*;
import java.io.*;

class HomeFrame extends JFrame
{
	Container c;
	
	JButton btnadd,btnview,btndelete,btnupdate,btnsignout;
	
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

	HomeFrame()
	{
		//start of frame design
		c=getContentPane();
		c.setLayout(new FlowLayout());
		
		btnadd=new JButton(" ADD INTO RECORDS ");
		btnview=new JButton(" VIEW THE RECORDS ");
		btnupdate=new JButton("UPDATE THE RECORD");
		btndelete=new JButton("DELETE THE RECORD");
		btnsignout=new JButton(" SIGN OUT  ");
		
		
		c.add(btnadd);
		c.add(btnview);
		c.add(btnupdate);
		c.add(btndelete);
		c.add(btnsignout);
		
		setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle(" * HOME PAGE *");
		// end of frame design
		
		//start of actionlistner code
		ActionListener ahadd = (ae)->
		{
			SoundActionPerformed1();
			AddStudent h1=new AddStudent();
			dispose();		
		};
		btnadd.addActionListener(ahadd);
		
		ActionListener ahview = (ae)->
		{
			SoundActionPerformed1();
			ViewData h1=new ViewData();
			dispose();		
		};
		btnview.addActionListener(ahview);
		
		
		ActionListener ahupdate = (ae)->
		{
			SoundActionPerformed1();
			UpdateRecord h1=new UpdateRecord();
			dispose();		
		};
		btnupdate.addActionListener(ahupdate);
		
		ActionListener ahdelete = (ae)->
		{
			SoundActionPerformed1();
			DeleteRecord h1=new DeleteRecord();
			dispose();		
		};
		btndelete.addActionListener(ahdelete);
		
		ActionListener asignout = (ae)->
		{
			SoundActionPerformed1();
			dispose();
			System.exit(1);
			
		};
		btnsignout.addActionListener(asignout);
		
	}
	
	/*public static void main(String args[])
	{
		HomeFrame f=new HomeFrame();
	}*/
	
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
	
	
	
	
	