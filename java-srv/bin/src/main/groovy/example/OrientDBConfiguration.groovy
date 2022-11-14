package example;

import com.orientechnologies.orient.core.db.*;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Basic OrientDB configuration class
 * To configure and provide the bean to inject later for database interactions
 * @author dassiorleando
 */
@Configuration
public class OrientDBConfiguration {
    @Bean
    public ODatabaseDocumentTx orientDBfactory() {
      OrientDB orient = new OrientDB("plocal:db", OrientDBConfig.defaultConfig());
      orient.create("animal", ODatabaseType.PLOCAL);
      orient.close();
        return new ODatabaseDocumentTx("plocal:db/animal")
                .open("admin", "admin");
    }

}
