package us.marek.jedis.mbean;

import javax.management.Attribute;
import javax.management.AttributeList;
import javax.management.AttributeNotFoundException;
import javax.management.DynamicMBean;
import javax.management.InvalidAttributeValueException;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanConstructorInfo;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.MBeanOperationInfo;
import javax.management.ReflectionException;

import redis.clients.jedis.Jedis;

public class JedisMBean implements DynamicMBean {
	
	private final Jedis jedis;
	
	public JedisMBean(final Jedis jedis) {
		
		this.jedis = jedis;		
	}

	private int getConnectedClients() {

		return Integer.parseInt(getMeta("connected_clients"));
	}

	private int getBlockedClients() {
		
		return Integer.parseInt(getMeta("blocked_clients"));
	}

	private int totalConnectionsReceived() {

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

	@Override
	public Object getAttribute(String attribute)
			throws AttributeNotFoundException, MBeanException,
			ReflectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttribute(Attribute attribute)
			throws AttributeNotFoundException, InvalidAttributeValueException,
			MBeanException, ReflectionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AttributeList getAttributes(String[] attributes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AttributeList setAttributes(AttributeList attributes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object invoke(String actionName, Object[] params, String[] signature)
			throws MBeanException, ReflectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MBeanInfo getMBeanInfo() {
		
		final MBeanAttributeInfo[] attrInfo = new MBeanAttributeInfo[1];
		
		attrInfo[0] = new MBeanAttributeInfo(
				"connected clients",
				"int",
				"get number of connected clients",
				true,
				false,
				false
		);
		
		// TODO Auto-generated method stub
		return new MBeanInfo(
				"JedisMBeanImpl",
				"Description",
				attrInfo,
				new MBeanConstructorInfo[0],
				new MBeanOperationInfo[0],
				new MBeanNotificationInfo[0]
				);
	}
	

}
