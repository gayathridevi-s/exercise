package com.threadexercise;

import java.util.ArrayList;
import java.util.List;
class ReadAndDelete{
	private ArrayList<String> history=new ArrayList<>();
	private boolean flag=true;
	public  void addUrls(List<String> urls) {
	    this.history.addAll(urls);
	    
	}
	
	public synchronized void readUrl() {
		while (!flag||history.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		String first = this.history.get(0);
		System.out.println("read url :"+first);
		flag = false;
		notifyAll();
		
	}
	public synchronized void deleteUrl() {

		while (flag||history.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
			String removed = this.history.remove(0);
			System.out.println("removed url:" + removed);
		
		flag = true;
		notifyAll();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	
}
public class Browser {
	public static void main(String[] args) {
		ArrayList<String> urlList = new ArrayList<>();
		urlList.add("www.google.com");
		urlList.add("www.mozilla.com");
		urlList.add("www.facebook.com");
		urlList.add("www.instagram.com");
		urlList.add("www.github.com");
		urlList.add("www.firefox.com");
		urlList.add("www.yahoo.com");
		urlList.add("www.twitter.com");
		ReadAndDelete object=new ReadAndDelete();
		object.addUrls(urlList);
		Read r = new Read(object);
		Thread read = new Thread(r);
		Delete d = new Delete(object);
		Thread delete = new Thread(d);
		read.start();
		delete.start();

	}
}

class Read implements Runnable {
	ReadAndDelete list;
	public Read(ReadAndDelete list){
		this.list=list;
	}
	@Override
	public void run() {
		while (true) {
			list.readUrl();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	
}

class Delete implements Runnable {
	ReadAndDelete list;

	public Delete(ReadAndDelete list) {
		this.list = list;
		
	}

	@Override
	public void run() {
		while (true) {
			list.deleteUrl();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}

	
}
