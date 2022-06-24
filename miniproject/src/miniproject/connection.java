package miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class connection {
	

		private static String id;

		static void insert() {
			Scanner sc=new Scanner(System.in);
			try{ Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","Kolli12para.");
			Statement st=con.createStatement();
			System.out.println("Enter your id:");
			int id=sc.nextInt();
			System.out.println("Enter your  cname:");
			String cname=sc.next();
			System.out.println("Enter your location:");
			String location=sc.next();
			System.out.println("Enter your dob:");
			String dob=sc.next();
			System.out.println("Enter your price:");
			String price=sc.next();
			System.out.println("Enter your mobile:");
			String mobile=sc.next();
			st.executeUpdate("insert into details values('"+id+"','"+cname +"','"+location+"','"+dob +"','"+price+"','"+mobile+"')");
			System.out.println("Record is stored in the DataBase sucessfully...");
			con.close();
			}
		
			catch(Exception e)
			{
			System.out.println(e.getMessage());}
			System.out.println("Please check it in the MySql table....");

		}

		static void update() {
			Scanner sc=new Scanner(System.in);
			try{ Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","Kolli12para.");
			System.out.println("Enter new location:");
			String location=sc.next();
			System.out.println("Enter your id:");
			int id=sc.nextInt();
			
			Statement st=con.createStatement();
			st.executeUpdate("update details set location=('"+location+"')  where id=('"+id+"')");
			System.out.println("Your location is updated check it in the Mysql...");
			con.close();
			}
			catch(Exception e)
			{
			System.out.println(e.getMessage());}
		}
		static void delete() {
			Scanner sc=new Scanner(System.in);
			try{ Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","Kolli12para.");
			System.out.println("Enter your id:");
			int id=sc.nextInt();
			Statement st=con.createStatement();
			st.executeUpdate("delete from details where id=('"+id+"')");
			System.out.println("Your record is deleted check it in the Mysql...");
			con.close();
			}
			catch(Exception e)
			{
			System.out.println(e.getMessage());}
		}
		static void record() {
			try{ Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","Kolli12para.");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from details");
			
			while(rs.next())
			{
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6));
			}
			}
			catch(Exception e)
			{
			System.out.println(e.toString());}
		}
	
		public static void main(String args[]) {
			connection s=new connection();
			int a=0;
			
			Scanner c=new Scanner(System.in);
			System.out.println("Select an option \n1-Registration \n2-Update location \n3-Delete record \n4-See Records \n5-Exit");
			a=c.nextInt();
			switch(a) {
			case 1:
				insert();
				break;
			case 2:
			  update();
				break;
			case 3:
				delete();
				break;
			case 4:
				record();
			case 5:
				System.out.println("Exit");
				break ;
			}
		}
}

	
