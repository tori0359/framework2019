package com.bit.action;

import java.util.List;

import com.bit.model.Struts04Dao;
import com.bit.model.entity.Struts04Dto;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

//0. struts.xml���� <interceptor-ref name="prepare"></interceptor-ref>�� �ۼ� -> �ʵ带 �����ϰ� �ʱ�ȭ 
//1. struts.xml���� <interceptor-ref name="modelDriven"></interceptor-ref>�� �ۼ� -> �ʵ带 ����
//2. actionŬ������ �ͼ� ModelDriven �������̽��� ��ӹ޴´�.
//3. getModel() �������̵��Ͽ� bean�� �����ϸ� setter�� �޾� ������ �ڵ����� ���ش�.
//3-1. �� bean��ü�� �����Ǿ� �־���ϴ� ��������!
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
		//��ü�� ����
		return bean;
	}

	@Override
	public void prepare() throws Exception {
		//�ʵ带 �ʱ�ȭ�ؼ� ��ü�� ���� 
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
