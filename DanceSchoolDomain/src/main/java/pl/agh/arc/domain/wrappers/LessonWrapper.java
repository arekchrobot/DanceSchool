package pl.agh.arc.domain.wrappers;

import pl.agh.arc.domain.Lesson;

/**
 *
 * @author chrobota
 */
public class LessonWrapper {

    private String hour;
    private String instructorName;
    private String weekDay;
    private double pricePerHour;

    public LessonWrapper(Lesson lesson) {
        this.hour = lesson.getHour();
        this.instructorName = lesson.getInstructor().getName();
        this.weekDay = lesson.getWeekDay().getValue();
        this.pricePerHour = lesson.getPricePerHour();
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
}
