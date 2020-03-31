package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Pais;

public class PaisDAO {

	private Connection conexao;
	
	public PaisDAO (Connection conexao) {
		this.conexao = conexao;
	}
	
	public void insert (Pais pais) {
		String inserir = "INSERT INTO Paises (id, nome, populacao, area_total)" + "VALUES(?,?,?,?)";
	
		try (PreparedStatement pst = conexao.prepareStatement(inserir)){
			pst.setInt(1, pais.getId());
			pst.setString(2, pais.getNome());
			pst.setLong(3, pais.getPopulacao());
			pst.setDouble(4, pais.getArea());
			pst.execute();
			
			System.out.println("Pais Cadastrado!");
		} catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("Erro ao cadastrar o Pais");
		}	
	}
	
	//SELECT
	public String selectPais (int id) {
		
		String consulta = "SELECT id, nome, populacao, area_total FROM pais WHERE id = ?";
				
		try (PreparedStatement pst = conexao.prepareStatement(consulta)){
			pst.setInt(1, id);
			ResultSet resultado = pst.executeQuery();
			Pais pais = null;
			
			if(resultado.next()) {
				pais = new Pais();
				
				int idPais = resultado.getInt("id");
				String nome = resultado.getString("nome");
				long populacao = resultado.getLong("populacao");
				double area = resultado.getDouble("area_total");
				
				//Atribuição
				pais.setId(idPais);
				pais.setNome(nome);
				pais.setPopulacao(populacao);
				pais.setArea(area);
				
				return pais.toString();
			}
			System.out.println("Consulta feita com sucesso");
		} catch(SQLException ex) {	
			ex.printStackTrace();
			System.out.println("Falha na consulta");
		}
		return null;
	}
	
	//DELETE
	public void delete (String pais) {
		String deleta = "DELETE FROM Paises WHERE nome = ?";
		
		try (PreparedStatement pst = conexao.prepareStatement(deleta)){
			pst.setString(1, pais);
			pst.execute();
			
			System.out.println("Pais excluido");
			
		} catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("Falha ao excluir o Pais");
		}
	}
	
	public void upDateNomePais (String pais, int id) {		
		String update = "UPDATE Paises SET nome = ? WHERE id = ?";
			
		try (PreparedStatement pst = conexao.prepareStatement(update)){
			pst.setString(1, pais);
			pst.setInt(2, id);
			pst.execute();
				
			System.out.println("Atualizado com sucesso!");
		} catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("Erro ao atualizar");
		}
	}	
}
