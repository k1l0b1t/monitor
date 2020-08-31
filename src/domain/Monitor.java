package domain;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 
 * @author Vincent Lammens (vincent@vincentlammens.be)
 *
 */
public class Monitor {

	/**
	 * This variable holds the name of the monitor
	 */
	private String name;
	
	/**
	 * This vairable holds the IP of the monitor
	 */
	private InetAddress ip;
	
	/**
	 * This variable holds the online status of the monitor
	 */
	private boolean isOnline;
	
	/**
	 * Constructs a monitor
	 * @param name The name of the monitor
	 * @param ip A string with the ip (ipv4,ipv6 or FQDN) of the monitor
	 * @throws UnknownHostException
	 */
	public Monitor(String name, String ip) throws UnknownHostException {
		setName(name);
		setIp(ip);
		setIsOnline(false); // default status to false
	}
	
	/**
	 * Constructs a monitor, with a initial status
	 * @param name The name of the monitor
	 * @param ip A string with the ip (ipv4, ipv6 or FQDN) of the monitor
	 * @param isOnline the status of the monitor on creation
	 * @throws UnknownHostException
	 */
	public Monitor(String name, String ip, boolean isOnline) throws UnknownHostException {
		setName(name);
		setIp(ip);
		setIsOnline(isOnline);
		
	}

	/**
	 * Getter for the name
	 * @return Name of the monitor
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter of the isOnline status
	 * @return Status of the monitor
	 */
	public boolean getIsOnline() {
		return isOnline;
	}

	/**
	 * Setter for the name
	 * @param name The name of the monitor
	 */
	private void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Setter for the ip
	 * @param ip String containing the IP of the monitor. Either ipv4, ipv6 or FQDN
	 * @throws UnknownHostException
	 */
	private void setIp(String ip) throws UnknownHostException {
		this.ip = InetAddress.getByName(ip);
	}
	
	/**
	 * Setter for the monitor status
	 * @param isOnline the status to set
	 */
	private void setIsOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	
	/**
	 * Method to ping the monitor
	 * @return the result of the ping. 
	 * @throws IOException
	 */
	public boolean pingMonitor() throws IOException {
		boolean newStatus = this.ip.isReachable(500);
		setIsOnline(newStatus);
		return newStatus;
		
	}
	
	@Override 
	public String toString() {
		return String.format("Monitor %s (%s): %s%n", this.name, this.ip.toString(), this.isOnline);
	}

}
