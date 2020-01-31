package allTests.controllerTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import shop.controller.DAOAuthentification;
import shop.controller.HashSalting;
import shop.model.User;


public class DAOAuthTest {
	
	//private DAOAuthentification daoAuth = new DAOAuthentification();
	
	DAOAuthentification authSpy = Mockito.spy(DAOAuthentification.class);

	User userMock = Mockito.mock(User.class);
	
	ArrayList<User> userList = new ArrayList<User>();
	
	@Test
	/**
	 * Checks that correct Users are returned while using the getAllUsers method.
	 */
	public void allUsersAreFound() {
		//need a testing .csv file
	}
	
	@Test
	/**
	 * Checks that 0 is returned if the authentification failed or 1 if it succeeded.
	 */
	public void AuthChecked() throws Exception {
		userList.add(userMock);
		Mockito.doReturn(userList).when(authSpy).getAllUsers();
		Mockito.when(userMock.getUsername()).thenReturn("test");
		Mockito.when(userMock.getHashPassword()).thenReturn(HashSalting.getSaltedHash("test"));
		assertEquals(1,authSpy.checkAuth("test","test"));
		assertEquals(0,authSpy.checkAuth("test","noTest"));
		assertEquals(0,authSpy.checkAuth("noTest","noTest"));
		assertEquals(0,authSpy.checkAuth("noTest","test"));
		assertEquals(0,authSpy.checkAuth("",""));
	}
}
