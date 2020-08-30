package domain;

public class Monitor {

	private final String name;
	private final String ipv4;
	private boolean isOnline;
	
	public Monitor(String name, String ipv4) {
		this.name = name;
		this.ipv4 = ipv4;
	}
	
	/**
	 * Returns the name of the monitor
	 * @return name
	 */
	public String getName() {
		return name;
	}
	

}
