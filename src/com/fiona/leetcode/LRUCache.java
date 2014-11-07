package com.fiona.leetcode;

/**
 * @author Fiona
 * 
 * https://oj.leetcode.com/problems/lru-cache/
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
 * 					 it should invalidate the least recently used item before inserting a new item.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class LRUCache {
	private Map<Integer, Integer> cache = null;
	private int capacity = 0;
	private TreeMap<Long, Integer> lastUsageTimestamps = null;
	private Map<Integer, Long> lastUsageTimestampsByKey = null;

	private Object lock = new Object();
	private int currentSize = 0;

	public LRUCache(int capacity) {
		cache = new HashMap<Integer, Integer>();
		lastUsageTimestamps = new TreeMap<Long, Integer>();
		lastUsageTimestampsByKey = new HashMap<Integer, Long>();
		this.capacity = capacity;
	}

	public int get(int key) {
		synchronized (lock) {
			if (cache.containsKey(key)) {
				updateTimeStamp(key);
				return cache.get(key);
			}
		}
		return -1;
	}

	public void set(int key, int value) {
		synchronized (lock) {
			if (!cache.containsKey(key)) {
				while (currentSize >= capacity) {
					int foundKey = removeItemTimeStamp();
					cache.remove(foundKey);
					currentSize--;
				}
				currentSize++;
			}
			
			cache.put(key, value);
			updateTimeStamp(key);
		}
	}

	private void updateTimeStamp(int key) {
		if (lastUsageTimestampsByKey.containsKey(key)) {
			Long removedDate = lastUsageTimestampsByKey.get(key);
			lastUsageTimestamps.remove(removedDate);
		}
		long now = System.nanoTime();
		lastUsageTimestamps.put(now, key);
		lastUsageTimestampsByKey.put(key, now);
	}

	private int removeItemTimeStamp() {
		Entry<Long, Integer> removedItem = lastUsageTimestamps.pollFirstEntry();
		lastUsageTimestampsByKey.remove(removedItem.getValue());
		return removedItem.getValue();
	}
	
	public String mapsInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("lastUsageTimestamps: size=" + lastUsageTimestamps.size()); 
		for (Entry<Long, Integer> tmp : lastUsageTimestamps.entrySet()) {
			sb.append("\r\n[" + tmp.getKey() + "--" + tmp.getValue() + "]");
		}
		
		sb.append("\r\nlastUsageTimestampsByKey: size=" + lastUsageTimestampsByKey.size()); 
		for (Entry<Integer, Long> tmp : lastUsageTimestampsByKey.entrySet()) {
			sb.append("\r\n[" + tmp.getKey() + "--" + tmp.getValue() + "]");
		}
		return sb.toString();
	}
}
