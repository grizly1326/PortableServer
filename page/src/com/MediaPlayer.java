package com;

import java.io.File;
import java.net.MalformedURLException;

public class MediaPlayer {
	public static String getMusicPlayer(){
		MediaBlock block= MediaList.musicList.get(MediaList.findBynameInMusicList(Settings.musicSelected));
		String out="<audio controls ><source src='";
		String second="' type='audio/";
		String third="'/></audio>";
		try {
			return out+new File(block.getPath()).toURI().toURL()+second+block.getSubName()+third;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return "ERROR in loading song.";
		
	}
}
