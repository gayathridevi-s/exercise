package wrapper.com;

class Browser {
	int noOfTabs;
	Integer tabs;
	int tabFetch;

	Browser(int noOfTabs) {
		this.noOfTabs = noOfTabs;
	}

	public Integer countTabs() {
		Integer tabs = noOfTabs;
		return tabs;
	}
	public int fetchTabs(Integer value) {
		//int tabFetch=value;
		return value;
	}
	 

}

public class Main {
	public static void main(String[] args) {
		Browser browser = new Browser(10);
		Integer countTab = browser.countTabs();
		System.out.println(countTab);
		int fetchTab=browser.fetchTabs(countTab);
		System.out.println(fetchTab);
		
		//System.out.println(typeof(fetchTab));
		System.out.println(countTab.getClass());
		//System.out.println(browser.getClass());
	}
}
