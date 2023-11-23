package Main;

import java.util.Scanner;

import Character.Hero;
import Character.Monster;
import Map.Mission;
import Map.PotionStore;
import Map.WeaponStore;

public class GameMain {
	static Hero hero;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		boolean flag = true;
		while (flag) {
			System.out.println("1. 전사");
			System.out.println("2. 마법사");
			System.out.println("3. 궁수");
			System.out.print("직업을 선택하세요 (1-3): ");
			int jobChoice = Integer.parseInt(in.nextLine());
			switch (jobChoice) {
			case 1:
				hero = new Hero("전사", 1, 15, 80, 25, 0, 100);
				hero.setJob("전사");
				flag = false;
				break;
			case 2:
				hero = new Hero("마법사", 1, 18, 60, 10, 60, 100);
				hero.setJob("마법사");
				flag = false;
				break;
			case 3:
				hero = new Hero("궁수", 1, 17, 70, 17, 30, 100);
				hero.setJob("궁수");
				flag = false;
				break;
			default:
				System.out.println("올바른 번호를 입력하세요.");
			}
		}

		System.out.print("영웅의 이름을 입력하세요: ");
		String heroName = in.nextLine();
		hero.setName(heroName);

		System.out.println("게임에 입장하였습니다.");

		while (true) {
			hero.printHeroInfo();
			System.out.println("1. 사냥터에 입장");
			System.out.println("2. 포션 상점에 입장");
			System.out.println("3. 무기 상점에 입장");
			System.out.println("4. 미션 입장");
			System.out.println("5. 종료");
			System.out.print("입장할 장소를 선택하세요 (1~5): ");
			int choice = Integer.parseInt(in.nextLine());

			switch (choice) {
			case 1:
				enterHuntingGround();
				Monster selectedMonster = selectMonster(in);
				if (selectedMonster != null) {
					mainBattleLoop(in, hero, selectedMonster);
				}
				break;

			case 2:
				PotionStore potionStore = new PotionStore(hero.getMoney());
				potionStore.showPotionMenu(in, hero);
				break;

			case 3:
				WeaponStore.showWeaponMenu(hero);
				System.out.print("무기를 선택하세요: ");
				int weaponChoice = Integer.parseInt(in.nextLine());
				switch (weaponChoice) {
				case 1:
					WeaponStore.purchaseWeapon(hero, weaponChoice);
					break;
				case 2:
					break;
				default:
					System.out.println("잘못된 선택입니다.");
				}
				break;

			case 4:
				Mission.startMission(in, hero);
				break;

			case 5:
				System.out.println("게임을 종료합니다.");
				return;

			default:
				System.out.println("1~5번중에서 입력하세요.");
				break;
			}
		}
	}

	static void enterHuntingGround() {
		System.out.println(hero.getName() + "님, 사냥터에 입장합니다!");
	}

	static Monster selectMonster(Scanner in) {
		System.out.println("사냥할 몬스터를 선택하세요: ");
		System.out.println("1. 너구리 (레벨 1)");
		System.out.println("2. 살쾡이 (레벨 5)");
		System.out.println("3. 들개 (레벨 10)");
		System.out.println("4. 멧돼지 (레벨 15)");

		int monsterChoice = Integer.parseInt(in.nextLine());

		switch (monsterChoice) {
		case 1:
			return new Monster("너구리", 300, 1, 10, 5, 20, 15);
		case 2:
			return new Monster("살쾡이", 1500, 5, 20, 10, 50, 30);
		case 3:
			return new Monster("들개", 3000, 10, 30, 15, 80, 50);
		case 4:
			return new Monster("멧돼지", 10000, 15, 40, 20, 100, 80);
		default:
			System.out.println("올바른 몬스터를 선택하세요.");
			return null;
		}
	}

	static int heroAttack() {
		return hero.getLevel() * 10 + hero.getPower() * 30;
	}

	static void heroAttacked(int sum) {
		if (sum > hero.getDefense()) {
			hero.setHp(hero.getHp() + hero.getDefense() - sum);
		}
	}

	static int monsterAttack(Monster monster) {
		return monster.getPower();
	}

	static void monsterAttacked(Monster monster, int sum) {
		if (sum > hero.getDefense()) {
			monster.setHp(monster.getHp() - (sum - monster.getDefense()));
		}
	}

	static void levelUp(Hero hero) {
		hero.setLevel(hero.getLevel() + 1);
		int moneyIncrease = hero.getLevel() * 50;
		System.out.println("레벨이 올랐습니다!");
		hero.setMoney(hero.getMoney() + moneyIncrease);
		System.out.println("레벨업 기념으로 돈이 " + moneyIncrease + "원 증가했습니다.");
		System.out.println(hero.getMoney() + "원이 되었습니다.");
		hero.setExperience(0);
	}

	static void printHeroInfo() {
		System.out.println("---------------");
		System.out.println("Hero 정보");
		System.out.println("이름: " + hero.getName());
		System.out.println("레벨: " + hero.getLevel());
		System.out.println("힘: " + hero.getPower());
		System.out.println("방어력: " + hero.getDefense());
		System.out.println("HP: " + hero.getHp());
		System.out.println("MP: " + hero.getMp());
		System.out.println("경험치: " + hero.getExperience());
		System.out.println("돈: " + hero.getMoney());
		System.out.println("---------------");
	}

	static void mainBattleLoop(Scanner in, Hero hero, Monster monster) {
		boolean flag = true;
		while (flag) {
			System.out.println(monster.getName() + "와 전투를 시작합니다.");

			while (hero.getHp() > 0 && monster.getHp() > 0) {
				System.out.println(hero.getName() + "의 공격입니다.");

				int skillDamage = chooseSkill(in, hero);

				System.out.println("데미지는 " + skillDamage + "입니다.");
				monsterAttacked(monster, skillDamage);

				if (monster.getHp() > 0) {
					int monsterDamage = monsterAttack(monster);
					System.out.println(monster.getName() + "의 공격입니다.");
					System.out.println("데미지는 " + monsterDamage + "입니다.");
					heroAttacked(monsterDamage);
				}
			}

			if (monster.getHp() <= 0) {
				System.out.println(monster.getName() + "를 물리쳤습니다!");
				hero.setExperience(hero.getExperience() + monster.getExperience());
				hero.setMoney(hero.getMoney() + monster.getMoney());
				System.out.println("경험치를 얻었습니다.");
				System.out.println("돈을 획득하였습니다.");
				if (hero.getExperience() >= hero.getLevel() * 80) {
					levelUp(hero);
				}
				switch (monster.getName()) {
				case "살쾡이":
					if (hero.getLevel() >= 5) {
						hero.setLynxKillCount(hero.getLynxKillCount() + 1);
					}
					break;
				case "들개":
					if (hero.getLevel() >= 10) {
						hero.setWolfKillCount(hero.getWolfKillCount() + 1);
					}
					break;
				case "멧돼지":
					if (hero.getLevel() >= 15) {
						hero.setBoarKillCount(hero.getBoarKillCount() + 1);
					}
					break;
				default:
					break;
				}
				flag = false;

			} else if (hero.getHp() <= 0) {
				System.out.println(hero.getName() + "이(가) 죽었습니다.");
				hero.setHp(hero.getOriginalHp());
				flag = false;
			}
		}
	}

	static int chooseSkill(Scanner in, Hero hero) {
		System.out.println("스킬을 선택하세요:");
		System.out.println("1. 쓰러스트 (데미지: " + (hero.getLevel() * 10 + hero.getPower() * 30) + ")");

		if (hero.getLevel() >= 10) {
			System.out.println("2. 삼단 베기 (데미지: " + (3 * (hero.getLevel() * 10 + hero.getPower() * 30)) + ")");
		}

		if (hero.getLevel() >= 15) {
			System.out.println("3. 지건 (데미지: " + (5 * (hero.getLevel() * 10 + hero.getPower() * 30)) + ")");
		}

		int skillChoice = Integer.parseInt(in.nextLine());
		switch (skillChoice) {
		case 1:
			return hero.getLevel() * 10 + hero.getPower() * 30;
		case 2:
			return hero.getLevel() >= 10 ? (3 * (hero.getLevel() * 10 + hero.getPower() * 30)) : 0;
		case 3:
			return hero.getLevel() >= 15 ? (5 * (hero.getLevel() * 10 + hero.getPower() * 30)) : 0;
		default:
			System.out.println("올바른 번호를 입력하세요.");
			return 0; // Add a default return statement
		}
	}
}
