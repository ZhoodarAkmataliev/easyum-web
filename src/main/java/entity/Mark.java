package entity;

import java.util.Objects;

public class Mark {
	private int id;
	private Student student;
	private Semestr semestr;
	private Discipline discipline;
	private String mark;

	public Mark() {
	}

	public Mark(int id, Student student, Semestr semestr, Discipline discipline, String mark) {
		this.id = id;
		this.student = student;
		this.semestr = semestr;
		this.discipline = discipline;
		this.mark = mark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Semestr getSemestr() {
		return semestr;
	}

	public void setSemestr(Semestr semestr) {
		this.semestr = semestr;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Mark mark1 = (Mark) o;
		return id == mark1.id &&
				Objects.equals(student, mark1.student) &&
				Objects.equals(semestr, mark1.semestr) &&
				Objects.equals(discipline, mark1.discipline) &&
				Objects.equals(mark, mark1.mark);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, student, semestr, discipline, mark);
	}

	@Override
	public String toString() {
		return "Mark{" +
				"id=" + id +
				", student=" + student +
				", semestr=" + semestr +
				", discipline=" + discipline +
				", mark='" + mark + '\'' +
				'}';
	}
}
