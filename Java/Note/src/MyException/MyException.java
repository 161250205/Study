package MyException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MyException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
			FileReader reader=null;
			try {
				reader = new FileReader("d:/a.txt");
				char temp = (char)reader.read();
				System.out.println("���������ݣ�"+temp);
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					if(reader!=null){
						reader.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
		
	}

}
