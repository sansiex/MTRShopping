package cn.cubianyu.hackathon.hk.neo.dao.impls;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
import cn.cubianyu.hackathon.hk.neo.dao.MTRShoppingDAO;
import cn.cubianyu.hackathon.hk.neo.query.DataQuery;
import cn.cubianyu.hackathon.hk.neo.utils.NeoUtil;

public class MTRShoppingDAOImpl implements MTRShoppingDAO {
	public MTRShoppingDAOImpl() {
	}

	public int createCategory(String name) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", name);

		NeoUtil.getInstance().update(DataQuery.createCategory, params);
		return 1;
	}

	public int createBrandforCategory(String name, String category, String level) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", name);
		params.put("category", category);

		JSONObject others=new JSONObject();
		others.put("level", level);
		params.put("others", others.toString());

		NeoUtil.getInstance().update(DataQuery.createBrand, params);
		return 1;
	}

	public int createMall(String name, String chinese,
			Map<String, String> properties, int stationId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", name);
		params.put("chinese", chinese);
		params.put("station", "s"+stationId);
		
		JSONObject others=new JSONObject();
		for(String key:properties.keySet()){
			others.put(key, properties.get(key));
		}
		params.put("others", others.toString());
		
		NeoUtil.getInstance().update(DataQuery.createMall, params);
		return 0;
	}

	public int createMallShop(String name,String chinese, Map<String, String> properties,String category,
			String mall) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", name);
		params.put("chinese", chinese);
		params.put("mall", mall);
		
		JSONObject others=new JSONObject();
		for(String key:properties.keySet()){
			others.put(key, properties.get(key));
		}
		params.put("others", others.toString());
		NeoUtil.getInstance().update(DataQuery.createMallShop, params);
		return 0;
	}

	public int createShop(String name,String chinese, Map<String, String> properties,String category,
			int stationId) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("name", name);
		params.put("chinese", chinese);
		params.put("station", "s"+stationId);
		
		JSONObject others=new JSONObject();
		for(String key:properties.keySet()){
			others.put(key, properties.get(key));
		}
		params.put("others", others.toString());
		NeoUtil.getInstance().update(DataQuery.createShop, params);
		return 0;
	}

	public int linkShopBrand(int shopId, String brand,
			Map<String, String> properties) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int createStation(String stationId, String name, String alias,
			String chinese) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", "s" + stationId);
		params.put("name", name);
		params.put("alias", alias);
		params.put("chinese", chinese);

		NeoUtil.getInstance().update(DataQuery.createStation, params);
		return 1;
	}

	public int setLine(String line) {
		String[] stops = line.split(",");
		Map<String, String> params = new HashMap<String, String>();

		for (int i = 1; i < stops.length; i++) {
			params.put("s", "s" + stops[i - 1]);
			params.put("t", "s" + stops[i]);

			NeoUtil.getInstance().update(DataQuery.linkStation, params);
			params.clear();
		}

		return 1;
	}

	public int setTransport(int stationA, int stationB) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("s", "s" + stationA);
		params.put("t", "s" + stationB);

		NeoUtil.getInstance().update(DataQuery.linkStation, params);

		return 1;
	}

}
