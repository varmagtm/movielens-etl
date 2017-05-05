package hw.ac.uk.movielens.etl.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

/**
 * <pre>
 * <b>Description : </b>
 * The Mongo instance Spring configuration.
 * 
 * @author $Author: Nagendra Varma $ 
 * </pre>
 */
@Configuration
@EnableMongoRepositories
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Value("${mongo.host}")
    private String host;

    @Value("${mongo.port}")
    private int port;

    @Value("${mongo.db.name}")
    private String dbName;

    @Override
    protected String getDatabaseName() {
        return dbName;
    }

    /**
     * <pre>
	 * <b>Description : </b>
	 * Creates and returns the instance of MongoClient to interact with mongo instances.
	 * 
	 * @return
	 * @throws Exception
	 * </pre>
     */
    @Override
    public MongoClient mongo() throws Exception {
        return new MongoClient(host, port);
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Creates and returns the instance of MongoDbFactory.
     * 
     * @return
     * @throws Exception
     * </pre>
     */
    public @Bean MongoDbFactory factory() throws Exception {
        return new SimpleMongoDbFactory(mongo(), dbName);
    }

    /**
     * <pre>
     * <b>Description : </b>
     * Creates and returns the instance of MongoTemplate.
     * 
     * The default configuration of MongoTemplate supplies the documents with an extra field '_class'.
     * The MongoTemplate instance returned by this method suppresses this field from being inserted into 
     * the documents when any document is being inserted using this template.
     * 
     * @return
     * @throws Exception
     * </pre>
     */
    @SuppressWarnings("deprecation")
    public @Bean MongoTemplate mongoTemplate() throws Exception {
        MappingMongoConverter converter = new MappingMongoConverter(factory(), new MongoMappingContext());
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return new MongoTemplate(factory(), converter);

    }
}
