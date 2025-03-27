package oop.tegevusteplaneerija.common;

import java.sql.*;

public class DatabaseManager {
    private final String url;

    /**
     * Objekt, mille meetodite abil saab lisada ja kustutada evente jms. Nõuab
     *
     * @param dbFilePath
     */
    public DatabaseManager(String dbFilePath) {
        this.url = "jdbc:sqlite:data/" + dbFilePath;
    }

    // järgneb jällegi gpt kirjutatud kood, mis annab ideed, kuidas hakkame kasutama andmebaasi.
    public void init() throws SQLException {
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute("""
                CREATE TABLE IF NOT EXISTS events (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    title TEXT NOT NULL,
                    description TEXT
                )
            """);
        }
    }

    public void insertEvent(String title, String desc) throws SQLException {
        String sql = "INSERT OR REPLACE INTO events(title,description) VALUES(?,?)";
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, title);
            ps.setString(2, desc);
            ps.executeUpdate();
        }
    }

    public String printAll() throws SQLException {
        String sql = "SELECT * FROM events";
        StringBuilder sb;
        try (Connection conn = DriverManager.getConnection(url);
             ResultSet rs = conn.createStatement().executeQuery(sql)) {
            sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getInt("id"));
                sb.append(rs.getString("title"));
                sb.append(rs.getString("description"));
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public void insertEvent(CalendarEvent event) throws SQLException {
        insertEvent(event.getTitle(), event.getDescription());
    }
}