package com.aiyo407.literature;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

/**
 * @author luzh
 * @version 1.0.0
 * @ClassName Launcher.java
 * @Description TODO
 * @createTime 2021年03月29日 10:56:00
 */
public class Launcher {

	public static void main(String[] args) {
		// create facts
		Facts facts = new Facts();
		facts.put("isFirst",true);
		// create rules
		Rules rules = new Rules();
		HelloWorldRule rule = new HelloWorldRule();
		rules.register(rule);

		// create a rules engine and fire rules on known facts
		RulesEngine rulesEngine = new DefaultRulesEngine();
		rulesEngine.fire(rules, facts);

	}
}
