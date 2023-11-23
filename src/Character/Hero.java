package Character;

public class Hero {
	private String name;
	private int level;
	private int power;
	private int hp;
	private int defense;
	private int mp;
	private int experience;
	private int money;
	private int originalHp;
	private String weapon;
	private String job;
	private int monstersHunted;
	private int lynxKillCount;
	private int wolfKillCount;
	private int boarKillCount;

	// 각 몬스터에 대한 카운트를 hero에 넣어놓고 get, set을 통해 get, update하도록 수정
	// 생성자에 위에 변수 3개 초기화 필요

	// 생성자
	public Hero(String name, int level, int power, int hp, int defense, int mp, int money) {
		this.name = name;
		this.level = level;
		this.power = power;
		this.hp = hp;
		this.defense = defense;
		this.mp = mp;
		this.experience = 0;
		this.money = money;
		this.originalHp = hp;
		this.monstersHunted = 0;
	}

	// Getter 메소드들
	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public int getPower() {
		return power;
	}

	public int getHp() {
		return hp;
	}

	public int getDefense() {
		return defense;
	}

	public int getMp() {
		return mp;
	}

	public int getExperience() {
		return experience;
	}

	public int getMoney() {
		return money;
	}

	public int getOriginalHp() {
		return originalHp;
	}

	public String getWeapon() {
		return weapon;
	}

	public String getJob() {
		return job;
	}

	public int getMonstersHunted() {
		return monstersHunted;
	}

	public int getLynxKillCount() {
		return lynxKillCount;
	}

	public int getWolfKillCount() {
		return wolfKillCount;
	}

	public int getBoarKillCount() {
		return boarKillCount;
	}

	// Setter 메소드들
	public void setName(String name) {
		this.name = name;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public void setLynxKillCount(int count1) {
		this.lynxKillCount = count1;
	}

	public void setWolfKillCount(int count2) {
		this.wolfKillCount = count2;
	}

	public void setBoarKillCount(int count3) {
		this.boarKillCount = count3;
	}

	// 기타 필요한 메소드들
	public void levelUp() {
		level++;
		int moneyIncrease = level * 50;
		System.out.println("레벨이 올랐습니다!");
		money += moneyIncrease;
		System.out.println("레벨업 기념으로 돈이 " + moneyIncrease + "원 증가했습니다.");
		System.out.println(money + "원이 되었습니다.");
		experience = 0;
	}

	public void printHeroInfo() {
		System.out.println("---------------");
		System.out.println("Hero 정보");
		System.out.println("이름: " + name);
		System.out.println("레벨: " + level);
		System.out.println("힘: " + power);
		System.out.println("방어력: " + defense);
		System.out.println("HP: " + hp);
		System.out.println("MP: " + mp);
		System.out.println("경험치: " + experience);
		System.out.println("돈: " + money);
		System.out.println("---------------");
	}

	public int chooseSkill(int skillChoice) {
		switch (skillChoice) {
		case 1:
			return level * 10 + power * 30;
		case 2:
			return level >= 10 ? 3 * (level * 10 + power * 30) : 0;
		case 3:
			return level >= 15 ? 5 * (level * 10 + power * 30) : 0;
		default:
			System.out.println("올바른 번호를 입력하세요.");
			return 0;
		}
	}

	public void hero_attacked(int sum) {
		if (sum > defense) {
			hp = hp + defense - sum;
		}
	}

	public void increaseStrength() {
		power += 5;
	}

	public void increaseDefense() {
		defense += 5;
	}

	public void increaseExperience() {
		experience += 50;
	}

	public void increaseHP() {
		hp += 50;
	}

	public void increaseMP() {
		mp += 50;
	}
}