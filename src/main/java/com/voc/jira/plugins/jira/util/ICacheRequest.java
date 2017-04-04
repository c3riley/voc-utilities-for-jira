package com.voc.jira.plugins.jira.util;

public interface ICacheRequest {
	
	/** Actually get the real value instead of using the cache.
	 * @return
	 */
	Object get();
	
	/** Transform the value before storing in the cache.
	 * @param getResult
	 * @return
	 */
	Object transform(Object getResult);
	
	/** Client host (e.g. devjira or jira or local dev machine)
	 * @return
	 */
	String host();
	
	/** Key used by memcached. Probably should include host:some-value:some-type
	 * @return
	 */
	String key();
	
	/** How many seconds to keep in cache. If negative, cache uses a default (currently expire at midnight).
	 * @return
	 */
	int ttlSecs();
	
	/** True if user is requesting the latest. False if we should try to find the value in the cache.
	 * @return
	 */
	boolean getLatest();
}
