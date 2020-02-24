package com.sxt.io;

import java.util.jar.Attributes.Name;

/**
 * 装饰者模式
 * 1. 抽象组件：需要装饰的抽象对象（接口或者父类）
 * 2. 具体组件：需要装饰的对象
 * 3. 抽象装饰类：包含了对抽象组件的引用以及装饰着共有的方法
 * 4. 具体装饰类：被装饰的对象
 * @author Administrator
 *
 */
public class TestIO14 {
	public static void main(String[] args) {
		Coffee coffee = new Coffee();
		Suger milk = new Suger(coffee);
		System.out.println(milk.cost() + "----->" + milk.info());
	}
}
// 抽象组件
interface Drink {
	double cost();
	String info();
}

// 具体组件
class Coffee implements Drink {
	private String Name = "咖啡";

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return Name;
	}
	
}

// 抽象修饰类
abstract class Decorate implements Drink {
	private Drink drink;
	
	public Decorate(Drink drink) {
		// TODO Auto-generated constructor stub
		this.drink = drink;
	}
	
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return this.drink.cost();
	}
	
	@Override
	public String info() {
		// TODO Auto-generated method stub
		return this.drink.info();
	}
}

// 具体修饰类
class Suger extends Decorate {

	public Suger(Drink drink) {
		super(drink);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return super.cost() * 10;
	}
	
	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info() + "加入糖";
	}
}