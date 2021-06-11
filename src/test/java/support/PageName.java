package support;

import java.util.HashMap;

public class PageName {
    private static HashMap<String, String> PAGE_URLS = null;
    private static final String GOOGLE_SEARCH = "Google search engine";

    public static HashMap<String, String> getPageUrl() {
        if (PAGE_URLS != null) {
            return PAGE_URLS;
        }
        PAGE_URLS = new HashMap<>();
        //by Vishal
        PAGE_URLS.put(PageName.GOOGLE_SEARCH, "https://www.google.com/");

        return PAGE_URLS;
    }
}
