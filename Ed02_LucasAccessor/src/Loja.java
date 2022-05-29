
public class Loja {
	String nome, validade;
	int qntd;

	
	public Loja(String nome, String validade, int qntd) {
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
		aux += "Nome: " + nome + "\n";
		aux += "Validade: " + validade + "\n";
		aux += "Quantidade: " + qntd + "\n";
		return aux;
	}

}
