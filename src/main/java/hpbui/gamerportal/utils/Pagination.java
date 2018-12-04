package hpbui.gamerportal.utils;

import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Pagination<T> {
	private int totalRecord;
	private int currentPage;
	private int maxResult;
	private int totalPage;
	private int maxNavigationPage;
	private List<T> results;

	public Pagination(Query<T> query, int page, int maxResult, int maxNavigationPage){
		final int pageIndex = page - 1 < 0 ? 0 : page - 1;

		int fromRecordIndex = pageIndex * maxResult;
		int maxRecordIndex = fromRecordIndex + maxResult;

		ScrollableResults resultScroll = query.scroll(ScrollMode.SCROLL_INSENSITIVE);

		List<T> results = new ArrayList<T>();

		boolean hasResult = resultScroll.first();

		if (hasResult) {
			// Cuộn tới vị trí:
				hasResult = resultScroll.scroll(fromRecordIndex);

				if (hasResult) {
					do {
						T record = (T) resultScroll.get(0);
						results.add(record);
					} while (resultScroll.next()//
							&& resultScroll.getRowNumber() >= fromRecordIndex
							&& resultScroll.getRowNumber() < maxRecordIndex);

				}

				// Chuyển tới bản ghi cuối
				resultScroll.last();
		}

		// Tổng số bản ghi.
		this.totalRecord = resultScroll.getRowNumber() + 1;
		this.currentPage = pageIndex + 1;
		this.results = results;
		this.maxResult = maxResult;

		if (this.totalRecord % this.maxResult == 0) {
			this.totalPage = this.totalRecord / this.maxResult;
		} else {
			this.totalPage = (this.totalRecord / this.maxResult) + 1;
		}

		this.maxNavigationPage = maxNavigationPage;

		if (maxNavigationPage < totalPage) {
			this.maxNavigationPage = maxNavigationPage;
		}
	}
}
