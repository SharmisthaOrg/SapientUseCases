import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CalculateSum {

	public static void main(String[] args) {
		int[] ia= {1,2,3,4,5,6,7,8,9,10,11,12,13};

		ExecutorService es=Executors.newFixedThreadPool(5);
		List<Callable<Integer>> l=new ArrayList<>();
		int range=ia.length/5;
		for(int i=0;i<ia.length;i=i+range) {
			int end = (i+range)>ia.length ? ia.length:i+range;
			l.add(new CallableClass(i, end, ia));
		}
		List<Future<Integer>> sumparts;
		try {
			sumparts = es.invokeAll(l);
			int total=0;
			for(Future<Integer> sumpart:sumparts) {
				total += sumpart.get();
			}
			System.out.println(total);
		} catch (InterruptedException | ExecutionException e1) {
			e1.printStackTrace();
		}
		finally{
			es.shutdown();
		}

	}

}
class CallableClass implements Callable<Integer>{
	int start;
	int end;
	int[] arr;
	public CallableClass(int start,int end,int[] arr) {
		this.start = start;
		this.end = end;
		this.arr = arr;
	}
	@Override
	public Integer call() throws Exception {
		int sum=0;
		for(int i=start;i<end;i++) {
			sum+= arr[i];
		}
		return sum;
	}

}
