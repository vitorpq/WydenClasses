class Forma2D
{
    double dim1;
    double dim2;
    //double ar;
    
    public Forma2D(double dim1, double dim2)
    {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }
    
    public double area()
    {
        return dim1 * dim2;
    }
}

public class Main
{
	public static void main(String[] args) {
            double dim1 = 5;
            double dim2 = 3;
            
            Forma2D ret = new Forma2D(dim1, dim2);
            
            System.out.println(ret.area());
	}
}