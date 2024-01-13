package dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import com.wisesaying.WiseSaying;

public class WiseSayingDAO {
	private static int squence = 1;
	private static List<WiseSaying> list = new ArrayList<>();
	
	
	public static List<WiseSaying> find(Predicate<WiseSaying> p) {
		return list.stream().filter(p).sorted(Comparator.comparing(WiseSaying::getId).reversed()).toList();
	}


	public int insert(String content, String author) {
		list.add(new WiseSaying(squence, LocalDateTime.now(), content, author));
		return squence++;
	}


	public void delete(WiseSaying saying) {
		list.remove(saying);
		
	}
	
	
	
	
}
