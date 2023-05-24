<?php
	
if ($_POST["password1"] == $_POST["password2"])	{
	$db = new SQLite3('usuarios.db');
	// Criar uma tabela chamada "usuarios"
	$db->exec('CREATE TABLE IF NOT EXISTS dados (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, email TEXT NOT NULL, senha TEXT NOT NULL)');

	// Inserir alguns dados na tabela
	$db->exec("INSERT INTO dados (nome, email, senha) 
		VALUES ('$_POST[user_name]', '$_POST[email]', '$_POST[password1]')");
	$db->close();
	header('Location:index.php?status=1');
}
else {
	header('Location:index.php?status=1');
}
?>
