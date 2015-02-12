# JMX MBean for Jedis

[![Build Status](https://travis-ci.org/mkolod/jedis_jmx.svg)](https://travis-ci.org/mkolod/jedis_jmx)

Setup
=====

First, import the dependencies:

```java
import java.lang.management.ManagementFactory;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import us.marek.jedis.mbean.JedisMonitor;
import us.marek.jedis.mbean.JedisMonitorMBean;
```

Next, hook up the MBean to your Jedis object.

```java
final MBeanServer mbs = ManagementFactory.getPlatformMBeanServer(); 
final ObjectName name = new ObjectName("us.marek.jedis.mbean:type=JedisMonitor"); 
final JedisMonitorMBean mBean = new JedisMonitor(jedis);
mbs.registerMBean(mBean, name); 
```

Finally, once your application is running:
  1. Start VisualVM.
  2. Enable the VisualVM JMX plugin.
  3. Find your application on the left-hand side and double-click on it to open a detailed view.
  4. Click on the MBeans tab.
  5. Click on us.marek.jedis.mbean.JedisMonitor to open up the Attributes view.
  6. Double-clicking on numeric values will open a self-updating time series graph. 
  7. Right-clicking on the time series graph will allow you to export the data to a CSV file and to change the time range of the graph.

Also note that there exists a [JMeter JMX plugin](http://jmeter-plugins.org/wiki/JMXMon/), so you could monitor the Redis metrics of interest from JMeter while the other performance tests are running. This could be helpful in figuring out the bugs associated with the interplay between the load elsewhere in the application and the Java client's demands on the Redis connections.


Example
=======

```java
package us.marek.jedis.mbean;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.util.Scanner;

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

public class SampleApp {
	
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
	    // update MBean information every 2 seconds
	    final JedisMonitorMBean mBean = new JedisMonitor(jedis, 2000L);
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
```
