package com.diegotomfurtado.liferayproject.testSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.diegotomfurtado.liferayproject.executionTests.CreateNewFormTest;
import com.diegotomfurtado.liferayproject.executionTests.FieldBoxMessageTest;
import com.diegotomfurtado.liferayproject.executionTests.FieldDateTest;
import com.diegotomfurtado.liferayproject.executionTests.FieldNameTest;

@RunWith(Suite.class)
@SuiteClasses({ 
	CreateNewFormTest.class,
	FieldNameTest.class,
	FieldBoxMessageTest.class,
	FieldDateTest.class
})

public class ExecutionSuites {
	// Nothing To describe
}
