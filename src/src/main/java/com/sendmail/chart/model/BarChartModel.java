package com.sendmail.chart.model;

import java.io.Reader;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.JSONException;

public class BarChartModel extends ChartModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String title;
	private String rowName;
	private String columnName;
	
	private String[] rowKeys;
	private String[] columnKeys;
	private double[][] data;
	
	public BarChartModel(){
		
	}
	@SuppressWarnings("rawtypes")
	public BarChartModel(Map hashMap){
		
		this.id=(String)hashMap.get("id");
		this.title=(String)hashMap.get("title");
		this.rowName=(String)hashMap.get("rowName");
		this.columnName=(String)hashMap.get("columnName");
		
		this.rowKeys=this.toStringArray((List)hashMap.get("rowKeys"));
		this.columnKeys=this.toStringArray((List)hashMap.get("columnKeys"));
		
		this.data=this.toDouble2Array((List)hashMap.get("data"));
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRowName() {
		return rowName;
	}
	public void setRowName(String rowName) {
		this.rowName = rowName;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String[] getRowKeys() {
		return rowKeys;
	}
	public void setRowKeys(String[] rowKeys) {
		this.rowKeys = rowKeys;
	}
	public String[] getColumnKeys() {
		return columnKeys;
	}
	public void setColumnKeys(String[] columnKeys) {
		this.columnKeys = columnKeys;
	}
	public double[][] getData() {
		return data;
	}
	public void setData(double[][] data) {
		this.data = data;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@SuppressWarnings("rawtypes")
	public BarChartModel deserialize(Reader reader) throws JSONException{
		HashMap hashMap=(HashMap) super.deserialize(reader);
		
		this.id=(String)hashMap.get("id");
		this.title=(String)hashMap.get("title");
		this.rowName=(String)hashMap.get("rowName");
		this.columnName=(String)hashMap.get("columnName");
		
		this.rowKeys=this.toStringArray((List)hashMap.get("rowKeys"));
		this.columnKeys=this.toStringArray((List)hashMap.get("columnKeys"));
		
		this.data=this.toDouble2Array((List)hashMap.get("data"));
		
		return this;
	}
	@SuppressWarnings("rawtypes")
	public BarChartModel deserialize(String json) throws JSONException{
		HashMap hashMap=(HashMap)super.deserialize(json);
		
		this.id=(String)hashMap.get("id");
		this.title=(String)hashMap.get("title");
		this.rowName=(String)hashMap.get("rowName");
		this.columnName=(String)hashMap.get("columnName");
		
		this.rowKeys=this.toStringArray((List)hashMap.get("rowKeys"));
		this.columnKeys=this.toStringArray((List)hashMap.get("columnKeys"));
		
		this.data=this.toDouble2Array((List)hashMap.get("data"));
		
		
		return this;
	}
	
	
	
}
