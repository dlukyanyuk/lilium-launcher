package net.minecraft;

import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MinecraftLauncher {
  //private static final int MIN_HEAP = 511;
  //private static final int RECOMMENDED_HEAP = 1024;

	public static void main(String[] args) throws Exception { 		
		launchMainFrame(new HashMap());
	}
	
	private static void launchMainFrame(Map params) {
		try {
			ProcessBuilder pb = new ProcessBuilder(getLaunchParams(params));
			Process process = pb.start();
			if (process == null) {
				throw new Exception("!");
			}			
		} catch (Exception e) {
			e.printStackTrace();
			LauncherFrame.main(new String[]{});
		}
	}
	
	public static void updateMainFrame(Map params) {
		launchMainFrame(params);
		System.exit(0);
	}
  
  	private static ArrayList<String> getLaunchParams(Map params) throws URISyntaxException {
  		ArrayList<String> launchParams = new ArrayList<String>();
	  
  		String pathToJar = MinecraftLauncher.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
	  
	    //TODO убрать отовсюду статические переменные и сделать утилитный класс
  		Integer memory = 1024;
  		if (params.containsKey(OptionsPanel.MEMORY_KEY)) {
  			memory = (Integer) params.get(OptionsPanel.MEMORY_KEY);
  		}
  		float heapSizeMegs = (float)(Runtime.getRuntime().maxMemory() / 1024L / 1024L);
  		
  		launchParams.add("javaw");
  		launchParams.add("-Xms512m");
  		if (memory <= 0) {
  			memory = 1024;
  		}
  		MessageFormat memoryFormat = new MessageFormat("-Xmx{0}m");
  		launchParams.add(memoryFormat.format(new Object[]{memory.toString()}));
	      
  		launchParams.add("-Dsun.java2d.noddraw=true");
  		launchParams.add("-Dsun.java2d.d3d=false");
  		launchParams.add("-Dsun.java2d.opengl=false");
  		launchParams.add("-Dsun.java2d.pmoffscreen=false");
  		launchParams.add("-classpath");
  		launchParams.add(pathToJar);
  		launchParams.add("net.minecraft.LauncherFrame");
  		return launchParams;
  	}
}