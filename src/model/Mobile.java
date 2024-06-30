package model;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Mobile extends Product implements MobileManager, Comparable<Mobile>, Serializable {
	private String color;
	private int batteryLife;
	private String brand;
	private static final String FILE_NAME = "Mobile.bin";
	
	public static String getFileName() {
		return FILE_NAME;
	}


	public static List<Mobile> mobileInventory = new ArrayList<>();

	public Mobile() {
		
	}

	public Mobile(int id) {
		this.product_id = id;
	}

	public Mobile(int product_id, String product_name, double product_price, int product_total, String color,
			int batteryLife, String brand) {
		super(product_id, product_name, product_price, product_total);
		this.color = color;
		this.batteryLife = batteryLife;
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getBatteryLife() {
		return batteryLife;
	}

	public void setBatteryLife(int batteryLife) {
		this.batteryLife = batteryLife;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Mobile [product_id= " + getProduct_id() + ", product_name= " + getProduct_name() + ", product_price= "
				+ getProduct_price() + "\n" + ", product_total= " + getProduct_total() + ", color= " + color
				+ ", batterylife= " + batteryLife + ", brand=" + brand + "]" + "\n";
	}

	@Override
	public boolean addMobile(Mobile m) {
		// TODO Auto-generated method stub
		if (isMobileExists(m.getProduct_id())) {
			return false;
		}
		return mobileInventory.add(m);
	}

	// phương thức kiểm tra sự tồn tại của sản phẩm
	public boolean isMobileExists(int productID) {
		for (Mobile m : mobileInventory) {
			if (m.getProduct_id() == productID) {
				return true;
			}
		}
		return false;
	}


	@Override
	public boolean editMobile(Mobile m) {
		for (int i = 0; i < mobileInventory.size(); i++) {
			if (mobileInventory.get(i).getProduct_id() == m.getProduct_id()) {
				mobileInventory.set(i, m);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delMobile(Mobile m) {
		// TODO Auto-generated method stub
		for (Mobile mobile : mobileInventory) {
			if (mobile.getProduct_id() == m.getProduct_id()) {
				return mobileInventory.remove(mobile);
			}
		}
		return false;
	}

	@Override
	public ArrayList<Mobile> searchMobile(String name) {
		ArrayList<Mobile> searchResult = new ArrayList<>();
		for (Mobile m : mobileInventory) {
			if (m.getProduct_name().equalsIgnoreCase(name)) {
				searchResult.add(m);
			}
		}
		return searchResult.isEmpty() ? null : searchResult;
	}

	@Override
	public int compareTo(Mobile o) {
		if (this.getProduct_price() > o.getProduct_price()) {
			return 1;
		} else if (this.getProduct_price() < o.getProduct_price()) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public ArrayList<Mobile> sortedMobile(double price) {
		Collections.sort(mobileInventory);
		return (ArrayList<Mobile>) mobileInventory;
	}


//	public void generateProducts() {
//		Mobile mobile1 = new Mobile(1, "iPhone X", 23.3, 100, "Blue", 4, "iPhone");
//		Mobile mobile2 = new Mobile(2, "SamSung S20 Ultra", 22.2, 150, "White", 6, "SamSung");
//		Mobile mobile3 = new Mobile(3, "Xiaomi Redmi Note 5", 12.5, 200, "Black", 10, "Xiaomi");
//		Mobile mobile4 = new Mobile(4, "OPPO A3S", 25.5, 100, "Red", 5, "Oppo");
//		Mobile mobile5 = new Mobile(5, "RealMi C3", 17.5, 150, "Green", 3, "RealMi");
//		new Mobile().addMobile(mobile1);
//		new Mobile().addMobile(mobile2);
//		new Mobile().addMobile(mobile3);
//		new Mobile().addMobile(mobile4);
//		new Mobile().addMobile(mobile5);
//	}
}
