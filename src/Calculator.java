
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

abstract class Calcular {
	protected int a;
	protected int b;
	protected char oper;
	boolean isOper(char oper) {
		return false;
		
	}
	int  compute(int a,int b){
		return 0;
	}
}

class add extends Calcular {

	@Override
	public int compute(int a,int b) {
		return a + b;
	}
	@Override
	public boolean isOper(char oper) {
		if(oper=='+') 
			return true;
		return false;
		
	}
}

class sub extends Calcular {

	@Override
	public int compute(int a,int b) {
		return a - b;
	}
	@Override
	public boolean isOper(char oper) {
		if(oper=='-') 
			return true;
		return false;
		
	}
}

class div extends Calcular {

	@Override
	public int compute(int a,int b) {
		if(b==0) {
			throw new ArithmeticException();
		}
		return a/b;
	}
	@Override
	public boolean isOper(char oper) {
		if(oper=='/') 
			return true;
		return false;
		
	}

}

class mul extends Calcular {

	@Override
	public int compute(int a,int b) {
		return a * b;
	}
	@Override
	public boolean isOper(char oper) {
		if(oper=='*') 
			return true;
		return false;
		
	}
}

public class Calculator {
	public static ArrayList<Calcular>list = new ArrayList<>(List.of(new add(),new sub(),new div(),new mul()));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringTokenizer st= new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		char op = (char) br.read();
		for(Calcular val:list) {
			if(val.isOper(op)) {
				System.out.println(val.compute(a, b));
			}
			
		}
		//list.stream().filter(e -> e.isOper(op)).map(t -> t.compute(a, b)).findFirst();
	}

}
