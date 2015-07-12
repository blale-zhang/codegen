package org.blade.personal.utils;

import java.util.List;

/**
 * Pager Class is encapsulating logic of Paging-querying, If someone want to get the index of record Pager object
 * require them  setting  pageSize and currentPage
 * @author zgf
 *
 * @param <T>
 */
public class Pager<T> {
	
	public Long pageSize = 30L;// 每页记录数,默认30
	public Long totalPageNum;// 总共页数,toatlCount/pageSize得到（能整除，有余数则+1）
	public Long currentPage;// 当前页码
	public Long totalCount;// 总记录数
	public Long index; //当前页第一条记录下标
	public List<T> entities;

	public Pager(Long pageSize, Long totalCount) {
		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}
	
	public Pager() {
		// TODO Auto-generated constructor stub
	}

	public Long getIndex(){
		return pageSize * (currentPage-1);
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public Long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Long correntPage) {
		this.currentPage = correntPage;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	/**
	 * Set the total count of record
	 * @param totalCount
	 */
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	private Long computeTotalPageNum(){
		totalPageNum = totalCount/pageSize;
		if(totalCount % pageSize != 0)
			totalPageNum++;
		return totalPageNum;
	}
	
	public Long getTotalPageNum(){
		return this.computeTotalPageNum();
	}
	
	public List<T> getEntities() {
		return entities;
	}

	public void setEntities(List<T> entities) {
		this.entities = entities;
	}

	public boolean hasNext() {
		if ((currentPage - 1) * pageSize <= getTotalCount())
			return true;
		return false;
	}

	public boolean hasPrevious() {
		if ((currentPage - 1) * pageSize >= getPageSize())
			return true;
		return false;
	}

	public void nextPage() {
		if (this.hasNext())
			currentPage += currentPage;

	}

	public void prePage() {
		if (this.hasPrevious())
			currentPage -= currentPage;
	}
	
}

