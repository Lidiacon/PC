package P1;

import java.util.ArrayList;

public class ej2{
	public static int N = 8000;
	public static int M = 5000;
	public volatile int n = 0;

	class Incr extends Thread implements Runnable{
		@Override
		public void run() {
			n++;
		}
	}
	
	class Decr extends Thread implements Runnable{
		@Override
		public void run() {
			n--;
		}
	}
	
	private void sumando(){
		ArrayList<Thread> threads = new ArrayList<Thread>();
		
		for(int i = 0; i < M;i++){	
			Thread in = new Incr();
			threads.add(in);
			Thread de = new Decr();
			threads.add(de);
			in.start();
			de.start();
		}
		
		for(Thread thread : threads){
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(n);
	}
	
	public static void main(String args[]){
		ej2 exe = new ej2();
		exe.sumando();
	}
	
}
