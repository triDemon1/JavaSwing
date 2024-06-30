package model;

import java.util.ArrayList;


public interface MobileManager {
	public boolean addMobile(Mobile m);

	public boolean editMobile(Mobile m);

	public boolean delMobile(Mobile m);

	public ArrayList<Mobile> searchMobile(String name);

	public ArrayList<Mobile> sortedMobile(double price);
}
