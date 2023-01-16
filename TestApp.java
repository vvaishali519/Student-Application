import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TestApp {

	public static void main(String[] args) {
		
		Connection connection = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		int rowCount = 0;
		int choice =0;
		Scanner sc = new Scanner(System.in);
		try {
			connection = JDBCUtils.getJdbcConnection();
			if (connection != null) {
				System.out.println("Select :: 1. Data Insertion 2. Data Retrival");
				choice = sc.nextInt();
				if(choice == 1) {
					String sqlInserQuery = "insert into Users(`name`,`dob`,`dom`) values(?,?,?)";
					pstmt1 = connection.prepareCall(sqlInserQuery);
					if (pstmt1 != null) {
						System.out.print("Enter Name ::");
						String name = sc.next();
						System.out.println("Enter Dob (dd-MM-yyyy) :: ");
						String dob = sc.next();
						System.out.println("Enter Dom (yyyy-MM-dd) :: ");
						String dom = sc.next();
						pstmt1.setString(1, name);
						if (dob != null) {
							SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
							java.util.Date uDate = sdf.parse(dob);
							long value =uDate.getTime();
							java.sql.Date sqlDob = new java.sql.Date(value);
							pstmt1.setDate(2, sqlDob);
						}
						if (dom != null) {
							java.sql.Date sqlDom = java.sql.Date.valueOf(dom);
							pstmt1.setDate(3, sqlDom);
						}
						rowCount = pstmt1.executeUpdate();
						System.out.println("Data Inserted Succesfully"+rowCount);
					}
				}else if(choice == 2) {
					String sqlSelectQuery = "select name,dob,dom from Users where id=?";	
					pstmt2 = connection.prepareCall(sqlSelectQuery);
					if (pstmt2 != null) {
						System.out.print("Enter Id :: ");
						int id = sc.nextInt();
						pst
					}
				}
			}
		} catch (IOException | SQLException e) {
			
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			sc.close();
			try {
				JDBCUtils.cleapUp(connection, pstmt1, null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
