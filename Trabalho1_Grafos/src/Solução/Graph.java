package Solução;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private List<No> paises = new ArrayList<No>();
	
	public Graph() {
		No AC = new No("AC");
		No AM = new No("AM");
		No RO = new No("RO");
		No MT = new No("MT");
		No RR = new No("RR");
		No PA = new No("PA");
		No AP = new No("AP");
		No MA = new No("MA");
		No PI = new No("PI");
		No CE = new No("CE");
		No RN = new No("RN");
		No PB = new No("PB");
		No PE = new No("PE");
		No TO = new No("TO");
		No BA = new No("BA");
		No AL = new No("AL");
		No SE = new No("SE");
		No GO = new No("GO");
		No DF = new No("DF");
		No MG = new No("MG");
		No ES = new No("ES");
		No MS = new No("MS");
		No SP = new No("SP");
		No PR = new No("PR");
		No RJ = new No("RJ");
		No SC = new No("SC");
		No RS = new No("RS");
		
		paises.add(AC);
		paises.add(AM);
		paises.add(RO);
		paises.add(MT);
		paises.add(RR);
		paises.add(PA);
		paises.add(AP);
		paises.add(MA);
		paises.add(PI);
		paises.add(CE);
		paises.add(RN);
		paises.add(PB);
		paises.add(PE);
		paises.add(TO);
		paises.add(BA);
		paises.add(AL);
		paises.add(SE);
		paises.add(GO);
		paises.add(DF);
		paises.add(MG);
		paises.add(ES);
		paises.add(MS);
		paises.add(SP);
		paises.add(PR);
		paises.add(RJ);
		paises.add(SC);
		paises.add(RS);
		
		
		AM.addEdge(RR);
		AM.addEdge(AC);
		AM.addEdge(RO);
		AM.addEdge(MT);
		AM.addEdge(PA);

		RR.addEdge(PA);

		AC.addEdge(RO);

		RO.addEdge(MT);

		MT.addEdge(PA);
		MT.addEdge(TO);
		MT.addEdge(GO);

		PA.addEdge(MA);
		PA.addEdge(AP);
		PA.addEdge(TO);

		TO.addEdge(GO);
		TO.addEdge(PI);
		TO.addEdge(MA);
		TO.addEdge(BA);

		GO.addEdge(MG);
		GO.addEdge(MS);
		GO.addEdge(BA);
		GO.addEdge(DF);

		MG.addEdge(ES);
		MG.addEdge(BA);
		MG.addEdge(DF);
		MG.addEdge(MS);
		MG.addEdge(SP);
		MG.addEdge(RJ);

		ES.addEdge(BA);
	
		RJ.addEdge(SP);
		RJ.addEdge(ES);

		SP.addEdge(MS);
		SP.addEdge(PR);

		PR.addEdge(MS);
		PR.addEdge(SC);

		SC.addEdge(RS);

		PI.addEdge(MA);
		PI.addEdge(CE);
		PI.addEdge(PE);
		PI.addEdge(BA);

		CE.addEdge(RN);
		CE.addEdge(PB);
		CE.addEdge(PE);

		RN.addEdge(PB);
		
		PB.addEdge(PE);

		PE.addEdge(AL);
		SE.addEdge(AL);
		
		BA.addEdge(PE);
		BA.addEdge(SE);
		BA.addEdge(AL);
	}
	
	
	public void run() {
		int total = MaisPaises();
		MenosPaises();
		Densidade();
		Frequencia_Grau(total);
	}
	
	
	private int MaisPaises() {
		No aux = paises.get(0);
		
		for(No n : paises) {
			if(n.getValues().size() >aux.getValues().size()) {
				aux = n;
			}}
		
		System.out.println("Estado com Mais Vizinhos");
		System.out.println(aux.getNome() + " -> " + aux.getValues().toString() + "\n");
		
		return aux.getValues().size();
	}
	
	
	private int MenosPaises() {
		No aux = paises.get(0);
		
		for(No n : paises) {
			if(n.getValues().size() < aux.getValues().size()) {
				aux = n;
			}}
		
		System.out.println("Estado com Menos Vizinhos");
		System.out.println(aux.getNome() + " -> " + aux.getValues().toString() + "\n");
		
		return aux.getValues().size();
	}
	
	
	private void Densidade() {
		float edges = 0;
		
		for(No n : paises) {
			n.setVisitado(true);
			
			for(No x : n.getValues()) {
				if(x.isVisitado() == false) {
					edges++;
				}}}
		
		float vertex = paises.size(); 
		System.out.println("Vertices: " + vertex + "\nArestas: " + edges);
		System.out.println("Densidade: " + (edges/vertex) + "\n");
	}
	
	
	private int Quantidade_Paises_Aresta(int total) {
		int cont = 0;

		for (No n : paises) {
			if (n.getValues().size() == total) {
				cont++;
			}}

		return cont;
	}
	
	
	private void Frequencia_Grau(int total) {
		System.out.println("Grau - Quantidade");
		for (int x = 1; x <= total; x++) {
			System.out.println(" " + x + "   -    " + Quantidade_Paises_Aresta(x));
		}}
	
}