package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.UnknownHostException;
import java.sql.*;
import domain.Monitor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MonitorMapper {
	
	private String connectionString;
	
	private void loadConfigurationFile() {
		File conf = new File("monitor.cnf");
		Scanner file = null;
		
		// default values
		String server = "localhost";
		String user = "root";
		String password = "root";
		String database = "monitor";
		
		try {
			file = new Scanner(conf);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (file.hasNext()) {
			String[] tokens = file.next().split("=");
			//System.out.printf("%s:%s%n",tokens[0], tokens[1]);
			if (tokens[0].equals("dbserver")) {
				server = tokens[1];
			} else if (tokens[0].equals("dbuser")) {
				user = tokens[1];
			} else if (tokens[0].equals("dbpassword")) {
				password = tokens[1];
			}else if (tokens[0].equals("dbname")) {
				database = tokens[1];
			}
		}
		file.close();// close the file
		this.connectionString = String.format("jdbc:mysql://%s:%s@%s/%s", user, password, server, database);
	}
	
	public List<Monitor> listMonitors() throws UnknownHostException {
		
		loadConfigurationFile();
		
		List<Monitor> monitors = null;
		
		try (Connection conn = DriverManager.getConnection(connectionString);
				PreparedStatement query = conn.prepareStatement("select monitor.name, monitor.ip from monitor")) {
			
			try (ResultSet rs = query.executeQuery()) {
			
				monitors = new ArrayList<Monitor>();
				while (rs.next()) {      
					monitors.add(new Monitor(rs.getString("name"), rs.getString("ip")));                                 
				}
			}
				
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		}
		
		return monitors;			
	}
	
	public void updateMonitor(String name, boolean status) {
		
		try (Connection conn = DriverManager.getConnection(connectionString);
                PreparedStatement query = conn.prepareStatement("update monitor set status="+status+" where name='"+name+"'")) {
                query.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
	}
	
	
	
	
}
