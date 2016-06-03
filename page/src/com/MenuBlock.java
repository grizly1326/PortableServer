package com;

public class MenuBlock {
	private String name, path, code;
	private int status;
	public MenuBlock(int status, String name, String path, String code){
		this.status=status;
		this.name=name;
		this.path=path;
		this.code=code;
	}
	public String getName(){
		return name;
	}
	public String getPath(){
		return path;
	}
	public String getCode() {
		return code;
	}
	public int getStatus() {
		return status;
	}
}
