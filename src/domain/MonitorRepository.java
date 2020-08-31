package domain;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import persistence.MonitorMapper;

/**
 * 
 * @author Vincent Lammens <vincent@vincentlammens.be>
 *
 */
public class MonitorRepository {

	// attributes
	/**
	 * holds the monitor objects
	 */
	private Monitor[] monitors;
	
	/**
	 * Holds the monitor mapper object
	 */
	private MonitorMapper mapper;
	
	// constructor
	/**
	 * Constructs a MonitorRepository
	 * @throws UnknownHostException
	 */
	public MonitorRepository() throws UnknownHostException {
		this.mapper = new MonitorMapper();
		this.monitors = mapper.listMonitors();
	}

	
	// other methods
	/**
	 * Returns a list of the names of the monitors
	 * @return List with the names of the monitors
	 */
	public List<String> listMonitorNames()  {
		// TODO Auto-generated method stub
		List<String> o = new ArrayList<String>();
		for (Monitor monitor : monitors) {
			o.add(monitor.getName());
		}
		return o;
	}

	/**
	 * returns the status of a monitor
	 * @param name Name of the monitor
	 * @return boolean of the status
	 * @throws IOException 
	 */
	public boolean getMonitorStatus(String name) throws IOException {
		//List<String> monitors = this.listMonitorNames();
		boolean status = false;
		for (int i = 0; i < this.monitors.length; i++) {
			//System.out.println(this.monitors[i]);
			if (this.monitors[i].getName().equals(name)) {
				// get status
				
				status = this.monitors[i].pingMonitor();
			}
		}
		return status;
	}
	
}
