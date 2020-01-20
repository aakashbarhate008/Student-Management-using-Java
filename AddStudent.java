// Add Student-FRAME OF PROJECT
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import sun.audio.*;
import java.io.*;

class AddStudent extends JFrame
{
	Container c;
	
	JButton btnsave,btnback;
	JLabel lblrno,lblname,lblmarks;
	JTextField txtrno,txtname,txtmarks;
	
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
	
	AddStudent()
	{
		//start of frame design
		c=getContentPane();
		c.setLayout(new FlowLayout());
		
		lblrno=new JLabel(" * ENTER RNO OF STUDENT *");
		lblname=new JLabel(" * ENTER NAME OF STUDENT *");
		lblmarks=new JLabel(" * ENTER MARKS OF STUDENT *");
		
		txtrno=new JTextField(15);
		txtname=new JTextField(15);
		txtmarks=new JTextField(15);
		
		btnsave=new JButton(" SAVE ");
		btnback=new JButton(" BACK ");
		
		c.add(lblrno);
		c.add(txtrno);
		
		c.add(lblname);
		c.add(txtname);
		
		c.add(lblmarks);
		c.add(txtmarks);
		
		c.add(btnsave);
		c.add(btnback);
		
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle(" * ADD STUDENT DATA *");
		setLocationRelativeTo(null);
		// end of frame design
		
		//start of actionlistner code
		ActionListener asave = (ae)->
		{
			try{
			int rno=Integer.parseInt(txtrno.getText());
			String name=txtname.getText();
			int marks=Integer.parseInt(txtmarks.getText());
			
			if((rno<0) &&(name.length()<2) &&(marks<0 || marks>100))
			{
				SoundActionPerformed2();
				JOptionPane.showMessageDialog(new JDialog(),"INVALID ENTRY");
				txtrno.setText(" ");
				txtname.setText(" ");
				txtmarks.setText(" ");
				txtrno.requestFocus();
				
			}
			else
			{
				SoundActionPerformed1();
				DbHandler db=new DbHandler();
				db.addData(rno,name,marks);
			}
			}
			catch(Exception e)
			{
				SoundActionPerformed2();
				JOptionPane.showMessageDialog(new JDialog(),"INVALID ENTRY");
			}
			
			
				
		};
		btnsave.addActionListener(asave);
		
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
		AddStudent f=new AddStudent();
	}*/
	
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
	
	
	
	
	