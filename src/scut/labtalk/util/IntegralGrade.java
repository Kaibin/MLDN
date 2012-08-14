package scut.labtalk.util;

import java.util.Properties;

public class IntegralGrade {
	private Properties pro = null;

	private static final IntegralGrade ig = new IntegralGrade();

	// key --> value
	private IntegralGrade() {
		this.pro = new Properties();
		this.pro.setProperty("1", "开发爱好者");
		this.pro.setProperty("2", "初级程序员");
		this.pro.setProperty("3", "软件工程师");
		this.pro.setProperty("4", "高级软件工程师");
		this.pro.setProperty("5", "项目主管");
		this.pro.setProperty("6", "项目经理");
		this.pro.setProperty("7", "项目总监");
		this.pro.setProperty("8", "首席技术执行官");
	}

	public static IntegralGrade getInstance() {
		return ig;
	}

	// 确认等级
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

	// 取得等级信息
	/**
	 * 
	 * @param grade
	 *            表示用户登陆之后的等级
	 * @return 返回一个等级的具体信息
	 */
	public String getGradeInfo(int grade) {
		String str = null;
		str = this.pro.getProperty(grade + "");
		return str == null ? "" : str;
	}
}
