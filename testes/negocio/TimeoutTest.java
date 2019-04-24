package negocio;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

public class TimeoutTest {
	
	@Rule
    public Timeout globalTimeout = Timeout.seconds(1);
	
	@Test(timeout = 500)
	public void testInfiniteTametakingLoop() throws InterruptedException
	{
	    Thread.currentThread();
		Thread.sleep(450);
	    
	}
	
	@Test
	public void testInfiniteTametakingLoop2() throws InterruptedException
	{
	    Thread.currentThread();
		Thread.sleep(1450);
	    
	}
}
