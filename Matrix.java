import java.util.*;
class Matrix
{
  private final int row;
  private final int col;
  private final int[][]mat;

 

// constructor to initialize values
  public Matrix(int row,int col)
  {
    this.row=row;
    this.col=col;
    mat=new int[row][col];
  }

//constructor to initialize values to matrix
  public Matrix(int[][] mat)
  {
    row=mat.length;
    col=mat[0].length;
    this.mat=new int[row][col];
    for(int i=0;i<row;i++)
    	for(int j=0;j<col;j++)
        	this.mat[i][j]=mat[i][j];
  }

//constructor to transpose a matrix
  public Matrix transpose()
  {
    Matrix transposed=new Matrix(col,row);
    for(int i=0;i<row;i++)
    	for(int j=0;j<col;j++)
        	transposed.mat[j][i]=this.mat[i][j];
    return transposed;
  }

//constructor to add two matrix
  public Matrix Add(Matrix second)
  {
    Matrix first=this;
    if(second.row!=first.row || second.col!=first.col) throw new RuntimeException("Sorry!, Illegal matrix Dimensions");
    Matrix Sum = new Matrix(row,col);
    for(int i=0;i<row;i++)
    	for(int j=0;j<col;j++)
        	Sum.mat[i][j]=first.mat[i][j]+second.mat[i][j];
    return Sum;
  }

  
//constructor to multiply two matrix
   public Matrix Mul(Matrix second)
   {
     Matrix first=this;
     if(first.col!=second.row) throw new RuntimeException("Sorry!, Illegal Matrix Dimension");
     Matrix multiply=new Matrix(first.row,second.col);
     for(int i=0;i<multiply.row;i++){
     	for(int j=0;j<multiply.col;j++){
     		multiply.mat[i][j]=0;
        	for(int k=0;k<first.col;k++){
                	multiply.mat[i][j]+=(first.mat[i][k]*second.mat[k][j]);
        	}
        }
     }
     return multiply;
   }
 
// constructor to check whether a matrix is symmetric or not
   public boolean Symm(Matrix first)
   {
     if (row!=col) throw new RuntimeException("It Can't be Symmetric since not square!!! ");
     for(int i=0;i<row;i++)
     {
       for(int j=0;j<col;j++)
       {
         if(first.mat[i][j]!=first.mat[j][i])
         	return false;
       }
     }
     return true;
  }	
    
// constructor to display the matrix
   public void show()
   {
    for(int i=0;i<row;i++)
    {
      for(int j=0;j<col;j++)
      {
        System.out.printf("%5d",mat[i][j]);
      }
      System.out.println("\n");
    }
  } 

   public static void main(String...arg)
   {
     int [][]first={
        {0 , 3 , 0 , 4 },
        {0 , 5 , 7 , 0 },
        {0 , 0 , 0 , 0 },
        {2 , 6 , 0 , 0 }
    };

    int [][]second={
       {0 , 1 , 1 , 0},
       {2 , 0 , 0 , 5},
       {0 , 0 , 4 , 4},
       {1 , 8 , 0 , 0}
    };
       

    Matrix initialMatrix=new Matrix(first);
    System.out.println("\nThe Sparse Matrix given here is : ");
    initialMatrix.show();
    System.out.println("\nThe Transposed Matrix is : ");
    Matrix transMatrix=initialMatrix.transpose();
    transMatrix.show();
    System.out.println("\n");
    Matrix secondMatrix=new Matrix(second);
    System.out.println("\nThe second matrix is :");
    secondMatrix.show();
    boolean result;
    result = secondMatrix.Symm(secondMatrix);
    if(result){
    System.out.println("\nThe second matrix is symmetrix :");
    }
    else{
    System.out.println("\nThe second matrix is not symmetrix :");
    } 
    System.out.println("\nThe addition of first & second matrix is :");
    initialMatrix.Add(secondMatrix).show();
    System.out.println("\nThe multiplication of first & second matrix is :");
    initialMatrix.Mul(secondMatrix).show();
  }
}
      