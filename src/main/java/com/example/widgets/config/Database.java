package com.example.widgets.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
@PropertySource("classpath:config/database-${spring.profiles.active}.properties")
public class Database extends AbstractMongoConfiguration {

	@Value("${database.name}")
	private String name;
	
	@Value("${database.host.name}")
	private String hostName;
	
	@Value("${database.port}")
	private String port;
	
	@Value("${database.user.name}")
	private String userName;
	
	@Value("${database.user.password}")
	private String password;
	
	/**
	 * 
	 */
	protected String getDatabaseName() {
		return name;
	}

	/**
	 * 
	 */
	@Override
	public Mongo mongo() throws Exception {
		ServerAddress server = new ServerAddress(hostName, new Integer(port));
		MongoCredential credential = MongoCredential.createCredential(userName, name, password.toCharArray());
		return new MongoClient(server, Arrays.asList(credential));
	}
}
