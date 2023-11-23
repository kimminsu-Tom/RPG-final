package Map;

import java.util.Scanner;

import Character.Hero;

public class PotionStore {
	private int hero_money;

	public PotionStore(int hero_money) {
		this.hero_money = hero_money;
	}

	public int getHero_money() {
		return hero_money;
	}

	public void setHero_money(int hero_money) {
		this.hero_money = hero_money;
	}

	public void potionStore_show(int num, Hero hero) {
		int money = getItemPrice(num);

		switch (num) {
		case 1:
			money = 30;
			System.out.println("힘 증강 포션을 구입했습니다. (가격: 30원)");
			increaseStrength(hero);
			break;
		case 2:
			money = 30;
			System.out.println("방어력 증강 포션을 구입했습니다. (가격: 30원)");
			increaseDefense(hero);
			break;
		case 3:
			money = 100;
			System.out.println("경험치 증강 포션을 구입했습니다. (가격: 100원)");
			increaseExperience(hero);
			break;
		case 4:
			money = 10;
			System.out.println("HP 증강 포션을 구입했습니다. (가격: 10원)");
			increaseHP(hero);
			break;
		case 5:
			money = 10;
			System.out.println("MP 증강 포션을 구입했습니다. (가격: 10원)");
			increaseMP(hero);
			break;
		default:
			System.out.println("올바른 번호를 입력하세요.");
		}

		hero.setMoney(hero.getMoney() - money);
		System.out.println("구입이 완료되었습니다.");
		System.out.println(hero.getMoney() + "원 남았습니다.");
	}

	private void increaseStrength(Hero hero) {
		hero.setPower(hero.getPower() + 5);
	}

	private void increaseDefense(Hero hero) {
		hero.setDefense(hero.getDefense() + 5);
	}

	private void increaseExperience(Hero hero) {
		hero.setExperience(hero.getExperience() + 50);
	}

	private void increaseHP(Hero hero) {
		hero.setHp(hero.getHp() + 50);
	}

	private void increaseMP(Hero hero) {
		hero.setMp(hero.getMp() + 50);
	}

	public void showPotionMenu(Scanner in, Hero hero) {
		while (true) {
			System.out.println("포션 상점에 입장하였습니다.");
			System.out.println("1. 힘 증강 포션(30원)");
			System.out.println("2. 방어력 증강 포션(30원)");
			System.out.println("3. 경험치 증강 포션(100원)");
			System.out.println("4. HP 증강 포션(10원)");
			System.out.println("5. MP 증강 포션(10원)");
			System.out.println("6. 나가기");

			System.out.print("원하시는 물건을 입력하세요 (1-6): ");
			int choice = Integer.parseInt(in.nextLine());

			if (choice == 6) {
				System.out.println("포션 상점에서 나갑니다.");
				break;
			}

			if (hero.getMoney() >= getItemPrice(choice)) {
				potionStore_show(choice, hero);
			} else {
				System.out.println("돈이 부족합니다.");
			}
		}
	}

	public int getItemPrice(int choice) {
		switch (choice) {
		case 1:
		case 2:
			return 30;
		case 3:
			return 100;
		case 4:
		case 5:
			return 10;
		default:
			return 0;
		}
	}
}