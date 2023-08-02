package ex07;

import java.util.Date;

public class SaleVO extends ProductVO { // extends  ProductVO를 상속 !!

	private int scode;
	private int pcode;
	private int qnt;
	private int sprice;
	private Date sdate; // sql말고, utill 사용 sql데이터는 format 못함

	public int getScode() {
		return scode;
	}

	public void setScode(int scode) {
		this.scode = scode;
	}

	public int getPcode() {
		return pcode;
	}

	public void setPcode(int pcode) {
		this.pcode = pcode;
	}

	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}

	public int getSprice() {
		return sprice;
	}

	public void setSprice(int sprice) {
		this.sprice = sprice;
	}

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	@Override
	public String toString() {
		return "SaleVO [scode=" + scode + ", pcode=" + pcode + ", qnt=" + qnt + ", sprice=" + sprice + ", sdate="
				+ sdate + "]";
	}
}
