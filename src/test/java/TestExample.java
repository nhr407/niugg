
public class TestExample {

	public static void main(String[] args) throws InterruptedException {
		@SuppressWarnings("unused")
		Poll poll = new Poll();
	}

}

class Poll {
	private final int MAX = 100;
	private long count;
	public Poll() {
		new Thread(new Runnable(){
			public void run(){add();}
		}, "Thread1").start();;
	}
	
	public long getCountAvailable() {
		return count;
	}
	
	public void add() {
		while (true) {
			if (count < MAX ) {
				count++;
			}
			System.out.println(count);
			try {
				Thread.sleep(1000l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
	}
}
