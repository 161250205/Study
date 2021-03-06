
import java.util.HashMap;
import java.util.Scanner;


public class Main {
	public static int game(char a,char b){
		if(a==b){
			return 0;
		}
		else if((a=='C'&&b=='J')||(a=='J'&&b=='B')||(a=='B'&&b=='C')){
			return 1;
		}
		else{
			return -1;
		}
	}
	public static char max(HashMap<Character,Integer> A){
		if(A.get('B')>=A.get('C')&&A.get('B')>=A.get('J')){
			return 'B';
		}
		else if(A.get('C')>=A.get('J')&&A.get('C')>=A.get('B')){
			return 'C';
		}
		else
		{
			return 'J';
		}
		
	}
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N=in.nextInt();
		int win=0,lose=0,equal=0;
		HashMap<Character,Integer> A =new HashMap<Character,Integer>();
		HashMap<Character,Integer> B=new HashMap<Character,Integer>();
		A.put('C', 0);A.put('J', 0);A.put('B', 0);
		B.put('C', 0);B.put('J', 0);B.put('B', 0);
		for(int i=0;i<N;i++){
			char a =in.next().charAt(0);
			char b =in.next().charAt(0);
			if(game(a,b)==1)
			{
				win++;
				A.put(a,A.get(a)+1);
			}
			else if(game(a,b)==0)
			{
				equal++;
			}
			else
			{
				B.put(b,B.get(b)+1);
				lose++;
			}
		}
		System.out.printf("%d %d %d\n",win,equal,lose);
		System.out.printf("%d %d %d\n",lose,equal,win);
		System.out.printf("%c %c\n",max(A),max(B));
	}

}
