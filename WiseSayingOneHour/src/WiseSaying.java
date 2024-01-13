import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WiseSaying {
	private int id;
	private LocalDateTime regDate; 
	private String content;
	private String author;
	public WiseSaying(int id, LocalDateTime regDate, String content, String author) {
		super();
		this.id = id;
		this.regDate = regDate;
		this.content = content;
		this.author = author;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void showOne() {
		System.out.printf("번호 : %d \n", id);
		System.out.printf("날짜 : %s \n", regDate.format(DateTimeFormatter.ofPattern("yy-MM-dd hh:mm:ss")));
		System.out.printf("작가 : %s \n", author);
		System.out.printf("내용 : %s \n", content);
	}
	
	
	
}