package com.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.Filegetter;
import com.GeneralInfo;
import com.MainMenu;
import com.MenuList;
import com.ProfileList;
import com.Settings;


@WebServlet("/Init")
public class Init extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Init() {
        super();
        ProfileList.init();
        MenuList.loadString(Settings.stringPath, MenuList.getList(), MainMenu.errorcode());
        Filegetter.getFilesToList(Settings.musicPath);
        Filegetter.fileLister(Settings.musicPath);
        System.out.println(GeneralInfo.restart());
        //Here is the server side code for initilization....(Normal java program)
    }
}
