package org.aming.test;

import static org.junit.Assert.*;

import org.aming.enums.Language;
import org.aming.translate.Dispatch;
import org.aming.translate.impl.YoudaoDispatch;
import org.junit.Test;

public class YoudaoDispatchTest {

	@Test
	public void translateTest() {
		Dispatch d = new YoudaoDispatch();
		System.out.println(d.translate(Language.ZH_CN, Language.EN,"你好"));
	}

}
