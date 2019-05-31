/**********************************************
*Copyright 2016 fengxing Corporation
*
* 2016年4月12日 wangshu 创建文件
*
***********************************************/
package com.demo.boot.test;


import com.alibaba.druid.pool.DruidDataSource;
import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.generator.Generator;
import org.junit.Test;

/**
 * Jfinal 代码生成
 */
public class JfinalModelGen {
	
	private static DruidDataSource dataSource=new DruidDataSource();
	static{
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/cloud?useUnicode=true&characterEncoding=utf8&useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("");
	}
	@Test
	public void testModelGen(){
		//base model 所使用的包名
		String baseModelPkg = "com.demo.boot.model.test.model.base";
		// base model 文件保存路径
		String baseModelDir = PathKit.getWebRootPath() + "/src/test/java/com/demo/boot/test/model/base";
		// model 所使用的包名
		String modelPkg = "com.demo.boot.model.test.model";
		// model 文件保存路径
		String modelDir = baseModelDir + "/..";
		Generator gernerator = new Generator(dataSource, baseModelPkg, baseModelDir, modelPkg, modelDir);
		gernerator.generate();
	}
	
	

}