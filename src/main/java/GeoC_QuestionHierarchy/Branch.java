package GeoC_QuestionHierarchy;

public class Branch {
    String expression;
    String next;

    public Branch(String expr, String nextID )
    {
        this.expression = expr;
        this.next = nextID;
    }
    public String getExpression() {return this.expression;}
    public String getNext() {return this.next;}
    
    public void print()
    {
    	System.out.println(this.expression + " --> " + this.next);
    }
}