import java.util.Date;
import java.util.*;
import java.text.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Operacoes {
	static Lista<Loja> lista = new Lista<Loja>();
	
	
	//adiciona produto
	public static void cadastrar() {
		String nome, dataString;
		int qntd;
		boolean found = false;
		Date validade = new Date();
		
		nome = JOptionPane.showInputDialog("Informe o nome: ");
		//formatador da pagina de data
		  JTextField dia = new JTextField(2);
	      JTextField mes = new JTextField(2);
	      JTextField ano = new JTextField(4);
	      
	      JPanel myPanel = new JPanel();
	      myPanel.add(new JLabel("dia[XX]:"));
	      myPanel.add(dia);
	      myPanel.add(new JLabel("mes[XX]:"));
	      myPanel.add(mes);
	      myPanel.add(new JLabel("ano[XXXX]:"));
	      myPanel.add(ano);

	      int result = JOptionPane.showConfirmDialog(null, myPanel, 
	               "Informe a validade", JOptionPane.OK_CANCEL_OPTION);
	      if (result == JOptionPane.OK_OPTION) {
	    	  SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy");
	    	  dataString = dia.getText().toString() + mes.getText().toString() + ano.getText().toString();
	    	  //System.out.println(dataString);
	    	  try {
				validade = formato.parse(dataString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      }
	      
		qntd = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade: "));
		
		No<Loja> aux = lista.com;
		
		while(aux != null && found == false) {
			if(aux.dado.nome.equals(nome)) {
				found = true;
			}
			aux = aux.dir;
		}
		
		if(found == true) {
			JOptionPane.showMessageDialog(null, "Erro, produto já cadastrado");
		} else {
			Loja produtoOK = new Loja(nome, validade, qntd);
			lista.inserir(produtoOK);
		}
	}
	
	//vende os produtos
	public static void vender() {
		String nome;
		boolean found = false;
		int venda;
		
		nome = JOptionPane.showInputDialog("Venda de Produtos [$}---(°u°) \n Digite o nome: ");
		venda = Integer.parseInt(JOptionPane.showInputDialog("Venda de Produtos [$}---(°u°) \n Digite a quantidade da venda: "));
		Loja vendaBusca = new Loja(nome.toLowerCase(), null, 0);
		
		No<Loja> aux = lista.com;
		
		while(aux != null && found == false) {
			if(aux.dado.nome.equals(nome.toLowerCase())) {
				found = true;
				vendaBusca = aux.dado;
				break;
			}
			aux = aux.dir;
		}
		
		if(found == false) {
			JOptionPane.showMessageDialog(null, "Não encontramos nenhum produto com este nome. \n Por favor, verifique os dados e tente novamente");
		} else if (vendaBusca.qntd < venda) {
			JOptionPane.showMessageDialog(null, "Quantidade insuficiente para a venda. \n A quantidade atual é de: " + vendaBusca.qntd + "\nPor favor, verifique os dados e tente novamente");
		} else {
			aux.dado.qntd -= venda;
			if(aux.dado.qntd == 0) {
				lista.remover(aux.dado);
				JOptionPane.showMessageDialog(null, "Venda realizada com sucesso! [$}---(°u°) \n O produto teve seu estoque zerado D: \n Removendo do Sistema...");
			}else {
				JOptionPane.showMessageDialog(null, "Venda realizada com sucesso! [$}---(°u°) \n A quantidade do produto restante é: " + vendaBusca.qntd);
			}
		}
	}	
	
	//lista os produtos
	public static void listar() {
		No<Loja> aux = lista.com;		
		String impressao = "";
		if(aux == null) {
			impressao = "Não possui nenhum item cadastrado  ):";
		}
		while(aux != null) {
			impressao += aux.dado.toString();
			aux = aux.dir;
		}
		
		JOptionPane.showMessageDialog(null, impressao);
	}
}
