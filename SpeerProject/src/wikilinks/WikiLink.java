package wikilinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;

import testbase.TestBase;

public class WikiLink extends TestBase{
	public static void main(String[] args) {
		
		WebDriver dr = TestBase.getInstance();
		
        String url = "http://en.wikipedia.org/wiki/";
        HttpURLConnection huc = null;
        int respCode = 200;
        List<String> all_elements_text=new ArrayList<>();
        
		for(int i=1;i<=20;i++) {
			
			dr.get(url+i);
			try {
				huc = (HttpURLConnection)(new URL(url+i).openConnection());
                
                huc.setRequestMethod("HEAD");
                
                huc.connect();
                
                respCode = huc.getResponseCode();
                if(respCode >= 400){
                    System.out.println(url+" is a broken link");
                }
                else{
                    System.out.println(url+" is a valid link");
                    all_elements_text.add(url+i);
                }
				
			} catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
			
		}
		
		for (String r : all_elements_text) {
			System.out.println(r);
		}
	}
}
