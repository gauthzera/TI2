package exercicio3.service;
import exercicio3.dao.UsuarioDAO;
import exercicio3.model.Usuario;


import java.util.HashMap;
import java.util.Map;

import exercicio3.dao.UsuarioDAO;
import exercicio3.model.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class UsuarioService {
    private UsuarioDAO dao;

    public UsuarioService() {
        this.dao = new UsuarioDAO();
    }

    public void criarUsuario(Request req, Response res) {
        int codigo = Integer.parseInt(req.queryParams("codigo"));
        String login = req.queryParams("login");
        char sexo = req.queryParams("sexo").charAt(0);
        String senha = req.queryParams("senha");

        Usuario usuario = new Usuario(codigo, login, sexo, senha);
        dao.inserirUsuario(usuario);
    }

    public ModelAndView listarUsuarios(Request req, Response res) {
        Map<String, Object> model = new HashMap<>();
        model.put("usuarios", dao.getUsuarios());
        return new ModelAndView(model, "form/listar.ftl");
    }

    public ModelAndView telaExcluirUsuario(Request req, Response res) {
        Map<String, Object> model = new HashMap<>();
        model.put("usuarios", dao.getUsuarios());
        return new ModelAndView(model, "form/excluir.ftl");
    }

    public ModelAndView excluirUsuario(Request req, Response res) {
        String[] idsParaExcluir = req.queryParamsValues("idsExcluir");

        if (idsParaExcluir != null) {
            for (String idStr : idsParaExcluir) {
                int codigo = Integer.parseInt(idStr);
                dao.excluirUsuario(codigo);
            }
        }

        Map<String, Object> model = new HashMap<>();
        model.put("usuarios", dao.getUsuarios());
        model.put("mensagem", "Usuário(s) excluído(s) com sucesso.");
        return new ModelAndView(model, "form/excluir.ftl");
    }

    public ModelAndView telaEditarUsuario(Request req, Response res) {
        int codigo = Integer.parseInt(req.queryParams("codigo"));
        Usuario usuario = dao.getUsuarioPorCodigo(codigo);

        Map<String, Object> model = new HashMap<>();
        model.put("usuario", usuario);
        return new ModelAndView(model, "form/editar.ftl");
    }

    public ModelAndView atualizarUsuario(Request req, Response res) {
        int codigo = Integer.parseInt(req.queryParams("codigo"));
        String login = req.queryParams("login");
        char sexo = req.queryParams("sexo").charAt(0);
        String senha = req.queryParams("senha");

        Usuario usuario = new Usuario(codigo, login, sexo, senha);
        dao.atualizarUsuario(usuario);

        Map<String, Object> model = new HashMap<>();
        model.put("usuarios", dao.getUsuarios());
        model.put("mensagem", "Usuário atualizado com sucesso.");
        return new ModelAndView(model, "form/listar.ftl");
    }
}
