package ifpr.pgua.eic.tads.contatos.controllers;
import java.util.List;
import com.github.hugoperlin.results.Resultado;
import ifpr.pgua.eic.tads.contatos.model.Tarefa;
import ifpr.pgua.eic.tads.contatos.model.repositories.TarefaRepository;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class ListTarefaController {
    
    TarefaRepository repository;

    public ListTarefaController(TarefaRepository repository) {
        this.repository = repository;
    }

        public Handler get = (Context ctx)->{
            String html="<html><head><meta charset=\"UTF-8\"></head><body><h1>Lista de Contatos</h1><ul>";
            Resultado<List<Tarefa>> resultado = repository.getTarefas();
            
            if(resultado.foiErro()){
                html += "<h1>"+resultado.getMsg()+"</h1>";
            }else{
                List<Tarefa> tarefas = resultado.comoSucesso().getObj();
                for(Tarefa tarefa:tarefas){
                    html+="<li>"+tarefa.toString()+"</li>";
                }
            }
    
            html+="</ul><a href=\"/\">Voltar</a></body></html>";
            ctx.html(html);
        };
    }
