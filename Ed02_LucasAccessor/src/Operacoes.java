import javax.swing.JOptionPane;

public class Operacoes {
	static Lista<Loja> lista = new Lista<Loja>();
	
	
	//adiciona produto
	public static void cadastrar() {
		String nome, validade;
		int qntd;
		boolean found = false;
		
		validade = JOptionPane.showInputDialog("Informe o validade: ");
		nome = JOptionPane.showInputDialog("Informe o nome: ");
		qntd = 0;
		
		No<Loja> aux = lista.com;
		
		while(aux != null && found == false) {
			if(aux.dado.validade.equals(validade)) {
				found = true;
			}
			aux = aux.dir;
		}
		
		if(found == true) {
			JOptionPane.showMessageDialog(null, "Erro, conta já cadastrada");
		} else {
			Loja contaOK = new Loja(nome, validade, qntd);
			lista.inserir(contaOK);
		}
	}
	
	//vende os produtos
	public static void vender() {
		String nome;
		boolean found = false;
		double venda;
		
		nome = JOptionPane.showInputDialog("Venda de Produtos [$}---(°u°) \n Digite o nome: ");
		venda = Double.parseDouble(JOptionPane.showInputDialog("Venda de Produtos [$}---(°u°) \n Digite a quantidade da venda: "));
		Loja vendaBusca = new Loja(null, nome, 0);
		
		No<Loja> aux = lista.com;
		
		while(aux != null && found == false) {
			if(aux.dado.nome.equals(nome)) {
				found = true;
				vendaBusca = aux.dado;
				break;
			}
			aux = aux.dir;
		}
		
		if(found == false) {
			JOptionPane.showMessageDialog(null, "Não encontramos nenhum produto com este nome. \n Por favor, verifique os dados e tente novamente");
		} else if (vendaBusca.qntd < venda) {
			JOptionPane.showMessageDialog(null, "qntd insuficiente para a venda. \n A quantidade atual é de: " + vendaBusca.qntd + "\nPor favor, verifique os dados e tente novamente");
		} else {
			aux.dado.qntd -= venda;
			JOptionPane.showMessageDialog(null, "Venda realizada com sucesso! [$}---(°u°) \n A quantidade do produto restante é: " + vendaBusca.qntd);
		}
	}	
	
	//lista os produtos
	public static void listar() {
		No<Loja> aux = lista.com;
		String impressao = "";
		while(aux != null) {
			impressao += aux.dado.toString();
			aux = aux.dir;
		}
		
		JOptionPane.showMessageDialog(null, impressao);
	}
}
