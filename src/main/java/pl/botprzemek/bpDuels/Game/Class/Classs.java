package pl.botprzemek.bpDuels.Game.Class;

public enum Classs {

    RONIN("Ronin", ArmorLevel.LIGHT),
    NETRUNNER("Netrunner", ArmorLevel.LIGHT),
    NOMAD("Nomad", ArmorLevel.HEAVY),
    TECHNIK("Technik", ArmorLevel.MEDIUM),
    BUSINESSMAN("Businessman", ArmorLevel.LIGHT),
    FIXER("Fixer", ArmorLevel.LIGHT),
    JUGERNAUT("Jugernaut", ArmorLevel.HEAVY);

    private String className;

    private ArmorLevel armorLevel;

    Classs(String className, ArmorLevel armorLevel) {

        this.className = className;

        this.armorLevel = armorLevel;

    }

    public static Classs getClassByName(String name)  {

        for (Classs classs : values()) {

            if (name.equals(classs.getRawClassName())) return classs;

        }

        return null;

    }

    public String getClassName() {

        return className;

    }

    public String getRawClassName() {

        return className.toLowerCase();

    }

    public ArmorLevel getArmorLevel() {

        return armorLevel;

    }

}
