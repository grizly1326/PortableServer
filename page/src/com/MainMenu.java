package com;

public class MainMenu {
	private static String error;
	public static String printBox(){
		String first="<a href='";
		String second="'><div id='Box'>";
		String third="</div></a>	";
		String out=null;
		boolean one=false;
		for(int i=0;i<MenuList.getList().size();i++){
			if(one==false){
				out=first+MenuList.getList().get(i).getPath()+second+MenuList.getList().get(i).getName()+third;
				one=true;
			}else{
				out+=first+MenuList.getList().get(i).getPath()+second+MenuList.getList().get(i).getName()+third;
			}
		}
		return out;
	}
	public static String errorcode(){
		return error;
	}
}
