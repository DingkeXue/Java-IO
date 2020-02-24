package com.sxt.io;

import java.util.jar.Attributes.Name;

/**
 * װ����ģʽ
 * 1. �����������Ҫװ�εĳ�����󣨽ӿڻ��߸��ࣩ
 * 2. �����������Ҫװ�εĶ���
 * 3. ����װ���ࣺ�����˶Գ�������������Լ�װ���Ź��еķ���
 * 4. ����װ���ࣺ��װ�εĶ���
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
// �������
interface Drink {
	double cost();
	String info();
}

// �������
class Coffee implements Drink {
	private String Name = "����";

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

// ����������
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

// ����������
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
		return super.info() + "������";
	}
}