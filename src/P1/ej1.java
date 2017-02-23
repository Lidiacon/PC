package P1;

public class ej1 extends Thread implements Runnable{
	private int T = 100;
	private static int N = 5;
	
	@Override
	public void run() {
		System.out.println("Soy el proceso " + this.getId());
		try {
			sleep(T);
			System.out.println(this.getId() + " was here");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String args[]){
		for(int i = 0; i < N;i++){	
			(new Thread(new ej1())).start();
		}
	}

}
