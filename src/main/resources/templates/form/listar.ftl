<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Listagem de Usuários</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background: #f4f4f4; }
        .container { max-width: 900px; margin: 0 auto; background: white; padding: 24px; border-radius: 8px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
        th { background: #f0f0f0; }
        a { text-decoration: none; color: #1f6feb; }
        .menu a { margin-right: 12px; }
        .mensagem { margin-top: 16px; padding: 12px; background: #e7f7e7; color: #145214; border-radius: 4px; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Usuários cadastrados</h1>

        <div class="menu">
            <a href="/cadastro">Cadastrar</a>
            <a href="/listar-usuarios">Listar usuários</a>
            <a href="/excluir-usuario">Excluir usuários</a>
        </div>

        <#if mensagem??>
            <div class="mensagem">${mensagem}</div>
        </#if>

        <table>
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Login</th>
                    <th>Sexo</th>
                    <th>Ação</th>
                </tr>
            </thead>
            <tbody>
                <#list usuarios as usuario>
                    <tr>
                        <td>${usuario.codigo}</td>
                        <td>${usuario.login}</td>
                        <td>${usuario.sexo}</td>
                        <td><a href="/editar-usuario?codigo=${usuario.codigo}">Editar</a></td>
                    </tr>
                </#list>
            </tbody>
        </table>
    </div>
</body>
</html>
