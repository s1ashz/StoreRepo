package com.polo.rest.polo.validators;

import static com.polo.rest.polo.constants.ExceptionMessages.*;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.polo.rest.polo.CreateObjectsTest;
import com.polo.rest.polo.dto.EventDto;

@RunWith(SpringRunner.class)
public class EventValidatorTest {

	@InjectMocks
	private EventValidator eventValidator;
	private EventDto eventDto;
	
	private String EXCEPTION_EVENT_NOT_CREATED_TEST = EXCEPTION_EVENT_NOT_CREATED;
	private String EXCEPTION_EVENT_TARGET_NULL_TEST = EXCEPTION_EVENT_TARGET_NULL;
	private String EXCEPTION_INVALID_EVENT_MESSAGE_TEST = EXCEPTION_INVALID_EVENT_MESSAGE;
	private String EXCEPTION_EVENT_NOT_EXISTS_TEST = EXCEPTION_EVENT_NOT_EXISTS;
	
	@Before
	public void instantiate() {
		MockitoAnnotations.initMocks(this);
		//eventDto = CreateObjectsTest.createEventDto();

	
	
	
	}
	
	@Test
	public void test() {
		//TODO do tests latter....leelkek
		assertTrue(true);
	}
	
	
	
	
}
