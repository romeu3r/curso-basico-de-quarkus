package org.romeu3r;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @GET
    public List<Produto> buscarProdutos() {
        return Produto.listAll();
    }

    @POST
    @Transactional
    public void adicionarProdutos(CadastrarProdutoDTO dto) {
        Produto produto = new Produto();
        produto.nome = dto.nome;
        produto.preco = dto.preco;
        produto.persist();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void editarProduto(@PathParam("id") Long id, CadastrarProdutoDTO dto) {
        Optional<Produto> produtoOptional = Produto.findByIdOptional(id);
        if (produtoOptional.isEmpty())
            throw new NotFoundException();
        Produto produto = produtoOptional.get();
        produto.nome = dto.nome;
        produto.preco = dto.preco;
        produto.persist();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void deletarProduto(@PathParam("id") Long id, CadastrarProdutoDTO dto) {
        Optional<Produto> produtoOptional = Produto.findByIdOptional(id);
        if (produtoOptional.isEmpty())
            throw new NotFoundException();
        produtoOptional.get().delete();
    }
}
