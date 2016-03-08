package com.aic.paas.comm.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;

import com.binary.core.io.Resource;
import com.binary.core.io.ResourceResolver;
import com.binary.core.util.BinaryUtils;
import com.binary.core.util.Properties;

public class PropertiesPool implements Serializable, InitializingBean {
	private static final long serialVersionUID = 1L;
	
	
	
	private static PropertiesPool pool;
	
	
	private final Map<String, String> properties = new HashMap<String, String>();
	
	
	private String[] locations;


	public String[] getLocations() {
		return locations;
	}
	public void setLocation(String location) {
		BinaryUtils.checkEmpty(location, "location");
		setLocations(new String[]{location});
	}
	public void setLocations(String[] locations) {
		BinaryUtils.checkEmpty(locations, "locations");
		this.locations = locations;
		loadResource();
	}
	
	
	
	private void loadResource() {
		this.properties.clear();
		for(int i=0; i<locations.length; i++) {
			Resource res = ResourceResolver.getResource(locations[i]);
			Properties pro = new Properties(res);
			this.properties.putAll(pro);
		}
	}
	
	
	
	/**
	 * 判断键是否存在
	 * @param key
	 * @return
	 */
	public boolean containsKey(String key) {
		return properties.containsKey(key);
	}
	
	
	/**
	 * 获取值
	 * @param key
	 * @return
	 */
	public String get(String key) {
		return properties.get(key);
	}
	
	
	
	/**
	 * 设置值
	 * @param key
	 * @param value
	 */
	public void set(String key, String value) {
		this.properties.put(key, value);
	}
	
	
	
	
	/**
	 * 删除键
	 * @param key
	 */
	public String remove(String key) {
		return properties.remove(key);
	}
	
	
	
	/**
	 * 清空键值池
	 */
	public void clear() {
		properties.clear();
	}
	
	
	/**
	 * 获取所有键
	 */
	public Set<String> keySet() {
		return properties.keySet();
	}
	
	
	
	/**
	 * 获取键值集合
	 * @return
	 */
	public Set<Entry<String, String>> entrySet() {
		return properties.entrySet();
	}
	
	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		pool = this;
	}
	
	
	
	
	/**
	 * 获取所有属性
	 * @return
	 */
	public static Map<String, String> getProperties() {
		if(pool == null) {
			return new HashMap<String, String>();
		}
		return pool.properties;
	}
	
	

}
