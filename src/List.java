
public class List<ListItem> 
{

	private class ListNode
	{
		
		Comparable Content;
		ListNode Link;
		
	}
	//end of ListNode class
	
	private ListNode Head, Cursor, SearchPtr;
	
	public List()
	{
		
		Head = new ListNode();
		Head.Link = Head;
		Cursor = Head;
		
	}
	//end of List constructor
	
	public void ClearList()
	{
		
		Head.Link = Head;
		Cursor = Head;
		
	}
	//end of public ClearList method
	
	public boolean EmptyList()
	{
		
		//Is this list Empty?
		
		if (Head == Head.Link)
		{
			
			return true;
		
		}
		else
		{
			
			return false;
			
		}
		
	}
	//end of public EmptyList method
	
	public ListItem GetList()
	{
		
		ListItem LI;
		LI = (ListItem) Cursor.Content;
		Cursor = Cursor.Link;
		return LI;	
		
	}
	//end of public GetList method
	
	public boolean EndOfList()
	{
	
		if (Cursor == Head)
		{
		
			return true;
		
		}
		else
		{
			
			return false;
		
		}
		
	}
	//end of public EndOfList method
	
	public void InsertList(ListItem LI)
	{
		
		ListNode P;
		
		if(FindList(LI))
		{
			
			System.out.println("Insert Error");
			System.exit(0);
			
		}
		else
		{
			
			P = new ListNode();
			P.Content = (Comparable) LI;
			P.Link = SearchPtr.Link;
			SearchPtr.Link = P;
			
		}
		
	}
	//end of public InsertList method
	
	private boolean FindList(ListItem LI)
	{
		
		ListNode LookAheadPtr;
		Comparable X = (Comparable) LI;
		
		SearchPtr = Head;
		LookAheadPtr = SearchPtr.Link;
		
		while (LookAheadPtr != Head && X.compareTo(LookAheadPtr.Content) > 0)
		{
			
			SearchPtr = SearchPtr.Link;
			LookAheadPtr = LookAheadPtr.Link;
	
		}
		
		if (LookAheadPtr != Head && X.compareTo(LookAheadPtr.Content) > 0)
		{
			
			return true;
			
		}
		else
		{
			
			return false;
			
		}
		
	}
	//end of private FindList method
	
	public void DeleteList(ListItem LI)
	{
		
		ListNode P;
		
		if (!FindList(LI))
	      {
			
	         System.out.println("Delete Error!");
	         System.exit(0);
	         
	      }
	      else
	      {
	    	  
	         P = SearchPtr.Link;
	         SearchPtr.Link = P.Link;
	         
	      }
		
	}
	//end of public DeleteList method
	
	public void UpdateList(ListItem LI)
	{
		
		if(!FindList(LI))
		{
			
			System.out.println("Update Error!");
			System.exit(0);
			
		}
		else
		{
			
			SearchPtr = SearchPtr.Link;
			SearchPtr.Content = (Comparable) LI;
			
		}
		
	}
	//end of public UpdateList method.
	
	public ListItem SearchList(ListItem LI)
	{
		
		if (FindList(LI))
		{
		
			return (ListItem) SearchPtr.Link.Content;
			
		}
		else
		{
			
			return null;
			
		}
		
	}
	//end of public SearchList method.
	
	public int LengthOfList()
	{
		
		ListNode P;
		int Counter = 0;
		
		P = Head;
		while (P.Link != Head)
		{
			
			Counter++;
			P = P.Link;
			
		}
		
		return Counter;
		
	}
	//end of public LengthofList method.
	
	public ListItem ExtractFromList(int N)
	{
		
		ListItem LI;
		ListNode P;
		
		if (N < 1 || N > LengthOfList())
		{
			
			System.out.println("ExtractFromList Error!");
			System.exit(0);
			
		}
		
		P = Head;
		
		for (int i = 1; i <= N; i++)
		{
			
			P = P.Link;
			
		}
		
		LI = (ListItem) P.Content;
		return LI;
		
	}
	//end of public ExtractFromList method.
	
	
}