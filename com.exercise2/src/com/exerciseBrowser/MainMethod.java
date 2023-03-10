package com.exerciseBrowser;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMethod {

	public static void main(String[] args) {
		final String BROWSER = "browser"; // final String
		Scanner input = new Scanner(System.in);
		Browser chrome = new Browser(BROWSER);
		BrowserHistory website = new BrowserHistory("GoogleChrome");

		System.out.println("enter number of urls:");

		int n = input.nextInt();

		String[] history = new String[n];
		System.out.println("enter URLs:");
		for (int i = 0; i < n; i++) {

			history[i] = input.next();
		}
		// exercise -1
		Browser.History visitedUrl = new Browser.History(); // instance of static inner class
		visitedUrl.setUrl(history); // accessing non static methods
		System.out.println("history:");
		System.out.println(Browser.History.getUrl()); // accessing static methods

		// exercise 4-java strings
		System.out.println("To track history count :");
		System.out.println("How many entries do you want?");
		int noOfEntries = input.nextInt();
		System.out.println("give url:");
		for (int i = 0; i < noOfEntries; i++) {
			String page = input.next();
			chrome.historyCount(page);
		}
		// exercise 5-inner class
		Browser.Bookmarks chromeBookmarks = chrome.new Bookmarks();// member inner class
		chromeBookmarks.addBookmarks();
		System.out.println("the bookmarks for chrome are: ");
		System.out.println(chromeBookmarks.displayBookmark());

		System.out.println("add shortcuts:(type N to exit)");
		Browser.Shortcuts browserShortcuts = new Browser.Shortcuts() { // anonymous inner class
			ArrayList<String> shortcuts = new ArrayList<>();

			public void addShortcuts() {

				while (true) {

					String shortcut = input.next();

					if (shortcut.equalsIgnoreCase("N")) {
						break;
					}
					shortcuts.add(shortcut);
				}

			}

			public String displayShortcuts() {
				return shortcuts.toString();

			}
		};
		browserShortcuts.addShortcuts();
		System.out.println("the shortcuts are:");
		System.out.println(browserShortcuts.displayShortcuts());

		// exercise 6-exception handling
		int position;
		int choice = 0;
		do {
			System.out.println("enter your choice:");
			System.out.println("1:visit url");
			System.out.println("2:fetch history");
			System.out.println("3:fetch history using extension");
			System.out.println("4:search extension");
			System.out.println("5:get url");
			System.out.println("6:sort");
			System.out.println("7:size");
			System.out.println("8:delete history");
			System.out.println("9:update history");
			System.out.println("10:move forward");
			System.out.println("11:move backward");
			System.out.println("12:exit");
			try {
				choice = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(e);
				System.out.println("Please enter a number!");
				input.nextLine();
				continue;
			}
			switch (choice) {
			case 1: {
				System.out.println("enter url");
				String site = input.next();

				try {
					if (site.endsWith(".com") || site.endsWith(".in") || site.endsWith(".org")) {
						website.visit(site);

					} else {
						throw new invalidURLException("invalid URL extension");
					}
				} catch (invalidURLException e) {
					System.out.println(e);

				}

				break;
			}
			case 2: {
				website.fetchHistory();
				
				break;
			}
			case 3:{
				System.out.println("type the extension to fetch its history:");
				String extensionUrl=input.next();
				website.fetchHistory(extensionUrl);
				break;
			}
			case 4: {
				System.out.println("type the extension to search its url:");
				String extension=input.next();
				website.search(extension);
				
				break;
			}
			case 5: {
				System.out.println("enter the position");
				position = input.nextInt();
				try {
					if (position >= website.urlList.size()) {
						throw new IndexOutOfBoundsException("Invalid position");
					} else if (position <= -1) {
						throw new InvalidPositionException("Provide only positive values");
					} else {
						String getUrl = website.get(position);
						System.out.println(getUrl);
					}

				} catch (IndexOutOfBoundsException e) {
					System.out.println(e);
				} catch (InvalidPositionException f) {
					System.out.println(f);
				}

				break;
			}
			case 6: {
				website.sort();
				break;
			}
			case 7: {
				website.size();
				break;
			}
			case 8: {
				System.out.println("enter the url that needs to be deleted:");
				String deleteUrl = input.next();
				website.deleteHistory(deleteUrl);
				System.out.println("enter the index whose url needs to be deleted");
				int deleteIndex=input.nextInt();
				website.deleteHistory(deleteIndex);
				System.out.println("enter the extension whose url needs to be deleted");
				String extensionDelete=input.next();
				website.deleteHistoryExtension(extensionDelete);
				
				
				break;
			}
			case 9: {
				System.out.println("enter the url for updation");
				String updatedUrl = input.next();
				System.out.println("enter the index whose url needs to be updated :");
				int updatedUrlIndex = input.nextInt();
				website.updateHistory(updatedUrlIndex, updatedUrl);
				break;
			}

			case 10: {
				System.out.println("enter number of steps to forward: ");
				int steps = input.nextInt();
				String urlForward = null;
				try {
					urlForward = website.forward(steps);
				} catch (NoHistoryFoundException e) {
					System.out.println(e);
					System.out.println("You have reached the end of your browsing history!");

				}
				System.out.println(urlForward);
				break;
			}

			case 11: {
				System.out.println("enter number of steps to move backward: ");
				int steps = input.nextInt();
				String urlBackward = null;
				try {
					urlBackward = website.back(steps);
				} catch (NoHistoryFoundException e) {
					System.out.println(e);
				}
				System.out.println(urlBackward);
				break;

			}
			case 12:
				System.out.println("exiting the program!");

				break;
			default:
				System.out.println("invalid choice");
				break;
			}
		} while (choice != 12);

		// exercise 2-oops concept
		Browser pages = new Browser(BROWSER);
		Browser tabOne = new GoogleChrome(BROWSER, "google chrome");
		Browser tabTwo = new Firefox(BROWSER, "firefox");
		Browser tabThree = new Firefox(BROWSER, "firefox");
		Browser tabFour = new GoogleChrome(BROWSER, "google chrome");
		Browser tabFive = new GoogleChrome(BROWSER, "google chrome");
		Browser[] allBrowsers = { tabOne, tabTwo, tabThree, tabFour, tabFive };
		pages.whoAmI();
		tabOne.whoAmI();
		tabThree.whoAmI();
		// exercise 3-wrapper class
		int fetchTab = GoogleChrome.noOfTabs(allBrowsers);
		Integer googleTab = fetchTab; // autoboxing
		int openedTabs = googleTab; // unboxing
		System.out.println("No of google chrome tabs: " + openedTabs);

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
