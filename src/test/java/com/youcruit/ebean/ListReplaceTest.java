package com.youcruit.ebean;

import org.h2.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.youcruit.ebean.list.test.Child;
import com.youcruit.ebean.list.test.Parent;

import io.ebean.Ebean;
import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import io.ebean.config.dbplatform.h2.H2Platform;

public class ListReplaceTest {


    private ServerConfig config;
    private EbeanServer server;

    @Before
    public void setupEbean() {
	config = new ServerConfig();
	config.setName("youcruit-test");
	config.loadFromProperties();
	config.getDataSourceConfig().setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
	config.getDataSourceConfig().setUsername("sa");
	config.getDataSourceConfig().setPassword("blank");
	config.getDataSourceConfig().setDriver(Driver.class.getName());
	config.setDefaultServer(true);
	config.setDatabasePlatform(new H2Platform());
	config.setDdlGenerate(true);
	config.setDdlRun(true);
	server = EbeanServerFactory.create(config);
    }

    @Test
    public void testListReplaceWithTransaction() {
	Parent originalParent = new Parent();
	originalParent.setName("I'm a parent");
	Child originalChild = new Child();
	originalChild.setName("I'm a child");
	originalChild.setValue("Most");
	originalParent.getChildren().add(originalChild);
	Ebean.save(originalParent);

	Child dupedChild = new Child();
	dupedChild.setName("I'm a child");
	dupedChild.setValue("Most");

	originalParent.getChildren().clear();
	originalParent.getChildren().add(dupedChild);

	Ebean.beginTransaction();
	Ebean.save(originalParent);
	Ebean.commitTransaction();
	Ebean.endTransaction();
    }

    @Test
    public void testListReplaceWithOutTransaction() {
	Parent originalParent = new Parent();
	originalParent.setName("I'm a parent");
	Child originalChild = new Child();
	originalChild.setName("I'm a child");
	originalChild.setValue("Most");
	originalParent.getChildren().add(originalChild);
	Ebean.save(originalParent);

	Child dupedChild = new Child();
	dupedChild.setName("I'm a child");
	dupedChild.setValue("Most");

	originalParent.getChildren().clear();
	originalParent.getChildren().add(dupedChild);

	Ebean.save(originalParent);
    }

    @After
    public void tearDown() {
        server.shutdown(true,false);
    }
}
