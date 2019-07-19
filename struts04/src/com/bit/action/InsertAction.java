package com.bit.action;

import java.util.List;

import com.bit.model.Struts04Dao;
import com.bit.model.entity.Struts04Dto;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

//0. struts.xml에서 <interceptor-ref name="prepare"></interceptor-ref>를 작성 -> 필드를 생성하고 초기화 
//1. struts.xml에서 <interceptor-ref name="modelDriven"></interceptor-ref>를 작성 -> 필드를 주입
//2. action클래스에 와서 ModelDriven 인터페이스를 상속받는다.
//3. getModel() 오버라이딩하여 bean을 전달하면 setter를 받아 주입을 자동으로 해준다.
//3-1. 단 bean객체가 생성되어 있어야하는 전제조건!
public class InsertAction implements Action, ModelDriven<Struts04Dto>,Preparable {

	Struts04Dto bean = new Struts04Dto();
	
//	public Struts04Dto getBean(){
//		return bean;
//	}

	@Override
	public String execute() throws Exception {
//		new Struts04Dao().insertOne(sub,name,content);
//		System.out.println(bean.getSub());
//		System.out.println(bean.getName());
//		System.out.println(bean.getContent());
		new Struts04Dao().insertOne(bean);
		return this.SUCCESS;
	}
	
	@Override
	public Struts04Dto getModel() {
		//객체를 전달
		return bean;
	}

	@Override
	public void prepare() throws Exception {
		//필드를 초기화해서 객체를 생성 
		bean = new Struts04Dto();
	}

}

/*
 * 	private String sub, name, content;
	

	public void setSub(String sub) {
		this.sub = sub;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setContent(String content) {
		this.content = content;
	}
 * 
 * 
 * */
