package com.example.jdbcdemo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.jdbcdemo.domain.Ryby;

public class RybyManager {

	private Connection connection;

	private String url = "jdbc:hsqldb:hsql://localhost/workdb";

	private String createTableRyby = "CREATE TABLE Ryby (id bigint GENERATED BY DEFAULT AS IDENTITY, nazwa varchar(20), gatunek varchar(20), rok_urodzenia integer)";

	private Statement statement;

	private PreparedStatement addRybyStmt;
	private PreparedStatement deleteAllRybyStmt;
	private PreparedStatement getAllRybyStmt;
	private PreparedStatement getRybaByIdStmt;

	public RybyManager() {

		try {
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();

			ResultSet rs = connection.getMetaData().getTables(null, null, null,
					null);
			boolean tableExists = false;
			while (rs.next()) {
				if ("Ryby".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}

			if (!tableExists)
				statement.executeUpdate(createTableRyby);

			addRybyStmt = connection
					.prepareStatement("INSERT INTO Ryby (nazwa,gatunek,rok_urodzenia) VALUES (? ,? ,?)");

			deleteAllRybyStmt = connection.prepareStatement("DELETE FROM Ryby");

			getAllRybyStmt = connection
					.prepareStatement("SELECT id,nazwa,gatunek,rok_urodzenia FROM Ryby");
			getRybaByIdStmt = connection
					.prepareStatement("SELECT id,nazwa,gatunek,rok_urodzenia FROM Ryby WHERE id = ?");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	Connection getConnection() {
		return connection;
	}

	public void clearRyby() {
		try {
			deleteAllRybyStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int addRyby(Ryby rezyser) {
		int count = 0;

		try {
			addRybyStmt.setString(1, rezyser.getNazwa());
			addRybyStmt.setString(2, rezyser.getGatunek());
			addRybyStmt.setInt(3, rezyser.getRok_urodzenia());

			count = addRybyStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	public List<Ryby> getAllRyby() {
		List<Ryby> rezysers = new ArrayList<Ryby>();

		try {
			ResultSet rs = getAllRybyStmt.executeQuery();

			while (rs.next()) {
				Ryby r = new Ryby();
				r.setId(rs.getInt("id"));
				r.setNazwa(rs.getString("nazwa"));
				r.setGatunek(rs.getString("gatunek"));
				r.setRok_urodzenia(rs.getInt("rok_urodzenia"));

				rezysers.add(r);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rezysers;
	}

	public Ryby getRybaByid(Ryby ryby){
		Ryby r = new Ryby();
		
		try {
			ResultSet rs = getRybaByIdStmt.executeQuery();
			rs.next();
			
			r.setId(rs.getInt("id"));
			r.setNazwa(rs.getString("nazwa"));
			r.setGatunek(rs.getString("gatunek"));
			r.setRok_urodzenia(rs.getInt("rok_urodzenia"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return r;
	}
}
