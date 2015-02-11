package us.marek.jedis.mbean;

import redis.clients.jedis.Jedis;

public class JedisMonitor implements JedisMonitorMBean {
	
	private final Jedis jedis;
	private final long updateFrequencyMillis;
	private String info;
	private long lastUpdate;
	
	public static final String REDIS_VERSION = "redis_version";
	public static final String REDIS_MODE = "redis_mode";
	public static final String OS = "os";
	public static final String ARCH_BITS = "arch_bits";
	public static final String MULTIPLEXING_API =  "multiplexing_api";
	public static final String GCC_VERSION = "gcc_version";
	public static final String PROCESS_ID = "process_id";
	public static final String RUN_ID = "run_id";
	public static final String TCP_PORT = "tcp_port";
	public static final String UPTIME_IN_SECONDS = "uptime_in_seconds";
	public static final String UPTIME_IN_DAYS = "uptime_in_days";
	public static final String LRU_CLOCK = "lru_clock";
	public static final String CONNECTED_CLIENTS = "connected_clients";
	public static final String CLIENT_LONGEST_OUTPUT_LIST = "client_longest_output_list";
	public static final String CLIENT_BIGGEST_INPUT_BUF = "client_biggest_input_buf";
	public static final String BLOCKED_CLIENTS = "blocked_clients";
	public static final String USED_MEMORY = "used_memory";
	public static final String USED_MEMORY_HUMAN = "used_memory_human";
	public static final String USED_MEMORY_RSS = "used_memory_rss";
	public static final String USED_MEMORY_PEAK = "used_memory_peak";
	public static final String USED_MEMORY_PEAK_HUMAN = "used_memory_peak_human";
	public static final String USED_MEMORY_LUA = "used_memory_lua";
	public static final String MEMORY_FRAGMENTATION_RATIO = "mem_fragmentation_ratio";
	public static final String MEMORY_ALLOCATOR = "mem_allocator";
	public static final String LOADING = "loading";
	public static final String RDB_CHANGES_SINCE_LAST_SAVE = "rdb_changes_since_last_save";
	public static final String RDB_BGSAVE_IN_PROGRESS = "rdb_bgsave_in_progress";
	public static final String RDB_LAST_SAVE_TIME = "rdb_last_save_time";
	public static final String RDB_LAST_BGSAVE_STATUS = "rdb_last_bgsave_status";
	public static final String RDB_LAST_BGSAVE_TIME_SEC = "rdb_last_bgsave_time_sec";
	public static final String RDB_CURRENT_BGSAVE_TIME_SEC = "rdb_current_bgsave_time_sec";
	public static final String AOF_ENABLED = "aof_enabled";
	public static final String AOF_REWRITE_IN_PROGRESS = "aof_rewrite_in_progress";
	public static final String AOF_REWRITE_SCHEDULED = "aof_rewrite_scheduled";
	public static final String AOF_LAST_REWRITE_TIME_SEC = "aof_last_rewrite_time_sec";
	public static final String AOF_CURRENT_REWRITE_TIME_SEC = "aof_current_rewrite_time_sec";
	public static final String AOF_LAST_BGREWRITE_STATUS = "aof_last_bgrewrite_status";
	public static final String TOTAL_CONNECTIONS_RECEIVED = "total_connections_received";
	public static final String TOTAL_COMMANDS_PROCESSED = "total_commands_processed";
	public static final String INSTANTANEOUS_OPS_PER_SEC = "instantaneous_ops_per_sec";
	public static final String REJECTED_CONNECTIONS = "rejected_connections";
	public static final String EXPIRED_KEYS = "expired_keys";
	public static final String EVICTED_KEYS = "evicted_keys";
	public static final String KEYSPACE_HITS = "keyspace_hits";
	public static final String KEYSPACE_MISSES = "keyspace_misses";
	public static final String PUB_SUB_CHANNELS = "pubsub_channels";
	public static final String PUB_SUB_PATTERNS = "pubsub_patterns";
	public static final String LATEST_FORK_USEC = "latest_fork_usec";
	public static final String ROLE = "role";
	public static final String CONNECTED_SLAVES = "connected_slaves";
	public static final String USED_CPU_SYS = "used_cpu_sys";
	public static final String USED_CPU_USER = "used_cpu_user";
	public static final String USED_CPU_SYS_CHILDREN = "used_cpu_sys_children";
	public static final String USED_CPU_USER_CHILDREN = "used_cpu_user_children";
	
