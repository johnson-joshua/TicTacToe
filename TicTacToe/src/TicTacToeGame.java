import java.util.Scanner;
public class TicTacToeGame 
{
	private Cell[][] board; //The board which stores all the cells.
	private boolean isPlayerOne; //A flag to determine if it is player one's turn. True = Player 1
	private int numberOfMoves; //Stores the number of moves that have been taken.
	private String winner; //Stores the name of the player which wins



	public TicTacToeGame() //Initializes the game instance object back to start.
	{
		this.init();
	}

	private boolean hasDiagonalWin( char value ) //a char value is passed in X or Y
	{
		if (this.board[1][1].getValue() == value)//Checks if middle cell is equal to the value passed in
		{
			if (this.board[0][0].getValue() == value) //Checks if value in first cell is equal to value passed in
			{
				if (this.board[2][2].getValue() == value) //Checks if value in bottom right corner is equal to value passed in
				{
					return true;
				}
			}
			else if (this.board[0][2].getValue() == value) //Checks if value in top right corner is equal to value passed in
			{
				if (this.board[2][0].getValue() == value) //Checks if value in bottom left corner is equal to value passed in
				{
					return true;
				}
			}
		}
		return false; //Middle cell is not equal to the value passed in, can't be a diagonal win
	}


	private boolean hasHorizontalWin( char value ) //a char value is passed in X or Y
	{		
		if (this.board[0][0].getValue() == value) //Checks for a win in row 1
		{
			if (this.board[0][1].getValue() == value)
			{
				if (this.board[0][2].getValue() == value)
				{
					return true;
				}
			}
		}
		else if (this.board[1][0].getValue() == value) //Checks for a win in row 2
		{
			if (this.board[1][1].getValue() == value)
			{
				if (this.board[1][2].getValue() == value)
				{
					return true;
				}
			}
		}
		else if( this.board[2][0].getValue() == value) //Checks for a win a row 3
		{
			if (this.board[2][1].getValue() == value)
			{
				if (this.board[2][2].getValue() == value)
				{
					return true;
				}
			}
		}

		return false; //No other paths available, All other if statements are not true
	}

	private boolean hasVerticalWin( char value ) //a char value is passed in X or Y
	{
		if (this.board[0][0].getValue() == value) //Checks for a win in column 1
		{
			if (this.board[1][0].getValue() == value)
			{
				if (this.board[2][0].getValue() == value)
				{
					return true;
				}
			}
		}
		else if (this.board[0][1].getValue() == value) ////Checks for a win in column 2
		{
			if (this.board[1][1].getValue() == value)
			{
				if (this.board[2][1].getValue() == value)
				{
					return true;
				}
			}
		}
		else if( this.board[0][2].getValue() == value) ////Checks for a win in column 3
		{
			if (this.board[1][2].getValue() == value)
			{
				if (this.board[2][2].getValue() == value)
				{
					return true;
				}
			}
		}

		return false; //No other paths available, All other if statements are not true
	}

	private boolean gameOver() //Checks to see if the games is over
	{
		if (isPlayerOne)
		{
			//Player two just played a turn and has a win.
			if( hasHorizontalWin( 'O' ) || hasVerticalWin( 'O' ) || hasDiagonalWin( 'O' ))
			{
				setWinner( "Player 2" );
				return true;
			}
			//Player two has just played a turn and has no win.
			else
			{
				return false;
			}
		}
		else
		{
			//Player one has just played a turn and has a win
			if( hasHorizontalWin( 'X' ) || hasVerticalWin( 'X' ) || hasDiagonalWin( 'X' ))
			{
				setWinner( "Player 1" );
				return true;
			}
			//Player one has just played a turn and has no win.
			else
			{
				return false;
			}
		}
	}

