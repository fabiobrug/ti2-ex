package maven.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class usersDAO {
 
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";  
    private final String password = "5151"; 

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void inserir(users u) {
        String sql = "INSERT INTO users (code, login, pass, gender) VALUES (?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

        	pstmt.setInt(1, u.getCode());
            pstmt.setString(2, u.getLogin());
            pstmt.setString(3, u.getPass());
            pstmt.setString(4, String.valueOf(u.getGender()));
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<users> listar() {
        List<users> lista = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                users u = new users(
                        rs.getInt("code"),
                        rs.getString("login"),
                        rs.getString("pass"),
                        rs.getString("gender").charAt(0)
                );
                lista.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void atualizar(users u) {
        String sql = "UPDATE users SET login = ?, pass = ?, gender = ? WHERE code = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, u.getLogin());
            pstmt.setString(2, u.getPass());
            pstmt.setString(3, String.valueOf(u.getGender()));
            pstmt.setInt(4, u.getCode());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    public void excluir(int code) {
        String sql = "DELETE FROM users WHERE code = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, code);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
