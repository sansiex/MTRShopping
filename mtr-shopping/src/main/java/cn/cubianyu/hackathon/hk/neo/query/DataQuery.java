package cn.cubianyu.hackathon.hk.neo.query;

public interface DataQuery {
	public static final String createCategory = "CREATE (c:Category{name:{}})";
	public static final String createBrand="MATCH (c:Category{name={category}}) CREATE UNIQUE (b:Brand{name={name}})-[:Property]->(c)";
	public static final String createMallShop="MATCH (ma:Mall{name={name}}) CREATE (sh:Shop{name:{name},chinese:{chinese}})-[:Locate]->(ma)";
	public static final String createShop="MATCH (s:Station{id:{station}}) CREATE (sh:Shop{name:{name},chinese:chinese})-[:Near]->(s)";
	public static final String linkShopBrand="MATCH (sh:Shop{id:''}),(b:Brand) CREATE (sh)-[:Sell]->(b)";
	public static final String linkShopCategory="MATCH (sh:Shop{id:''}),(c:Category) CREATE (sh)-[:Property]->(c)";
	public static final String createMall="MATCH (s:Station{id:{station}}) CREATE (m:Mall{name:{name},chinese:{chinese},pic_url:{others.pic},description:{others.des},level:{others.level}})-[n:Near]-(s)";
	public static final String createStation="CREATE (s:Station{id:{id},name:{name},alias:{alias},chinese:{chinese}})";
	public static final String linkStation="MATCH (s:Station{id:{s}}),(t:Station{id:{t}}) CREATE UNIQUE (s)-[:TO]->(t)";
	public static final String linkTransportStation="MATCH (s:Station{id:{s}}),(t:Station{id:{t}}) CREATE UNIQUE (s)-[:TO]->(tr:Transport)-[:TO]->(t)";
}//TODO unique
//TODO index
