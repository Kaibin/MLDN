package scut.labtalk.util;

import java.util.Properties;

public class IntegralGrade {
	private Properties pro = null;

	private static final IntegralGrade ig = new IntegralGrade();

	// key --> value
	private IntegralGrade() {
		this.pro = new Properties();
		this.pro.setProperty("1", "����������");
		this.pro.setProperty("2", "��������Ա");
		this.pro.setProperty("3", "�������ʦ");
		this.pro.setProperty("4", "�߼��������ʦ");
		this.pro.setProperty("5", "��Ŀ����");
		this.pro.setProperty("6", "��Ŀ����");
		this.pro.setProperty("7", "��Ŀ�ܼ�");
		this.pro.setProperty("8", "��ϯ����ִ�й�");
	}

	public static IntegralGrade getInstance() {
		return ig;
	}

	// ȷ�ϵȼ�
	public int getGrade(int ita) {
		int grade = 0;
		if (ita >= 0 && ita <= 300) {
			grade = 1;
		}
		if (ita >= 301 && ita <= 1000) {
			grade = 2;
		}
		if (ita >= 1001 && ita <= 5000) {
			grade = 3;
		}
		if (ita >= 5001 && ita <= 10000) {
			grade = 4;
		}
		if (ita >= 10001 && ita <= 20000) {
			grade = 5;
		}
		if (ita >= 20001 && ita <= 50000) {
			grade = 6;
		}
		if (ita >= 50001 && ita <= 100000) {
			grade = 7;
		}
		if (ita >= 100000 && ita <= 500000) {
			grade = 8;
		}
		return grade;
	}

	// ȡ�õȼ���Ϣ
	/**
	 * 
	 * @param grade
	 *            ��ʾ�û���½֮��ĵȼ�
	 * @return ����һ���ȼ��ľ�����Ϣ
	 */
	public String getGradeInfo(int grade) {
		String str = null;
		str = this.pro.getProperty(grade + "");
		return str == null ? "" : str;
	}
}
