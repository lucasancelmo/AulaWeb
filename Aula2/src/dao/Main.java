package dao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Pais;

public class Main {

	public static void main(String[] args) {
		PaisDAO dao = new PaisDAO(ConnectionBD.conectar());
		List<Pais> ps = dao.vetorTresPaises();
		for(int i = 0; i < ps.size(); ++i) {
			System.out.println(ps.get(i));
		}

		
	}
}
