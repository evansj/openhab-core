/**
 * Copyright (c) 2015-2019 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.core.compat1x.internal;

import static org.junit.Assert.assertEquals;

import javax.measure.quantity.Temperature;

import org.eclipse.smarthome.core.library.types.DecimalType;
import org.eclipse.smarthome.core.library.types.QuantityType;
import org.junit.Test;
import org.openhab.core.library.types.DateTimeType;
import org.openhab.library.tel.types.CallType;

public class TypeMapperTest {

    @Test
    public void testDateTypeType() {
        DateTimeType ohType1 = new DateTimeType();
        DateTimeType ohType2 = (DateTimeType) TypeMapper.mapToOpenHABType(TypeMapper.mapToESHType(ohType1));
        assertEquals(ohType1.toString(), ohType2.toString());
    }

    @Test
    public void testCallType() {
        CallType ohType1 = new CallType("123##456");
        CallType ohType2 = (CallType) TypeMapper.mapToOpenHABType(TypeMapper.mapToESHType(ohType1));
        assertEquals(ohType1, ohType2);
    }

    @Test
    public void testQuantityType() {
        QuantityType<Temperature> eshType1 = new QuantityType<>("10 °C");
        DecimalType eshType2 = (DecimalType) TypeMapper.mapToESHType(TypeMapper.mapToOpenHABType(eshType1));
        assertEquals(eshType1.as(DecimalType.class), eshType2);
    }
}
