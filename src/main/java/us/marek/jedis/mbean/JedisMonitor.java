package us.marek.jedis.mbean;

import redis.clients.jedis.Jedis;

public class JedisMonitor implements JedisMonitorMBean {
	
	private final Jedis jedis;
	
	public JedisMonitor(final Jedis jedis) {
		
		this.jedis = jedis;		
	}

	public int getConnectedClients() {

		return Integer.parseInt(getMeta("connected_clients"));
	}

	public int getBlockedClients() {
		
		return Integer.parseInt(getMeta("blocked_clients"));
	}

	public int totalConnectionsReceived() {

		return Integer.parseInt(getMeta("total_connections_received"));
	}
	
	private String getMeta(final String keyword) {
    	for (final String s : jedis.info().split("\n")) {
    		if (s.contains(keyword)) {
    			return s.substring(keyword.length() + 1, s.length()).trim();
    		}
    	}
    	return null;
    }
}
