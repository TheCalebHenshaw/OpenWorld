package openworld.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;

public class EnvironmentPanel extends JPanel implements ActionListener {
	
	private GameWorld gameWorld;
	private Timer timer;
	private JButton respawnButton, startButton, stopButton;
	
	public EnvironmentPanel(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorder(new TitledBorder("Monster and NPC controls"));
		
		respawnButton = new JButton("Respawn all");
		respawnButton.addActionListener(this);
		startButton = new JButton("Start moving");
		startButton.addActionListener(this);
		stopButton = new JButton("Stop moving");
		stopButton.addActionListener(this);
		
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				gameWorld.getWorld().monsterMove();
				gameWorld.getWorld().nonPlayerCharactersMove();
			}
		});

		add(respawnButton);
		add(startButton);
		add(stopButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==respawnButton){
			gameWorld.respawnWorld();
		}
		if(e.getSource()==startButton){
			if(!timer.isRunning()){
				startButton.setEnabled(false);
			}
			timer.start();
		}
		if(e.getSource()==stopButton){
			timer.stop();
			startButton.setEnabled(true);
		}
	}

	public void disableAll() {
		startButton.setEnabled(false);
		stopButton.setEnabled(false);
		respawnButton.setEnabled(false);
	}

}
