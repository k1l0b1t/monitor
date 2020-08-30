package persistence;

import domain.Monitor;

public class MonitorMapper {

	public MonitorMapper() {
		
	}

	public Monitor[] listMonitors() {
		
		Monitor[] monitors = {new Monitor("Test1","1.2.3.4"), new Monitor("Test2","1.2.3.4")};
		return monitors;
		
		
	}
	
}
