package domain;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;


/**
 * @author Vincent Lammens (vincent@vincentlammens.be)
 */
public class DomainController {

	/**
	 * This variable holds the MonitorRepository object
	 */
	private final MonitorRepository mr;
	
	/**
	 * Constructs a DomainController
	 * @throws UnknownHostException
	 */
	public DomainController() throws UnknownHostException {
		this.mr = new MonitorRepository();
	}

	/**
	 * Returns a list of all monitor names
	 * @return List<String> with the names of the monitors
	 */
	public List<String> listMonitorNames() {
		return mr.listMonitorNames();
		
	}
	
	/**
	 * Gets the status of an individual monitor object.
	 * @param name String with the name of the monitor too check the status of
	 * @return boolean with the monitor status.
	 * @throws IOException
	 */
	public boolean getMonitorStatus(String name) throws IOException {
		return mr.getMonitorStatus(name);
	}
	
}
