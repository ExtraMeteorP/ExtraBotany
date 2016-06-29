package com.meteor.extrabotany.common.handler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import net.minecraftforge.common.MinecraftForge;

public class ThreadUpdateChecker extends Thread {

	public ThreadUpdateChecker() {
		setName("ExtraBotany Version Checker Thread");
		setDaemon(true);
		start();
	}

	@Override
	public void run() {
		try {
			URL url = new URL("https://raw.githubusercontent.com/ExtraMeteorP/ExtraBotany/master/build/" + MinecraftForge.MC_VERSION + ".txt");
			BufferedReader r = new BufferedReader(new InputStreamReader(url.openStream()));
			UpdateChecker.onlineVersion = r.readLine();
			r.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		UpdateChecker.doneChecking = true;
	}

}
