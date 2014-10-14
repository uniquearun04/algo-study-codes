import java.util.ArrayList;
import java.util.List;

public class Test{
	static int value = 1;
	
	public int getValue(){
		
		try{
			value = value +1;
			return value;
		}
		catch(Exception e){
			return 0;
		} finally{
			value = value+1;
		}
		
		
	}
	
	public static void main(String args[]){
		Test t1 = new Test();
		System.out.println(t1.getValue());
		System.out.println(t1.value);
		
//		int x = 10.0;
//		int x = 10f;
		int x = 012;
		if(x == 10.0) System.out.println("test");
		Derived d = new Derived();
		d.finalize();
		
		List<Integer> ml= new ArrayList<>();
		ml.add(25);
		ml.add(35);
		
		List  l2 = ml;
		l2.add("asdf");
		
		for(Object o : l2){
			System.out.println(o);
		}
	}
}



class BaseTest{
	
	protected void finalize(){
		System.out.println("base destroyed.");
	}
}

class Derived extends BaseTest{
	protected void finalize(){
		System.out.println("derived destroyed.");
	}
}