package de.wholestone.fitsizer;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.wholestone.fitsizer.FitSizer.Message;

public class FitSizerTest {
	
	
	private ByteArrayOutputStream stdout = new ByteArrayOutputStream();
	
	@Before
	public void setup(){
		System.setOut(new PrintStream(stdout));
	}

	@Test
	public void testNoArgumentsShouldPrintAnErrorMessageAndExit() {
		FitSizer fitSizer = new FitSizer();
		boolean valid = fitSizer.validateParameters();

		assertFalse(valid);
		assertEquals(Message.NO_ARGUMENTS.plain(), getOutput());
	}

	@Test
	public void testFirstArgumentShouldDenoteADirectory() {
		FitSizer fitSizer = new FitSizer("C:\\", "10");
		boolean valid = fitSizer.validateParameters();
		assertTrue(valid);

		fitSizer = new FitSizer("X:\\x", "10");
		valid = fitSizer.validateParameters();
		assertFalse(valid);
		assertEquals(Message.DIR_NOT_EXISTS.withParameter("X:\\x"), getOutput());
		
		stdout.reset();

		fitSizer = new FitSizer("-$-X:\\x", "10");
		valid = fitSizer.validateParameters();
		assertFalse(valid);
		assertEquals(Message.DIR_NOT_EXISTS.withParameter("-$-X:\\x"), getOutput());
	}
	
//	@Test
//	public void testParsingSize()
	
	private String getOutput() {
		return new String(stdout.toByteArray()).trim();
	}
	
	@After
	public void teardown(){
		stdout.reset();
	}
}
