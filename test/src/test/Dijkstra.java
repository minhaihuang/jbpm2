package test;

import java.util.TreeMap;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Point {
	private int id;// ���id
	private boolean flag = false;// ��־�Ƿ񱻱���
	int sum;// ��¼�ܵĵ����

	private TreeMap<Integer, Integer> thisPointMap = new TreeMap<Integer, Integer>();// �õ㵽����ľ��롣
	BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

	Point(int sum) { // ���캯�� ���ж������
		this.sum = sum;
	}

	public void setId(int id) {// ���ö���id
		this.id = id;
	}

	public int getId() {// ��ö���id
		return this.id;
	}

	public void changeFlag() {// �޸ķ���״̬��
		this.flag = true;
	}

	public boolean isVisit() {// �鿴����״̬
		return flag;
	}

	public void setLenToOther()throws IOException{// ��ʼ���ĵ㵽������ľ��롣
		System.out.println("=======�����붥��" + (this.id + 1) + "������������ı߾�=======");
		for (int i = 0; i < sum; i++) {
			if (i == this.id)
				thisPointMap.put(this.id, 0);
			else {
				System.out.print("�� ����" + (i + 1) + " �ľ��� ��");
				boolean flag =true;
				int len = 0;
				while(flag){
					try {
						len = Integer.valueOf(bufr.readLine());
						flag = false;
					} catch (NumberFormatException e) {
						System.out.print("�����������������룺");
					}
				};
				thisPointMap.put(i, len);
			}
		}
	}

	// �õ㵽����id�� ���롣
	public int lenToPointId(int id) {
		return thisPointMap.get(id);
	}
}

class Dijkstra {
	public static void main(String[] args)throws IOException {
		ArrayList<Point> point_arr = new ArrayList<Point>();// �洢�㼯��
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�����붥������� ");
		int sum = 0;
		boolean flag =true;
		while(flag){
			try {
				sum = Integer.valueOf(bufr.readLine());
				flag = false;
			} catch (NumberFormatException e) {
				System.out.print("�����������������룺");
			}
		};
		for (int i = 0; i < sum; i++) {// ��ʼ��
			Point p = new Point(sum);
			p.setId(i);
			p.setLenToOther();
			point_arr.add(p);
		}
		System.out.print("��������ʼ���� id ��");
		boolean flag2 =true;
		int start = 0;
		while(flag2){
			try {
				start = Integer.valueOf(bufr.readLine())-1;
				if(start > sum-1 || start < 0)
					throw new NumberFormatException();
				flag2 = false;
			}catch (NumberFormatException e) {
				System.out.print("�����������������룺");
			}
		};
		showDijkstra(point_arr, start);// ��Դ���·������
	}

	public static void showDijkstra(ArrayList<Point> arr, int i) {
		System.out.print("����" + (i + 1));
		arr.get(i).changeFlag();
		Point p1 = getTopointMin(arr, arr.get(i));
		if (p1 == null)
			return;
		int id = p1.getId();
		showDijkstra(arr, id);

	}

	public static Point getTopointMin(ArrayList<Point> arr, Point p) {
		Point temp = null;
		int minLen = Integer.MAX_VALUE;
		for (int i = 0; i < arr.size(); i++) {
			// ���ѷ��� �� ������������޸�·��ʱ������
			if (arr.get(i).isVisit() || arr.get(i).getId() == p.getId() || p.lenToPointId(i) < 0)
				continue;
			else {
				if (p.lenToPointId(i) < minLen) {
					minLen = p.lenToPointId(i);
					temp = arr.get(i);
				}
			}
		}
		if (temp == null)
			return temp;
		else
			System.out.print("  @--" + minLen + "--> ");
		return temp;
	}
}
