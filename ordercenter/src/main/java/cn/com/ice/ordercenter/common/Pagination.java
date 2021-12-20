//package cn.com.ice.ordercenter.common;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.validation.constraints.NotNull;
//import java.io.Serializable;
//import java.util.List;
//
///**
// *
// * @author Kenny
// * created on 2019-11-11
// */
//@Data
//@NoArgsConstructor
//public class Pagination<T> implements Serializable{
//	private static final long serialVersionUID = 1L;
//
//	@NotNull(message = "pageNo不能为空",groups = {QueryByPage.class})
//	private Integer pageNo;
//
//	private Integer pageCount;
//
//	private Integer total;
//
//	@NotNull(message = "pageSize不能为空",groups = {QueryByPage.class})
//	private Integer pageSize;
//
//	private List<T> dataList;
//
//	public Integer countPage(){
//		if (total % pageSize == 0) {
//			this.pageCount = total / pageSize;
//		} else {
//			this.pageCount = (total / pageSize) + 1;
//		}
//		return pageCount;
//	}
//}
