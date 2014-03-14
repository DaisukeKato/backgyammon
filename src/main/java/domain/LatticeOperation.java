package domain;


public class LatticeOperation {

	public TipPositionLattice init() throws IllegalArgumentException, TipPositionLatticeOverFlow{
		TipPositionLattice lattice = new TipPositionLattice();
		for(short i = 0; i < 2; i++){
			lattice.push((short)1, (short)1);
			lattice.push((short)24, (short)2);
		}
		for(short i = 0; i < 3; i++){
			lattice.push((short)8, (short)2);
			lattice.push((short)17, (short)1);
		}
		for(short i = 0; i < 5; i++){
			lattice.push((short)6, (short)2);
			lattice.push((short)12, (short)1);
			lattice.push((short)13, (short)2);
			lattice.push((short)19, (short)1);
		}
		
		return lattice;
	}
}
