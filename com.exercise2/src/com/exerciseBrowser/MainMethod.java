package com.exerciseBrowser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import hack.Hacker;

public class MainMethod {

	public static void main(String[] args) throws IOException {
		final String BROWSER = "browser"; // final String
		Scanner input = new Scanner(System.in);
		Browser chrome = new Browser(BROWSER);
		BrowserHistory website = new BrowserHistory();

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
			System.out.println("2:fetch history using all collections!");
			System.out.println("3:fetch history using extension");
			System.out.println("4:fetch history ");
			System.out.println("5:search extension");
			System.out.println("6:get url");
			System.out.println("7:sort");
			System.out.println("8:size");
			System.out.println("9:delete history");
			System.out.println("10:update history");
			System.out.println("11:search url by word");
			System.out.println("12:move forward");
			System.out.println("13:move backward");
			System.out.println("14:write contents of file");
			System.out.println("15:read contents of file");
			System.out.println("16:exit");
			ArrayList<String> visitedHistory=website.returnUrl();
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
			//exercise-7 collections framework
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
			case 4:{
				System.out.println(website.returnUrl());
				break;
			}
			case 5: {
				System.out.println("type the extension to search its url:");
				String extension=input.next();
				website.search(extension);
				
				break;
			}
			case 6: {
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
			case 7: {
				website.sort();
				break;
			}
			case 8: {
				website.size();
				System.out.println("enter the extension of url whose size is needed:");
				String extensionSize=input.next();
				System.out.println("size of url with extension"+extensionSize+" :");
				website.size(extensionSize);
				break;
			}
			case 9: {
				System.out.println("enter the url that needs to be deleted:");
				String deleteUrl = input.next();
				website.deleteHistory(deleteUrl);
				System.out.println();
				System.out.println("enter the index whose url needs to be deleted");
				int deleteIndex=input.nextInt();
				website.deleteHistory(deleteIndex);
				System.out.println();
				System.out.println("enter the extension whose url needs to be deleted");
				String extensionDelete=input.next();
				website.deleteHistoryExtension(extensionDelete);
				
				
				break;
			}
			case 10: {
				System.out.println("enter the url for updation");
				String updatedUrl = input.next();
				System.out.println("enter the index whose url needs to be updated :");
				int updatedUrlIndex = input.nextInt();
				website.updateHistory(updatedUrlIndex, updatedUrl);
				break;
			}

			case 11:{
				System.out.println("enter the word that needs to be searched in url");
				String word=input.next();
				website.wordSearch(word);
				break;
			}
			case 12: {
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

			case 13: {
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
			//exercise 8-file handling
			case 14:
			{
				//ArrayList<String> visitedHistory=website.returnUrl();
				System.out.println("type the name of file you want to create:");
				String file=input.next();
				new Hacker(visitedHistory);
				Hacker.writeToFile(file);
				break;
			}
			case 15:
			{ 	System.out.println("type the name of file you want to read:");
			       String readFileContent=input.next();
				ArrayList<String>readHistory=Hacker.readFile(readFileContent);
				System.out.println("the contents in the file are:");
				System.out.println(readHistory);
				
				if(!(website.returnUrl()).equals(readHistory)) {
					website.setUrlUpdated(readHistory);
					
					System.out.println("the list gets updated!");
				}
				break;
			}
			case 16:
				System.out.println("exiting the program!");

				break;
			default:
				System.out.println("invalid choice");
				break;
			}
		} while (choice != 16);
		
		
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
