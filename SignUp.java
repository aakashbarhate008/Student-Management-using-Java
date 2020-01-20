//sign up page 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import sun.audio.*;
import java.io.*;

class SignUp extends JFrame
{
	Container c;
	JTextField username,password;
	JLabel lblname,lblpassword;
	JButton btnSubmit,btnBack;
	
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
	
	public void SoundActionPerformed2()
	{
		InputStream in;
		try
		{
			in=new FileInputStream(new File("C:\\Users\\Aakash\\Downloads\\maybe-next-time.wav"));
			AudioStream audios=new AudioStream(in);
			AudioPlayer.player.start(audios);
				
		}
		catch(Exception e)
		{
			System.out.println("error");
				
		}
			
	}

	
	SignUp()
	{
		c=getContentPane();
		c.setLayout(new FlowLayout());
		
		username=new JTextField(10);
		password=new JTextField(10);
		
		lblname=new JLabel(" ENTER NAME:");
		lblpassword=new JLabel("ENTER PASSWORD:");
		
		btnSubmit=new JButton("SUBMIT");
		btnBack=new JButton("BACK");
		
		c.add(lblname);
		c.add(username);
		c.add(lblpassword);
		c.add(password);
		c.add(btnSubmit);
		c.add(btnBack);
		
		
		setSize(280,300);
		setTitle("sign up page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		ActionListener asBack=(aw)->
		{
			SoundActionPerformed1();
			MainFrame m1=new MainFrame();
			dispose();
		};
		btnBack.addActionListener(asBack);
		
		
		
	}
	

}

	

		