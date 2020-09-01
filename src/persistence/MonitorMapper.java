package persistence;

import java.net.UnknownHostException;
import domain.Monitor;

import java.util.ArrayList;
import java.util.List;


public class MonitorMapper {
	
	public List<Monitor> listMonitors() throws UnknownHostException {
		
		
		List<Monitor> monitors = new ArrayList<Monitor>();
		monitors.add(new Monitor("Test1","127.0.0.1"));
		monitors.add(new Monitor("Test2","10.0.0.255"));
				
		return monitors;
				
	}
	
	
	
	
}
