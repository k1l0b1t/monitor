package persistence;

import java.net.UnknownHostException;

import domain.Monitor;

public class MonitorMapper {
	
	public Monitor[] listMonitors() throws UnknownHostException {
		
		Monitor[] monitors = {new Monitor("Test1","127.0.0.1"), new Monitor("Test2","10.0.0.255")}; // second monitor is offline
		return monitors;
				
	}
	
	
	
	
}
