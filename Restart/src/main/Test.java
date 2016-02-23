package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Test {

	public static void main(String[] args) {
		//frame();												//GUI Optional.
		while(true){
			Ping.start();
		}
	}
	public static void frame(){
		Config.frame.setTitle("Restart");
		Config.frame.setBounds(50, 50, 500,200);
		Config.frame.setLayout(null);
		Config.frame.setDefaultCloseOperation(Config.frame.EXIT_ON_CLOSE);
		Config.frame.setVisible(true);
		
		//Components
		JLabel info=new JLabel();
		info.setText("Not started.");
		info.setVisible(true);
		info.setBounds(0, 0, Config.frame.getWidth(), 50);
		Config.frame.add(info);
		
		JButton button= new JButton();
		button.setText("Start");
		button.setBounds(200, 100, 100, 50);
		button.setVisible(true);
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Config.run){
					Config.run=false;
					try {
						Thread.currentThread().sleep(Config.timeout+100);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					Config.run=true;
					new Thread(new Ping()).start();
				}
			}
			
		});
		Config.frame.add(button);
	}

}
