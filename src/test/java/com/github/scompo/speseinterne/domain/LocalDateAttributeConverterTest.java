package com.github.scompo.speseinterne.domain;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LocalDateAttributeConverterTest {

	private static final LocalDate LOCAL_DATE_TEST = LocalDate.of(2015, 3, 10);

	private LocalDateAttributConverter localDateAttributConverter;

	@Before
	public void setUp() throws Exception {

		localDateAttributConverter = new LocalDateAttributConverter();
	}

	@After
	public void tearDown() throws Exception {

		localDateAttributConverter = null;
	}

	@Test
	public void testConvertToDatabaseColumnShouldReturnTheCorrectValue() {

		assertEquals(Date.valueOf(LOCAL_DATE_TEST), localDateAttributConverter.convertToDatabaseColumn(LOCAL_DATE_TEST));
	}

	@Test
	public void testConvertToDatabaseColumnShouldReturnNullIfAttributeIsNull() {

		assertNull(localDateAttributConverter.convertToDatabaseColumn(null));
	}

	@Test
	public void testConvertToEntityAttributeShouldReturnTheCorrectValue() {

		assertEquals(LOCAL_DATE_TEST,
				localDateAttributConverter.convertToEntityAttribute(Date.valueOf(LOCAL_DATE_TEST)));
	}

	@Test
	public void testConvertToEntityAttributeShouldReturnNullIfDbDataIsNull() {

		assertNull(localDateAttributConverter.convertToEntityAttribute(null));
	}

}
