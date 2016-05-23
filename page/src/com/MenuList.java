package com;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class MenuList {

	private static ArrayList<MenuBlock> list= new ArrayList<MenuBlock>();
	public static ArrayList<MenuBlock> getList(){
		return list;
	}
	public static void loadString(String path,ArrayList<MenuBlock> list,String error){
		String line;
		String[] cut;
		try (
			    InputStream fis = new FileInputStream(path);
			    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
			    BufferedReader br = new BufferedReader(isr);
			) {
			    while ((line = br.readLine()) != null) {
			    	cut=line.split(Settings.splitString);
			    	System.out.println(cut[0]+" 	Path: "+cut[1]);
			    	list.add(new MenuBlock(cut[0],cut[1]));
			    }
			}
		catch (FileNotFoundException e) {
			error="Cannot find a file named that way.";
		} catch (IOException e) {
			error="Error, while reading a file.";
		}
		System.out.println("MENU LOADED.... ");
	}
}
