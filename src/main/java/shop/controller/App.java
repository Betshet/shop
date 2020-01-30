package shop.controller;

import shop.model.Aisle;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Aisle aisle = new Aisle(0,"clothes",null);
    	windowControl.launchArticleWindow(aisle);
    }
}
