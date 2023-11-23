package Map;

import java.util.Scanner;

import Character.Hero;

public class Mission {
	boolean flag1 = false;
	boolean flag2 = false;
	boolean flag3 = false;

	public static void startMission(Scanner in, Hero hero) {
		System.out.println("미션에 입장했습니다!");

		// 카운트를 hero에서 get하도록 수정
		while (true) {
			System.out.println("---------------");
			System.out.println("미션 진행 상황");
			System.out.println("1. Level 5 이상: 살쾡이 X3 - 경험치 추가 30 (처치한 살쾡이 수: " + hero.getLynxKillCount() + ")");
			System.out.println("2. Level 10 이상: 들개 X3 - 경험치 추가 50 (처치한 들개 수: " + hero.getWolfKillCount() + ")");
			System.out.println("3. Level 15 이상: 멧돼지 X3 - 경험치 추가 70 (처치한 멧돼지 수: " + hero.getBoarKillCount() + ")");
			System.out.println("4. 나가기");
			System.out.print("미션을 선택하세요 (1~4): ");
			int missionChoice = Integer.parseInt(in.nextLine());

			switch (missionChoice) {
			case 1:
				if (hero.getLevel() >= 5) {
					hero.setLynxKillCount(handleMissionResult(hero, "살쾡이", hero.getLynxKillCount(), 3, 30));
				} else {
					System.out.println("미션을 수행할 레벨이 부족합니다.");
				}
				break;
			case 2:
				if (hero.getLevel() >= 10) {
					hero.setWolfKillCount(handleMissionResult(hero, "들개", hero.getWolfKillCount(), 3, 50));
				} else {
					System.out.println("미션을 수행할 레벨이 부족합니다.");
				}
				break;
			case 3:
				if (hero.getLevel() >= 15) {
					hero.setBoarKillCount(handleMissionResult(hero, "멧돼지", hero.getBoarKillCount(), 3, 70));
				} else {
					System.out.println("미션을 수행할 레벨이 부족합니다.");
				}
				break;
			case 4:
				System.out.println("미션 창을 종료합니다.");
				return;
			default:
				System.out.println("올바른 선택을 입력하세요.");
			}
		}
	}

	private static int handleMissionResult(Hero hero, String monsterName, int killCount, int targetCount,
			int experience) {
		switch (monsterName) {
		case "살쾡이":
			if (killCount >= targetCount) {
				System.out.println("미션 목표를 달성했습니다!");
				hero.setExperience(hero.getExperience() + experience);
				System.out.println("경험치를 추가했습니다: " + experience);
				hero.setLynxKillCount(0); // 살쾡이 처치 목표를 달성하여 초기화
				return 0;
			} else {
				System.out.println(
						monsterName + "을(를) " + (targetCount - killCount) + "마리 더 처치해야 합니다. 목표 수: " + targetCount);
				return hero.getLynxKillCount(); // 목표를 달성하지 못했으므로 현재 몬스터 수를 리턴
			}
		case "들개":
			if (killCount >= targetCount) {
				System.out.println("미션 목표를 달성했습니다!");
				hero.setExperience(hero.getExperience() + experience);
				System.out.println("경험치를 추가했습니다: " + experience);
				hero.setWolfKillCount(0); // 들개 처치 목표를 달성하여 초기화
				return 0;
			} else {
				System.out.println(
						monsterName + "을(를) " + (targetCount - killCount) + "마리 더 처치해야 합니다. 목표 수: " + targetCount);
				return hero.getWolfKillCount(); // 목표를 달성하지 못했으므로 현재 몬스터 수를 리턴
			}
		case "멧돼지":
			if (killCount >= targetCount) {
				System.out.println("미션 목표를 달성했습니다!");
				hero.setExperience(hero.getExperience() + experience);
				System.out.println("경험치를 추가했습니다: " + experience);
				hero.setBoarKillCount(0); // 멧돼지 처치 목표를 달성하여 초기화
				return 0;
			} else {
				System.out.println(
						monsterName + "을(를) " + (targetCount - killCount) + "마리 더 처치해야 합니다. 목표 수: " + targetCount);
				return hero.getBoarKillCount(); // 목표를 달성하지 못했으므로 현재 몬스터 수를 리턴
			}
		default:
			System.out.println("올바른 몬스터를 선택하세요.");
			return 0;
		}
	}

}
