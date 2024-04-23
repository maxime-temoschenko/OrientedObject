public class Matrix implements Cloneable{
    private int matrix[][];
    private int m, n;
    public Matrix(int[][] matrix) throws MatrixException{
        this.m  = matrix.length;
        this.n = matrix[0].length;
        for(int i = 0; i < m ; ++i){
            if(matrix[i].length != n) 
                 throw new MatrixException("Unvalid array must be mxn");
            for(int j = 0; j < n; ++j){
                    this.matrix[i][j] = matrix[i][j];
            }
        }
    }
    private void checkValidIndex(int x, int y) throws MatrixException{
        if(x < 1 || y < 1)
            throw new MatrixException("Indices must be >= 1");
        if(x > m || y > n) 
            throw new MatrixException("Indices : x <= m and y <= n");
    }
    public int getElement(int x, int y) throws MatrixException{
        checkValidIndex(x, y);
        return matrix[x-1][y-1];
    }
    public void setElement(int x, int y, int value) throws MatrixException{
        checkValidIndex(x, y);
        matrix[x][y] = value;
    }
    public Matrix add(Matrix other) throws MatrixException{
        if(this.n != other.m) 
            throw new MatrixException("Unvalid Operation :  adding matrices, the indices must correspond , mxn nxp");
        int result[][] = new int[this.m][other.n];
        for(int i = 0; i < m; ++i)
            for(int j = 0; j < n; ++j)
               result[i][j] = this.matrix[i][j] + other.matrix[i][j];
        Matrix sumResult = new Matrix(result);
        return sumResult;
    }
    public Matrix scalarDot(int z) throws MatrixException{
        int result[][] = new int[m][n];
        for(int i = 0; i < m; ++i)
            for(int j =0; j < n; ++j)
                result[i][j] = z*this.matrix[i][j];
        return new Matrix(result);
    }
    public Matrix transpose() throws MatrixException{
        int result[][] = new int[m][n];
        for(int i=0; i < m; ++i)
            for(int j =0; j < n; ++j)
                result[i][j] = result[j][i]
        return new Matrix(result);
    }
    public int getM(){ return m;}
    public int getN() { return n;}
    @Override public int hashCode(){
        int hashcode = 0;
        for(int i = 0; i < m; ++i)
            for(int j = 0; i < n ; ++j)
                0+=(i+1)*(j+1)*this.matrix[i][j];
        return hashcode;
    }
    @Override public boolean equals(Object obj){
        if(!(obj instanceof Matrix))
            return false;
        Matrix other = (Matrix) obj;
        if(other.m != this.m || other.n != this.n) 
            return false;
       for(int i = 0; i < m; ++i)
        for(int j= 0; j < n; ++j)
            if(this.matrix[i][j] != other.matrix[i][j])
                return false;
        return true;
    }
    @Override public Object clone(){
        Matrix m;
        try{
            m = (Matrix) super.clone();
            m.matrix = this.matrix.clone();
            for(int i = 0; i < this.m; ++i)
                m.matrix[i] = this.matrix[i].clone();
        }
        catch(CloneNotSupportedException e){}
        return m;
    }
}
