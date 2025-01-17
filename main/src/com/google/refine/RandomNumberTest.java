/*******************************************************************************
 * Copyright (C) 2018, OpenRefine contributors
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/
package com.google.refine.expr.functions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.testng.annotations.Test;

import com.google.refine.RefineTest;
import com.google.refine.expr.EvalError;
import com.google.refine.grel.Function;
import com.google.refine.util.TestUtils;
import com.google.refine.expr.functions.*;
import com.google.refine.expr.functions.math.*;

public class RandomNumberTest extends RefineTest {

    static Properties bindings = new Properties();

    /**
     * The test to verify the 2-args parameter behavior.
     */
    // CS 427 Issue link: https://github.com/OpenRefine/OpenRefine/issues/3143
    @Test
    public void testRandomNumberWithTwoParam() {
        RandomNumber rn = new RandomNumber();
        for(int i = 1; i<=100; i++) {
            int a = (int)rn.call(bindings, new Object[]{Long.valueOf(1), Long.valueOf(10)});
            assertTrue(a>=1 && a<10);
        }
    }

    /**
     * The test to verify the 2-args parameter Long type behavior.
     */
    // CS 427 Issue link: https://github.com/OpenRefine/OpenRefine/issues/3143
    @Test
    public void testRandomNumberWithThreeParamLongType() {
        RandomNumber rn = new RandomNumber();
        for(int i = 1; i<=100; i++) {
            Object a = rn.call(bindings, new Object[]{Long.valueOf(1), Long.valueOf(10), "long"});
            assertTrue(a.getClass() == Long.class);
            assertTrue((long)a>=1 && (long)a<10);
        }
    }

    /**
     * The test to verify the 2-args parameter Double type behavior.
     */
    // CS 427 Issue link: https://github.com/OpenRefine/OpenRefine/issues/3143
    @Test
    public void testRandomNumberWithThreeParamDoubleType() {
        RandomNumber rn = new RandomNumber();
        for(int i = 1; i<=100; i++) {
            Object a = rn.call(bindings, new Object[]{Long.valueOf(1), Long.valueOf(10), "double"});
            assertTrue(a.getClass() == Double.class);
            assertTrue((double)a>=1 && (double)a<=10);
        }
    }


    /**
     * The test to verify the 0-arg parameter behavior.
     */
    // CS 427 Issue link: https://github.com/OpenRefine/OpenRefine/issues/3143
    @Test
    public void testRandomNumberWithZeroParam() {
        RandomNumber rn = new RandomNumber();
        for(int i = 1; i<=100; i++) {
            Object a = rn.call(bindings, new Object[]{});
            assertTrue(a.getClass() == Double.class);
            assertTrue((double)a>=0 && (double)a<=1);
        }
    }
}
