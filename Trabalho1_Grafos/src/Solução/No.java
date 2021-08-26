package Solução;

import java.util.ArrayList;
import java.util.List;

public class No{

	private String nome;
	private List<No> values;
	private boolean visitado = false;
	
	public No(String n) {
		this.nome = n;
		values = new ArrayList<>();
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public List<No> getValues() {
		return values;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}
	
	
	public void addEdge(No n) {
		if(this.getValues().contains(n)) {
			throw new IllegalArgumentException("Não pode ter 2 valores com o mesmo nome");
			
		}else if(values.contains(n)) {
			throw new ArrayStoreException("A lista já possui o pais " + n.getNome());
			
		}else if(n.getValues().contains(this)){
			throw new ArrayStoreException("A lista já possui o pais " + this.getNome());

		}else{
			values.add(n);
			n.values.add(this);
		}}
	
	@Override
	public String toString() {
		return nome;
	}
	
}