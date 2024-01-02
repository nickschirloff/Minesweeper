
public class MSModel {
	
	private MSFrame frame;
	private int[][] mineArray = new int[10][10];
	private int numMines = 0;
	
	public MSModel(MSFrame frame) {
		this.frame = frame;
		populateCells();
		
	}
	
	public void populateCells() {

		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				mineArray[i][j] = determineMineChance();
			}
		}

		mineArray = addNumbers(mineArray);
	}

	public int determineMineChance() {

		int chance = (int)(Math.random() * 12) + 1;
		if(chance == 12)
		{
			numMines++;
			return -1;
		}
		else
		{
			return 0;
		}

	}
	
	public int[][] addNumbers(int[][] mArray){

		while(numMines == 0)
		{
			determineMineChance();
		}
		//Rows, columns
		for(int r = 0; r < 10; r++)
		{
			for(int c = 0; c < 10; c++)
			{
				//If the instance is a mine, and the column is less than 10
				if(mArray[r][c] == -1)
				{
					//If top left corner exists, add one
					if(r-1 > -1 && c-1 > -1 && mArray[r-1][c-1] != -1)
					{
						mArray[r-1][c-1] += 1;
					}
					//If row above exists, add one
					if((r-1) > -1 && mArray[r-1][c] != -1)
					{
						mArray[r-1][c] += 1;
					}
					//If top right corner exists, add one
					if((r-1) > -1 && (c+1) < 10 && mArray[r-1][c+1] != -1)
					{
						mArray[r-1][c+1] += 1; 
					}
					//If cell to the left exists
					if((c-1) > -1 && mArray[r][c-1] != -1)
					{
						mArray[r][c-1] += 1;
					}
					//If cell to the right exists
					if((c+1)  < 10 && mArray[r][c+1] != -1)
					{
						mArray[r][c+1] += 1;
					}
					//If bottom left corner exists
					if((r+1) < 10 && (c-1) > -1 && mArray[r+1][c-1] != -1)
					{
						mArray[r+1][c-1] += 1;
					}
					//If cell below exists, add one
					if((r+1) < 10 && mArray[r+1][c] != -1)
					{
						mArray[r+1][c] += 1;
					}
					//If bottom right corner exists, add one
					if((r+1) < 10 && (c+1) < 10 && mArray[r+1][c+1] != -1)
					{
						mArray[r+1][c+1] += 1;
					}
					
				}

			}
		}

		return mArray;
	}

	public int getValueOfCell(int id) {
		return mineArray[id/10][id%10];
	}

	public int getNumMines() {
		return numMines;
	}
	
	public void setMinesRemaining(int num) {
		numMines += num;
	}
	
	public int setDifficulty(String selectedDifficulty) {
	
		if(selectedDifficulty == "Easy")
		{
			System.out.println("Easy");
			return 6;
		}
		else if(selectedDifficulty == "Medium")
		{
			System.out.println("Medium");
			return 12;
		}
		else
		{
			System.out.println("Hard Level");
			return 20;
		}
	}
}
