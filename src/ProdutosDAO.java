import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto(ProdutosDTO produto){
        //conn = new conectaDAO().connectDB();
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        return listagem;
    }

    // Novo método adicionado
    public void venderProduto(int idProduto) {
        String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11", "root", "1234")) {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, idProduto);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao vender produto: " + e.getMessage());
        }
    }
}
