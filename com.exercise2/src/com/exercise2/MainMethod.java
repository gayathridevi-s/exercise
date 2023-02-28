package com.exercise2;

import java.util.Scanner;

public class MainMethod {

	public static void main(String[] args) {
		final String BROWSER = "browser"; // final String
		Scanner input = new Scanner(System.in);
		Browser chrome = new Browser(BROWSER);
		Browser.Bookmarks chromeBookmarks = chrome.new Bookmarks();// member inner class
		System.out.println("add bookmarks: ");
		chromeBookmarks.addBookmarks();
		System.out.println("the bookmarks for chrome are: ");
		System.out.println(chromeBookmarks.displayBookmark());

		System.out.println("enter number of urls:");

		int n = input.nextInt();

		String[] history = new String[n];
		System.out.println("enter URLs:");
		for (int i = 0; i < n; i++) {

			history[i] = input.next();
		}

		Browser.History visitedUrl = new Browser.History(); // instance of static inner class
		visitedUrl.setUrl(history); // accessing non static methods
		System.out.println("history:");
		System.out.println(Browser.History.getUrl()); // accessing static methods

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
		System.out.println(tab5.getVersionNumber()); // getting final keyword
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
		System.out.println("The containers in firefox are:");
		((Firefox) browser).displayContainers();

	}
}
