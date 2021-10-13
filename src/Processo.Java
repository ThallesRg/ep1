public class processo {

public enum Estado {
		
		PRONTO,
		EM_EXECUÇÃO,
		BLOQUEADO
	}

    public Estado estado;
    String nome;
    String instrução[];


    	public Processo(String nome, String[] instrucao, Estados estado) {
		this.setEstado(estado);
		this.instrucao = instrucao;
		this.nome = nome;
	}
    
}