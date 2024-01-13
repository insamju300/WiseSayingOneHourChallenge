package com.wisesaying;

import java.util.Scanner;

import com.wisesaying.controller.WiseSayingController;

public class App {
	private Scanner sc;
	private WiseSayingController controller;

	public App(Scanner sc, WiseSayingController controller) {
		super();
		this.sc = sc;
		this.controller = controller;
	}

	public void run() {
		System.out.println("== 명언 앱 실행 ==");

		while (true) {
			System.out.print("명렁어 ) ");
			String cmd = sc.nextLine();
			if (cmd.equals("목록")) {
				controller.showList();
			} else if (cmd.startsWith("상세보기")) {
				controller.showDetail(cmd);
			} else if (cmd.equals("등록")) {
				controller.doWrite();
			} else if (cmd.startsWith("수정")) {
				controller.doModify(cmd);
			} else if (cmd.startsWith("삭제")) {
				controller.doDelete(cmd);
			} else if (cmd.equals("종료")) {
				break;
			} else {
				System.out.println("잘못된 명렁어입니다.");
			}
		}

		System.out.println("안녕히 가세요.");
	}

}
