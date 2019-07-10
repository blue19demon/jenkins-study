package org.zmph.shop.api.common;

import java.io.Serializable;
import java.util.List;
public class PageResult<T> {
	private List<T> data;
	private Integer pageNow;
	private Integer pageSize;
	private Integer total;
	@SuppressWarnings("rawtypes")
	public static Builder<?> builder() {
        return new Builder();
    }
	
	public PageResult(List<T> data, Integer pageNow, Integer pageSize, Integer total) {
		super();
		this.data = data;
		this.pageNow = pageNow;
		this.pageSize = pageSize;
		this.total = total;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Integer getPageNow() {
		return pageNow;
	}

	public void setPageNow(Integer pageNow) {
		this.pageNow = pageNow;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "PageResult [data=" + data + ", pageNow=" + pageNow + ", pageSize=" + pageSize + ", total=" + total
				+ "]";
	}

	public static class Builder<T> implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private List data;
		private Integer pageNow;
		private Integer pageSize;
		private Integer total;
		public Builder data(List data) {
			this.data = data;
			return this;
		}
		public Builder<T> pageNow(Integer pageNow) {
			this.pageNow = pageNow;
			return this;
		}
		public Builder<T> pageSize(Integer pageSize) {
			this.pageSize = pageSize;
			return this;
		}
		public Builder<T> total(Integer total) {
			this.total = total;
			return this;
		}
		
		public PageResult<T> build() {
            return new PageResult<T>(data, pageNow, pageSize, total);
        }
	}
}

