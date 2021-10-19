package com.aiyo407.literature;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "Hello World rule", description = "Always say hello world")
public class HelloWorldRule {

	@Condition
	public boolean when(@Fact("isFirst") boolean isFirst ) {
		return isFirst;
	}

	@Action
	public void then(@Fact("isFirst") boolean isFirst) throws Exception {
		System.out.println("hello world,"+isFirst);
	}

}
