package pl.botprzemek.bpDuels.Game.Class;

public enum Classs {

    RONIN("Ronin"),
    NETRUNNER("Netrunner"),
    NOMAD("Nomad"),
    TECHNIK("Technik"),
    BUSINESSMAN("Businessman"),
    FIXER("Fixer"),
    JUGERNAUT("Jugernaut");

    private String className;

    Classs(String className) {

        this.className = className;

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

}
