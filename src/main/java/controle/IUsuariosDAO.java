package controle;

import java.sql.Connection;
import java.util.ArrayList;

import modelo.Usuarios;

public interface IUsuariosDAO {
	
	public int inserirUsuarios(Usuarios end);

	public ArrayList<Usuarios> listarUsuarios();

	public boolean atualizarUsuarios(Usuarios end);

	public int removerUsuarios(Usuarios end);

	public Usuarios buscarUsuariosPorCPF(int cpf);

}
