package wikilinks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testbase.TestBase;

public class WikiLinkCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver dr = TestBase.getInstance();
		 String url = "http://en.wikipedia.org/wiki/";
		 String notwork = "NOT WORKING: WIKIPEDIA";
		 dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		dr.get(url);					
    List<WebElement> linkElement = dr.findElements(By.tagName("a"));
    String[] linktxt = new String[linkElement.size()];
    int i=0;
    for (WebElement el : linkElement) {							
		linktxt[i] = el.getText();							
		i++;
    }
	for (String t : linktxt) {							
		dr.findElement(By.linkText(t)).click();					
		if (dr.getTitle().equals(notwork)) 
		{							
            System.out.println("\"" + t + "\""								
                    + " not working.");
	}
		 else {			
             System.out.println("\"" + t + "\""								
                     + " is working.");			
         }		
			dr.navigate().back();			
     }		
}
}