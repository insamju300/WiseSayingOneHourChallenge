package com.wisesaying;
import java.util.List;

public class Util {

	public static String whileInput(String filedName) {
		String result = "";
		while (true) {
			result = trimInput();
			if (isEmpty(result)) {
				System.out.println(filedName + "은(는) 필수 입력 사항입니다.");
				continue;
			}
			break;
		}

		return result;

	}

	public static String trimInput() {
		return Container.sc.nextLine().trim();
	}

	public static boolean isEmpty(String content) {
		// TODO Auto-generated method stub
		return content == null || content.trim().length() == 0;
	}



	public static boolean isEmpty(List<WiseSaying> list) {
		return list == null || list.size() == 0;

	}

	public static int getId(String cmd) {
		int id = -1;
		String[] split = cmd.split("\\?id=");
		switch (split[0]) {
		case "수정":
		case "상세보기":
		case "삭제":
			break;
		default:
			return id;
		}

		try {
			id = Integer.parseInt(split[1]);
		} catch (NumberFormatException e) {

		}

		return id;

	}

}
