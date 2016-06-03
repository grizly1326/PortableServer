package com;

import java.io.File;
import java.util.regex.Pattern;

public class Filegetter {
	public static void getFilesToList(String path){			//can be a path defined
		if(MediaList.getMusicList()!=null){
			MediaList.getMusicList().clear();
		}
		File f= new File(path);
		String[] filename=f.list();
		for(String s:filename){
			try{
				String prefix=(String) s.subSequence(0, s.length()-4);
				String subfix=(String) s.subSequence(s.length()-3, s.length());
				MediaList.getMusicList().add(new MediaBlock(prefix, subfix,path+"/"+s,0));
			}catch(Exception e){
			}
		}
		System.out.println("Loaded: "+filename.length+" files.");
	}
	private static boolean firstRun=true;
	public static void fileLister(String path){
		/*if(firstRun==false){
			System.out.println(".......................Path befor:	"+MediaList.getdirList().get(1).getPath());
		}*/
		File f = null;
		if(path.equals("Back")){
			f= new File(MediaList.getdirList().get(1).getPath());
			//System.out.println(".......................Back Path:	"+f.getAbsolutePath());
		}
		if(!firstRun&&!path.equals("Back")){
			f= new File(MediaList.getdirList().get(0).getPath()+"/"+path);
			//System.out.println(".......................Forward Path:	"+f.getAbsolutePath());
		}
		if(firstRun==true){
			f= new File(path);
			firstRun=false;
		}
		//System.out.println(".......................Path After:	"+f.getAbsolutePath());
		MediaList.getdirList().clear();
		String[] dir=f.list();
		String pattern = Pattern.quote(System.getProperty("file.separator"));					//this is totaly bullshit.... -___-
		String[] sub=new File(f.getAbsolutePath()).getAbsolutePath().split(pattern);
		String backPath = null;
		for(int i=0;i<sub.length-1;i++){					//this is for seperating the last location in the path.
			backPath+=sub[i]+"/";
		}
		MediaList.getdirList().add(new MediaBlock("Current path","dir",new File(f.getAbsolutePath()).getAbsolutePath(),0));
		if(sub.length!=1)				//cannot go farther than default Drive.
		{
			MediaList.getdirList().add(new MediaBlock("Back", "dir", backPath.substring(4, backPath.length()), 0));
		}
		//System.out.println("Number of DIR:	"+dir.length);
		for(String a:dir){
			if(new File(f.getAbsolutePath()+"/"+a).isDirectory()){
				MediaList.getdirList().add(new MediaBlock(a,"dir", f.getAbsolutePath()+"/"+a, 0));
			}
		}
		System.out.println("FileBrowser loaded....");
	}
}
