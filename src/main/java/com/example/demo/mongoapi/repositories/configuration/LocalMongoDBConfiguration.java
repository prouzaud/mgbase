package com.example.demo.mongoapi.repositories.configuration;

import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;

@Profile("local")
@Configuration
public class LocalMongoDBConfiguration {

    @Value("${mongodb.database}")
    private String database;

    @Value("${mongodb.host}")
    private String host;

    @Value("${mongodb.port}")
    private int port;

    @Value("${mongodb.username}")
    private String username;

    @Value("${mongodb.pwd}")
    private String pwd;

    @Bean
    public MongoClientFactoryBean mongo() {
        MongoClientFactoryBean mongo = new MongoClientFactoryBean();
        mongo.setHost(host);
        mongo.setPort(port);
        MongoCredential[] mongoCredentials = new MongoCredential[1];
        mongoCredentials[0] =   MongoCredential.createCredential(username, database, pwd.toCharArray());
        mongo.setCredential(mongoCredentials);
        return mongo;
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
        return new MongoTemplate(mongoClient, database);
    }
}
