// Delete Student record-FRAME OF PROJECT
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import sun.audio.*;
import java.io.*;

class DeleteRecord extends JFrame
{
	Container c;
	
	JButton btnsave,btnback;
	JLabel lblrno,lblname;
	JTextField txtrno,txtname;
	
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
	
	DeleteRecord()
	{
		//start of frame design
		c=getContentPane();
		c.setLayout(new FlowLayout());
		
		lblrno=new JLabel(" * ENTER RNO OF STUDENT *");
		
		txtrno=new JTextField(15);
		
		btnsave=new JButton(" SAVE ");
		btnback=new JButton(" BACK ");
		
		c.add(lblrno);
		c.add(txtrno);
		
		
		c.add(btnsave);
		c.add(btnback);
		
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle(" * DELETE STUDENT DATA *");
		// end of frame design
		
		//start of actionlistner code
		ActionListener aback = (ae)->
		{
			SoundActionPerformed1();
			HomeFrame h1=new HomeFrame();
			dispose();		
		};
		btnback.addActionListener(aback);
		
		ActionListener aDelete= (ae)->
		{
			try{
			int rno=Integer.parseInt(txtrno.getText());
			
			if((rno<0))
			{
				SoundActionPerformed2();
				JOptionPane.showMessageDialog(new JDialog(),"INVALID ENTRY");
				txtrno.setText(" ");
				txtrno.requestFocus();
				
			}
			else
			{
				SoundActionPerformed1();
				DbHandler db=new DbHandler();
				db.DeleteData(rno);
			}
			}
			catch(Exception e)
			{
				SoundActionPerformed2();
				JOptionPane.showMessageDialog(new JDialog(),"INVALID ENTRY");
			}
				
		};
		btnsave.addActionListener(aDelete);
		
	}
	/*
	public static void main(String args[])
	{
		DeleteRecord  f=new DeleteRecord();
	}*/
	
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
	
	
	
	
	