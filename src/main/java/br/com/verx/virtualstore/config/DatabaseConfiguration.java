package br.com.verx.virtualstore.config;

import br.com.verx.virtualstore.domain.movie.Movie;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.autoconfigure.transaction.TransactionManagerCustomizers;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;

import static org.eclipse.persistence.config.PersistenceUnitProperties.CACHE_SHARED_DEFAULT;
import static org.eclipse.persistence.config.PersistenceUnitProperties.CACHE_STATEMENTS;
import static org.eclipse.persistence.config.PersistenceUnitProperties.DDL_GENERATION;
import static org.eclipse.persistence.config.PersistenceUnitProperties.PERSISTENCE_CONTEXT_CLOSE_ON_COMMIT;
import static org.eclipse.persistence.config.PersistenceUnitProperties.PERSISTENCE_CONTEXT_FLUSH_MODE;
import static org.eclipse.persistence.config.PersistenceUnitProperties.PERSISTENCE_CONTEXT_PERSIST_ON_COMMIT;
import static org.eclipse.persistence.config.PersistenceUnitProperties.QUERY_CACHE;
import static org.eclipse.persistence.config.PersistenceUnitProperties.THROW_EXCEPTIONS;
import static org.eclipse.persistence.config.PersistenceUnitProperties.WEAVING;

/**
 * Class comments go here...
 *
 * @author Allan Magnum
 * @version 1.0 13/10/2018
 */
@Configuration
@EntityScan(basePackageClasses = {Movie.class})
@EnableJpaRepositories(basePackageClasses = {Movie.class})
public class DatabaseConfiguration extends JpaBaseConfiguration {

    public DatabaseConfiguration(final DataSource dataSource, final JpaProperties properties,
            final ObjectProvider<JtaTransactionManager> jtaTransactionManager,
            final ObjectProvider<TransactionManagerCustomizers> transactionManagerCustomizers) {
        super(dataSource, properties, jtaTransactionManager, transactionManagerCustomizers);
    }

    @Override
    public AbstractJpaVendorAdapter createJpaVendorAdapter() {
        return new EclipseLinkJpaVendorAdapter();
    }

    @Override
    protected Map<String, Object> getVendorProperties() {
        final Map<String, Object> vendorProperties = new HashMap<>();
        vendorProperties.put(CACHE_SHARED_DEFAULT, "false");
        vendorProperties.put(CACHE_STATEMENTS, "false");
        vendorProperties.put(THROW_EXCEPTIONS, "true");
        vendorProperties.put(WEAVING, "static");
        vendorProperties.put(QUERY_CACHE, "true");
        vendorProperties.put(PERSISTENCE_CONTEXT_CLOSE_ON_COMMIT, "true");
        vendorProperties.put(PERSISTENCE_CONTEXT_FLUSH_MODE, "commit");
        vendorProperties.put(PERSISTENCE_CONTEXT_PERSIST_ON_COMMIT, "false");
        vendorProperties.put(DDL_GENERATION, "none");
        return vendorProperties;
    }

}
