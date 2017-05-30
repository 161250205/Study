package fileclass;

import java.io.File;

public class TestFile {
	public static void printfile(File F,int level){
		for(int i=0;i<level;i++){
			System.out.print("-");
		}
		System.out.println(F.getName());
		if(F.list()!=null&&F.list().length!=0){
			String [] SF=F.list();
			for(int i=0;i<SF.length;i++){
				File temp = new File(F,SF[i]);
				printfile(temp,level+1);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f= new File("G:/Ѹ������");
		printfile(f,0);
	}

}
