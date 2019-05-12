
import java.util.concurrent.atomic.*;


public abstract class Task 
{
	
	private static final AtomicInteger ID_GENERATOR = new AtomicInteger();
	private final int id;
	private final int timeMs;
	
	/*
	 * An Abstract Class for the implementation of Worker processes.
	 * 
	 * 
	 */
	
	public Task(final int timeMs)
	{
		this.id = ID_GENERATOR.incrementAndGet();
		this.timeMs = timeMs;
		
	}
	//end public Task Constructor.
	
	public int getId()
	{
		
		return id;
		
	}
	//end public getId() method.
	
	public int getTimeMs()
	{
	
		return timeMs;
	
	}
	//end public getTimeMs() method.
	
	public String toString()
	{
		
		return String.format("id=%d TimeMs=%d", id, timeMs);
	
	}
	//end public toString() method.
	
	
	

}
