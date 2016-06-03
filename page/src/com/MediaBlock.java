package com;

public class MediaBlock {
	String name,subName,path;
	int duration;
	public MediaBlock(String name, String subName, String path,int duration){
		this.name=name;
		this.duration=duration;
		this.subName=subName;
		this.path=path;
	}
	public String getPath(){
		return path;
	}
	public String getSubName(){
		return subName;
	}
	public String getName(){
		return name;
	}
	public int getDuration(){
		return duration;
	}
}
