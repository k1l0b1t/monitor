package main;

import domain.DomainController;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class startup {

	
	public static void main(String[] args) {

		
		final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
	    executorService.scheduleAtFixedRate(new Runnable() {
	        @Override
	        public void run() {
	            try {
					myTask();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	    }, 0, 1, TimeUnit.MINUTES); // the monitor update every minute
			
	}
	
	
	
	private static void myTask() throws IOException {
		
		// create new domain controller
		DomainController dc = null;
		dc = new DomainController();
				
		List<String> monitors = null;
		monitors = dc.listMonitorNames();
		
		
		for (String monitor : monitors) {
			boolean status = false;
			status = dc.getMonitorStatus(monitor);
			System.out.printf("Monitor %s: %s%n", monitor, status);
		}
	}

}
