package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Pais;

public class PaisDAO {

	Connection conexao = ConnectionFactory.conectar();	
	/*public PaisDAO (Connection conexao) {
		this.conexao = conexao;
	}*/
	
	public long insert (Pais pais) {
		String inserir = "INSERT INTO Paises (id, nome, area_total, populacao)" + "VALUES(?,?,?,?)";
	
		try (PreparedStatement pst = conexao.prepareStatement(inserir)){
			pst.setInt(1, pais.getId());
			pst.setString(2, pais.getNome());
			pst.setDouble(3, pais.getArea());
			pst.setLong(4, pais.getPopulacao());
			
			pst.execute();
			
			System.out.println("Pais Cadastrado!");
		} catch(SQLException ex){
			ex.printStackTrace();
			System.out.println("Erro ao cadastrar o Pais");
		}
		return pais.getId();
	}
	
	//SELECT
	public Pais selectPais (int id) {
		// 
		String consulta = "SELECT id, nome, populacao, area_total FROM Paises WHERE Paises.id = ?";
				
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
				
				//Atribui��o
				pais.setId(idPais);
				pais.setNome(nome);
				pais.setPopulacao(populacao);
				pais.setArea(area);
				
				return pais;
			}
			System.out.println("Consulta feita com sucesso");
		} catch(SQLException ex) {	
			ex.printStackTrace();
			System.out.println("Falha na consulta");
		}
		return null;
	}
	
	//DELETE
	public void delete (int id) {
		String deleta = "DELETE FROM Paises WHERE id = ?";
		
		try (PreparedStatement pst = conexao.prepareStatement(deleta)){
			pst.setInt(1, id);
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
	public String maiorNumeroHabitante() {
		String maiorNumero = "SELECT * FROM Paises WHERE populacao = (SELECT MAX(populacao) FROM Paises);";
		
		try (PreparedStatement pst = conexao.prepareStatement(maiorNumero)){
			ResultSet resultado = pst.executeQuery();
			
			if(resultado.next()) {
				String nome = resultado.getString("nome");
				return nome;
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}
	public String menorNumeroHabitante() {
		String maiorNumero = "SELECT * FROM Paises WHERE area_total = (SELECT MIN(area_total) FROM Paises);";
		
		try (PreparedStatement pst = conexao.prepareStatement(maiorNumero)){
			ResultSet resultado = pst.executeQuery();
			
			if(resultado.next()) {
				String nome = resultado.getString("nome");
				return nome;
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}
}
