package net.minecraft;

import net.minecraft.Config;

public class Config {
	
	public static final String cassandraServerUrl = "http://client.lilium.su/cassandra/";
	public static final String feyaServerUrl = "http://client.lilium.su/feya/";
	public static final String dreamweaverServerUrl = "http://client.lilium.su/dreamweaver/";
	private static String downloadLink = cassandraServerUrl;
	
	public static String StrDown1 = "http://client.lilium.su/cassandra/";
	public static String StrDown2 = "http://client.lilium.su/cassandraHDlow/";
	public static String StrDown3 = "http://client.lilium.su/cassandraHDhigh/";
	public static String StrDown4 = "http://client.lilium.su/feya/";
	public static String StrDown5 = "http://client.lilium.su/dreamweaver/";
	public static String StrDown6 = "http://client.lilium.su/update4/";
	public static String StrDown = "http://client.lilium.su/cassandra/";
	public static String regURL = "http://lilium.su/user/register";
	
	//Название вашего лаунчера
	public static String title   = "Lilium Launcher";
	//версия лаунчера
	public static String version = "3";
	//Авторизация
	public static String auth    = "http://login.lilium.su/feya.php";
	//IP вашего сервера
	public static String serverip1 = "mc.lilium.su";
	//Порт вашего сервера
	public static String serverport1 = "25565";
	//Загрузка новостей
	public static String news    = "http://client.lilium.su/changelog.html";
	//Регистрация
	public static String register = "http://lilium.su/user/register";
	//Откуда скачивать новый лаунчер
	public static String newlauncher = "http://client.lilium.su/Lilium Launcher.exe";
	public static String server = "1";
	public static String serverport2 = "25565";
	public static String serverport3 = "25565";
	public static String serverport4 = "25555";
	public static String serverport5 = "25556";
	public static String serverport6 = "25580";
	public static String name = "(made by Cimon&Silly)";
	public static String site = "http://lilium.su";
	public static String forum = "http://forum.lilium.su/";
	public static String skinsystem = "http://lilium.su/skinsupload";
	public static String workdir = "lilium";
	public static String getDownloadLink() {
		return downloadLink;
	}
	public static void setDownloadLink(String downloadLink) {
		Config.downloadLink = downloadLink;
	}
	
}
