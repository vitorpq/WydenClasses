<!DOCTYPE HTML>
<html>
	<head>
	
	</head>
	<body>
		1. <?php echo 'Se quiser servir código PHP em documentos XHTML ou XML,
						use essas tags'; ?>
		<br>
		2. A tag echo curta <?= 'imprima essa string' ?> também pode ser usada.
		Ela é equivalente a <?php echo 'imprima essa string' ?>.
		<br>
		<h3>Short open tag</h3>
		3. <? echo 'Este código está entre tags curtas, mas só funcionará '.
		'se a diretiva short_open_tag estiver habilitada'; ?>
		<p>Se não apareceu o texto acima é pq a diretiva short_open_tag não 
		está configurada.</p>
		
		<h1>Escape avançado</h1>
		<?php $expression =  true; ?>
		<?php if ($expression == true): ?>
			Isso irá aparecer se a expressão for verdadeira.
		<?php else: ?>
		Senão isso irá aparecer.
		<?php endif; ?>
		
		<h1>Comentários</h1>
		<ul>
			<li>#</li>
			<li>//</li>
			<li>/* */</li>
		</ul>
		
		<h1>Tipos</h1>
			<ul>
				<li>null</li>
				<li>bool</li>
				<li>int</li>
				<li>float (número de ponto flutuante)</li>
				<li>string</li>
				<li>array</li>
				<li>object</li>
				<li>callable</li>
				<li>resource</li>
				
			</ul>
			
			<p>Para verificar o valor e tipo de uma expressão, utilize a funçãovar_dump().
			Para extrair o tipo de uma expressão, utilize a funçãoget_debug_type().
			Para apenas validar se uma expressão é de um certo tipo, utilize as funções is_type.</p>
			<?php
				$a_bool = true;   // um valor boleano
				$a_str  = "foo";  // um texto
				$a_str2 = 'foo';  // um texto
				$an_int = 12;     // um inteiro

				echo get_debug_type($a_bool), "\n";
				echo get_debug_type($a_str), "\n";

				// Se essa variável conter um inteiro, aumento o número por quatro
				if (is_int($an_int)) {
					$an_int += 4;
				}
				var_dump($an_int);

				// Se $a_bool for um texto, imprima
				if (is_string($a_bool)) {
					echo "String: $a_bool";
					}
			?>
		<h1>Strings</h1>
		<dl>
			<dt>Aspas Simples</dt>
				<dd>A maneira mais simples de se especificar uma string. Para especificar um apóstrofo, escape-o com uma contra barra (\). Para especificar uma contra barra literal, dobre-a (\\). Todas as outras ocorrências da contra barra serão tratadas como uma contra 
				barra literal: isso significa que outras sequências de escape que se esteja acostumado a utilizar, como \r ou \n, 
				serão literalmente impressas em vez de ter qualquer significado especial.</dd>
			<dt>Aspas duplas</dt>
				<dd>Se a string for delimitada entre aspas duplas ("), o PHP interpretará a seguinte sequência de escape como caracteres especiais.</dd>
				<dd>O recurso mais importante de strings delimitadas por aspas duplas é o fato de que nomes de variáveis serão expandidos.</dd>
		</dl>
		<h2>Interpretação de Variáveis</h2>
		
		Quando uma string é especificada dentro de aspas duplas ou heredoc, as variáveis são interpretadas dentro delas.

		Há dois tipos de sintaxe: uma simples e uma complexa. A sintaxe simples é a mais comum e conveniente. Provê uma maneira de interpretar uma variável, o valor de um array ou uma propriedade de objeto em uma string com o mínimo de esforço.

		<p>A sintaxe complexa pode ser reconhecida pelas chaves envolvendo a expressão.</p>

		<h3>Sintaxe Simples</h3>
		
			<?php
			$suco = "maçã";

			echo "Ele bebeu um pouco de suco de $suco."."<br>";
			//Inválido. "s" é um caractere válido para um nome de variável, mas a variável é $suco.
			echo "Ele bebeu um suco feito de $sucos.<br>";
			// Válido. Especifique explicitamente o final do nome da variável colocando-o entre colchetes:
			echo "Ele bebeu um pouco de suco feito de ${suco}s.<br>";
			?>
			<?php
				$sucos = array("maçã", "laranja", "koolaid1" => "roxo");

				echo "Ele bebeu um pouco de suco $sucos[0]<br>";
				echo "Ele bebeu um pouco de suco $sucos[1].<br>";
				echo "Ele bebeu um pouco de suco $sucos[koolaid1].<br>";
			?>
			<h1>Arrays</h1>
</body>
</html>	
