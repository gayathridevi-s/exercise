package exercise1;
import java.util.Scanner;
class Browser{
	private static String[] url;
	Browser(){
		
	}
	void setUrl(String[] url) {
		this.url=url;
	}
	String[] getUrl() {
		return url;
	}
	Browser(String[] url){
		this.url=url;
	}
	
}
public class browse {

	public static void main(String[] args) {

		String [] history= new String[4];
		String [] chromeTemp = new String[4];
		String [] mozillaTemp = new String[4];
		
		for(int i=0;i<4;i++) {
			Scanner input=new Scanner(System.in);
			history[i]=input.nextLine();
		}
		
		Browser chrome=new Browser();
		chrome.setUrl(history);
		for(int i=0;i<4;i++) {
			Scanner input=new Scanner(System.in);
			history[i]=input.nextLine();
		}
		Browser mozilla=new Browser(history);
		chromeTemp=chrome.getUrl();
		mozillaTemp=mozilla.getUrl();
		for(int i=0;i<4;i++) {
		System.out.println(chromeTemp[i]);
		
		}
		for(int i=0;i<4;i++) {
		System.out.println(mozillaTemp[i]);

		}
	}
}
