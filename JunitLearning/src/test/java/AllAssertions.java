import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AllAssertions {
	
	
	@Test
	void trueAssertion() {
		
		assertEquals(2,2);
//		assertEquals(2,3,"direct message argument condition false");
		assertEquals(2,2,"direct arg with true condition");
//		assertEquals(2,3,() -> "passing through the lamda function");
		assertEquals(2,2,() -> "lamd with true");
		
	}
	
	@Test
	void groupedAssertions() {
		assertAll("persion",() -> assertEquals("kk","kk"),() -> assertEquals("kk","kn")
				
				);
	}
	
	
	
	@Test
	@SuppressWarnings("unused")
	void dependentAssertion() {
		
	assertAll("dependent",() -> {
		
		assertNotNull("kk");
		
		assertEquals(2,2);
			
		},()->{
			
			
			
			assertNotNull("kk");
			
			assertEquals(2,2);
			assertTrue(true);
			
		});	
	
		
	}
	
	

	@Test
	void exceptioncheck() {
		
		Throwable exception = assertThrows(IllegalArgumentException.class, ()-> {
			throw new IllegalArgumentException("a message");
			});
		
		assertEquals("a message",exception.getMessage());
		
	}
	
	
	@Test
	void timeoutCheck() {
		
		String output = assertTimeout(ofMinutes(2), ()-> {
			return "Karthik";
		});
		
		
		assertEquals("Karthik",output);
		
	}
	
	
	
	

}
