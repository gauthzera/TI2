<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Editar Usuário</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background: #f4f4f4; }
        .container { max-width: 700px; margin: 0 auto; background: white; padding: 24px; border-radius: 8px; }
        label { display: block; margin-top: 12px; font-weight: bold; }
        input, select { width: 100%; padding: 10px; margin-top: 6px; box-sizing: border-box; }
        button { margin-top: 18px; padding: 10px 16px; border: none; background: #1f6feb; color: white; border-radius: 4px; cursor: pointer; }
        .menu a { margin-right: 12px; text-decoration: none; color: #1f6feb; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Editar usuário</h1>

        <div class="menu">
            <a href="/cadastro">Cadastrar</a>
            <a href="/listar-usuarios">Listar usuários</a>
            <a href="/excluir-usuario">Excluir usuários</a>
        </div>

        <form action="/editar-usuario" method="post">
            <label for="codigo">Código</label>
            <input type="number" id="codigo" name="codigo" value="${usuario.codigo}" readonly>

            <label for="login">Login</label>
            <input type="text" id="login" name="login" value="${usuario.login}" required>

            <label for="senha">Senha</label>
            <input type="text" id="senha" name="senha" value="${usuario.senha}" required>

            <label for="sexo">Sexo</label>
            <select id="sexo" name="sexo" required>
                <option value="M" <#if usuario.sexo == 'M'>selected</#if>>Masculino</option>
                <option value="F" <#if usuario.sexo == 'F'>selected</#if>>Feminino</option>
            </select>

            <button type="submit">Salvar alterações</button>
        </form>
    </div>
</body>
</html>
