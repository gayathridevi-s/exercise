package com.exercise2;

import java.util.Arrays;

public class GoogleChrome extends Browser {
	boolean isLocationAccessible;
	boolean isCameraAccessible;
	boolean isMicrophoneAccessible;
	final double versionNumber = 1.0;

	GoogleChrome(String name1, String name2) {
		super(name1); 								// accessing main class constructor
		System.out.println("this is a " + name2 + " subclass");
	}

	void whoAmI() {
		
		System.out.println("I am Google Chrome ");
	}

	 public boolean[]setPermission(boolean value) {
		isLocationAccessible = value;
		isCameraAccessible = value;
		isMicrophoneAccessible = value;
		return getPermission();
	}
	boolean[] getPermission() {
		boolean[] all = { isLocationAccessible, isCameraAccessible, isMicrophoneAccessible };
		boolean[] out=Arrays.toString(all);
		return all;
	}

	boolean[] setPermission(boolean isLocationAccessible, boolean isCameraAccessible, boolean isMicrophoneAccessible) {
		this.isLocationAccessible = isLocationAccessible;
		this.isCameraAccessible = isCameraAccessible;
		this.isMicrophoneAccessible = isMicrophoneAccessible;
		boolean[] all = { this.isLocationAccessible, this.isCameraAccessible, this.isMicrophoneAccessible };
		return all;

	}

}
