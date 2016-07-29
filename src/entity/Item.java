package entity;

public class Item {
	private int id;
	private String name;
	private String city;
	private int price;
	private int number;
	private String picture;//商品图片
	
	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(int id, String name, String city, int price, int number,
			String picture) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.price = price;
		this.number = number;
		this.picture = picture;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public int hashCode() {
		//TODO 为何如此重写hashCode方法
		return this.getId()+this.getName().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj){
			return true;
		}
		if (obj instanceof Item) {
			Item item = (Item)obj;
			if(this.getId()==item.getId() && this.getName().equals(item.getName())){
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "商品id是： "+ this.getId() +", "+ "商品名称是： " + this.getName();
	}
	
	
	
	
	
	
	
	
	
	
}
