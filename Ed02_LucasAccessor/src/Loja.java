import java.text.SimpleDateFormat;
import java.util.Date;

public class Loja {
	String nome;
	Date validade;
	int qntd;

	
	public Loja(String nome, Date validade, int qntd) {
		this.validade = validade;
		this.nome = nome;
		this.qntd = qntd;
	}
	
	@Override
	public boolean equals(Object obj) {
		Loja aux = (Loja) obj;
		if(aux.nome.equals(nome)) {
			return true;
		} else {
			return false;
		}	
	}
	
	@Override
	public String toString() {
		String aux = "";
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		aux += "Nome: " + nome + " | ";
		aux += "Validade: " + formato.format(validade) + " | ";
		aux += "Quantidade: " + qntd + "| \n";
		return aux;
	}

}
