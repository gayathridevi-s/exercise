package com.exercise2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Browser {
	Scanner enter = new Scanner(System.in);
	String[] historyNumber = new String[10];
    int count = 0;


	Browser(String name1) {
		System.out.println("This is " + name1 + " class");
	}

	Browser() {

	}

	private static String[] url;

	public void whoAmI() {
		System.out.println("I am a browser");
	}

	static class History { // static inner class
		public void setUrl(String[] history) {
			url = history;
		}

		public static String getUrl() {
			return Arrays.toString(url);
		}
	}
	//int count =0;
	public void historyCount(String name) {
		boolean flag = false;
		//int count = 0;

        for (int j = 0; j < count; j++) {
            if (historyNumber[j].startsWith(name)) {
                String[] splittedUrl = historyNumber[j].split("##");
                
                int num = Integer.parseInt(splittedUrl[1].trim());
                historyNumber[j] = (name + " ## " + (num + 1));
                flag = true;
            }
        }

        if (!flag) {
            historyNumber[count] = (name + " ## " + 1);
            count++;
        }

        for (int j = 0; j < count; j++) {
            System.out.println(historyNumber[j]);
        }
	}

	class Bookmarks {
		ArrayList<String> bookmark = new ArrayList<>();

		void addBookmarks() {
			System.out.println("enter url to be bookmarked(type N to exit): ");
			while (true) {

				String webSite = enter.next();

				if (webSite.equalsIgnoreCase("N")) {
					break;
				}
				bookmark.add(webSite);
			}
		}

		String displayBookmark() {
			return bookmark.toString();
		}

	}

	interface Shortcuts {
		public void addShortcuts();
		public String displayShortcuts();
	}

	
	
}