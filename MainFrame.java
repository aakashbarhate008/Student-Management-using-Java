// MAIN-FRAME OF PROJECT
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import sun.audio.*;
import java.io.*;

class MainFrame extends JFrame
{
	Container c;
	
	JLabel lbluname,lblpass;
	JTextField txtname;
	JPasswordField txtpass;
	JButton btnsubmit,btnSignUp;
	
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

	MainFrame()
	{
		//start of frame design
		c=getContentPane();
		c.setLayout(new FlowLayout());
		
		lbluname=new JLabel(" * ENTER USER_NAME *");
		lblpass=new JLabel(" * ENTER PASSWORD *");
		
		txtname=new JTextField(15);
		txtpass=new JPasswordField(15);
		//txtpass.setEchoChar('*');
		
		
		btnsubmit=new JButton(" LOG IN ");
		btnSignUp=new JButton(" SignUp  ");
		
		c.add(lbluname);
		c.add(txtname);
		
		c.add(lblpass);
		c.add(txtpass);
		
		c.add(btnsubmit);
		c.add(btnSignUp);
		
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle(" * LOG IN PAGE *");
		setLocationRelativeTo(null);
		// end of frame design
		
		//start of actionlistner code	
		ActionListener amsubmit = (ae)->
		{
			String username=txtname.getText();
			String password=txtpass.getText();
			
			
			if(!(username.equals("aakash") && password.equals("123")))
			{
				SoundActionPerformed2();
				JOptionPane.showMessageDialog(c,"INVALID USER NAME AND PASSWORD COMBINATION");
				txtname.setText(" ");
				txtpass.setText(" ");
				txtname.requestFocus();
					
			}
			else
			{
				SoundActionPerformed1();
				HomeFrame h1=new HomeFrame();
				dispose();
			}	
		};
		btnsubmit.addActionListener(amsubmit);
		
		ActionListener amSignUp = (ae)->
		{
			SoundActionPerformed1();
			SignUp h1=new SignUp();
			dispose();	
		};
		btnSignUp.addActionListener(amSignUp);
	}
	
	public static void main(String args[])
	{
		MainFrame f=new MainFrame();
	}
	
}
class DbHandler
{
	public void addData(int rno,String name,int marks)
	{
		Connection conn=null;
		try
		{
			System.out.println("trying to load drivers..Have patients");
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			System.out.println("Driver is loadede");
			
			System.out.println("Trying to connect....");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
			System.out.println("connected");
			
			String sql1="insert into student values(?,?,?)";
			PreparedStatement pst1=conn.prepareStatement(sql1);
			pst1.setInt(1,rno);
			pst1.setString(2,name);
			pst1.setInt(3,marks);
			int result=pst1.executeUpdate();
			System.out.println(result+" record inserted");
			JOptionPane.showMessageDialog(new JDialog(),result+" record inserted");
			pst1.close();
		}
		catch(SQLException e)
		{
			System.out.println("there is issue: "+e);
		}
		finally
		{
			try
			{
				System.out.println("trying to close conncetion:");
				if(conn!=null)
				{
					conn.close();
					System.out.println("connection is closed");
				}
			}
			catch(SQLException ae)
			{
				System.out.println("there is some issue");
			}
		}
	}
	
	public String viewData()
	{
		Connection conn=null;
		StringBuffer sb=new StringBuffer();
		
		try
		{
			System.out.println("trying to load the driver ");
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			System.out.println("driver is loaded");
			
			System.out.println("trying to connect");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
			System.out.println("connected");
			
			Statement stmt=conn.createStatement();
			String sql="select * from student";
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				int rno=rs.getInt(1);
				String name=rs.getString(2);
				int marks=rs.getInt(3);
				
				System.out.println("Student rno:"+rno+" Name:"+name+" Marks :"+marks);
				sb.append("Student rno:"+rno+" Name:"+name+" Marks :"+marks+"\n\n");
			}
			
			rs.close();
			stmt.close();
		}
		catch(SQLException e)
		{
			System.out.println("error is:"+e);
		}
		finally
		{
			System.out.println("trying to close connection");
			try
			{
				if(conn!=null)
				{
					conn.close();
					System.out.println("connection closed");
				}
			}
				catch(SQLException e)
				{
					System.out.println("closing issue");
				}
		}
		return sb.toString();
	}
	
	public void UpdateData(int rno,String name,int marks)
	{
	
		Connection conn=null;
		try
		{
			System.out.println("trying to load the driver");
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			System.out.println("driver is loaded");
			
			System.out.println("trying to connect");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
			System.out.println("connected");
			
			String sql="update student set name=?,marks=? where rno=?";
			PreparedStatement pst2=conn.prepareStatement(sql);
			
			pst2.setString(1,name);
			pst2.setInt(2,marks);
			pst2.setInt(3,rno);
			
			
			int result=pst2.executeUpdate();
			System.out.println(result+"records updated");
			JOptionPane.showMessageDialog(new JDialog(),result+" records updated");
			pst2.close();
		}
		catch(SQLException e)
		{
			System.out.println("error is:"+e);
		}
		finally
		{
			System.out.println("trying to close connection");
			try
			{
				if(conn!=null)
				{
					conn.close();
					System.out.println("connection closed");
				}
			}
				catch(SQLException e)
				{
					System.out.println("closing issue");
				}
		}
		
    }
	
	public void DeleteData(int rno)
	{
	
		Connection conn=null;
		try
		{
			System.out.println("trying to load the driver");
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			System.out.println("driver is loaded");
			
			System.out.println("trying to connect");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
			System.out.println("connected");
			
			String sql="delete from student where rno=?";
			PreparedStatement pst3=conn.prepareStatement(sql);
			
			pst3.setInt(1,rno);
			
			int result=pst3.executeUpdate();
			System.out.println(result+" records updated");
			JOptionPane.showMessageDialog(new JDialog(),result+"records deleted ");
			pst3.close();
		}
		catch(SQLException e)
		{
			System.out.println("error is:"+e);
		}
		finally
		{
			System.out.println("trying to close connection");
			try
			{
				if(conn!=null)
				{
					conn.close();
					System.out.println("connection closed");
				}
			}
				catch(SQLException e)
				{
					System.out.println("closing issue");
				}
		}
		
    }
}

				
			

	