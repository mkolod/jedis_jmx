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
	
	@Test
	public void testRdbBgSaveInProgress() {
		
		assertEquals(monitor.getRdbBgSaveInProgress(), 0L);
	}
	
	@Test
	public void testRdbLastSaveTime() {
		
		assertEquals(monitor.getRdbLastSaveTime(), 1423680071L);
	}
	
	@Test
	public void testRdbLastBgSaveStatus() {
		
		assertEquals(monitor.getRdbLastBgSaveStatus(), "ok");
	}
	
	@Test
	public void testRdbLastBgSaveTimeSec() {
		
		assertEquals(monitor.getRdbLastBgSaveTimeSec(), -1L);
	}
	
	@Test
	public void testAofEnabled() {
		
		assertEquals(monitor.getAofEnabled(), 0L);
	}
	
	@Test
	public void testAofRewriteInProgress() {
		
		assertEquals(monitor.getAofRewriteInProgress(), 0L);
	}
	
	@Test
	public void testAofRewriteScheduled() {
		
		assertEquals(monitor.getAofRewriteScheduled(), 0L);
	}
	
	@Test
	public void testAofLastRewriteTimeSec() {
		
		assertEquals(monitor.getAofLastRewriteTimeSec(), -1L);
	}
	
	@Test
	public void testOfCurrentRewriteTimeSec() {
		
		assertEquals(monitor.getAofCurrentRewriteTimeSec(), -1L);
	}
	
	@Test
	public void testAofBgRewriteStatus() {
		
		assertEquals(monitor.getAofBgRewriteStatus(), "ok");
	}
	
	@Test 
	public void testToalConnectionsReceived() {
		
		assertEquals(monitor.getTotalConnectionsReceived(), 2L);
	}
	
	@Test
	public void testTotalCommandsProcessed() {
		
		assertEquals(monitor.getTotalCommandsProcessed(), 1L);
	}
	
	@Test
	public void testInstantaneousOpsPerSec() {
		
		assertEquals(monitor.getInstantaneousOpsPerSec(), 0L);
	}
	
	@Test
	public void testRejectedConnections() {
		
		assertEquals(monitor.getRejectedConnections(), 0L);
	}
	
	@Test 
	public void testExpiredKeys() {
		
		assertEquals(monitor.getExpiredKeys(), 0L);
	}
	
	@Test 
	public void testEvicted() {
		
		assertEquals(monitor.getEvictedKeys(), 0L);
	}
	
	@Test
	public void testKeySpaceHits() {
		
		assertEquals(monitor.getKeySpaceHits(), 0L);
		
	}
	
	@Test
	public void testKeySpaceMisses() {
		
		assertEquals(monitor.getKeySpaceMisses(), 0L);
		
	}
	
	@Test
	public void testPubSubChannels() {
		
		assertEquals(monitor.getPubSubChannels(), 0L);
	}
	
	@Test
	public void testPubSubPatterns() {
		
		assertEquals(monitor.getPubSubPatterns(), 0L);
	}
	
	@Test
	public void testLatestForkUseC() {
		
		assertEquals(monitor.getLatestForkUseC(), 0L);
	}
	
	@Test
	public void testRole() {
		
		assertEquals(monitor.getRole(), "master");
	}
	
	@Test
	public void testConnectedSlaves() {
		
		assertEquals(monitor.getConnectedSlaves(), 0L);
	}
	
	@Test
	public void testUsedCpuSys() {
		
		assertEquals(monitor.getUsedCpuSys(), 0.16, 0.1);
	}
	
	@Test
	public void testUsedCpuUser() {
		
		assertEquals(monitor.getUsedCpuUser(), 0.10, 0.1);
	}
	
	@Test
	public void testUsedCpuSysChildren() {
		
		assertEquals(monitor.getUsedCpuSysChildren(), 0.00, 0.1);
	}
	
	@Test
	public void testUsedCpuUserChildren() {
		
		assertEquals(monitor.getUsedCpuUserChildren(), 0.00, 0.1);
	}
}
