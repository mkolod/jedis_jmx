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

If you have a Redis server running on localhost, you can try out the example in [us.marek.jedis.mbean.SampleApp](https://github.com/mkolod/jedis_jmx/blob/master/src/main/java/us/marek/jedis/mbean/SampleApp.java).
