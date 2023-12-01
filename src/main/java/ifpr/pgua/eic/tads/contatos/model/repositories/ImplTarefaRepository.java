package ifpr.pgua.eic.tads.contatos.model.repositories;
import java.util.List;
import com.github.hugoperlin.results.Resultado;
import ifpr.pgua.eic.tads.contatos.model.Tarefa;
import ifpr.pgua.eic.tads.contatos.model.daos.TarefaDAO;

public class ImplTarefaRepository implements TarefaRepository {

    private TarefaDAO dao;

    public ImplTarefaRepository(TarefaDAO dao) {
        this.dao = dao;
    }

    @Override
    public Resultado<Tarefa> cadastrarTarefa(String titulo, String descricao) {
        if (titulo.isBlank() || titulo.isEmpty()) {
            return Resultado.erro("Titulo inválido!");
        }

        if (descricao.isBlank() || descricao.isEmpty()) {
            return Resultado.erro("Descrição inválida!");
        }

        Tarefa tarefa = new Tarefa(titulo, descricao);
        
        return dao.cadastrarTarefa(tarefa);
    }

    @Override
    public Resultado<List<Tarefa>> getTarefas() {
       return dao.getTarefas();
    }

}

   