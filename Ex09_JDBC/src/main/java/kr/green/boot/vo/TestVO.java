package kr.green.boot.vo;

import java.util.Date;

import lombok.Data;

@Data
public class TestVO {
	private String message;
	private int    result;
	private Date   today;
}
