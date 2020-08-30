package main;

import domain.DomainController;
import java.util.*;

public class startup {

	public static void main(String[] args) {
		// create new domain controller
		DomainController dc = new DomainController();
		List<String> monitors = dc.listMonitors();
		for (String monitor : monitors) {
			System.out.printf("Monitor: %s%n", monitor);
		}
	}

}
