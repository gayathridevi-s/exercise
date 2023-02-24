package com.exercise2;

public class Browser {
	Browser(String name1) {
		System.out.println("This is " + name1 + " class");
	}

	void whoAmI() {
		System.out.println("I am a browser");
	}

	static int noOfTabs(Browser[] allBrowsers) {
		int countTabs = 0;
		for (int i = 0; i < allBrowsers.length; i++) {
			if (allBrowsers[i] instanceof GoogleChrome) {
				countTabs++;
			}
		}
		return countTabs;
	}

	public static void main(String[] args) {
		final String BROWSER ="browser";
		Browser page = new Browser(BROWSER);
		Browser tabOne = new GoogleChrome(BROWSER ,"google chrome");
		Browser tabTwo = new Firefox(BROWSER, "firefox");
		Browser tabThree = new Firefox("browser", "firefox");
		Browser tabFour = new GoogleChrome("browser", "google chrome");
		Browser tabFive = new GoogleChrome("browser", "google chrome");
		Browser[] allBrowsers = { tabOne, tabTwo, tabThree, tabFour, tabFive };
		page.whoAmI();
		tabOne.whoAmI();
		tabThree.whoAmI();
		int chromeTabs = Browser.noOfTabs(allBrowsers);

		System.out.println("No of GoogleChrome tabs : " + chromeTabs);

		GoogleChrome tab5 = (GoogleChrome) tabFive;

		//boolean[] displayPermission = tab5.setPermission(false);
		//for (int i = 0; i < 3; i++) {
		//	System.out.println(displayPermission[i]);
		//}
		boolean[] displayAllPermission = tab5.setPermission(true, false, true);
		for (int i = 0; i < 3; i++) {
			System.out.println(displayAllPermission[i]);
		}
		Browser browser = new Firefox("browser", "firefox");
		((Firefox) browser).addContainer("facebook");
		((Firefox) browser).addContainer("private browsing");
		((Firefox) browser).addContainer("mails");
		((Firefox) browser).addContainer("facebook");
		((Firefox) browser).addContainer("instagram");
		((Firefox) browser).leaveContainer("mails");
		((Firefox) browser).leaveContainer("messenger");

	}
}
