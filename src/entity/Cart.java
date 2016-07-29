package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Cart {
	
	private HashMap<Item, Integer> goods ;
	
	private double totalPrice;
	
	public Cart() {
		goods = new HashMap<Item, Integer>();
		totalPrice = 0.0;
	}

	public HashMap<Item, Integer> getGoods() {
		return goods;
	}

	public void setGoods(HashMap<Item, Integer> goods) {
		this.goods = goods;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public boolean addGoods(Item item, int number){
		if(goods.containsKey(item)){
			goods.put(item, goods.get(item)+number);
		}
		else {
			goods.put(item, number);
		}
		calTotalPrice();
		return true;
	}
	
	public boolean removeGoods(Item item){
		goods.remove(item);
		calTotalPrice();
		return true;
	}
	
	public double calTotalPrice(){
		double sum = 0.0;
		Set<Item> keys = goods.keySet();
		for(Iterator<Item> it=keys.iterator();it.hasNext();){
			Item item = it.next();
			sum += item.getPrice()*goods.get(item);
		}
		this.setTotalPrice(sum);
		return this.getTotalPrice();
	}
	
	public static void main(String[] args) {
		Item i1=new Item(1,"nike","anhui",200,500,"001.jpg");
		Item i2=new Item(2, "lining", "beijing", 300, 500, "002.jpg");
		
		Cart cart = new Cart();
		
		cart.addGoods(i1, 1);
		cart.addGoods(i2, 3);
		cart.addGoods(i1, 2);
		
		Set<Map.Entry<Item, Integer>> set = cart.getGoods().entrySet();
		
		for(Map.Entry<Item, Integer> obj:set){
			System.out.println(obj);
		}
		
		System.out.println("购物车总金额"+cart.getTotalPrice());
	}
	
}
