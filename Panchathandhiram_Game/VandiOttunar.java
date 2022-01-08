//import java.io.*;
//import java.util.Timer;
import java.util.Scanner;
import java.io.IOException;
public class VandiOttunar {

	public static void main(String[] args) throws IOException,InterruptedException
	
	{
		// TODO Auto-generated method stub
		Scanner cho=new Scanner(System.in);
		Guesser g1=new Guesser("201",120,"S",5);
		String ch;
		int i=1;
		System.out.println("Let's Start the Game!!\n(Press Enter to Begin :)");
		ch=cho.nextLine();
		long begin=System.currentTimeMillis();
		long end=0;
		do
		{
		System.out.println("\n\n");
		g1.getGrid().dispGrid();
		int guess=g1.guessaNum();
		System.out.println("\nPlayer Guess: "+guess);
	    g1.guessesUpdate(guess);
	    end=System.currentTimeMillis();
	    if((end-begin)>=30000*i && (end-begin)<60000)
	    {
	    	System.out.println("\nRe-Arranging the Grid ;)\n");
	    	g1.getGrid().fixCellOrder();
	    	i++;
	    }
	    
		}while((end-begin)<60000 && g1.getGrid().getFoundCells().size()<5);
		g1.getGrid().getGStatus()[1].setText("Total");
		g1.getGrid().getGStatus()[2].setText("Score :");
		System.out.println("Total Score: "+g1.getGamePoint().getScore(Integer.parseInt(Grid.wrongSlotValue)));
		cho.close();
		ch=ch+"bye";
	}

}
