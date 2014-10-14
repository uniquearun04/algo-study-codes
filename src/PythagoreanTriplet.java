
public class PythagoreanTriplet {

	
	public void findPTriblet(int A[]){
		
		for(int i = 0; i < A.length - 2; i++){
			int a = A[i];
			for(int j = i+1; j < A.length - 1; j++){
				int b = A[j];
				int c = (int)Math.sqrt(a*a + b*b);
//				for(int k = j+1; k < A.length; k++){
//					if(A[k] == c){
//						System.out.println(a+", "+b+", "+c);
//						break;
//					}
//				}
				
				int index = binSearch(A, c, j+1, A.length-1);
				if(index == -1){
					break;
				} else{
					System.out.println(a+", "+b+", "+A[index]);
					break;
				}
			}
		}
	}
	
	
	public int binSearch(int A[], int c, int lo, int hi){
		
		int mid = (hi+lo)/2;
		
		if(hi < lo){
			return -1;
		} 
		if(hi == lo){
			if(A[hi] == c){
				return hi;
			} else return -1;
		}
		
		if(c < A[mid]){
			return binSearch(A,c,lo, mid-1);
		} else if( c > A[mid]){
			return binSearch(A, c, mid+1, hi);
		} else return mid;
		
	}
	
	
	
	
	public static void main(String[] args) {

		
	}

}
