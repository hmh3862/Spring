package kr.green.boot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class MainApp2 {
	public static void main(String[] args) {
		// 유틸 패키지의 타이머
		Timer timer = new Timer(); // 타이머 객체 생성
		// 할일 
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				System.out.println("나는 언제 실행이 될까요?");
			}
		};
		// 타이머 시작
		timer.schedule(task, 5000, 1000); // 5초후 1초마다 실행
		
		// 스윙패키지의 타이머 : Timer(시간, 할일) 할일은 ActionListener를 구현해서 등록
		javax.swing.Timer timer2 = new javax.swing.Timer(5000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Swing패키지의 타이머");
			}
		});
		
		timer2.start(); // 타이머 시작
		// 30초 일시 정지
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		// 타이머 종료
		timer.cancel();
		timer2.stop();
	}
}
