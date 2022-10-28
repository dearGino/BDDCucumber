package main.java.common;

import main.java.core.pages.HomePage;
import main.java.core.pages.MortagePage;


public class PageManager {

	private static PageManager pageManager;


    private HomePage homePage;
    private MortagePage mortagePage;


    private PageManager() {
    }

    
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }


    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public MortagePage getMortagePage() {
        if (mortagePage == null) {
        	mortagePage = new MortagePage();
        }
        return mortagePage;
    }
}
