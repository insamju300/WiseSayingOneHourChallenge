package com.wisesaying.controller;

import static com.wisesaying.Util.getId;
import static com.wisesaying.Util.isEmpty;
import static com.wisesaying.Util.trimInput;
import static com.wisesaying.Util.whileInput;

import java.util.List;
import com.wisesaying.Container;
import com.wisesaying.Util;
import com.wisesaying.WiseSaying;
import com.wisesaying.service.WiseSayingService;

public class WiseSayingController {
	private WiseSayingService service;

	public WiseSayingController(WiseSayingService service) {
		this.service = service;

	}

	public void showList() {
		System.out.printf(Container.pattern, "번호", "작가", "명언");
		System.out.println("=".repeat(30));
		List<WiseSaying> list = service.findAll();
		list.forEach(a -> System.out.printf(Container.pattern, a.getId(), a.getAuthor(), a.getContent()));
	}

	public void showDetail(String cmd) {
		final int id = Util.getId(cmd);
		if (id == -1) {
			System.out.println("상세보기?=id(숫자) 식으로 입력 해주세요.");
			return;
		}
		List<WiseSaying> list = service.findOne(id);
		if (isEmpty(list)) {
			System.out.println(id + "번 명언은 존재하지 않습니다.");
			return;
		}
		list.get(0).showOne();
	}

	public void doWrite() {
		System.out.print("명언 : ");
		String content = whileInput("명언");
		System.out.print("작가 : ");
		String author = whileInput("작가");

		int id = service.doWrite(content, author);

		System.out.println(id + "번 명언이 등록되었습니다.");
	}

	public void doModify(String cmd) {
		final int id = getId(cmd);
		if (id == -1) {
			System.out.println("수정?=id(숫자) 식으로 입력 해주세요.");
			return;
		}

		List<WiseSaying> list = service.findOne(id);
		if (isEmpty(list)) {
			System.out.println(id + "번 명언은 존재하지 않습니다.");
			return;
		}
		WiseSaying wiseSaying = list.get(0);

		System.out.printf("명언(기존) : %s\n", wiseSaying.getContent());
		System.out.printf("작가(기존) : %s\n", wiseSaying.getAuthor());
		System.out.print("명언 : ");
		String content = trimInput();
		System.out.print("작가 : ");
		String author = trimInput();

		if (isEmpty(content) && isEmpty(author)) {
			System.out.println("입력된 내용이 없어 수정처리를 캔슬합니다.");
			return;
		}

		service.doModify(wiseSaying, content, author);
		System.out.println(id + "번 명언이 수정되었습니다.");
	}

	public void doDelete(String cmd) {
		final int id = getId(cmd);
		if (id == -1) {
			System.out.println("수정?=id(숫자) 식으로 입력 해주세요.");
			return;
		}

		List<WiseSaying> list = service.findOne(id);
		if (isEmpty(list)) {
			System.out.println(id + "번 명언은 존재하지 않습니다.");
			return;
		}
		service.delete(list.get(0));
		System.out.println(id + "번 명언이 삭제되었습니다.");
	}
}
