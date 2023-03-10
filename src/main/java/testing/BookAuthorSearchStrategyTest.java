package testing;

import home.yorku.bookmarks.controller.search.BookAuthorSearchStrategy;
import home.yorku.bookmarks.model.SearchCriteria;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class BookAuthorSearchStrategyTest {

    //This test tests to ensure the URL for searching by author name is correct
    @Test
    void getSearchURLRegAuthorSearch() throws MalformedURLException {

        BookAuthorSearchStrategy urlTester = new BookAuthorSearchStrategy();
        String type = "book";
        String searchKey = "author";
        String value = "Stephen King";
        URL expected = new URL("https://openlibrary.org/search.json?author=Stephen%20King&sort=new");
        SearchCriteria searchCriteria = new SearchCriteria(type,searchKey,value);

        URL actual = urlTester.getSearchURL(searchCriteria);

        assertEquals(expected, actual);
    }
    //This test tests to ensure the URL for when a search is null is correct
    void getSearchURLNullAuthorSearch() throws MalformedURLException {

        BookAuthorSearchStrategy urlTester = new BookAuthorSearchStrategy();
        String type = "book";
        String searchKey = "author";
        String value = "";
        URL expected = new URL("https://openlibrary.org/search.json?author=&sort=new");
        SearchCriteria searchCriteria = new SearchCriteria(type,searchKey,value);

        URL actual = urlTester.getSearchURL(searchCriteria);

        assertEquals(expected, actual);
    }
    //This test tests to ensure the URL for when a search is incorrect is correct
    void getSearchURLIncorrectAuthorSearch() throws MalformedURLException {

        BookAuthorSearchStrategy urlTester = new BookAuthorSearchStrategy();
        String type = "book";
        String searchKey = "author";
        String value = "Cars3231";
        URL expected = new URL("https://openlibrary.org/search.json?author=Cars3231&sort=new");
        SearchCriteria searchCriteria = new SearchCriteria(type,searchKey,value);

        URL actual = urlTester.getSearchURL(searchCriteria);

        assertEquals(expected, actual);
    }
}