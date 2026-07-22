package com.ssafy.ws.step3.comp;

import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int[][][] board;
	static int[][] volcanoes;
	static boolean[] canExplode;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int turn = 0;
		board = new int[N][N][2];
		int[][] turtles = new int[M][2];
		int[] results = new int[M];
		volcanoes = new int[K][5];
		canExplode = new boolean[K];
		
		// board 초기화
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j][0] = Integer.parseInt(st.nextToken());
			}
		}
		
		// turtles 초기화
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			turtles[i][0] = x;
			turtles[i][1] = y;
			
			board[x][y][0] = 2; // 거북이 존재하는 칸으로 변경
		}
		
		// volcanoes 초기화
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			
			volcanoes[i][0] = x;
			volcanoes[i][1] = y;
			volcanoes[i][2] = P;
			canExplode[i] = true;
		}
		
		// 100턴 제한
		while(turn++ < 100) {
			Arrays.fill(canExplode, true);
			// 1. 바다거북 이동 
			for(int ID = 0; ID < M; ID++) {
				// 이동 불가능한 경우(도착, 화석) 스킵
				if(results[ID] != 0) {
					continue;
				}
				
				// 다음 이동 위치 찾기(목표지점에 도착 못하면 이동X)
				int[] next = findNext(turtles[ID][0], turtles[ID][1]);
				if(next == null) {
					continue;
				}
				
				// 다음 위치가 목표 지점이면 거북이 소멸
				if(next[0] == board.length - 1 && next[1] == board.length - 1) {
					results[ID] = turn;
					board[turtles[ID][0]][turtles[ID][1]][0] = 0;
				}
				// 다음 위치가 목표 지점이 아니면 갱신
				else {
					board[turtles[ID][0]][turtles[ID][1]][0] = 0;
					
					turtles[ID][0] = next[0];
					turtles[ID][1] = next[1];
					
					board[turtles[ID][0]][turtles[ID][1]][0] = 2;
				}	
			}
			
//			// 바다거북 이동 검증
//			System.out.print("turn "+ turn + "\n");
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < N; j++) {
//					System.out.print(board[i][j][0] + " ");
//				}
//				System.out.print("\n");
//			}
			
			// 2. 화산 압력 증가
			for(int[] volcano : volcanoes) {
				volcano[3] += 10;
			}
			
			// 3. 화산 분출
			explode();
			
			// 4. 화석화
			for(int i = 0; i < M; i++) {
				// 도착했거나 이미 화석이면 스킵
				if(results[i] != 0) {
					continue;
				}
				
				int x = turtles[i][0];
				int y = turtles[i][1];
				
				// 만약 거북의 현재 위치의 열기가 20 이상이면 화석화
				if(board[x][y][1] >= 20) {
					results[i] = -1;
					board[x][y][0] = 3;
				}
			}
			
			// 5. 열기 초기화
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					board[i][j][1] = 0;
				}
			}
			
			// 6. 종료 조건
			boolean isEnd = true;
			
			for(int i = 0; i < M; i++) {
				if(results[i] == 0) {
					isEnd = false;
				}
			}
			
			if(isEnd) {
				break;
			}
		}
		
		// 100턴 지나도 도달 못했으면 -1
		for(int i = 0; i < M; i++) {
			if(results[i] == 0) {
				results[i] = -1;
			}
		}
		
		// 결과 출력
		for(int r : results) {
			sb.append(r).append("\n");
		}
		System.out.print(sb);
	}
	
	private static int[] findNext(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		boolean[][] visited = new boolean[board.length][board.length];
		int[][][] predecessor = new int[board.length][board.length][2];
		
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] curr = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = curr[0] + dx[i];
				int ny = curr[1] + dy[i];
				
				if(nx < 0 || nx >= board.length || ny < 0 || ny >= board.length) {
					continue;
				}
				
				if(board[nx][ny][0] == 0 && !visited[nx][ny]) {
					queue.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
					predecessor[nx][ny] = new int[] {curr[0], curr[1]};
				}
			}
		}
		
		// 목표에 도착했는지 visited로 확인
		if(!visited[board.length - 1][board.length - 1]){
			return null;
		}
		// 목표에 도착했으면 이전 위치 역추적
		else {
			int currX = board.length - 1;
			int currY = board.length - 1;
			
			while(true) {	
				int prevX = predecessor[currX][currY][0];
				int prevY = predecessor[currX][currY][1];
				
				// 이전 위치가 시작 지점이면
				// 현재 위치가 시작 지점의 바로 다음 이동 지점 = 결과값
				if(prevX == x && prevY == y) {
					return new int[] {currX, currY};
				}
				
				// 한 칸 더 이전 위치로 역추적
				currX = prevX;
				currY = prevY;
			}
		}
	}
	
	private static void explode() {
		Queue<int[]> queue = new ArrayDeque<>();
		
		// 이번 턴에 분출 조건을 만족하는 화산 큐에 삽입
		for(int i = 0; i < volcanoes.length; i++) {
			if(canExplode[i] && volcanoes[i][2] <= volcanoes[i][3]) {
				queue.offer(volcanoes[i]);
				volcanoes[i][3] = 0;
				canExplode[i] = false;
			}
		}
		
		while(!queue.isEmpty()) {
			int[] vol = queue.poll();
			int initialHeat = vol[2];
			int x = vol[0];
			int y = vol[1];
			
			// 1. 화산 중심지에 열기 추가
			board[x][y][1] += initialHeat;
			
			// 2. 상하좌우 4방향으로 열기 전파
			for(int i = 0; i < 4; i++) {
				int currentHeat = initialHeat / 2;
				int nx = x;
				int ny = y;
				
				while(currentHeat > 0) {
					nx += dx[i];
					ny += dy[i];
					
					// 범위를 벗어나거나 산호초를 만나면 해당 방향 중단
					if(nx < 0 || nx >= board.length || ny < 0 || ny >= board.length || board[nx][ny][0] == 1) {
						break;
					}
					
					// 현재 칸에 열기 누적
					board[nx][ny][1] += currentHeat;
					
					// 현재 칸에 화산이 있다면 연쇄 폭발 검사 후 큐에 추가
					if(isVolcano(nx, ny)) {
						int[] triggeredVol = isExplode(nx, ny);
						if(triggeredVol != null) {
							queue.offer(triggeredVol);
						}
					}
					
					// 다음 칸으로 넘어갈 때 열기 반감
					currentHeat /= 2;
				}
			}
		}
	}
	
	private static boolean isVolcano(int x, int y) {
		for(int i = 0; i < volcanoes.length; i++) {
			// [x, y]에 화산이 있는지 검사
			if(volcanoes[i][0] == x && volcanoes[i][1] == y) {
				return true;
			}
		}
		
		return false;
	}
	
	private static int[] isExplode(int x, int y) {
		for(int i = 0; i < volcanoes.length; i++) {
			// [x, y]에 있는 화산 탐색
			if(volcanoes[i][0] == x && volcanoes[i][1] == y) {
				// 이번 턴에 분출 가능한지 검사
				if(canExplode[i] && volcanoes[i][2] <= volcanoes[i][3] + board[x][y][1]) {
					canExplode[i] = false;
					volcanoes[i][3] = 0;
					return volcanoes[i];
				}
			}
		}
		
		return null;
	}
}
