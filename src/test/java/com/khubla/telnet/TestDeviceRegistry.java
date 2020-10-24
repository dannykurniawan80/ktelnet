/*
 * Copyright (C) khubla.com - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Tom Everett <tom@khubla.com>, 2018
 */
package com.khubla.telnet;

import org.testng.*;
import org.testng.annotations.*;

import com.khubla.telnet.nvt.tn3270.devicetype.*;

public class TestDeviceRegistry {
	@Test
	public void test1() {
		try {
			final DeviceType dt = DeviceTypeRegistry.getInstance().getDevice("IBM-3278-3");
			Assert.assertNotNull(dt);
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
