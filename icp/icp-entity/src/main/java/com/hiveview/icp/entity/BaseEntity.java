package com.hiveview.icp.entity;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity  implements Serializable {
	
	
	private static final long serialVersionUID = -16963221057278428L;

	private String id;
	
	private Date createDate;
	
	private String createBy;
	
	private Date lastUpdateDate;
	
	private String lastUpdateBy;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}
}
