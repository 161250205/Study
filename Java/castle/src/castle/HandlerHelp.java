package castle;

import mycastle.Room;

public class HandlerHelp extends Handler {
	

	public HandlerHelp(Room r) {
		super(r);
		// TODO Auto-generated constructor stub
	}

	public void doCmd(String s){
		 System.out.print("迷路了吗？你可以做的命令有：go bye help");
	     System.out.println("如：\tgo east");
	}
}
