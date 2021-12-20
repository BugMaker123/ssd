package cn.com.ice.ordercenter.common;


import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Kenny
 * created on 2019-12-23
 */
/*
public class PageResultModel<T> extends ResultModel<Pagination<T>> implements Serializable {

	private static final long serialVersionUID = 1L;

	public static <T extends Serializable> PageResultModel<T> createPageSuccessResult(Pagination<T> pagination) {
		PageResultModel<T> pageResultModel = new PageResultModel<>();
		pagination.countPage();
		pageResultModel.setData(pagination);
		pageResultModel.setCode(ResultCode.SUCCESS.code);
		return pageResultModel;
	}

	public static <T extends Serializable> PageResultModel<T> createPageSuccessResult(int pageNo, int pageSize, int total, List<T> data) {
		PageResultModel<T> pageResultModel = new PageResultModel<>();

		Pagination<T> pagination = new Pagination<>();
		pagination.setDataList(data);
		pagination.setTotal(total);
		pagination.setPageSize(pageSize);
		pagination.setPageNo(pageNo);
		pagination.countPage();

		pageResultModel.setData(pagination);
		pageResultModel.setCode(ResultCode.SUCCESS.code);
		return pageResultModel;
	}

	public static <T extends Serializable> PageResultModel<T> createPageSuccessResult(List<T> data) {
		return createPageSuccessResult(0, -1, 99999, data);
	}

	public static <T extends Serializable> PageResultModel<T> createPageFailResult() {
		PageResultModel<T> pageResultModel = new PageResultModel<>();
		pageResultModel.setData(null);
		pageResultModel.setCode(ResultCode.FAILURE.code);
		pageResultModel.setMsg(ResultCode.FAILURE.message);
		return pageResultModel;
	}
}
*/
