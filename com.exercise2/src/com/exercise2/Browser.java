package com.exercise2;

public class Browser {
	Browser(String name1) {
		System.out.println("This is " + name1 + " class");
	}

	void whoAmI() {
		System.out.println("I am a browser");
	}

	public static void main(String[] args) {
		final String BROWSER = "browser";
		// final String
		Browser page = new Browser(BROWSER);
		Browser tabOne = new GoogleChrome(BROWSER, "google chrome");
		Browser tabTwo = new Firefox(BROWSER, "firefox");
		Browser tabThree = new Firefox(BROWSER, "firefox");
		Browser tabFour = new GoogleChrome(BROWSER, "google chrome");
		Browser tabFive = new GoogleChrome(BROWSER, "google chrome");
		Browser[] allBrowsers = { tabOne, tabTwo, tabThree, tabFour, tabFive };
		page.whoAmI();
		tabOne.whoAmI();
		tabThree.whoAmI();
		System.out.println("No of google chrome tabs: " + GoogleChrome.noOfTabs(allBrowsers));

		GoogleChrome tab5 = (GoogleChrome) tabFive;
		tab5.setPermission(true);
		tab5.setPermission(true, false, true);
		System.out.println("To display the container in firefox");
		Browser browser = new Firefox(BROWSER, "firefox");
		((Firefox) browser).addContainer("facebook");
		((Firefox) browser).addContainer("private browsing");
		((Firefox) browser).addContainer("mails");
		((Firefox) browser).addContainer("facebook");
		((Firefox) browser).addContainer("instagram");
		((Firefox) browser).leaveContainer("mails");
		((Firefox) browser).leaveContainer("messenger");
		System.out.println("the containers in firefox are:");
		((Firefox) browser).displayContainers();

	}
}
