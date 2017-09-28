package com.ncr.example.reversegeocoding;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestAddress {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
       Address.parse("277 Bedford Ave, Brooklyn, NY 11211, USA");
    }

}
