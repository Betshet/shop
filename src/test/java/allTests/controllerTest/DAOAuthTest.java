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
	
	DAOAuthentification authSpy = Mockito.spy(DAOAuthentification.class);

	User userMock = Mockito.mock(User.class);
	
	ArrayList<User> userList = new ArrayList<User>();
	
	@Test
	/**
	 * Checks that 0 is returned if the authentification failed or 1 if it succeeded.
	 */
	public void AuthChecked() throws Exception {
		userList.add(userMock);
		Mockito.doReturn(userList).when(authSpy).getAllUsers();
		Mockito.when(userMock.getUsername()).thenReturn("test");
		Mockito.when(userMock.getHashPassword()).thenReturn(HashSalting.getSaltedHash("test"));
		
		assertEquals(userMock,authSpy.checkAuth("test","test"));
		assertEquals(null,authSpy.checkAuth("test","noTest"));
		assertEquals(null,authSpy.checkAuth("noTest","noTest"));
		assertEquals(null,authSpy.checkAuth("noTest","test"));
		assertEquals(null,authSpy.checkAuth("",""));
	}
	
}
