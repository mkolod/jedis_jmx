package us.marek.jedis.mbean;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Hello world!
 *
 */
public class App {
	
	private static JedisPool pool = null;
	private static Jedis jedis = null;
	
    public static void main(final String[] args) 
    		throws InstanceAlreadyExistsException, MBeanRegistrationException,
    		NotCompliantMBeanException, MalformedObjectNameException {
    	
    	Client client = null;
    	
    	try {
    		
			pool = new JedisPool(new JedisPoolConfig(), "localhost");
			jedis = pool.getResource();
			client = jedis.getClient();
			client.connect();
			
			final MBeanServer mbs = ManagementFactory.getPlatformMBeanServer(); 
	        final ObjectName name = new ObjectName("us.marek.jedis.mbean:type=JedisMonitor"); 
	        final JedisMonitorMBean mBean = new JedisMonitor(jedis);
	        mbs.registerMBean(mBean, name); 
			
	        /* Run forever until program is killed. This is just a test class
	           to see JMX in action via VisualVM/YourKit/JProfiler.
	         */
			while (true) {
				
				try {
				
					
				Thread.sleep(100);
				
				} catch (final InterruptedException ie) {
					
					ie.printStackTrace();
					
				}
			}
    		 
    	} finally {
    		
    		jedis.close();
    		pool.close();
    		client.close();
    		
    	}
        
    }
    
    
}
