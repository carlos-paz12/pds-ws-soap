package br.edu.ifrn.pds.ifilmes_ws.services;

import br.edu.ifrn.pds.ifilmes_ws.data.FilmeDAO;
import br.edu.ifrn.pds.ifilmes_ws.model.Filme;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "IFilmesWS")
public class IFilmesWS {

    @WebMethod(operationName = "create")
    public boolean create(@WebParam(name = "filme") Filme filme) {
        System.out.println("Executando método create()...");
        FilmeDAO filmeDAO = new FilmeDAO();
        return filmeDAO.create(filme);
    }

    @WebMethod(operationName = "update")
    public boolean update(@WebParam(name = "idFIlme") int idFilme, @WebParam(name = "novaAvaliacao") double novaAvaliacao) {
        System.out.println("Executando método update()...");
        FilmeDAO filmeDAO = new FilmeDAO();
        return filmeDAO.update(idFilme, novaAvaliacao);
    }

    @WebMethod(operationName = "delete")
    public boolean delete(@WebParam(name = "idFilme") int idFilme) {
        System.out.println("Executando método delete()...");
        FilmeDAO filmeDAO = new FilmeDAO();
        return filmeDAO.delete(idFilme);
    }

    @WebMethod(operationName = "retrieve")
    public Filme retrieve(@WebParam(name = "titulo") String titulo) {
        System.out.println("Executando método retrieve()...");
        FilmeDAO filmeDAO = new FilmeDAO();
        return filmeDAO.retrieve(titulo);
    }

    @WebMethod(operationName = "retrieveLatest")
    public Filme retrieveLatest() {
        System.out.println("Executando método retrieveLatest()...");
        FilmeDAO filmeDAO = new FilmeDAO();
        return filmeDAO.retrieveLatest();
    }

}