	public JedisMonitor(final Jedis jedis, 
			final long updateFrequencyMillis) {
		
		this.jedis = jedis;		
		this.updateFrequencyMillis = updateFrequencyMillis;
		this.info = jedis.info();
		this.lastUpdate = System.currentTimeMillis();
	}
	
	public String getRedisVersion() {
		
	  return getMeta(REDIS_VERSION); 
	}

	public String getRedisMode() {
		
		return getMeta(REDIS_MODE);
	}
	
	public String getRedisOS() {
		
		return getMeta(OS);
	}
	
	public int getArchBits() {
		
		return Integer.parseInt(getMeta(ARCH_BITS));
	}
	
	public String getMultiplexingApi() {
		
		return getMeta(MULTIPLEXING_API);
	}
	
	public String getGccVersion()  {
	
		return getMeta(GCC_VERSION); 
	}
	
	public int getProcessId() {
		
		return Integer.parseInt(getMeta(PROCESS_ID));
	}
	
	public String getRunId() {
		
		return getMeta(RUN_ID); 
	}
	
	public int getTcpPort() {
		
		return Integer.parseInt(getMeta(TCP_PORT));
	}
	
	public long getUpTimeInSeconds() {
		
		return Long.parseLong(getMeta(UPTIME_IN_SECONDS));
	}
	
	public int getUpTimeInDays() {
		
		return Integer.parseInt(getMeta(UPTIME_IN_DAYS));
	}
	
	public long getLruClock() {
		
		return Long.parseLong(getMeta(LRU_CLOCK)); 
	}
	
	public int getConnectedClients() {
		
		return Integer.parseInt(getMeta(CONNECTED_CLIENTS));
	}
	
	public int getClientLongestOutputList() {
		
		return Integer.parseInt(getMeta(CLIENT_LONGEST_OUTPUT_LIST));
	}
	
	public int getClientBiggestInputBuffer() {
	
		return Integer.parseInt(getMeta(CLIENT_BIGGEST_INPUT_BUF));
		
	}
	
	public int getBlockedClients() {
		
		return Integer.parseInt(getMeta(BLOCKED_CLIENTS));
	}
	
	public long getUsedMemoryBytes() {
		
		return Long.parseLong(getMeta(USED_MEMORY));
	}
	
    public String getUsedMemoryHuman() {
    	
    	return getMeta(USED_MEMORY_HUMAN);
    }
    
    public long getUsedMemoryBytesRss() {
    	
    	return Long.parseLong(getMeta(USED_MEMORY_RSS)); 
    }
    
    public long getUsedMemoryBytesPeak() {
    	
    	return Long.parseLong(getMeta(USED_MEMORY_PEAK));
    }
    public String getUsedMemoryBytesPeakHuman() {
    	
    	return getMeta(USED_MEMORY_PEAK_HUMAN); 
    }
    
    
    public long getUsedMemoryBytesLua() {
    	
    	return Long.parseLong(getMeta(USED_MEMORY_LUA));  
    }
    
    public double getMemoryFragmentationRatio() {
    	
    	return Double.parseDouble(getMeta(MEMORY_FRAGMENTATION_RATIO));
    }
    
    public String getMemoryAllocator() {
    	
    	return getMeta(MEMORY_ALLOCATOR);
    }
    
	public long getLoading() {
		
		return Long.parseLong(getMeta(LOADING));
	}
	
	public long getRdbChangesSinceLastSave() {
		
		return Long.parseLong(getMeta(RDB_CHANGES_SINCE_LAST_SAVE));
	}
	
	public long getRdbBgSaveInProgress() {
		
		return Long.parseLong(getMeta(RDB_BGSAVE_IN_PROGRESS));
	}
	
	public long getRdbLastSaveTime() {
		
		return Long.parseLong(getMeta(RDB_LAST_SAVE_TIME));
	}
	
	public String getRdbLastBgSaveStatus() {
		
		return getMeta(RDB_LAST_BGSAVE_STATUS);
	}
	
