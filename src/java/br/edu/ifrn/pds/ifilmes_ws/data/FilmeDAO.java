package br.edu.ifrn.pds.ifilmes_ws.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.edu.ifrn.pds.ifilmes_ws.model.Filme;

public class FilmeDAO {

    public boolean create(Filme filme) {

        boolean result = false;
        String query = "INSERT INTO filme (titulo, sinopse, duracao, ano_lancamento, avaliacao) VALUES (?,?,?,?,?);";
        Connection connection = Conexao.connect();

        try {

            PreparedStatement command = connection.prepareStatement(query);

            command.setString(1, filme.getTitulo());
            command.setString(2, filme.getSinopse());
            command.setInt(3, filme.getDuracao());
            command.setInt(4, filme.getAnoLancamento());
            command.setDouble(5, filme.getAvaliacao());

            int rowsAffected = command.executeUpdate();

            if (rowsAffected > 0) {

                result = true;

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            Conexao.disconect();

        }

        return result;

    }

    public boolean update(int idFilme, double novaAvaliacao) {

        boolean result = false;
        String query = "UPDATE filme SET avaliacao = ? WHERE id_filme = ?;";
        Connection connection = Conexao.connect();

        try {

            PreparedStatement command = connection.prepareStatement(query);

            command.setDouble(1, novaAvaliacao);
            command.setInt(2, idFilme);

            int rowsAffected = command.executeUpdate();

            if (rowsAffected > 0) {

                result = true;

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            Conexao.disconect();

        }

        return result;

    }

    public boolean delete(int idFilme) {

        boolean result = false;
        String query = "DELETE FROM filme WHERE id_filme = ?;";
        Connection connection = Conexao.connect();

        try {

            PreparedStatement command = connection.prepareStatement(query);

            command.setInt(1, idFilme);

            int rowsAffected = command.executeUpdate();

            if (rowsAffected > 0) {

                result = true;

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            Conexao.disconect();

        }

        return result;

    }

    public Filme retrieve(String titulo) {

        Filme filme = null;
        String query = "SELECT * FROM filme WHERE titulo = ?;";
        Connection connection = Conexao.connect();

        try {

            PreparedStatement command = connection.prepareStatement(query);

            command.setString(1, titulo);

            ResultSet resultSet = command.executeQuery();

            if (resultSet.next()) {

                filme = new Filme();
                filme.setId(resultSet.getInt("id_filme"));
                filme.setTitulo(resultSet.getString("titulo"));
                filme.setSinopse(resultSet.getString("sinopse"));
                filme.setDuracao(resultSet.getInt("duracao"));
                filme.setAnoLancamento(resultSet.getInt("ano_lancamento"));
                filme.setAvaliacao(resultSet.getDouble("avaliacao"));

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            Conexao.disconect();

        }

        return filme;

    }

    public Filme retrieveLatest() {

        Filme filme = null;
        String query = "SELECT * FROM filme ORDER BY id_filme DESC LIMIT 1;";
        Connection connection = Conexao.connect();

        try {

            PreparedStatement command = connection.prepareStatement(query);
            ResultSet resultSet = command.executeQuery();

            if (resultSet.next()) {

                filme = new Filme();
                filme.setId(resultSet.getInt("id_filme"));
                filme.setTitulo(resultSet.getString("titulo"));
                filme.setSinopse(resultSet.getString("sinopse"));
                filme.setDuracao(resultSet.getInt("duracao"));
                filme.setAnoLancamento(resultSet.getInt("ano_lancamento"));
                filme.setAvaliacao(resultSet.getDouble("avaliacao"));

            }

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            Conexao.disconect();

        }

        return filme;

    }

}
