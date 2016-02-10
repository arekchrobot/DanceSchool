package pl.agh.arc.domain;

/**
 *
 * @author chrobota
 */
public enum WeekDay {
    MONDAY("Poniedziałek",1),
    TUESDAY("Wtorek",2),
    WEDNESDAY("Środa",3),
    THURSDAY("Czwartek",4),
    FRIDAY("Piątek",5),
    SATURDAY("Sobota",6),
    SUNDAY("Niedziela",7);
    
    private String value;
    private int weight;

    private WeekDay(String value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
