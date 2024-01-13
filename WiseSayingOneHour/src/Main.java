import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
	private static int squence = 1;
	private static List<WiseSaying> list = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);
	private static String pattern = "%s  /  %s  /  %s\n";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("== 명언 앱 실행 ==");
		
		while (true) {
			System.out.print("명렁어 ) ");
			String cmd = sc.nextLine();
			
			if(cmd.equals("목록")) {
				System.out.printf(pattern, "번호", "작가", "명언");
				System.out.println("=".repeat(30));
				List<WiseSaying> list = find(a->1==1);
				list.forEach(a->System.out.printf(pattern, a.getId(), a.getAuthor(), a.getContent()));
			}else if(cmd.startsWith("상세보기")){
				final int id = getId(cmd);
				if(id==-1) {
					System.out.println("상세보기?=id(숫자) 식으로 입력 해주세요.");
					continue;
				}
				List<WiseSaying> list = find(a->a.getId()==id);
				if(isEmpty(list)) {
					System.out.println(id+"번 명언은 존재하지 않습니다.");
					continue;
				}
				list.get(0).showOne();

			}else if(cmd.equals("등록")) {
				System.out.print("명언 : ");
				String content = whileInput("명언");
				System.out.print("작가 : ");
				String author  = whileInput("작가");
				
				list.add(new WiseSaying(squence, LocalDateTime.now(), content, author));
				System.out.println(squence++ + "번 명언이 등록되었습니다.");
				
			}else if(cmd.startsWith("수정")){
				final int id = getId(cmd);
				if(id==-1) {
					System.out.println("수정?=id(숫자) 식으로 입력 해주세요.");
					continue;
				}
				
				List<WiseSaying> list = find(a->a.getId()==id);
				if(isEmpty(list)) {
					System.out.println(id+"번 명언은 존재하지 않습니다.");
					continue;
				}
				WiseSaying wiseSaying = list.get(0);
				
				System.out.printf("명언(기존) : %s\n", wiseSaying.getContent());
				System.out.printf("작가(기존) : %s\n", wiseSaying.getAuthor());
				System.out.print("명언 : ");
				String content = trimInput();
				System.out.print("작가 : ");
				String author = trimInput();
				
				if(isEmpty(content) && isEmpty(author)) {
					System.out.println("입력된 내용이 없어 수정처리를 캔슬합니다.");
					continue;
				}
				
			    if(!isEmpty(content)) {
			    	wiseSaying.setContent(content);
			    }
			    if(!isEmpty(author)) {
			    	wiseSaying.setAuthor(author);
			    }
			    
			    System.out.println(id + "번 명언이 수정되었습니다.");
			   
			    
				
			}else if(cmd.startsWith("삭제")){
				final int id = getId(cmd);
				if(id==-1) {
					System.out.println("수정?=id(숫자) 식으로 입력 해주세요.");
					continue;
				}
				
				List<WiseSaying> list = find(a->a.getId()==id);
				if(isEmpty(list)) {
					System.out.println(id+"번 명언은 존재하지 않습니다.");
					continue;
				}
				Main.list.remove(list.get(0));
				System.out.println(id+"번 명언이 삭제되었습니다.");
				
			}else if(cmd.equals("종료")) {
			   break;
			}else {
				System.out.println("잘못된 명렁어입니다.");
			}
		}
		
		System.out.println("안녕히 가세요.");

	}
	
	 
	
	private static String whileInput(String filedName) {
		String result = "";
		while(true) {
			result = trimInput();
			if(isEmpty(result)) {
				System.out.println(filedName + "은(는) 필수 입력 사항입니다.");
				continue;
			}
			break;
		}
		
		return result;
		
	}



	private static String trimInput() {
		return sc.nextLine().trim();
	}

	private static boolean isEmpty(String content) {
		// TODO Auto-generated method stub
		return content==null || content.trim().length()==0;
	}

	private static List<WiseSaying> find(Predicate<WiseSaying> p) {
		return list.stream().filter(p).sorted(Comparator.comparing(WiseSaying::getId).reversed()).toList();
	}
	private static boolean isEmpty(List<WiseSaying> list) {
		return list==null || list.size()==0;
		
	}
	

	
	
	private static int getId(String cmd) {
		int id = -1;
		String[] split = cmd.split("\\?id=");
		switch(split[0]){
		case "수정":
		case "상세보기":
		case "삭제":
			break;
		default:
			return id;
		}
		
		try {
			id = Integer.parseInt(split[1]);
		}catch(NumberFormatException e) {
			
		}
		
		return id;
		
	}

}
