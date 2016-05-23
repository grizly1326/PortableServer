package com;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class List {
	private static ArrayList<Profile> peopleList= new ArrayList<Profile>();
	private static String splitString="//";
	private static String error="INFO: No error in Loading.";
	public static String help;
	private static String path="ProfileSave.txt";
	public static void init(){
		//fill list, call load() or NOT.
		load();
	}
	public static void addPerson(Profile a){
		peopleList.add(a);
	}
	public static void load(){
		String line;
		String cut[];
		try (
			    InputStream fis = new FileInputStream(path);
			    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
			    BufferedReader br = new BufferedReader(isr);
			) {
			    while ((line = br.readLine()) != null) {
			    	cut=line.split(splitString);
			    	System.out.println("LOADED to DB: "+line);
			    	peopleList.add(new Profile(cut[0],cut[1],cut[2],Integer.parseInt(cut[3])));
			    }
			}
		catch (FileNotFoundException e) {
			error="Cannot find a file named that way.";
		} catch (IOException e) {
			error="Error, while reading a file.";
		}
	}
	public static void save(){
		try {
			PrintWriter out = new PrintWriter(path);
			for(Profile a : peopleList){
				out.println(a.getName()+splitString+a.getSurname()+splitString+a.getEmail()+splitString+a.getAdmin());
			}
			out.close();
		} catch (FileNotFoundException e) {
			error="cannot save to a file.";
		}
	}
	public static String errorcode(){
		return error;
	}
	public static boolean checkIfExist(String fname, String lname, String email){
		for(Profile a : peopleList){
			if(a.getName().toLowerCase().equals(fname.toLowerCase())){
				if(a.getSurname().toLowerCase().equals(lname.toLowerCase())){
					return true;
				}
			}
			if(a.getEmail().equals(email)){
				return true;
			}
		}
		return false;
	}
}
