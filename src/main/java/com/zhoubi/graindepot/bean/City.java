package com.zhoubi.graindepot.bean;import java.io.Serializable;import java.util.Date;import java.text.SimpleDateFormat;public class City implements Serializable {	private Integer cityid;//市主键	private String citycode;//市编码	private String cityname;//市名称	private Integer orderno;//排序号	private Double longitude;//经度	private Double latitude;//维度	public Integer getCityid(){		return cityid;	}	public void setCityid(Integer cityid){		this.cityid=cityid;	}	public String getCitycode(){		return citycode;	}	public void setCitycode(String citycode){		this.citycode=citycode;	}	public String getCityname(){		return cityname;	}	public void setCityname(String cityname){		this.cityname=cityname;	}	public Integer getOrderno(){		return orderno;	}	public void setOrderno(Integer orderno){		this.orderno=orderno;	}	public Double getLongitude(){		return longitude;	}	public void setLongitude(Double longitude){		this.longitude=longitude;	}	public Double getLatitude(){		return latitude;	}	public void setLatitude(Double latitude){		this.latitude=latitude;	}}