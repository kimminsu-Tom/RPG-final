package Map;

import Character.Hero;

public class WeaponStore {
	public static void showWeaponMenu(Hero hero) {
		System.out.println("무기 상점에 입장하였습니다.");

		// getJob() 메소드를 호출하여 직업을 가져옴
		String job = hero.getJob();

		switch (job) {
		case "전사":
			System.out.println("1. 검 (가격: 100, 힘 증가: 20)");
			break;
		case "마법사":
			System.out.println("1. 지팡이 (가격: 100, 힘 증가: 20)");
			break;
		case "궁수":
			System.out.println("1. 활 (가격: 100, 힘 증가: 20)");
			break;
		default:
			System.out.println("해당 직업에 대한 무기가 없습니다.");
		}

		System.out.println("2. 뒤로 가기");
	}

	public static void purchaseWeapon(Hero hero, int choice) {
		int price = 100; // 무기의 가격은 일단 100으로 가정
		if (hero.getMoney() >= price) {
			hero.setMoney(hero.getMoney() - price);
			switch (choice) {
			case 1:
				// getJob() 메소드를 호출하여 직업을 가져옴
				String job = hero.getJob();

				switch (job) {
				case "전사":
					if (hero.getWeapon() == null) {
						hero.setWeapon("검");
						hero.setPower(hero.getPower() + 20);
						System.out.println(hero.getWeapon() + "을(를) 구매했습니다.");
						System.out.println("현재 공격력: " + hero.getPower());
					} else {
						System.out.println("이미 무기를 보유하고 있습니다.");
					}
					break;
				case "마법사":
					if (hero.getWeapon() == null) {
						hero.setWeapon("지팡이");
						hero.setPower(hero.getPower() + 20);
						System.out.println(hero.getWeapon() + "을(를) 구매했습니다.");
						System.out.println("현재 공격력: " + hero.getPower());
					} else {
						System.out.println("이미 무기를 보유하고 있습니다.");
					}
					break;
				case "궁수":
					if (hero.getWeapon() == null) {
						hero.setWeapon("활");
						hero.setPower(hero.getPower() + 20);
						System.out.println(hero.getWeapon() + "을(를) 구매했습니다.");
						System.out.println("현재 공격력: " + hero.getPower());
					} else {
						System.out.println("이미 무기를 보유하고 있습니다.");
					}
					break;
				}
				break;
			default:
				System.out.println("잘못된 선택입니다.");
			}
		} else {
			System.out.println("돈이 부족합니다.");
		}
	}
}
