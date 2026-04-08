package exercicio3.app;
import exercicio3.service.UsuarioService;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

import java.util.HashMap;
import java.util.TimeZone;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class Aplicacao {
    public static void main(String[] args) {
        port(4567);
        staticFiles.location("/public");

        Configuration freeMarkerConfig = new Configuration(Configuration.VERSION_2_3_26);
        freeMarkerConfig.setClassForTemplateLoading(Aplicacao.class, "/templates");
        freeMarkerConfig.setDefaultEncoding("UTF-8");
        freeMarkerConfig.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        freeMarkerConfig.setLogTemplateExceptions(false);
        freeMarkerConfig.setSQLDateAndTimeTimeZone(TimeZone.getDefault());

        FreeMarkerEngine engine = new FreeMarkerEngine(freeMarkerConfig);
        UsuarioService usuarioService = new UsuarioService();

        get("/", (request, response) -> {
            response.redirect("/cadastro");
            return null;
        });

        get("/cadastro", (request, response) -> new ModelAndView(new HashMap<>(), "form/index.ftl"), engine);

        post("/cadastro", (request, response) -> {
            usuarioService.criarUsuario(request, response);
            HashMap<String, Object> model = new HashMap<>();
            model.put("mensagem", "Usuário cadastrado com sucesso.");
            return new ModelAndView(model, "form/index.ftl");
        }, engine);

        get("/listar-usuarios", usuarioService::listarUsuarios, engine);
        get("/excluir-usuario", usuarioService::telaExcluirUsuario, engine);
        post("/excluir-usuario", usuarioService::excluirUsuario, engine);
        get("/editar-usuario", usuarioService::telaEditarUsuario, engine);
        post("/editar-usuario", usuarioService::atualizarUsuario, engine);
    }
}
