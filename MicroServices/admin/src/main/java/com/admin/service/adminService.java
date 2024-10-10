package com.admin.service;

import com.admin.pojo.finalPojo;
import com.admin.pojo.product;

public interface adminService {
	public product[] getAll();
	public finalPojo getById(int id);
	public finalPojo save(finalPojo e1);
	public finalPojo update(finalPojo e1, int id);
	public String delete(int id);
}
