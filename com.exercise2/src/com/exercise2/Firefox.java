package com.exercise2;

public class Firefox extends Browser implements MultipleAccountContainers {
	String[] containerLists = new String[5];

	Firefox(String name1, String name2) {
		super(name1);
		System.out.println("this is " + name2 + " subclass");
	}

	void whoAmI() {
		System.out.println("I am Firefox");
	}

	public void addContainer(String name) {
		for (int i = 0; i < containerLists.length; i++) {
			if (containerLists[i] == null) {
				containerLists[i] = name;
				displayContainers(containerLists[i]);
				return;
			} else if (containerLists[i].equals(name)) {
				System.out.println("the container " + name + " already exists");
				return;
			} else if (i == containerLists.length - 1) {
				System.out.println("container is filled");
				return;
			}
		}
	}

	public void leaveContainer(String name) {
		for (int i = 0; i < containerLists.length; i++) {
			if (name.equals(containerLists[i])) {
				containerLists[i] = null;
				return;
			} else if (i == containerLists.length - 1) {
				System.out.println("the container " + name + " does not exist");
				return;
			}
		}
	}

	public void displayContainers(String name) {

		System.out.println(name);

	}

}
