public class Lista<T> {
	No<T> com, fim;
	int tot;
	
	public void inserir(T dado) {
		No<T> aux = new No<T>(dado);
		if(tot == 0) {
			com = aux;
		} else {
			aux.esq = fim;
			fim.dir = aux;
		}
		fim = aux;
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
