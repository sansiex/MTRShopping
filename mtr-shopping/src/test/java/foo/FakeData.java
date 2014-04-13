package foo;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import net.sf.json.JSONObject;
import cn.cubianyu.hackathon.hk.neo.dao.beans.Item;
import cn.cubianyu.hackathon.hk.neo.dao.beans.Route;
import cn.cubianyu.hackathon.hk.neo.dao.beans.Shop;
import cn.cubianyu.hackathon.hk.neo.dao.beans.Station;
import cn.cubianyu.hackathon.hk.neo.dao.beans.Stop;

public class FakeData extends TestCase{
	public void testData() {
		Route route=new Route();
		
		List<Item> items=new ArrayList<Item>();
		Item item=new Item();
		item.setName("劳力士");
		item.setCategory("手表");
		item.setDescription("男式 高档 全自动 机械 防水200米");
		
		Item item2=new Item();
		item2.setName("洗面奶");
		item2.setCategory("日化");
		item2.setDescription("女式 保湿 去黑头 100ml");
		
		Item item3=new Item();
		item3.setName("平板电脑");
		item3.setCategory("电子产品");
		item3.setDescription("苹果");
		
		Shop shop1=new Shop();
		shop1.setName("迪生钟表珠宝");
		shop1.setAddress("德辅道中 12B号 置地广场地下");
		shop1.setPhone("+852 2521 4245");
		List<Item> i1=new ArrayList<Item>();
		i1.add(item);
		shop1.setItems(i1);
		
		Shop shop2=new Shop();
		shop2.setName("屈臣氏 坚道店");
		shop2.setAddress("香港坚道99号丰乐阁地下");
		List<Item> i2=new ArrayList<Item>();
		i2.add(item2);
		shop2.setItems(i2);
		
		Shop shop3=new Shop();
		shop3.setName("Apple Store ifc mall");
		shop3.setAddress("香港中環金融街 8 號");
		shop3.setPhone("+852 3972 1500");
		List<Item> i3=new ArrayList<Item>();
		i3.add(item);
		shop3.setItems(i3);
		
		Station station=new Station();
		station.setId(1);
		station.setChinese("中环");
		station.setName("Central");
		List<Shop> shops=new ArrayList<Shop>();
		shops.add(shop1);
		shops.add(shop2);
		shops.add(shop3);
		
		Stop stop=new Stop();
		stop.setShops(shops);
		stop.setStation(station);
		
		
		Station s2=new Station();
		s2.setId(3);
		s2.setName("Tsim Sha Tsui");
		s2.setChinese("尖沙咀");
		
		Stop st2=new Stop();
		st2.setStation(s2);
		
		Shop shop4=new Shop();
		shop4.setName("路易威登 香港圆方商场");
		shop4.setAddress("九龙站圆方商场2楼 2048-2056店");
		shop4.setPhone("+852 8100 1182");
		
		Item i8=new Item();
		i8.setName("LV限量版");
		List<Item> isss=new ArrayList<Item>();
		isss.add(i8);
		
		shop4.setItems(isss);
		List<Shop> stsdsd=new ArrayList<Shop>();
		stsdsd.add(shop4);
		st2.setShops(stsdsd);
		
		
		List<Stop> stops=new ArrayList<Stop>();
		stops.add(stop);
		stops.add(st2);
		route.setStops(stops);
		
		JSONObject json=JSONObject.fromObject(route);
		
		
		System.out.println(json.toString());
	}
}
