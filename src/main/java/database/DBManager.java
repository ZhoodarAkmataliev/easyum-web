package database;

import entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

	public static List<Discipline> getAllActiveDisciplines() throws SQLException {
		List<Discipline> disciplines = new ArrayList<>();
		Statement stmt = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "goldenshark1");
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from discipline where status = '1';");
			while (rs.next()) {
				Discipline discipline = new Discipline();
				discipline.setId(rs.getInt("id"));
				discipline.setDiscipline(rs.getString("discipline"));
				disciplines.add(discipline);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stmt.close();
		}
		return disciplines;
	}

	public static void createDiscipline(String newDisc) throws SQLException {
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "goldenshark1");
			stmt = con.createStatement();
			stmt.execute("INSERT INTO `discipline` (`discipline`) VALUES (N'" + newDisc + "');\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stmt.close();
		}
	}

	public static void createStudents(String newSurname, String newName, String newGroup, String newDate) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "goldenshark1");
			Statement stmt = con.createStatement();
			stmt.execute("INSERT INTO `student` (`surname`, `name`, `group`, `date`) VALUES ('" + newSurname + "', '" + newName + "', '" + newGroup + "', '" + newDate + "')\n;");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<Student> getAllActiveStudents() throws SQLException {
		ArrayList<Student> students = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "goldenshark1");
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student where status = '1'");
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setSername(rs.getString("sername"));
				student.setName(rs.getString("name"));
				student.setGroup(rs.getString("group"));
				student.setDate(rs.getDate("date"));
				student.setStatus(rs.getInt("status"));
				students.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stmt.close();
		}
		return students;
	}

	public static Discipline getDisciplineById(String id) throws SQLException {
		Statement stmt = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "goldenshark1");
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from discipline where status = '1' and id =" + id);
			while (rs.next()) {
				Discipline discipline = new Discipline();
				discipline.setId(rs.getInt("id"));
				discipline.setDiscipline(rs.getString("discipline"));
				return discipline;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stmt.close();
		}
		return null;
	}

	public static void modifyDiscipline(String idDisc, String newName) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "goldenshark1");
			Statement stmt = con.createStatement();
			stmt.execute("UPDATE `discipline` SET `discipline` = '" + newName + "' WHERE (`id` = '" + idDisc + "');\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteDiscipline(String id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "goldenshark1");
			Statement stmt = con.createStatement();
			stmt.execute("UPDATE `students`.`discipline` SET `status` = '0' WHERE (`id` = '" + id + "');");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Account getAccount(String login, String password, String role) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "goldenshark1");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM account where login = '" + login + "' and password = '" + password + "' and role = '" + role + "';");
			while (rs.next()) {
				Account account = new Account();
				account.setId(rs.getInt("id"));
				account.setLogin(rs.getString("login"));
				account.setPassword(rs.getString("password"));
				account.setRole(rs.getString("role"));
				return account;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<Semestr> getAllActiveSemestrs() {
		ArrayList<Semestr> semestrs = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "goldenshark1");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from semestr where status = '1'");
			while (rs.next()) {
				Semestr semestr = new Semestr();
				semestr.setId(rs.getInt("id"));
				semestr.setSemestr(rs.getString("semestr"));
				semestr.setDuration(rs.getString("duration"));

				semestrs.add(semestr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return semestrs;
	}

	public static List<Discipline> getDisciplinesInSemestr(String idSem) {
		ArrayList<Discipline> disciplinesInSemestr = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "goldenshark1");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT discipline.id, discipline.discipline, discipline.status FROM semestr_discipline\n" +
					"INNER JOIN semestr on id_semestr = semestr.id\n" +
					"INNER JOIN discipline on id_discipline = discipline.id\n" +
					"WHERE discipline.status = '1' and id_semestr = "+idSem+";");

			while (rs.next()) {
				Discipline discipline = new Discipline();
				discipline.setId(rs.getInt("id"));
				discipline.setDiscipline(rs.getString("discipline"));
				discipline.setStatus(Integer.parseInt(rs.getString("status")));
				disciplinesInSemestr.add(discipline);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return disciplinesInSemestr;
	}

	public static Student getStudentById(String idStud) throws SQLException {
		Statement stmt = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "goldenshark1");
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student where status = '1' and id =" + idStud);
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setSername(rs.getString("sername"));
				student.setName(rs.getString("name"));
				student.setGroup(rs.getString("group"));
				student.setDate(rs.getDate("date"));
				return student;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
			stmt.close();
		}
		return null;
	}

	public static List<Mark> getMarkByStudentSemestr(String idStud, int idSemestr) {
		ArrayList<Mark> marks = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "goldenshark1");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM mark\n" +
					"INNER JOIN semestr_discipline as sd on mark.id_semestr_discipline = sd.id\n" +
					"INNER JOIN discipline as d on sd.id_discipline = d.id\n" +
					"INNER JOIN semestr as s on sd.id_semestr = s.id\n" +
					"WHERE mark.id_student = "+Integer.parseInt(idStud)+"\n" +
					"AND id_semestr = "+ idSemestr +"\n" +
					"and d.status = '1'\n" +
					"and s.status = '1';");

			while (rs.next()) {
				Discipline discipline = new Discipline();
				discipline.setId(rs.getInt("id_discipline"));
				discipline.setDiscipline(rs.getString("discipline"));
				discipline.setStatus(1);
				Mark mark = new Mark();
				mark.setDiscipline(discipline);
				mark.setMark(rs.getString("mark"));
				marks.add(mark);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return marks;
	}
}
