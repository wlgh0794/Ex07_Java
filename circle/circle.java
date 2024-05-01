package chap07_class.circle;

public class circle {

	public int radius ;
	
	public circle() // [ 기본 생성자 ]
	{
		System.out.println( " 클래스 호출" );
	}
	
	public circle( int radius ) // [ 기본 생성자 ] - [ 오버로드 ]
	{
		// 생성자를 호출하면 객체가 생성되는데
		// this는 생성된 객체를 받아온다.
		
		System.out.println( "circle 클래스 : 호출"  );
		
		this.radius = radius ;
	}
	
	public double round( double PI )
	{
		return (double)( 2 * PI * radius ) ;
	}
	
	public double Area( double Pi )
	{
		return (double)( Pi * radius * radius ) ;
	}	
}
