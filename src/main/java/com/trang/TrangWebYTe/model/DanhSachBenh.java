package com.trang.TrangWebYTe.model;

import java.util.ArrayList;
import java.util.List;

public class DanhSachBenh {
	List<Benh> insertBenh ;
	Benhemu[] benh;
	String[] benhs;
	String[] listngay;

	
	public String[] getListngay() {
		return listngay;
	}



	public void setListngay(String[] listngay) {
		this.listngay = listngay;
	}



	public DanhSachBenh() {
		super();
	}

	

	public String[] getBenhs() {
		return benhs;
	}



	public void setBenhs(String[] benhs) {
		this.benhs = benhs;
	}



	public Benhemu[] getBenh() {
		return benh;
	}

	public void setBenh(Benhemu[] benh) {
		this.benh = benh;
	}

	public List<Benh> getInsertBenh() {
		return insertBenh;
	}

	public void setInsertBenh(List<Benh> insertBenh) {
		this.insertBenh = insertBenh;
	}
	
}
