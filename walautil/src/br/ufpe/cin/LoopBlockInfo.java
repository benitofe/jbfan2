package br.ufpe.cin;

import java.util.List;
import java.util.Set;

import com.ibm.wala.ssa.IR;
import com.ibm.wala.ssa.ISSABasicBlock;
import com.ibm.wala.ssa.SymbolTable;
import com.ibm.wala.ssa.SSACFG.BasicBlock;
import com.ibm.wala.ssa.SSAInstruction;

public class LoopBlockInfo {
	
	private BasicBlock loopHeader;
	private Set<ISSABasicBlock> loopBody;
	private List<ISSABasicBlock> loopTails;
	private ISSABasicBlock loopConditionalBlock;
	private boolean isDoWhileLoop;
	private boolean explicitlyInfiniteLoop;
	private IR ir;
	
	public LoopBlockInfo(BasicBlock loopHeader, Set<ISSABasicBlock> loopBody,
			List<ISSABasicBlock> loopTails,
			ISSABasicBlock loopConditionalBlock, boolean isDoWhileLoop,
			boolean explicitlyInfiniteLoop, IR ir) {
		super();
		this.loopHeader = loopHeader;
		this.loopBody = loopBody;
		this.loopTails = loopTails;
		this.loopConditionalBlock = loopConditionalBlock;
		this.isDoWhileLoop = isDoWhileLoop;
		this.explicitlyInfiniteLoop = explicitlyInfiniteLoop;
		this.ir = ir;
	}

	public BasicBlock getLoopHeader() {
		return loopHeader;
	}

	public void setLoopHeader(BasicBlock loopHeader) {
		this.loopHeader = loopHeader;
	}

	public Set<ISSABasicBlock> getLoopBody() {
		return loopBody;
	}

	public void setLoopBody(Set<ISSABasicBlock> loopBody) {
		this.loopBody = loopBody;
	}

	public List<ISSABasicBlock> getLoopTails() {
		return loopTails;
	}

	public void setLoopTails(List<ISSABasicBlock> loopTails) {
		this.loopTails = loopTails;
	}

	public ISSABasicBlock getLoopConditionalBlock() {
		return loopConditionalBlock;
	}

	public void setLoopConditionalBlock(ISSABasicBlock loopConditionalBlock) {
		this.loopConditionalBlock = loopConditionalBlock;
	}

	public boolean isDoWhileLoop() {
		return isDoWhileLoop;
	}

	public void setDoWhileLoop(boolean isDoWhileLoop) {
		this.isDoWhileLoop = isDoWhileLoop;
	}

	public boolean isExplicitlyInfiniteLoop() {
		return explicitlyInfiniteLoop;
	}

	public void setExplicitlyInfiniteLoop(boolean explicitlyInfiniteLoop) {
		this.explicitlyInfiniteLoop = explicitlyInfiniteLoop;
	}
	
	public int getconditionalBranchInterationNumber() {

		int nConditional = 0;

		if(loopConditionalBlock != null){
		
			SymbolTable symbolTable = ir.getSymbolTable();
			
			SSAInstruction conditionalInstruntion = loopConditionalBlock.getLastInstruction();
			
			conditionalInstruntion.toString(symbolTable);
			System.out.println(conditionalInstruntion.toString(symbolTable));
	
			String val2Use = symbolTable.getValueString(conditionalInstruntion.getUse(1));
			String[] val2UseSplit = val2Use.split("#");
			if (val2UseSplit.length > 1) {
				if(!val2UseSplit[1].equals("null")){ 
					nConditional = Integer.parseInt(val2UseSplit[1]);
				}
			}
		}

		return nConditional;
	}
	
	
	

}
