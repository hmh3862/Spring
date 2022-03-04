package kr.green.core.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Emp {
	private int empId;
	private String empName;
	private EmpAddress empAddress;
}
