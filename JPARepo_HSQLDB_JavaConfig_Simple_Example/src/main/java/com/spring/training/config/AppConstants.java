package com.spring.training.config;

import org.springframework.orm.jpa.vendor.Database;

public class AppConstants {
    public static final  String DRIVER_CLASS_NAME = "org.hsqldb.jdbcDriver";
    public static final String DATABASE_ON_DISK_CONNECTION_URL = "jdbc:hsqldb:file:D:/temp/example";
    public static final String DATABASE_DIALECT = "org.hibernate.dialect.HSQLDialect";
    public static final Database DATABASE_TYPE = Database.HSQL;
    public static final String INIT_DATABASE_SCRIPT = "db/initDatabase.sql";
    public static final String POPULATE_DATABASE_SCRIPT = "db/populateDatabase.sql";
    public static final String DATABASE_IN_MEMORY_CONNECTION_URL = "jdbc:hsqldb:mem:example";
}
