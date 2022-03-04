package kr.green.core.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArrayObject {
	// 배열을 어떻게 주입할까?
	private int[] ids;
	private String[] names;
}
