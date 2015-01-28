package us.marek.jedis.mbean;

public interface JedisMonitorMBean {
	
	public int getConnectedClients();
	public int getBlockedClients();
	public int totalConnectionsReceived();

}