package com.zhoubi.graindepot.service;import com.zhoubi.graindepot.bean.Storagetype;import com.zhoubi.graindepot.mapper.StoragetypeMapper;import com.zhoubi.graindepot.base.BaseMapper;import com.zhoubi.graindepot.base.BaseService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;@Servicepublic class StoragetypeBiz extends BaseService<Storagetype>  {	@Autowired	private StoragetypeMapper StoragetypeMapper;	@Override	protected BaseMapper<Storagetype> getMapper() {		return StoragetypeMapper;	}}