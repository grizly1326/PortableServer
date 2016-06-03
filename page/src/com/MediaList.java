package com;

import java.util.ArrayList;

public class MediaList {
	static ArrayList<MediaBlock> musicList=new ArrayList<MediaBlock>();
	static ArrayList<MediaBlock> videoList=new ArrayList<MediaBlock>();
	static ArrayList<MediaBlock> dirList=new ArrayList<MediaBlock>();
	public static ArrayList<MediaBlock> getMusicList(){
		return musicList;
	}
	public static ArrayList<MediaBlock> getVideoList(){
		return videoList;
	}
	public static ArrayList<MediaBlock> getdirList(){
		return dirList;
	}
	public static String printMusic(){
		String out=null;
		String formStart="<form action='MusicPlayerServlet'method='post'>";
		String first="<input id='Box' type='submit' name='button' value='";
		String second="'>";
		String formEnd="</form>";
		out=formStart;
		for(int i=0;i<MediaList.getMusicList().size();i++){
			if(MediaList.getMusicList().get(i).getSubName().equals("mp3")){				//prints out only that has mp3 at the end.....
				out+=first+MediaList.getMusicList().get(i).getName()+second;	
			}
		}
		out+=formEnd;
		if(out.equals(formStart+formEnd)){
			out="No songs.";
		}
		return out;
	}
	public static int findBynameInMusicList(String name){
		int out=0;
		for(int i=0;i<musicList.size();i++){
			if(musicList.get(i).getName().equals(name)){
				out=i;
			}
		}
		return out;
	}
	public static String printDir(){
		String out="<form action='NewServlet'method='post'><input id='Box' type='submit' name='button' value='"+MediaList.getdirList().get(0).getPath()+"'>";
		String first="<input id='Box' type='submit' name='button' value='";
		String second="'>";
		String formEnd="</form>";
		for(int i=1;i<MediaList.getdirList().size();i++){
			out+=first+MediaList.getdirList().get(i).getName()+second;
		}
		out+=formEnd;
		return out;
	}
	public static int findBynameInDirList(String name){
		int out=0;
		for(int i=0;i<dirList.size();i++){
			if(dirList.get(i).getName().equals(name)){
				out=i;
			}
		}
		return out;
	}
}
