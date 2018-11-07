package hpbui.gamerportal.model;

public class JQueryDataTable {

    private String sEcho;

    private String sSearch;
    
    private int iDisplayLength;
    
    private int iDisplayStart;
    
    private int iColumns;	

    private int iSortingCols;
    
    private int iSortColumnIndex;
    
    private String sSortDirection;

    private String sColumns;

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public String getsSearch() {
		return sSearch;
	}

	public void setsSearch(String sSearch) {
		this.sSearch = sSearch;
	}

	public int getiDisplayLength() {
		return iDisplayLength;
	}

	public void setiDisplayLength(int iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}

	public int getiDisplayStart() {
		return iDisplayStart;
	}

	public void setiDisplayStart(int iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}

	public int getiColumns() {
		return iColumns;
	}

	public void setiColumns(int iColumns) {
		this.iColumns = iColumns;
	}

	public int getiSortingCols() {
		return iSortingCols;
	}

	public void setiSortingCols(int iSortingCols) {
		this.iSortingCols = iSortingCols;
	}

	public int getiSortColumnIndex() {
		return iSortColumnIndex;
	}

	public void setiSortColumnIndex(int iSortColumnIndex) {
		this.iSortColumnIndex = iSortColumnIndex;
	}

	public String getsSortDirection() {
		return sSortDirection;
	}

	public void setsSortDirection(String sSortDirection) {
		this.sSortDirection = sSortDirection;
	}

	public String getsColumns() {
		return sColumns;
	}

	public void setsColumns(String sColumns) {
		this.sColumns = sColumns;
	}
    
}
