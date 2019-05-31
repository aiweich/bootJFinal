package com.demo.boot.config;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.demo.boot.model._MappingKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.time.Duration;

/**
 * ActiveRecordConfig
 */
@Configuration
public class ActiveRecordConfig {

	@Resource
	private DataSource dataSource;
	@Bean
	@Primary
	public ActiveRecordPlugin activeRecordPlugin() {
		ActiveRecordPlugin arp=new ActiveRecordPlugin(dataSource);
		_MappingKit.mapping(arp);
		arp.setShowSql(true);
		arp.setDialect(new MysqlDialect());
		arp.setTransactionLevel(Connection.TRANSACTION_REPEATABLE_READ);
		arp.start();
		return arp;
	}
}
