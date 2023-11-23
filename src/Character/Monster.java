// Monster 패키지의 Monster 클래스
package Character;

public class Monster {
	private String name;
	private int hp;
	private int level;
	private int power;
	private int defense;
	private int money;
	private int experience;

	// 생성자
	public Monster(String name, int hp, int level, int power, int defense, int money, int experience) {
		this.name = name;
		this.hp = hp;
		this.level = level;
		this.power = power;
		this.defense = defense;
		this.money = money;
		this.experience = experience;
	}

	// Getter 메소드들
	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	public int getLevel() {
		return level;
	}

	public int getPower() {
		return power;
	}

	public int getDefense() {
		return defense;
	}

	public int getMoney() {
		return money;
	}

	public int getExperience() {
		return experience;
	}

	// Setter 메소드들
	public void setName(String name) {
		this.name = name;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
}
