package us.marek.jedis.mbean;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import redis.clients.jedis.Jedis;
import junit.framework.TestCase;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class AppTest extends TestCase {
	
	protected Jedis jedis;
	protected JedisMonitor monitor;
	protected String jedisInfo;
    
	@Override
	public void setUp() throws FileNotFoundException {
		
		jedis = mock(Jedis.class);
				
		Scanner scanner = null;
		
		try {
			
		final File file = new File("src/test/resources/jedisinfo.txt");
		scanner = new Scanner(file);
		jedisInfo = scanner.useDelimiter("\\A").next();
		when(jedis.info()).thenReturn(jedisInfo);
		monitor = new JedisMonitor(jedis, 1000L);
		
		} finally {
		
		    scanner.close();
		
		}
	}
	
	@Override
	public void tearDown() {
		
		jedis = null;
		monitor = null;
	}
	
	@Test
	public void testMockInit() {
		
		assertEquals(jedis.info(), jedisInfo);
	}
	
	@Test
	public void testRedisVersion() {

		assertEquals(monitor.getRedisVersion(), "2.6.9");
    }
	
	@Test
	public void testRedisMode() {
		
		assertEquals(monitor.getRedisMode(), "standalone");
	}
	
	@Test
	public void testRedisOs() {
		
		assertEquals(monitor.getRedisOS(), "Darwin 14.1.0 x86_64");
	}
	
	@Test
	public void testArchBits() {
		
		assertEquals(monitor.getArchBits(), 64);
	}
	
	@Test
	public void testMultiplexingApi() {
		
		assertEquals(monitor.getMultiplexingApi(), "select");
	}
	
	@Test
	public void testGccVersion() {
		
		assertEquals(monitor.getGccVersion(), "4.0.1");
	}
	
	@Test
	public void testProcessId() {
		
		assertEquals(monitor.getProcessId(), 12377);
	}
	
	@Test
	public void testRunId() {
		
		assertEquals(monitor.getRunId(), "39d9df2cde7eec929164bd1e9877f6edd565b0d9");
	}
	
	@Test
	public void testTcpPort() {
		
		assertEquals(monitor.getTcpPort(), 6379);
	}
	
	@Test
	public void testUpTimeInSeconds() {
		
		assertEquals(monitor.getUpTimeInSeconds(), 82L);
	}
	
	@Test
	public void testUpTimeInDays() {
		
		assertEquals(monitor.getUpTimeInDays(), 0);
	}
	
	@Test
	public void testLruClock() {
		
		assertEquals(monitor.getLruClock(), 1858831L);
	}
	
	@Test
	public void testConnectedClients() {
		
		assertEquals(monitor.getConnectedClients(), 1);
	}
	
	@Test
	public void testClientLongestOutputList() {
		
		assertEquals(monitor.getClientLongestOutputList(), 0);
	}
	
	@Test
	public void testClientBiggestInputBuffer() {
		
		assertEquals(monitor.getClientBiggestInputBuffer(), 0);
	}
	
	@Test
	public void testBlockedClients() {
		
		assertEquals(monitor.getBlockedClients(), 0);
	}
	
	@Test
	public void testUsedMemoryBytes() {
		
		assertEquals(monitor.getUsedMemoryBytes(), 699536L);
	}
	
	@Test
	public void testUsedMemoryHuman() {
		
		assertEquals(monitor.getUsedMemoryHuman(), "683.14K");
	}
	
	@Test
	public void testUsedMemoryBytesRss() {
		
		assertEquals(monitor.getUsedMemoryBytesRss(), 1740800L);
	}
	
	@Test
	public void testUseMemoryBytesPeak() {
		
		assertEquals(monitor.getUsedMemoryBytesPeak(), 698848L);
	}
	
	@Test
	public void testUsedMemoryBytesPeakHuman() {
		
		assertEquals(monitor.getUsedMemoryBytesPeakHuman(), "682.47K");
	}
	
	@Test
	public void testUsedMemoryBytesLua() {
		
		assertEquals(monitor.getUsedMemoryBytesLua(), 31744L);
	}
	
	@Test
	public void testMemoryFragmentationRatio() {
		
		assertEquals(monitor.getMemoryFragmentationRatio(), 2.49, 0.1);
	}
	
	@Test
	public void testMemoryAllocator() {
		
		assertEquals(monitor.getMemoryAllocator(), "libc");
	}
	
	@Test
	public void testLoading() {
		
		assertEquals(monitor.getLoading(), 0L);
	}
	
	@Test 
	public void testRdbChangesSinceLastSave() {
		
		assertEquals(monitor.getRdbChangesSinceLastSave(), 0L);
	}
	
	
	
	/*                                                              
	public long getRdbBgSaveInProgress();
	public long getRdbLastSaveTime();	
	public String getRdbLastBgSaveStatus();	
	public long getRdbLastBgSaveTimeSec();	
	public long getRdbBgSaveTimeSec();	
	public long getAofEnabled();	
	public long getAofRewriteInProgress();
	public long getAofRewriteScheduled();	
	public long getAofRewriteTimeSec();	
	public long getAofCurrentRewriteTimeSec();	
	public String getAofBgRewrtieStatus();	
	public long getTotalConnectionsReceived();	
	public long getTotalCommandsProcessed();	
	public long getInstantaneousOpsPerSec();	
	public long getRejectedConnections();	
	public long getExpiredKeys();	
	public long getEvictedKeys();
	public long getKeySpaceHits();
	public long getKeySpaceMisses();	
	public long getPubSubChannels();
	public long getPubSubPatterns();	
	public long getLatestForkUseC();	
	public String getRole();	
	public long getConnectedSlaves();		
	public double getUsedCpuSys();	
	public double getUsedCpuUser();	
	public double getUsedCpuSysChildren();	
	public double getUsedCpuUserChildren(); 
	 */
}
