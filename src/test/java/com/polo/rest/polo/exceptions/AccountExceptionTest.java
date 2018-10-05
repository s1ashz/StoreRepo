package com.polo.rest.polo.exceptions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class AccountExceptionTest {
	
	private String DEFAULT_MESSAGE = "this is a test exception message";
	private AccountException accountException;
	
	@Test
	public void testInstance() {
		accountException = new AccountException( DEFAULT_MESSAGE );
		assertEquals(accountException.getMessage(), DEFAULT_MESSAGE );
	}
	
	
}
