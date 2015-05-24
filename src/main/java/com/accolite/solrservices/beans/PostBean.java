package com.accolite.solrservices.beans;

public class PostBean {
private int id;
private String title;
private String description;
private String status;
private String Date;

public String getStatus() {
	return status;
}
public PostBean(int id, String title, String description) {
	super();
	this.id = id;
	this.title = title;
	this.description = description;
}
public void setStatus(String status) {
	this.status = status;
}
public String getDate() {
	return Date;
}
public void setDate(String date) {
	Date = date;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
@Override
public String toString() {
	return "PostBean [id=" + id + ", title=" + title + ", description="
			+ description + "]";
}

}
