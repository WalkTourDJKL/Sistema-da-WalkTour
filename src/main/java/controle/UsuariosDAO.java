package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Usuarios;

public class UsuariosDAO implements IUsuariosDAO {

    private static UsuariosDAO instancia;

    private UsuariosDAO() {
    }

    public static UsuariosDAO getInstancia() {
        if (instancia == null) {
            instancia = new UsuariosDAO();
        }
        return instancia;
    }

    public Usuarios hospAchado = null;

    public int inserirUsuarios(Usuarios end) {
        String SQL = "INSERT INTO usuarios (nome, nome_social, dt_nasc, cpf, login, senha, tipo_user) VALUES (?, ?, ?, ?, ?, ?, ?)";

        Conexao con = Conexao.getConexao();
        Connection conDB = con.conectar();
        int chavePrimariaGerada = Integer.MIN_VALUE;

        try {
            PreparedStatement ps = conDB.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, end.getNome());
            ps.setString(2, end.getNomeSocial());
            ps.setDate(3, Date.valueOf(end.getDtNasc()));
            ps.setString(4, end.getCpf());
            ps.setString(5, end.getLogin());
            ps.setString(6, end.getSenha());
            ps.setInt(7, end.getIdUsuario());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                chavePrimariaGerada = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.fecharConexao();
        }

        return chavePrimariaGerada;
    }

    public ArrayList<Usuarios> listarUsuarios() { 
        Conexao con = Conexao.getConexao();
        Connection conDB = con.conectar();

        ArrayList<Usuarios> usuario = new ArrayList<Usuarios>();

        String SQL = "SELECT * FROM usuarios";

        try {
            PreparedStatement ps = conDB.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Usuarios end = new Usuarios();

                String nome = rs.getString("nome");
                String nomeSocial = rs.getString("nome_social");
                LocalDate dtNasc = rs.getDate("dt_nasc").toLocalDate();
                String cpf = rs.getString("cpf");
                Integer idUsuario = rs.getInt("id_usuario");
                String login = rs.getString("login");
                String senha = rs.getString("senha");
                Integer tipo = rs.getInt("tipo_user");

                end.setNome(nome);
                end.setNomeSocial(nomeSocial);
                end.setDtNasc(dtNasc);
                end.setCpf(cpf);
                end.setIdUsuario(idUsuario);
                end.setLogin(login);
                end.setSenha(senha);
                end.setTipoUser(tipo);

                usuario.add(end);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    public boolean atualizarUsuarios(Usuarios end) {
        String SQL = "UPDATE usuarios SET nome = ?, nome_social = ?, dt_nasc = ?, cpf = ?, login = ?, senha = ?  WHERE id_usuario = ?";

        Conexao con = Conexao.getConexao();
        Connection conDB = con.conectar();

        int retorn = 0;

        try {
            PreparedStatement ps = conDB.prepareStatement(SQL);

            ps.setString(1, end.getNomeRegistro());
            ps.setString(2, end.getNomeSocial());
            ps.setDate(3, Date.valueOf(end.getDtNasc()));
            ps.setString(4, end.getCpf());
            ps.setString(5, end.getLogin());
            ps.setString(6, end.getSenha());
            ps.setInt(7, end.getIdUsuario());

            retorn = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.fecharConexao();
        }

        return (retorn == 0 ? false : true);
    }

    public int removerUsuarios(Usuarios end) {
        String SQL = "DELETE FROM usuarios WHERE id_usuario = ?;";
        Conexao con = Conexao.getConexao();

        Connection conBD = con.conectar();

        int retorno = 0;

        try {
            PreparedStatement ps = conBD.prepareStatement(SQL);
            ps.setInt(1, end.getIdUsuario());
            retorno = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.fecharConexao();
        }

        return retorno;
    }

    public Usuarios login(Usuarios h) {
        hospAchado = null;
        for (Usuarios hosp : listarUsuarios()) {
            if (hosp.getLogin().equals(h.getLogin()) && hosp.getSenha().equals(h.getSenha())) {
                hospAchado = hosp;
                return hospAchado;
            }

        }
        return hospAchado;
    }

    public Usuarios passaLogado() {
        return hospAchado;
    }

    @Override
    public Usuarios buscarUsuariosPorCPF(int cpf) {
        // TODO Auto-generated method stub
        return null;
    }
}
