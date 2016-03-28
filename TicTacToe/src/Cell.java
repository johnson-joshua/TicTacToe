
public class Cell 
{
	public static final char PLAYER_ONE_SYMBOL = 'X';
	public static final char PLAYER_TWO_SYMBOL = 'O';	

	private boolean taken; //Marks whether the cell is taken already or not
	private char value; //Stores the character value of what is inside the cell

	public Cell() //Sets all the defaults for each cell.
	{
		this.taken = false;
		this.value = ' ';
	}

	public void setValue( boolean isPlayerOne ) //Mutator for the value in the cell
	{
		if(isPlayerOne)
		{
			this.value = 'X';
		}
		else
		{
			this.value = 'O';
		}
		this.setTaken( true ); //SUPPOSED TO SET THE CELL'S TAKEN VALUE TO TRUE!
	}

	public char getValue() //Accessor for the value in the cell
	{
		return this.value;
	}

	private void setTaken( boolean value ) //Mutator for the taken value of the cell
	{
		this.taken = value;
	}

	public boolean isTaken() //Accessor for the taken value of the cell
	{
		return this.taken;
	}

	public String toString() //Returns the string version of value
	{
		return String.valueOf( this.getValue());
	}
} //End of Cell class.
