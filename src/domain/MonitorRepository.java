package domain;

import java.util.ArrayList;
import java.util.List;

import persistence.MonitorMapper;

public class MonitorRepository {

	// attributen
	private Monitor[] monitors;
	private MonitorMapper mapper;
	
	public MonitorRepository() {
		this.mapper = new MonitorMapper();
	}

	/**
	 * Returns a list of the names of the monitors
	 * @return String[]
	 */
	public List<String> listMonitors() {
		// TODO Auto-generated method stub
		Monitor[] monitors = mapper.listMonitors();
		List<String> o = new ArrayList<String>();
		for (Monitor monitor : monitors) {
			o.add(monitor.getName());
		}
		return o;
	}
	
	
	
	
}
