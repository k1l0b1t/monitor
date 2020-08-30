package domain;

import java.util.List;

public class DomainController {

	
	final private MonitorRepository mr;

	
	
	/**
	 * @author Vincent Lammens
	 */
	public DomainController() {
		this.mr = new MonitorRepository();
	}

	/**
	 * This method returns a list with the names of all monitors
	 * @author Vincent Lammens
	 * @return List with the names of the monitors
	 */
	public List<String> listMonitors() {
		return mr.listMonitors();
		
	}
	
}
