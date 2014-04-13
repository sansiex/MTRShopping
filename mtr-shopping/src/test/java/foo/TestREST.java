package foo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import junit.framework.TestCase;
import cn.cubianyu.hackathon.hk.neo.dao.MTRShoppingDAO;
import cn.cubianyu.hackathon.hk.neo.dao.impls.MTRShoppingDAOImpl;

public class TestREST extends TestCase {
	public void testCreateStation() throws IOException {
		MTRShoppingDAO dao = new MTRShoppingDAOImpl();

		FileReader fr = new FileReader("d://stations.csv");
		BufferedReader br = new BufferedReader(fr);
		String s = br.readLine();
		while ((s = br.readLine()) != null) {
			String[] ss = s.split(",");
			dao.createStation(ss[1], ss[0], ss[2], ss[3]);
		}
	}
	
	public void testLinkStation() throws IOException {
		MTRShoppingDAO dao = new MTRShoppingDAOImpl();

		String[] lines=new String[]{"103,102,101,100,99,98,97,96,67","76,75,74,73,72,71,69,68,67,8,65,64","120,119,118,117,116,115,114,20,53,111,80,64","119,118,117,116,115,114,20,19,18,17,16,6,5","49,48,38,15,14,13,12,11,10,9,8,7,16,6,5","57,50,49,48,32,31","37,36,35,34,33,32,31,30,29,28,27,2,1,26","39,40,41,53,21,42,46,42,54,43","25,24,23,22,21,53,41,40,39,1"};
		for (String line:lines ) {
			dao.setLine(line);
		}
	}
	
	public void testLinkTransport() throws IOException {
		MTRShoppingDAO dao = new MTRShoppingDAOImpl();

			dao.setTransport(39, 1);
			dao.setTransport(3, 80);
	}
	
	public void testCreateMall() throws IOException {
		
	}
	
}
