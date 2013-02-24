package net.minecraft;

public enum Servers {
	OFF("", "", "/.lilium_feya/bin/minecraft.jar", "lilium_feya", ""),
	CASSANDRA("http://client.lilium.su/cassandra/", 
			"http://login.lilium.su/cassandra.php", 
			"/.lilium_cassandra/bin/minecraft.jar", 
			"lilium_cassandra", 
			"http://client.lilium.su/cassandra/md5.php?hash="), 
	CASSANDRAHDlow("http://client.lilium.su/cassandraHDlow/", 
			"http://login.lilium.su/cassandra.php", 
			"/.lilium_cassandraHDlow/bin/minecraft.jar", 
			"lilium_cassandraHDlow", "http://client.lilium.su/cassandraHDlow/md5.php?hash="), 
	CASSANDRAHDhigh("http://client.lilium.su/cassandraHDhigh/", "http://login.lilium.su/cassandra.php", 
			"/.lilium_cassandraHDhigh/bin/minecraft.jar", "lilium_cassandraHDhigh", "http://client.lilium.su/cassandraHDhigh/md5.php?hash="), 
	FEYA("http://client.lilium.su/feya/", "http://login.lilium.su/feya.php", 
			"/.lilium_dizzy/bin/minecraft.jar", "lilium_dizzy", "http://client.lilium.su/feya/md5.php?hash="),
	DREAMWEAVER("http://client.lilium.su/dreamweaver/", "http://login.lilium.su/feya.php", 
			"/.lilium_dreamweaver/bin/minecraft.jar", "lilium_dreamweaver", "http://client.lilium.su/dreamweaver/md5.php?hash=");
	
	private String serverUrl;
	private String authUrl;
	private String clientPath;
	private String clientName;
	private String hashUrl;
	
	private Servers(String serverUrl, String authUrl, String clientPath, String clientName, String hashUrl) {	
		this.serverUrl = serverUrl;
		this.authUrl = authUrl;
		this.setClientPath(clientPath);
		this.setClientName(clientName);
		this.setHashUrl(hashUrl);
	}

	public String getServerUrl() {
		return serverUrl;
	}

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;		
	}

	public String getAuthUrl() {
		return authUrl;
	}

	public void setAuthUrl(String authUrl) {
		this.authUrl = authUrl;
	}

	public String getClientPath() {
		return clientPath;
	}

	public void setClientPath(String clientPath) {
		this.clientPath = clientPath;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getHashUrl() {
		return hashUrl;
	}

	public void setHashUrl(String hashUrl) {
		this.hashUrl = hashUrl;
	}

}
