package chap07_class.circle;

public class _03_UseOfCircle {

	public static void main(String[] args) {
		
		final double PI = 3.14 ; // final 변하지 않는 변수 값
		
		int radius = 10 ;
		
		circle c = new circle( radius ) ;
		
		System.out.println( "원의 반지름 : " + c.radius ) ;
		
		System.out.println( "원의 넓이 : " + c.Area( PI ) ) ;
		
		System.out.println( "원의 둘레 : " + c.round( PI ) ) ;
	}

}
