package com.exerciseBrowser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class BrowserHistory {
	String homepage;
	String visitedUrl;
	int maxSteps;
	int urlCount;
	int currentPosition;
	String lastUrl;
	ArrayList<String> urlList = new ArrayList<>();
	LinkedList<String> urlListLinked = new LinkedList<>();
	Stack<String> urlListStack = new Stack<>();
	Vector<String> urlListVector = new Vector<>();
	HashSet<String> urlSet = new HashSet<>();
	LinkedHashSet<String> urlLinkedSet = new LinkedHashSet<>();
	TreeSet<String> urlTreeSet = new TreeSet<>();
	HashMap<String, List<String>> urlHashMap = new HashMap<>();
	LinkedHashMap<String, List<String>> urlLinkedHashMap = new LinkedHashMap<>();
	TreeMap<String, List<String>> urlTreeMap = new TreeMap<>();

//	public BrowserHistory(String homepage) {
//		this.homepage = homepage;
//	}

	public BrowserHistory() {
		// TODO Auto-generated constructor stub
	}
	public void visit(String url) {
		visitedUrl = url;
		String urlExtension = visitedUrl.substring(visitedUrl.lastIndexOf("."));

		urlList.add(visitedUrl);

		if (!urlHashMap.containsKey(urlExtension)) {
			urlHashMap.put(urlExtension, new ArrayList<>());
		}

		urlHashMap.get(urlExtension).add(visitedUrl);
		if (!urlLinkedHashMap.containsKey(urlExtension)) {
			urlLinkedHashMap.put(urlExtension, new ArrayList<>());
		}

		urlLinkedHashMap.get(urlExtension).add(visitedUrl);
		if (!urlTreeMap.containsKey(urlExtension)) {
			urlTreeMap.put(urlExtension, new ArrayList<>());
		}

		urlTreeMap.get(urlExtension).add(visitedUrl);

		urlCount = urlList.size();
		maxSteps = urlCount - 1;
		lastUrl = urlList.get(maxSteps);
		urlListLinked.add(visitedUrl);
		urlListStack.add(visitedUrl);
		urlListVector.add(visitedUrl);
		urlSet.add(visitedUrl);
		urlLinkedSet.add(visitedUrl);
		urlTreeSet.add(visitedUrl);
	}
	public void setUrlUpdated(ArrayList<String> readHistory) {
		urlList.clear();
		urlList.addAll(readHistory);
		urlListLinked.clear();
		urlListLinked.addAll(readHistory);
		urlListStack.clear();
		urlListStack.addAll(readHistory);
		urlListVector.clear();
		urlListVector.addAll(readHistory);
		urlSet.clear();
		urlSet.addAll(readHistory);
		urlLinkedSet.clear();
		urlLinkedSet.addAll(readHistory);
		urlTreeSet.clear();
		urlTreeSet.addAll(readHistory);
		
	}
	public ArrayList<String> returnUrl() {
		return urlList;
	}
	

	public void sort() {
		ArrayList<String> copyUrlList = (ArrayList<String>) urlList.clone();
		Collections.sort(copyUrlList);
		LinkedList<String> copyUrlListLinked = (LinkedList<String>) urlListLinked.clone();
		Collections.sort(copyUrlListLinked);
		Stack<String> copyUrlListStack = (Stack<String>) urlListStack.clone();
		Collections.sort(copyUrlListStack);
		Vector<String> copyUrlListVector = (Vector<String>) urlListVector.clone();
		Collections.sort(copyUrlListVector);
		List<String> urlModifiedSet = new ArrayList<>(urlSet);
		Collections.sort(urlModifiedSet);
		List<String> urlModifiedLinkedSet = new ArrayList<>(urlLinkedSet);
		Collections.sort(urlModifiedLinkedSet);
		System.out.println("Sorted array list of url : " + copyUrlList);
		System.out.println("sorted linked list of url :" + copyUrlListLinked);
		System.out.println("sorted stack of url :" + copyUrlListStack);
		System.out.println("sorted vector of url  :" + copyUrlListVector);
		System.out.println("sorted set of url :" + urlModifiedSet);
		System.out.println("sorted linked set of url" + urlModifiedLinkedSet);
	}

	public void deleteHistory(int index) {
		urlList.remove(index);
		urlListLinked.remove(index);
		urlListStack.remove(index);
		urlListVector.remove(index);
		System.out.println("arraylist of url after removing url at index " + index + " " );
		System.out.println( urlList);
		System.out.println("linked list of url after removing url at index " + index + " ");
		System.out.println(urlListLinked);
		System.out.println("Stack of url after removing url at index " + index + " ");
		System.out.println(urlListStack);
		System.out.println("Vector of url after removing url at index " + index + " " );
		System.out.println(urlListVector);
	}

	public void deleteHistory(String deleteUrl) {
		urlList.remove(deleteUrl);
		urlListLinked.remove(deleteUrl);
		urlListStack.remove(deleteUrl);
		urlListVector.remove(deleteUrl);
		urlSet.remove(deleteUrl);
		urlLinkedSet.remove(deleteUrl);
		urlTreeSet.remove(deleteUrl);
		System.out.println("array list of url after removing  " + deleteUrl + " :");
		System.out.println(urlList);
		System.out.println("linked list of url after removing  " + deleteUrl + ": ");
		System.out.println(urlListLinked);
		System.out.println("Stack of url after removing  " + deleteUrl + ": ");
		System.out.println(urlListStack);
		System.out.println("Vector of url after removing  " + deleteUrl + " :");
		System.out.println(urlListVector);
		System.out.println("Set of url after removing  " + deleteUrl + " :");
		System.out.println(urlSet);
		System.out.println("Linked Set of url after removing  " + deleteUrl + ": ");
		System.out.println(urlLinkedSet);
		System.out.println("TreeSet of url after removing  " + deleteUrl + " :");
		System.out.println(urlTreeSet);
	}

	public void deleteHistoryExtension(String extension) {
		Set<String> keys = urlHashMap.keySet();
		Iterator<String> iter = keys.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			if (key.equals(extension)) {
				iter.remove();
			}
		}
		Set<String> linkedKeys = urlLinkedHashMap.keySet();
		Iterator<String> iterLinked=linkedKeys.iterator();
		while(iterLinked.hasNext()) {
			String linkedKey=iterLinked.next();
			if(linkedKey.equals(extension)) {
				iterLinked.remove();
			}
		}
		Set<String> treeKeys = urlTreeMap.keySet();
		Iterator<String> iterTree=treeKeys.iterator();
		while(iterTree.hasNext()) {
			String treeKey=iterTree.next();
			if(treeKey.equals(extension)) {
				iterTree.remove();
			}
		}
		
	}

	public void fetchHistory() {
		System.out.println("history of visited url in array list:");
		System.out.println(urlList);
		System.out.println("history of visited url in linked list:");
		System.out.println(urlListLinked);
		System.out.println("history of visited url in stack");
		System.out.println(urlListStack);
		System.out.println("history of visited url in vector");
		System.out.println(urlListVector);
		System.out.println("history of visited url in hash set");
		System.out.println(urlSet);
		System.out.println("history of visited url in linked hashset");
		System.out.println(urlLinkedSet);
		System.out.println("history of visited url in tree set:");
		System.out.println(urlTreeSet);
		System.out.println("history of visited url with its extension in hash map");
		System.out.println(urlHashMap);
		System.out.println("history of visited url with its extension in linked hash map");
		System.out.println(urlLinkedHashMap);
		System.out.println("history of visited url with its extension in tree map");
		System.out.println(urlTreeMap);
	}

	public void fetchHistory(String extension) {
		Set<String> keys = urlHashMap.keySet();
		if (keys.contains(extension)) {
			System.out.println(extension + urlHashMap.get(extension));
		}
	}

	public void size() {
		System.out.println("size of history arraylist :" + urlList.size());
		System.out.println("size of history linked list :" + urlListLinked.size());
		System.out.println("size of stack of url :" + urlListStack.size());
		System.out.println("size of vector url :" + urlListVector.size());
		System.out.println("size of history hashset :" + urlSet.size());
		System.out.println("size of history linked hash set :" + urlLinkedSet.size());
		System.out.println("size of history tree set :" + urlTreeSet.size());

	}

	public void size(String extension) {
		Set<String> keys = urlHashMap.keySet();
		for (String key : keys) {
			if (key.equals(extension)) {
				System.out.println(urlHashMap.get(key).size());

			}
		}

	}

	public void search(String extension) {
		ArrayList<String> urlWithExtension = new ArrayList<>();
		List<Collection<String>> allCollections=Arrays.asList(urlList,urlListLinked,urlListStack,urlListVector,urlSet,urlLinkedSet,urlTreeSet);
		for(Collection<String>collection:allCollections) {
			for(String eachUrl:collection) {
				if(eachUrl.endsWith(extension)) {
					urlWithExtension.add(eachUrl);
				}
				
			}
			if (!urlWithExtension.isEmpty()) {
				displaySearchHistory(urlWithExtension, extension, "Arraylist");
			}
			urlWithExtension.clear();
		}
		
	}

	public void updateHistory(int updateUrlIndex, String updatedUrl) {
		String oldUrl = urlList.get(updateUrlIndex);
		System.out.println("updated url history :");
		urlList.set(updateUrlIndex, updatedUrl); // update array list
		urlListLinked.set(updateUrlIndex, updatedUrl); // update linked array list
		urlListStack.set(updateUrlIndex, updatedUrl); // update stack
		urlListVector.set(updateUrlIndex, updatedUrl); // update vector

		urlSet.remove(oldUrl); // update hash set
		urlSet.add(updatedUrl);

		urlLinkedSet.remove(oldUrl); // update linked hash set
		urlLinkedSet.add(updatedUrl);

		urlTreeSet.remove(oldUrl); // update tree set
		urlTreeSet.add(updatedUrl);

	}

	public void displaySearchHistory(List<String> urlWithExtension, String extension, String typeOfCollection) {
		System.out.println("Search history of urls with extension " + extension + " using " + typeOfCollection);
		for (String urls : urlWithExtension) {
			System.out.println(urls);
		}
	}
	public void wordSearch(String word) {	//search url by word
		for(List<String>urls:urlHashMap.values()) {
			for(String url:urls) {
				if(url.contains(word)) {
					System.out.println(url);
				}
			}
		}
	}

	public String get(int position) {	//to access the url of given position
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
			System.out.println(
					"You have reached the begining of your browsing history. The first url is " + urlList.get(0));
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