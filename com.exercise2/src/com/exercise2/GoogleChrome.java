package com.exercise2;

public class GoogleChrome extends Browser {
	boolean isLocationAccessible;
	boolean isCameraAccessible;
	boolean isMicrophoneAccessible;
	private static final double VERSIONNUMBER = 1.0;

	GoogleChrome(String name1, String name2) {
		super(name1); // accessing main class constructor
		System.out.println("this is a " + name2 + " subclass");
	}

	public void whoAmI() {

		System.out.println("I am Google Chrome ");

	}

	public double getVersionNumber() {
		return VERSIONNUMBER;
	}

	static int noOfTabs(Browser[] googleTab) {
		int countTabs = 0;
		for (int i = 0; i < googleTab.length; i++) {
			if (googleTab[i] instanceof GoogleChrome) {
				countTabs++;
			}
		}
		return countTabs;
	}

	public void setPermission(boolean value) {
		isLocationAccessible = value;
		isCameraAccessible = value;
		isMicrophoneAccessible = value;
		getPermission();
	}
	
	void getPermission() {
		System.out.println("location permission: " + isLocationAccessible);
		System.out.println("camera permission: " + isCameraAccessible);
		System.out.println("microphone permission: " + isMicrophoneAccessible);

	}

	public void setPermission(boolean value1, boolean value2, boolean value3) {
		isLocationAccessible = value1;
		isCameraAccessible = value2;
		isMicrophoneAccessible = value3;
		getPermission();

	}

}
