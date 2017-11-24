package org.ram.reference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Species {

	public static void main(String[] args) {
		
		System.out.println("Enter n");
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		
		List<Animal> animals=new ArrayList<Animal>();
		List<Mammal> mammals=new ArrayList<Mammal>();
		
		for(int i=0;i<n;i++) {
		String type=scan.next();
		if(type.equals("A")) {
			Animal animal=new Animal();
			String name=scan.next();
			int legs=scan.nextInt();	
			animal.setName(name);
			animal.setLegs(legs);
			animals.add(animal);
		}
		else if(type.equals("M")) {
			Mammal mammal=new Mammal();
			String name=scan.next();
			String mType=scan.next();	
			int totalFoods=scan.nextInt();
			List<String> foods=new ArrayList<String>();
			for(int j=0;j<totalFoods;j++) {
				foods.add(scan.next());
			}
			mammal.setFoods(totalFoods);
			mammal.setName(name);
			mammal.setType(mType);
			mammal.setListFoods(foods);
			mammals.add(mammal);
		}
		}
		
		for (Iterator iterator = animals.iterator(); iterator.hasNext();) {
			Animal animal = (Animal) iterator.next();
			
			System.out.println(animal.getName() +"  "+animal.getLegs());
			
		}
		
		for (Iterator iterator = mammals.iterator(); iterator.hasNext();) {
			Mammal mammal = (Mammal) iterator.next();
			
			System.out.println(mammal.getName() +"  "+4);
			System.out.println(mammal.getType());
			System.out.print(mammal.listFoods.size() +":");
			mammal.listFoods.forEach(System.out::print);
			System.out.println("");
			
		}
	}

}

class Animal{
	
	String name;
	int legs;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLegs() {
		return legs;
	}
	public void setLegs(int legs) {
		this.legs = legs;
	}
	
}

class Mammal{
	
	String name;
	String type;
	int foods;
	List<String> listFoods;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getFoods() {
		return foods;
	}
	public void setFoods(int foods) {
		this.foods = foods;
	}
	public List<String> getListFoods() {
		return listFoods;
	}
	public void setListFoods(List<String> listFoods) {
		this.listFoods = listFoods;
	}
	
}
