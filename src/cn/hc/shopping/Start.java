package cn.hc.shopping;
import java.util.Scanner;
public class Start {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("========XX�̳�========");
			System.out.println("\t1.������Ʒ");
			System.out.println("\t2.�鿴������Ʒ");
			System.out.println("\t3.�鿴ָ�������Ʒ");
			System.out.println("\t4.���ӵ����ﳵ");
			System.out.println("\t5.��ʾ���ﳵ");
			System.out.println("\t6.�˳�");
			System.out.println("=======================");
			System.out.println("��ѡ��");
			
			int num = sc.nextInt();
			switch (num) {
			case 1:
				System.out.println("������Ʒ");
				break;
			case 2:
				System.out.println("�鿴������Ʒ");
				break;
			case 3:
				System.out.println("�鿴ָ�������Ʒ");
				break;
			case 4:
				System.out.println("���ӵ����ﳵ");
				break;
			case 5:
				System.out.println("��ʾ���ﳵ");
				break;
			case 6:
				System.out.println("�˳�");
			default:
				System.out.println("�������");
				break;
			}
		}while(true);
	}
}