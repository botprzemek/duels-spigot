package pl.botprzemek.bpDuels.Game.Class;

public enum ArmorLevel {

    LIGHT("Light", 16.0, 1.0),
    MEDIUM("Medium", 20.0, 2.0),
    HEAVY("Heavy", 24.0, 4.0);

    private String armorName;

    private double maxHealth;

    private double maxArmor;

    ArmorLevel(String className, double maxHealth, double maxArmor) {

        this.armorName = className;

        this.maxHealth = maxHealth;

        this.maxArmor = maxArmor;

    }

    public String getArmorName() {

        return armorName;

    }

    public double getMaxHealth() {

        return maxHealth;

    }

    public double getMaxArmor() {

        return maxArmor;

    }
}
