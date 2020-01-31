package allTests.controllerTest;

import static org.junit.Assert.*;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsNot;
import org.junit.Test;

import shop.controller.HashSalting;

/**
 * 
 * @author Pierre Pallier, Romain Bachelier
 * Test class for HashSalting class.
 *
 */
public class HashingTest {
	
	@Test
	/**
	 * Checks if the hashing in SHA-512 is correct.
	 */
	public void hashingIsCorrect() throws Exception
	{
			assertEquals("97464b0e4a590cecf9f30741200c51fc98c954d9ddcb8ec4b5b671712bcae53ff7ad952fa239d36e88cba5c5eade4fa6caf1619cd0ae0fcbd30e5ad1bba16509"
					,HashSalting.getSaltedHash("exemple"));
			assertThat("", Is.is(IsNot.not(HashSalting.getSaltedHash("exemple"))));
	}

}
