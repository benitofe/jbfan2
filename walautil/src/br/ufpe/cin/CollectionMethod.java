package br.ufpe.cin;

import java.util.ArrayList;

import com.ibm.wala.types.FieldReference;

public class CollectionMethod {

	private String nome;
	private String pacote;
	private int ocorrencias;
	private int numeroVariaveisCompartilhadas;
	private String classe;
	private String concreteType;

	private boolean isSyncMethod;
	private boolean isSyncBlock;
	private boolean isLock;
	private boolean isIntoGoTo;

	private boolean insideForeach;
	private ArrayList<Integer> interationLoopSize = new ArrayList<Integer>();
	
	//Field name that calls the method;,
	private String fieldName;
	private String callMethodName;

	//TODO: method has loopblock 
	private String conditionalBlock = "";
	private int conditionalBlockN = 0;
	private int invokeLineNumber = 0;

	
	public int getConditionalBlockN() {
		return conditionalBlockN;
	}

	public void setConditionalBlockN(int conditionalBlockN) {
		this.conditionalBlockN = conditionalBlockN;
	}
	
	public String getConditionalBlock() {
		return conditionalBlock;
	}

	public void setConditionalBlock(String conditionalBlock) {
		this.conditionalBlock = conditionalBlock;
	}

	public boolean isSyncMethod() {
		return isSyncMethod;
	}

	public boolean isInsideForeach() {
		return insideForeach;
	}

	public void setInsideForeach(boolean insideForeach) {
		this.insideForeach = insideForeach;
	}

	public ArrayList<Integer> getInterationLoopSize() {
		return interationLoopSize;
	}

	public void setSyncMethod(boolean isSyncMethod) {
		this.isSyncMethod = isSyncMethod;
	}

	public boolean isSyncBlock() {
		return isSyncBlock;
	}

	public void setSyncBlock(boolean isSyncBlock) {
		this.isSyncBlock = isSyncBlock;
	}

	public boolean isLock() {
		return isLock;
	}

	public void setLock(boolean isLock) {
		this.isLock = isLock;
	}

	public int getNumeroVariaveisCompartilhadas() {
		return numeroVariaveisCompartilhadas;
	}

	public void setNumeroVariaveisCompartilhadas(int numeroVariaveisCompartilhadas) {
		this.numeroVariaveisCompartilhadas = numeroVariaveisCompartilhadas;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPacote() {
		return pacote;
	}

	public void setPacote(String pacote) {
		this.pacote = pacote;
	}

	public int getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(int ocorrencias) {
		this.ocorrencias = ocorrencias;
	}

	public void incrementarOcorrencias() {
		this.ocorrencias++;
	}

	public void incrementarVariaveisCompartilhadas() {
		this.numeroVariaveisCompartilhadas++;
	}

	@Override
	public String toString() {
		return "Metodo: " + this.getNome() + " Pacote: " + this.getPacote() + " Ocorrencias: " + this.getOcorrencias()
				+ " Numero Variaveis Compartilhadas: " + this.getNumeroVariaveisCompartilhadas();
	}

	public boolean equals(CollectionMethod metodo) {
		if (this.getNome().equals(metodo.getNome()) && this.getInvokeLineNumber() == metodo.getInvokeLineNumber() && this.isIntoGoTo() == metodo.isIntoGoTo() 
				//&& this.getConditionalBlock().equals(metodo.getConditionalBlock())
				&& this.getClasse().equals(metodo.getClasse()) && this.getConcreteType().equals(metodo.getConcreteType())
				&& this.getPacote().equals(metodo.getPacote()) 
				&& this.getCallMethodName().equals(metodo.getCallMethodName()) 
				&& this.getFieldName().equals(metodo.getFieldName())) { return true; }
		return false;
	}

	public boolean equalsLight(CollectionMethod metodo) {
		if (this.getNome().equals(metodo.getNome()) && this.getPacote().equals(metodo.getPacote())) { return true; }
		return false;
	}

	public boolean isIntoGoTo() {
		return isIntoGoTo;
	}

	public void setIntoGoTo(boolean isIntoGoTo) {
		this.isIntoGoTo = isIntoGoTo;
	}

	public String getConcreteType() {
		return concreteType;
	}

	public void setConcreteType(String concreteType) {
		this.concreteType = concreteType;
	}

	public void setInvokeLineNumber(int invokeLineNumber) {
		this.invokeLineNumber = invokeLineNumber;		
	}

	public int getInvokeLineNumber() {
		return invokeLineNumber;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getCallMethodName() {
		return callMethodName;
	}

	public void setCallMethodName(String callMethodName) {
		this.callMethodName = callMethodName;
	}

}
