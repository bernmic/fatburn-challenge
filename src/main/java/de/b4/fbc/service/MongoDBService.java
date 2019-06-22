package de.b4.fbc.service;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MongoDBService {
  @ConfigProperty(name = "mongodb.host")
  String mongoHost;

  @ConfigProperty(name = "mongodb.port")
  Integer mongoPort;

  //@ConfigProperty(name = "mongodb.username")
  String mongoUsername;

  //@ConfigProperty(name = "mongodb.password")
  String mongoPassword;

  private MongoClient mongoClient;

  public MongoDatabase getDatabase(String dbName) {
    if (mongoClient == null) {
      if (mongoUsername != null && mongoUsername.length() > 0) {
        MongoCredential credential = MongoCredential.createCredential(mongoUsername, dbName, mongoPassword.toCharArray());
        mongoClient = new MongoClient(new ServerAddress(mongoHost, mongoPort), credential, null);
      } else {
        mongoClient = new MongoClient(new ServerAddress(mongoHost, mongoPort));
      }
    }
    return mongoClient.getDatabase(dbName);
  }
}
