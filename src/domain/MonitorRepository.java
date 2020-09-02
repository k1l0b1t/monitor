package domain;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import persistence.MonitorMapper;

/**
 * 
 * @author Vincent Lammens (vincent@vincentlammens.be)
 *
 */
public class MonitorRepository {

	// attributes
	/**
	 * holds the monitor objects
	 */
	private List<Monitor> monitors;
	
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
		for (int i = 0; i < this.monitors.size(); i++) {
			//System.out.println(this.monitors[i]);
			if (this.monitors.get(i).getName().equals(name)) {
				// get status
				
				status = this.monitors.get(i).pingMonitor();
			}
		}
		updateMonitorStatusInDatabase(name,status);
		return status;
	}
	
	/**
	 * Update the status of a monitor in the database
	 * @param name name of the monitor to update the status of
	 * @param status new status of the monitor
	 */
	public void updateMonitorStatusInDatabase(String name, boolean status) {
		mapper.updateMonitor(name,status);
	}
	
}