	public long getRdbLastBgSaveTimeSec() {
		
		return Long.parseLong(getMeta(RDB_LAST_BGSAVE_TIME_SEC));
	};	
	
	public long getRdbBgSaveTimeSec() {
		
		return Long.parseLong(getMeta(RDB_CURRENT_BGSAVE_TIME_SEC));
	}
	
	public long getAofEnabled() {
		
		return Long.parseLong(getMeta(AOF_ENABLED));
	}
	
	public long getAofRewriteInProgress()	{
		
		return Long.parseLong(getMeta(AOF_REWRITE_IN_PROGRESS));
	}
	
	public long getAofRewriteScheduled() {
		
		return Long.parseLong(getMeta(AOF_REWRITE_SCHEDULED));
	}
	
	public long getAofLastRewriteTimeSec() {
		
		return Long.parseLong(getMeta(AOF_LAST_REWRITE_TIME_SEC));
	}
	
	public long getAofCurrentRewriteTimeSec() {
		
		return Long.parseLong(getMeta(AOF_CURRENT_REWRITE_TIME_SEC));
	}
	
	public String getAofBgRewriteStatus() {
		
		return getMeta(AOF_LAST_BGREWRITE_STATUS);  
	}
	
   	public long getTotalConnectionsReceived() {
   		
   		return Long.parseLong(getMeta(TOTAL_CONNECTIONS_RECEIVED));
   	}
   	
	public long getTotalCommandsProcessed() {
		return Long.parseLong(getMeta(TOTAL_COMMANDS_PROCESSED));
	}
	
	public long getInstantaneousOpsPerSec() {
		
		return Long.parseLong(getMeta(INSTANTANEOUS_OPS_PER_SEC)); 
	}
	
	public long getRejectedConnections() {
		
		return Long.parseLong(getMeta(REJECTED_CONNECTIONS));
	}
	
	public long getExpiredKeys() {
		
		return Long.parseLong(getMeta(EXPIRED_KEYS));
	}
	
	public long getEvictedKeys() {
		
		return Long.parseLong(getMeta(EVICTED_KEYS));
	}
	
	public long getKeySpaceHits() {
		
		return Long.parseLong(getMeta(KEYSPACE_HITS));
	}
	
	public long getKeySpaceMisses() {
		return Long.parseLong(getMeta(KEYSPACE_MISSES));
	}
	
	public long getPubSubChannels() {
		
		return Long.parseLong(getMeta(PUB_SUB_CHANNELS)); 
	}
	public long getPubSubPatterns() {
		
		return Long.parseLong(getMeta(PUB_SUB_PATTERNS));
	}
	
	public long getLatestForkUseC() {
		
		return Long.parseLong(getMeta(LATEST_FORK_USEC));
	}
	
	public String getRole() {
		
		return getMeta(ROLE);
	}

	public long getConnectedSlaves() {
		
		return Long.parseLong(getMeta(CONNECTED_SLAVES));
	}
		
	public double getUsedCpuSys() {
		
		return Double.parseDouble(getMeta(USED_CPU_SYS));
	}
	
	public double getUsedCpuUser() {
		
		return Double.parseDouble(getMeta(USED_CPU_USER));
	}
	
	public double getUsedCpuSysChildren() {
		
		return Double.parseDouble(getMeta(USED_CPU_SYS_CHILDREN));
	}
	
	public double getUsedCpuUserChildren() {
		
		return Double.parseDouble(getMeta(USED_CPU_USER_CHILDREN));
	}
	
	/**
	 * This is done because every Redis status check is based on parsing
	 * the info string (that's how the Jedis API and Redis reporting works),
	 * and we don't want to get that String from Redis say every second
	 * for ~50 different metrics. That would be a huge performance penalty.
	 */
	private synchronized void updateInfo() {
		final long currentMillis = System.currentTimeMillis();
		if (currentMillis - lastUpdate > updateFrequencyMillis) {
			info = jedis.info();
			lastUpdate = currentMillis;
		}
	}
	private String getMeta(final String keyword) {
		updateInfo();
    	for (final String s : info.split("\n")) {
    		if (s.contains(keyword)) {
    			return s.substring(keyword.length() + 1, s.length()).trim();
    		}
    	}
    	return null;
    }
}
