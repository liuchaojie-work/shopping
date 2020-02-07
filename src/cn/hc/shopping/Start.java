package cn.hc.shopping;
import java.util.Scanner;
public class Start {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("========XX商城========");
			System.out.println("\t1.添加商品");
			System.out.println("\t2.查看所有商品");
			System.out.println("\t3.查看指定编号商品");
			System.out.println("\t4.添加到购物车");
			System.out.println("\t5.显示购物车");
			System.out.println("\t6.退出");
			System.out.println("=======================");
			System.out.println("请选择：");
			
			int num = sc.nextInt();
			switch (num) {
			case 1:
				System.out.println("添加商品");
				break;
			case 2:
				System.out.println("查看所有商品");
				break;
			case 3:
				System.out.println("查看指定编号商品");
				break;
			case 4:
				System.out.println("添加到购物车");
				break;
			case 5:
				System.out.println("显示购物车");
				break;
			case 6:
				System.out.println("退出");
			default:
				System.out.println("输入错误");
				break;
			}
		}while(true);
	}
}
