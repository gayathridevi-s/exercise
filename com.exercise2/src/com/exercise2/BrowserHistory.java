package com.exercise2;

import java.util.ArrayList;

public class BrowserHistory {
	String homepage;
	String visitedUrl;
	int maxSteps;
	int urlCount;
	int currentPosition;
	String lastUrl;
	ArrayList<String> urlList = new ArrayList<>();

	public BrowserHistory(String homepage) {
		this.homepage = homepage;
	}

	public String visit(String url) {
		visitedUrl = url;
		urlList.add(visitedUrl);
		urlCount = urlList.size();
		maxSteps = urlCount - 1;
		lastUrl = urlList.get(maxSteps);
		return urlList.toString();

	}

	public String get(int position) {
		currentPosition = position;
		return urlList.get(currentPosition);
	}

	public String forward(int steps) throws NoHistoryFoundException {
		if ((currentPosition + steps) > maxSteps) {
			System.out.println("the furthest you can forward is " + lastUrl);
			throw new NoHistoryFoundException("No history found");
		} else {
			return urlList.get(currentPosition + steps);
		}
	}

	public String back(int steps) throws NoHistoryFoundException {
		if (currentPosition - steps < 0) {
			System.out.println("You have reached the begining of your browsing history. The first url is " + urlList.get(0));
			throw new NoHistoryFoundException("no history found");
		} else {
			return urlList.get(currentPosition - steps);
		}
	}
}

class invalidURLException extends Exception {
	public invalidURLException(String message) {
		super(message);
	}
}

class NoHistoryFoundException extends Exception {
	public NoHistoryFoundException(String message) {
		super(message);
	}
}

class InvalidPositionException extends Exception {
	public InvalidPositionException(String message) {
		super(message);
	}
}