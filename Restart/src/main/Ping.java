package main;

import java.io.IOException;
import java.net.InetAddress;

public class Ping implements Runnable{

	public static void start() {
		while(Config.run){
			try {
				if(InetAddress.getByName(Config.gateway).isReachable(Config.timeout)){		//ping default gateway, if its Up or Down.
					System.out.println("IT is Up");
					Thread.currentThread().sleep(10000);
					//Do nothing..
				}else{
					System.out.println("IT is DOWN");
					//RESTART
					restart();															//uncomment this after finishing.
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private static void restart(){
		Runtime r=Runtime.getRuntime();
		try {
			Process proc = r.exec("shutdown -r -t 30");										//shuts down in some time, and saves to LOGs.
			System.exit(0);
			//saving to logs.
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		while(Config.run){
			start();
		}
	}
}
