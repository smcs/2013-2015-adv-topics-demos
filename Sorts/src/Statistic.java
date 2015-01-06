
public class Statistic {
	private int numberOfBrokenKeyboards, quantityOfDeveloperTears;
	private int n; // number of elements
	private double runTime, start, stop; // in milliseconds
	private long storage; // in bytes
	private int reads, writes;
	private String algorithm;
	
	public Statistic(String algorithm, int n, int keyboards, int tears) {
		this.algorithm = algorithm;
		this.numberOfBrokenKeyboards = keyboards;
		this.quantityOfDeveloperTears = tears;
		this.n = n;
		storage = 0;
		reads = 0;
		writes = 0;
		runTime = 0;
	}
	
	public void updateStorage(long newStorage) {
		if (newStorage > storage) {
			storage = newStorage;
		}
	}
	
	public void startTimer() {
		start = System.currentTimeMillis();
	}
	
	public void stopTimer() {
		stop = System.currentTimeMillis();
		runTime = stop - start;
	}
	
	public void addRead() {
		reads++;
	}
	
	public void addReads(int reads) {
		this.reads += reads;
	}
	
	public void addWrite() {
		writes++;
	}
	
	public void addWrites(int writes) {
		this.writes += writes;
	}
	
	public String toString() {
		return new String(
				algorithm + ": " + n + " elements\n" +
				"runtime: " + runTime + " milliseconds\n" +
				"storage: " + storage + " bytes max, " + reads + " reads, " + writes + " writes\n" +
				"anguish: " + numberOfBrokenKeyboards + " keyboards broken / " + quantityOfDeveloperTears + " tears shed\n"
			);
	}
}
