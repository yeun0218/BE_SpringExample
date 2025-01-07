package pack.controller;

import lombok.Getter;
import lombok.Setter;
import pack.model.Board;

@Getter
@Setter
public class BoardBean {
	private int num;
	private int readcnt;
	private String author,title, content,bwrite;
	private String searchValue;
}
