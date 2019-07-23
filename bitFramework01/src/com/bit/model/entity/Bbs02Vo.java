package com.bit.model.entity;

import java.sql.Date;

public class Bbs02Vo {

	private int num;
	private String sub,content,name;
	private Date nalja;
	
	public Bbs02Vo() {
		
	}
	
	//getter&setter, toString()
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getNalja() {
		return nalja;
	}

	public void setNalja(Date nalja) {
		this.nalja = nalja;
	}

	@Override
	public String toString() {
		return "Bbs02Vo [num=" + num + ", sub=" + sub + ", content=" + content
				+ ", name=" + name + ", nalja=" + nalja + "]";
	}
}
