package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Semestr {
    private int id;
    private String semestr;
    private String duration;
    private int status = 1;
    private List<Discipline> disciplines = new ArrayList<>();

    public Semestr() {
    }

    public Semestr(int id, String semestr, String duration, int status, List<Discipline> disciplines) {
        this.id = id;
        this.semestr = semestr;
        this.duration = duration;
        this.status = status;
        this.disciplines = disciplines;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSemestr() {
        return semestr;
    }

    public void setSemestr(String semestr) {
        this.semestr = semestr;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Semestr semestr1 = (Semestr) o;
        return id == semestr1.id &&
                status == semestr1.status &&
                Objects.equals(semestr, semestr1.semestr) &&
                Objects.equals(duration, semestr1.duration) &&
                Objects.equals(disciplines, semestr1.disciplines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, semestr, duration, status, disciplines);
    }

    @Override
    public String toString() {
        return "Semestr{" +
                "id=" + id +
                ", semestr='" + semestr + '\'' +
                ", duration='" + duration + '\'' +
                ", status=" + status +
                ", disciplines=" + disciplines +
                '}';
    }

}
