package no.hvl.dat110.system.display;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.RPCServer;
import no.hvl.dat110.system.controller.Common;

public class DisplayDevice {
	
	public static void main(String[] args) {
		
		System.out.println("Display server starting ...");
		
		// implement the operation of the display RPC server
		// see how this is done for the sensor RPC server in SensorDevice
		
		DisplayImpl disp = new DisplayImpl();
		RPCServer dServer = new RPCServer(Common.DISPLAYPORT);
		dServer.register(1, disp);
		dServer.run();
		dServer.stop();
		
		System.out.println("Display server stopping ...");
		
	}
}
