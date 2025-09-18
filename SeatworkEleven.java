public class SeatworkEleven {
	// fix commit
	public static void main(String[] args) {
		System.out.println("--- Seatwork 11 Part 1 ---");
		int[][] myNums = {{1,4,2}, {3,6,8}};
		myNums[1][2] = 9;
		System.out.println(myNums[1][2]);
		
		System.out.println("--- Seatwork 11 Part 2 ---\n");
		int[][] myInts = {{1,4,2},{3,6,8,5,2}};
		for (int row = 0; row < myInts.length; row++) {
			for (int col = 0; col < myInts[row].length; col++) {
				System.out.println("myInts[" + row + "][" + col + "] = " + myInts[row][col]);
			}
		}
	}
}