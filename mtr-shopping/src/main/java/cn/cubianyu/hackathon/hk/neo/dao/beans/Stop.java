package cn.cubianyu.hackathon.hk.neo.dao.beans;

import java.util.List;

public class Stop {
	private Station station;
	private List<Shop> shops;

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public List<Shop> getShops() {
		return shops;
	}

	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}
}
