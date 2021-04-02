package com.callor.score.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

import com.callor.score.model.ScoreVO;

public class ScoreService_01 {

	protected Scanner scan;
	protected List<ScoreVO> scoreList;

	public ScoreService_01() {

		scan = new Scanner(System.in);
		scoreList = new ArrayList<ScoreVO>();
	}

	public void scoreMenu() {
		while (true) {
			System.out.println("=".repeat(50));
			System.out.println("빛고을 고등학교 성적처리 프로젝트 2021");
			System.out.println("=".repeat(50));
			System.out.println("1. 학생별 성적 입력");
			System.out.println("2. 학생 성적 리스트 출력");
			System.out.println("QUIT. 업무종료");
			System.out.println("=".repeat(50));
			System.out.print("업무선택 >> ");
			String strMenu = scan.nextLine();

			if (strMenu.equals("QUIT")) {
				break;
			} // if - break end

			Integer intMenu = 0;
			intMenu = Integer.valueOf(strMenu);

			if (intMenu == 1) {
				 this.inputScore();// 1번 누름 => inputScore 불러옴
			} else if (intMenu == 2) {

			}

		} // while end
		System.out.println("업무종료");

	} // scoreMenu end

	public void inputScore() {
		String name = null;
		while (true) {
			System.out.println("=".repeat(50));
			System.out.println("학생이름을 입력하세요 (QUIT: 입력중단)");
			System.out.println("=".repeat(50));
			System.out.print("이름 >> ");
			name = scan.nextLine();

			System.out.println("=".repeat(50));
			System.out.println(name + "학생이름의 성적을 입력하세요" + "(성적범위 0 ~ 100, QUIT : 입력중단)");
		
			if(name.equals("QUIT")) {
				break;
			}
			ScoreVO vo = new ScoreVO();
			vo.setName(name);
			this.inputSubject(vo);

		}
		
	
	}


	public void inputSubject(ScoreVO vo) {
	
		String strKor = null;
		Integer intKor = 0;
		while (true) {
			System.out.print("국어 >> ");
			strKor = scan.nextLine();
				intKor = Integer.valueOf(strKor);
			if (intKor < 0 || intKor > 100) {
				System.out.println("점수는 0 ~ 100까지 범위만 입력");
				continue;
			}
			break;
		} // kor while
		
		String strEng = null;
		Integer intEng = 0;
		while (true) {
			System.out.print("영어 >> ");
			strEng = scan.nextLine();
				intEng = Integer.valueOf(strEng);
			if (intEng < 0 || intEng > 100) {
				System.out.println("점수는 0 ~ 100까지 범위만 입력");
				continue;
			}
			break;
		}
		
		String strMath = null;
		Integer intMath = 0;
		while (true) {
			System.out.print("수학 >> ");
			strMath = scan.nextLine();
				intMath = Integer.valueOf(strMath); 
			if ( intMath < 0 || intMath > 100) {
				System.out.println("점수는 0 ~ 100까지 범위만 입력");
				continue;
			}
			break;
		}
		
		String strSci = null;
		Integer intSci = 0;
		while (true) {
			System.out.print("과학 >> ");
			strSci = scan.nextLine();
			if (intSci < 0 || intSci > 100) {
				System.out.println("점수는 0 ~ 100까지 범위만 입력");
				continue;
			}
			break;
		}
		
		String strHis = null;
		Integer intHis = 0;
		while (true) {
			System.out.print("국사 >> ");
			
			strHis = scan.nextLine();
			if (intHis < 0 || intHis > 100) {
				System.out.println("점수는 0 ~ 100까지 범위만 입력");
				
			}
			break;

		}
		
		vo.setStrKor(strKor);
		vo.setStrEng(strEng);
		vo.setStrMath(strMath);
		vo.setStrSci(strSci);
		vo.setStrHis(strHis);
		scoreList.add(vo);
	} // inputSub

	public void printList(ScoreVO vo) {
		
			System.out.println("=".repeat(50));
			System.out.println(vo.getName() + "학생의 성적이 추가되었습니다");
			System.out.println("=".repeat(50));
			System.out.println("국어 : " + vo.getStrKor());
			System.out.println("영어 : " + vo.getStrEng());
			System.out.println("수학 : " + vo.getStrMath());
			System.out.println("과학 : " + vo.getStrSci());
			System.out.println("국사 : " + vo.getStrHis());
			
			
		}
		
		
		

	} // printList end


	// Class end
