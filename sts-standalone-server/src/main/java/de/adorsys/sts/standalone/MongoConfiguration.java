package de.adorsys.sts.standalone;

import com.mongodb.MongoClient;
import de.adorsys.sts.persistence.mongo.config.EnableMongoPersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
@EnableMongoPersistence
@Profile({"mongo"})
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.database:sts}")
    private String databaseName;

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient();
    }
}
