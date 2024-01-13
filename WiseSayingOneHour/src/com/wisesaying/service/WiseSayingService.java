package com.wisesaying.service;

import static com.wisesaying.Util.isEmpty;

import java.util.List;

import com.wisesaying.WiseSaying;

import dao.WiseSayingDAO;

public class WiseSayingService {
	WiseSayingDAO dao = new WiseSayingDAO();

	public WiseSayingService(WiseSayingDAO dao) {
		// TODO Auto-generated constructor stub
	}

	public List<WiseSaying> findAll() {
		// TODO Auto-generated method stub
		return dao.find(a -> 1 == 1);
	}

	public List<WiseSaying> findOne(int id) {
		// TODO Auto-generated method stub
		return dao.find(a -> a.getId() == id);
	}

	public int doWrite(String content, String author) {
		// TODO Auto-generated method stub
		return dao.insert(content, author);
	}

	public void doModify(WiseSaying wiseSaying, String content, String author) {
		if (!isEmpty(content)) {
			wiseSaying.setContent(content);
		}
		if (!isEmpty(author)) {
			wiseSaying.setAuthor(author);
		}

	}

	public void delete(WiseSaying saying) {
		dao.delete(saying);

	}

}