	public void play() //Starts the game from the very beginning.
	{
		do{
			gameOver();
			playTurn();
			numberOfMoves++;
			if ( isPlayerOne )  //If statement to switch turns from player 1 to player 2.
			{
				isPlayerOne = false;
			}
			else
			{
				isPlayerOne = true;
			}

		}while ( !gameOver() && numberOfMoves < 9 );

		//Once game is over, the following statements execute:
		System.out.println("________________________________________________________________________________");
		System.out.println();
		printBoard();
		System.out.println();
		System.out.println( "Winner is: " +winner );
		System.out.println();
		Scanner kb = new Scanner( System.in );
		System.out.println( "Would you like to play again? (Y/N)" );
		String again = kb.next();
		if( again.contains( "y"))
		{
			init();
			play();
		}
		else if( again.contains( "Y" ))
		{
			init();
			play();
		}
		else 
		{
			System.out.println( "Thanks for playing Tic Tac Toe Game!" );
			System.exit(0);
		}
	}


	private void playTurn() //Plays one turn based off of whose turn it is.
	{
		int rowInput, colInput;
		printBoard();
		//If statement switches the message about who's turn it is.
		if (isPlayerOne)
		{
			System.out.println( "Player 1's turn" );
		}
		else
		{
			System.out.println( "Player 2's turn" );	
		}

		Scanner kb = new Scanner(System.in);

		do
		{
			System.out.println( "Which row would you like to play (1 - 3): " );
			rowInput = kb.nextInt();

			//THIS WAS ME TRYING TO VALIDATE NUMERIC INPUT FOR ROW.	
			//		try {
			//			rowInput = Integer.parseInt(row);
			//		} catch (NumberFormatException e) 
			//		{
			//			System.out.println( "Please enter an integer" );
			//		}

			while( rowInput < 1 || rowInput > 3)
			{
				System.out.println( "Enter a valid row (1 - 3): " );
				rowInput = kb.nextInt();
			}

			rowInput -= 1;	//Subtract 1 from row so users' input matches the array's index

			System.out.println( "Which column would you like to play (1 - 3): " );
			colInput = kb.nextInt();

			/**THIS WAS ME TRYING TO VALIDATE NUMERIC INPUT FOR COLUMN.
			 * 		try {
			 *			colInput = Integer.parseInt(col);
			 *		} catch (NumberFormatException e) 
			 *		{
			 *			System.out.println( "Please enter an integer" );
			 *		}
			 */


			while( colInput < 1 || colInput > 3)
			{
				System.out.println( "Enter a valid column (1 - 3): " );
				colInput = kb.nextInt();
			}
			colInput -= 1;	//Subtract 1 from column so users' input matches the array's index

			//Will print a message to user if cell is taken.
			if( this.board[rowInput][colInput].isTaken() )
			{
				printBoard();
				System.out.println();
				System.out.println( "Cell is already taken." );
				System.out.println();
			}
			//If cell is taken, it will loop on asking for a row/column.
		}while( this.board[rowInput][colInput].isTaken());
		this.board[rowInput][colInput].setValue( isPlayerOne );
	}

	private void setWinner( String value ) //Sets the name of the winner
	{
		this.winner = value;
	}

	/**INIT() METHOD:
	 * Initializes the game board, number of moves, winner, and sets player one to start first
	 *  Defaults: isPlayerOne: true numberOfMoves: 0 winner: "CAT" board: set to a new 3x3 Cell array.
	 */
	private void init()
	{
		this.numberOfMoves = 0;
		this.setWinner( "CAT" );
		this.isPlayerOne = true;
		this.board = new Cell[3][3];								//If board is a 2-d array of Cells, from the Cell class, why do
		for( int row = 0; row < board.length; row++ )				//we need to fill it with cells in these 2 for loops?
		{
			for( int col = 0; col < board[row].length; col++ )
			{
				this.board[row][col] = new Cell();
			}
		}

	}

	private void printBoard() //Prints the game board in a user friendly manner
	{
		System.out.println( " " + this.board[0][0] + " | " + this.board[0][1] + " | " + this.board[0][2] + " " );
		System.out.println( "---+---+---" );
		System.out.println( " " + this.board[1][0] + " | " + this.board[1][1] + " | " + this.board[1][2] + " " );
		System.out.println( "---+---+---" );
		System.out.println( " " + this.board[2][0] + " | " + this.board[2][1] + " | " + this.board[2][2] + " " );
	}
}