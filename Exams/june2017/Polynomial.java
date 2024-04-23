public class Polynomial implements Cloneable{
        private  int[] coeff; // Not final because cloning would be impossible
        private final int degree;
        public Polynomial(int n, int coeff) throws PolynomialException{
            checkDegree(n);
            this.degree = n;
            this.coeff = new int[n+1];
            for(int i = 0; i <n; ++i)
                this.coeff[i] = 0;
            this.coeff[n] = coeff;          
        }
        public Polynomial(int[] coeff){
            this.coeff = coeff;
            this.degree = coeff.length;
        }
        public Polynomial(Polynomial p1, Polynomial p2) throws PolynomialException{
            int length = p1.degree < p2.degree ? p2.degree : p1.degree;
            int[] result = new int[length];
            for(int i =0; i <= length; ++i ){
                if(i <= p1.degree) 
                    result[i] += p1.coeff[i];
                if(i <= p2.degree) 
                    result[i] += p2.coeff[i];
            }
            this.degree = length;
            this.coeff = result;
        }
        public int getDegree() { return this.degree;}
        public int[] getCoeff() { return this.coeff;}
        private void checkDegree(final int n) throws PolynomialException{
            if(n <= 0)
                throw new PolynomialException("Degree must be n>= 0");
        }
        public int compute(){
            int result = 0;
            for(int i = 0; i <= degree; ++i)
                result += Math.pow(this.coeff[i],i);
            return result;
        }
        public boolean isNull(){
            return degree==0 && this.coeff[0] == 0;
        }
        @Override public Object clone(){
            Polynomial myPolinomial;
            try{
            myPolinomial = (Polynomial) super.clone();
            myPolinomial.coeff = this.coeff.clone();
            }
            catch(CloneNotSupportedException e) { }
            return myPolinomial;
        }
        @Override public int hashCode(){
            int hashcode = 0;
            for(int i  = 0; i <= this.degree; ++i)
                hashcode =31*hashcode + coeff[i];
            return hashcode;
        }
        @Override public boolean equals(Object obj){
            if(!(obj instanceof Polynomial))
                return false;
            Polynomial other = (Polynomial) obj;
            if(other.degree != this.degree)
                return false;
            for(int i =0;i <= degree; ++i)
                if(other.coeff[i] != this.coeff[i])
                    return false;
            return true;
        }
}
