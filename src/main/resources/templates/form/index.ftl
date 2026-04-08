<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Usuários</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background: #f4f4f4; }
        .container { max-width: 700px; margin: 0 auto; background: white; padding: 24px; border-radius: 8px; }
        h1 { margin-top: 0; }
        label { display: block; margin-top: 12px; font-weight: bold; }
        input, select { width: 100%; padding: 10px; margin-top: 6px; box-sizing: border-box; }
        button { margin-top: 18px; padding: 10px 16px; border: none; background: #1f6feb; color: white; border-radius: 4px; cursor: pointer; }
        button:hover { background: #1557b0; }
        .menu a { margin-right: 12px; text-decoration: none; color: #1f6feb; }
        .mensagem { margin-top: 16px; padding: 12px; background: #e7f7e7; color: #145214; border-radius: 4px; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Cadastro de Usuários</h1>

        <div class="menu">
            <a href="/cadastro">Cadastrar</a>
            <a href="/listar-usuarios">Listar usuários</a>
            <a href="/excluir-usuario">Excluir usuários</a>
        </div>

        <#if mensagem??>
            <div class="mensagem">${mensagem}</div>
        </#if>

        <form action="/cadastro" method="post">
            <label for="codigo">Código</label>
            <input type="number" id="codigo" name="codigo" required>

            <label for="login">Login</label>
            <input type="text" id="login" name="login" required>

            <label for="senha">Senha</label>
            <input type="password" id="senha" name="senha" required>

            <label for="sexo">Sexo</label>
            <select id="sexo" name="sexo" required>
                <option value="">Selecione</option>
                <option value="M">Masculino</option>
                <option value="F">Feminino</option>
            </select>

            <button type="submit">Cadastrar</button>
        </form>
    </div>
</body>
</html>
