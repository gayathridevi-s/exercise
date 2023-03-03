package com.exercise2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainHistory {
	public static void main(String[] args) {
		BrowserHistory chrome = new BrowserHistory("GoogleChrome");
		Scanner input = new Scanner(System.in);
		int position;
		int choice = 0;

		do {
			System.out.println("enter your choice:");
			System.out.println("1:visit url");
			System.out.println("2:get url");
			System.out.println("3:move forward");
			System.out.println("4:move backward");
			System.out.println("5:exit");
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
				// String list;
				try {
					if (site.endsWith(".com") || site.endsWith(".in") || site.endsWith(".org")) {
						String list = chrome.visit(site);
						System.out.println(list);
					} else {
						throw new invalidURLException("invalid URL extension");
					}
				} catch (invalidURLException e) {
					System.out.println(e);

				}

				break;
			}
			case 2: {
				System.out.println("enter the position");
				position = input.nextInt();
				try {
					if (position >= chrome.urlList.size()) {
						throw new IndexOutOfBoundsException("Invalid position");
					} else if (position <= -1) {
						throw new InvalidPositionException("Provide only positive values");
					} else {
						String getUrl = chrome.get(position);
						System.out.println(getUrl);
					}

				} catch (IndexOutOfBoundsException e) {
					System.out.println(e);
				} catch (InvalidPositionException f) {
					System.out.println(f);
				}

				break;
			}
			case 3: {
				System.out.println("enter number of steps to forward: ");
				int steps = input.nextInt();
				String urlForward = null;
				try {
					urlForward = chrome.forward(steps);
				} catch (NoHistoryFoundException e) {
					System.out.println(e);
					System.out.println("You have reached the end of your browsing history!");

				}
				System.out.println(urlForward);
				break;
			}

			case 4: {
				System.out.println("enter number of steps to move backward: ");
				int steps = input.nextInt();
				String urlBackward = null;
				try {
					urlBackward = chrome.back(steps);
				} catch (NoHistoryFoundException e) {
					System.out.println(e);
				}
				System.out.println(urlBackward);
				break;

			}
			case 5:
				System.out.println("exiting the program!");
				System.exit(0);
			default:
				System.out.println("invalid choice");
				break;
			}
		} while (choice != 5);
	}
}
