package com.callor.word.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.callor.word.model.WordVO;
import com.callor.word.service.WordService;

public class WordServiceImplV1 implements WordService {

	protected Scanner scan;
	protected List<WordVO> wordList;
	protected Random rnd;

	protected final int 영어 = 0;
	protected final int 한글 = 1;

	protected int nWin = 0;
	protected int nLoss = 0;
	protected int nPoint = 0;
	

	public WordServiceImplV1() {
		// TODO 생성자
		scan = new Scanner(System.in);
		wordList = new ArrayList<WordVO>();
		rnd = new Random();

		this.readWord();

	}

	public void readWord() {
		// TODO 저장

		String fileName = "src/com/callor/word/Word.txt";

		FileReader fileReader = null;
		BufferedReader buffer = null;

		try {
			fileReader = new FileReader(fileName);
			buffer = new BufferedReader(fileReader);

			while (true) {
				String reader = buffer.readLine();
				if (reader == null)
					break;

				String[] words = reader.split(":");

				WordVO wVO = new WordVO();
				wVO.setEng(words[영어]);
				wVO.setKor(words[한글]);

				wordList.add(wVO);

				// :D
				// System.out.println(wVO.toString());
			}
			buffer.close();

		} catch (FileNotFoundException e) {
			System.out.println("파일을 열수 없음");
		} catch (IOException e) {
			System.out.println("파일을 읽는 도중에 오류 발생");
		}

	}

	public void menuWord() {
		// TODO 메뉴
		while (true) {
			System.out.println("=".repeat(50));
			System.out.println("제시된 영단어를 바르게 배열하시오 [QUIT:게임종료]");
			this.viewWord();

		}

	}

	protected WordVO getWord() {
		// TODO List에 담긴 단어 1개 추출 후 출력

		int nSize = wordList.size();
		int num = rnd.nextInt(nSize);

		WordVO wVO = wordList.get(num);

		// :D
		// System.out.println(wVO.toString());

		return wVO;
	}

	public void viewWord() {
		// TODO 단어

		WordVO wVO = this.getWord();
		String strEng = wVO.getEng();
		String[] strWords = strEng.split("");

		for (int i = 0; i < 10; i++) {
			int num1 = rnd.nextInt(strWords.length);
			int num2 = rnd.nextInt(strWords.length);

			String temp = strWords[num1];
			strWords[num1] = strWords[num2];
			strWords[num2] = temp;
		}

		while (true) {
			// :D
			System.out.println(wVO.toString());

			System.out.println(Arrays.toString(strWords));
			System.out.println("=".repeat(50));
			System.out.print(">> ");
			String input = scan.nextLine();
			if (input.equals("QUIT")) {
				System.out.println("게임종료");
				return;
			}

			if (input.equalsIgnoreCase(wVO.getEng())) {
				System.out.printf("정답 : %s\n", wVO.getKor());
				nWin++;
				nPoint++;
				System.out.printf("맞은 개수 : %d, 틀린 개수: %d 점수 : %d\n",
						nWin, nLoss, nPoint);
				return;

			} else {
				System.out.println("오답");
				System.out.println("[힌트] 입력 (점수가 0점 이하이면 힌트 제공 x)");
				System.out.print(">> ");
				input = scan.nextLine();
				
				if(input.equals("힌트")) {
					System.out.printf("힌트 : %s\n", wVO.getKor());
					
				} else if(nPoint < 1) {
					System.out.println("점수가 0점이하여서 힌트 제공 x");
					continue;
				} 
				
				while (true) {
					
					int nCount = 4;
					for (int reNum = 0; reNum < 3; reNum++) {
						nCount--;
						System.out.printf("[기회 %d번 남음]\n", nCount);
						System.out.print("다시 입력 >> ");
						input = scan.nextLine();
					}
					System.out.printf("정답 : %s\n", wVO.getEng());
					nLoss++;
					nPoint--;
					System.out.printf("맞은 개수 : %d, 틀린 개수: %d 점수 : %d\n",
							nWin, nLoss, nPoint);
					return;
					
					
				} // while
				
			} // else

		} // while

	}

	/*
	 * System.out.println("[힌트] 입력 (점수가 0점 이하이면 힌트 제공 x)");
	 * System.out.println(">> "); input = scan.nextLine(); if (nPoint < 1) {
	 * System.out.println("점수가 0점이하임");
	 * 
	 * } else if (input.equals("힌트")) { System.out.printf("힌트 : %s\n ",
	 * wVO.getKor());
	 * 
	 * }
	 * 
	 * while(true) {
	 * 
	 * for (int i = 0; i < 3; i++) { if (nCount == 0) break;
	 * System.out.printf("다시 입력 (재도전 기회 : %d번 남음)\n", nCount); nCount--;
	 * System.out.print(">> "); input = scan.nextLine();
	 * 
	 * }
	 * 
	 * 
	 * }
	 * 
	 * nLoss++; nPoint--; System.out.printf("정답 : %s\n", wVO.getEng());
	 * System.out.printf("틀린 개수 : %d  점수 : %d\n", nLoss, nPoint); return;
	 * 
	 * }
	 */

	public void scoreWord() {

	}

}
