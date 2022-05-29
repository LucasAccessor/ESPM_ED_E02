import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		//FEITO POR LUCAS ACCESSOR 177350 (:

		int sel = 0;
		
		do {
			sel = Integer.parseInt(JOptionPane.showInputDialog(menu()));
			if (sel < 1 || sel > 6) {
				JOptionPane.showMessageDialog(null, "Opção inválida ):");
			} else {
				switch(sel) {
				case 1: // Cadastrar Produto
					Operacoes.cadastrar();
					break;
				case 2: //Listar Produtos
					Operacoes.listar();
					break;
				case 3: // Vender Produto
					Operacoes.vender();
					break;
				case 4: // fim
					break;
				}
			}
			
		} while (sel != 4);
		
		
	}

	
	//menu de opções 
	public static String menu() {
		String mensagemMenu = "Banquinha de Produtos |*L*| \n";
		mensagemMenu += "Escolha um opção: \n";
		mensagemMenu += "1. Cadastrar Produto \n";
		mensagemMenu += "2. Listar Produtos \n";
		mensagemMenu += "3. Vender Produto \n";
		mensagemMenu += "4. Encerrar a Aplicação \n";
		return mensagemMenu;
	}
	
		
}


