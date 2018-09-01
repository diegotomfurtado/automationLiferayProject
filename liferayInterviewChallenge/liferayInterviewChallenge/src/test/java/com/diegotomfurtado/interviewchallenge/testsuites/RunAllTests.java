package com.diegotomfurtado.interviewchallenge.testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.diegotomfurtado.interviewchallenge.tests.CreateNewFormTest;
import com.diegotomfurtado.interviewchallenge.tests.FieldBoxMessageTest;
import com.diegotomfurtado.interviewchallenge.tests.FieldDateTest;
import com.diegotomfurtado.interviewchallenge.tests.FieldNameTest;

@RunWith(Suite.class)
@SuiteClasses({ 
	CreateNewFormTest.class,
	FieldNameTest.class,
	FieldBoxMessageTest.class,
	FieldDateTest.class
})


public class RunAllTests {
	//nothing to do, for while.

}
