package Utils;

import java.util.List;

public class PageBean<T> {
	private int currentPage=1;
	//当前页，默认显示第一页
	private int pageCount=4;
	//没页显示的行数（查询返回的行数）
	private int totalCount;
	private int totalPage;
	private List<T> pageData;
	//分页查询到的数据
	
	//返回总页数
	public int getTotalPage(){
		if(totalCount % pageCount==0){
			totalPage=totalCount/pageCount;
		}else{
			totalPage=totalCount/pageCount+1;
		}
		return totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<T> getPageData() {
		return pageData;
	}

	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}

}
