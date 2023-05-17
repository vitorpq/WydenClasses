<?php
// Abrir uma conexão com o banco de dados SQLite

try {
	//$senha = 'minha_senha';
	//$db = new SQLite3('clientes.db', SQLITE3_OPEN_READWRITE | SQLITE3_OPEN_CREATE, $senha);

	$db = new SQLite3('clientes.db');
	// Criar uma tabela chamada "usuarios"
	$db->exec('CREATE TABLE IF NOT EXISTS usuarios (id INTEGER PRIMARY KEY, nome TEXT, email TEXT)');

	// Inserir alguns dados na tabela
	$db->exec("INSERT INTO usuarios (nome, email) VALUES ('João', 'joao@example.com')");
	$db->exec("INSERT INTO usuarios (nome, email) VALUES ('Maria', 'maria@example.com')");

	// Selecionar todos os usuários da tabela
	$result = $db->query('SELECT * FROM usuarios');
	while ($row = $result->fetchArray()) {
		echo "ID: " . $row['id'] . ", Nome: " . $row['nome'] . ", Email: " . $row['email'] . "<br>";
	}

	// Fechar a conexão com o banco de dados
	$db->close();
} catch (SQLite3Exception $e) {
    echo 'Ocorreu um erro ao executar a consulta: ' . $e->getMessage();
}



?>
