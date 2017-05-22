package mycastle;

import java.util.HashMap;

public class Water {
	private int statu;
	private HashMap<Integer,String> status = new HashMap<Integer,String>();
	public Water(int statu) {
		this.statu = statu;
		status.put(0, "��");
		status.put(1, "��ˮ");
		status.put(2, "ˮ");
		status.put(3, "ˮ����");
	}
	public void change(int i){
		if(statu>i&&statu>0){
			this.statu--;
		}
		else if(statu<i&&statu<4){
			this.statu++;
		}
		
	}
	public String showstatu(){
		return status.get(this.statu);
	}
}
