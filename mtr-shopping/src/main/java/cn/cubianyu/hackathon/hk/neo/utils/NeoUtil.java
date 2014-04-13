package cn.cubianyu.hackathon.hk.neo.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.kernel.impl.util.FileUtils;

import cn.cubianyu.hackathon.hk.neo.query.DataQuery;

public class NeoUtil {
	private static NeoUtil instance = null;
	private RestClient client = null;
	private Resource resource = null;

	private NeoUtil() {
		client = new RestClient();
		resource = client
				.resource("http://localhost:7474/db/data/cypher");
	}

	public static NeoUtil getInstance() {
		if (null == instance) {
			instance = new NeoUtil();
		}
		return instance;
	}

	public void update(String query, Map<String, String> params) {

		JSONObject json = new JSONObject();
		json.put("query", query);
		json.put("params", params);

		String response = resource.contentType("application/json")
				.accept("application/json").post(String.class, json.toString());

		System.out.println(response);
	}
}
