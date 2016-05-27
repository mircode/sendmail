package com.sendmail.chart.model;

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.List;

import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;

/**
 * 报表数据模型父类
 * @author root
 *
 */
public class ChartModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String serialize() throws JSONException{
		String json=JSONUtil.serialize(this);
		return json;
	}
	public void serialize(Writer writer) throws IOException, JSONException{
		JSONUtil.serialize(writer, this);
	}
	public Object deserialize(Reader reader) throws JSONException{
		return JSONUtil.deserialize(reader);
		
	}
	public Object deserialize(String json) throws JSONException{
		return JSONUtil.deserialize(json);
	}
	
	@SuppressWarnings("rawtypes")
	protected String [] toStringArray(List list){
		String [] strArrays=null;
		if(list!=null){
			strArrays=new String[list.size()];	
			for(int i=0;i<list.size();i++){
				strArrays[i]=(String)list.get(i);
			}
		}
		return strArrays;
	}
	@SuppressWarnings("rawtypes")
	protected double [][] toDouble2Array(List list){
		
		double [][] dou2Arrays=null;
		if(list!=null){
			dou2Arrays=new double[list.size()][];
			for(int i=0;i<list.size();i++){
				List list2=(List)list.get(i);
				if(list2!=null){
					dou2Arrays[i]=new double[list2.size()];
					for(int j=0;j<list2.size();j++){
						dou2Arrays[i][j]=(Double)list2.get(j);	
					}
				}
			}
		}
		return dou2Arrays;
	}
	
			
}
