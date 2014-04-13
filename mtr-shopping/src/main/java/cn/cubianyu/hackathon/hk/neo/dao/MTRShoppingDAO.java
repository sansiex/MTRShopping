package cn.cubianyu.hackathon.hk.neo.dao;

import java.util.Map;

public interface MTRShoppingDAO {
	public int createCategory(String name);

	/*******
	 * @Param level from 1 to 10
	 * *****/
	public int createBrandforCategory(String name, String category, String level);

	public int createMall(String name, String chinese,
			Map<String, String> properties, int stationId);

	public int createMallShop(String name, String chinese,Map<String, String> properties, String category,
			String mall);

	public int createShop(String name, String chinese,Map<String, String> properties, String category,
			int stationId);

	public int linkShopBrand(int shopId, String brand,
			Map<String, String> properties);

	public int createStation(String stationId, String name, String alias,
			String chinese);

	public int setLine(String line);

	public int setTransport(int stationA, int stationB);
}
