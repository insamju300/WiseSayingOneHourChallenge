package com.wisesaying;
import java.util.Scanner;

import com.wisesaying.controller.WiseSayingController;
import com.wisesaying.service.WiseSayingService;

import dao.WiseSayingDAO;

public class Container {

	
	public final static String pattern;
	public final static Scanner sc;
	public final static App app;
	public final static WiseSayingController contrller;
	public final static WiseSayingService service;
	public final static WiseSayingDAO dao;
	
	static {
		pattern =  "%s  /  %s  /  %s\n";
		sc = new Scanner(System.in);
		dao = new WiseSayingDAO();
		service = new WiseSayingService(dao);
		contrller= new WiseSayingController(service);
		app = new App(sc, contrller);
	}
	
	public static void close() {
		sc.close();
	}


}
