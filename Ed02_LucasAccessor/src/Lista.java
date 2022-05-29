public class Lista<T> {
	No<T> com, fim;
	int tot;
	
	public void inserir(T dado) {
		No<T> aux = new No<T>(dado);
		
		//método pra inserção ordenada		
		if(com == null){//quando não possui nenhum cadastrado
			com = aux;
			fim = aux;
		} else {
			Loja comP = (Loja) com.dado;
			Loja fimP =  (Loja) fim.dado;
			Loja aux2 = (Loja) aux.dado;
			No aux3 = com;
			Loja aux4 = (Loja) aux3.dado;
			
			if(aux2.validade.after(fimP.validade)){ //a data adicionada é maior
				fim.dir = aux;
				aux.esq = fim;
				fim = aux;
			} else if (aux2.validade.before(comP.validade)) {//a data adicionada é menor
				com.esq = aux;
				aux.dir = com;
				com = aux;
			} else {
				while(aux3 != null){ //quando insere no meio
					Loja aux5 = (Loja) aux3.dir.dado;
					if (aux2.validade.compareTo(aux5.validade) <= 0 && aux2.validade.compareTo(aux4.validade) >= 0){
						aux.esq = aux3;
						aux3.dir.esq = aux;
						aux.dir = aux3.dir;
						aux3.dir = aux;
						break;
					}
					aux3 = aux3.dir;
				}
			}
		}
		tot++;
	}
	
	public No<T> pesquisar(T dado){
		No<T> aux = com;
		boolean found = false;
		while(aux != null && found == false) {
			if(aux.dado.equals(dado)) {
				found = true;
				break;
			}
			aux = aux.dir;
		}
		return aux;
	}
	
	
	public void remover(T dado) {
		No<T> aux = pesquisar(dado);
		if(aux != null) {
			if(tot == 1) { //caso tenha 1 elemento
				com = null;
				fim = null;
			} else if (aux== com) { //remove no começo
				aux.dir.esq = null;
				com = aux.dir;
				aux.dir = null;
			} else if (aux == fim) { //remove no fim
				aux.esq.dir = null;
				fim = aux.esq;
				aux.esq = null;
			} else {
				aux.esq.dir = aux.dir;
				aux.dir.esq = aux.esq;
				aux.dir = null;
				aux.esq = null;
			}
			tot --;
		}
	}
}
