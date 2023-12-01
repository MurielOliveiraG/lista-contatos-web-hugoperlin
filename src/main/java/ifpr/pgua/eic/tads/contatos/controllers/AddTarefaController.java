package ifpr.pgua.eic.tads.contatos.controllers;
import com.github.hugoperlin.results.Resultado;
import ifpr.pgua.eic.tads.contatos.model.Tarefa;
import ifpr.pgua.eic.tads.contatos.model.repositories.TarefaRepository;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class AddTarefaController {
    
    private TarefaRepository repository;

    public AddTarefaController(TarefaRepository repository) {
        this.repository = repository;
    }

    public Handler get = (Context ctx)->{
        ctx.render("templates/addTarefa.html");
    };

    public Handler post = (Context ctx)->{
        String titulo = ctx.formParam("titulo");
        String descricao = ctx.formParam("descricao");

        Resultado<Tarefa> resultado = repository.cadastrarTarefa(titulo, descricao);
        
        ctx.html(resultado.getMsg()+"<br/><a href=\"/\">Voltar</a>");
    };
}
