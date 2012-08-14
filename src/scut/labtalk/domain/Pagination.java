package scut.labtalk.domain;

public class Pagination {
	private int start;
	// һ��ȡ�õ�����
	private int size;
	// ��ǰҳ��
	private int currentPage = 1;
	// �ܵļ�¼ҳ��
	private long totalPage = 0;
	// �ܵļ�¼����
	private long totalRecord;

	public long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}

	public Pagination() {

	}

	public Pagination(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

}
