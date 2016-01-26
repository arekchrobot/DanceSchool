package pl.agh.arc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author chrobota
 */
@Entity
@Table(name = "lesson")
@SequenceGenerator(name = "default_gen", sequenceName = "lesson_seq", allocationSize = 1)
public class Lesson extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "week_day")
    private WeekDay weekDay;
    
    @Column(name = "hour_", length = 5)
    @Size(min = 5, max = 5)
    private String hour;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Instructor instructor;

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
