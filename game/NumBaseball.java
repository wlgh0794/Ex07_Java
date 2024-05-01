package chap07_class.game;

import java.util.Random;
import java.util.Scanner;

public class NumBaseball {

	// 1 . 컴퓨터가 ( 0 ~ 9 ) 까지 숫자중 랜덤한 값 3개를 배열에 저장
	// 2 . 사용자가 ( 0 ~ 9 ) 까지 숫자 3개 입력 [ 중복 불가능 ]
	// 
	// 3 . 사용자가 입력한 숫자 중 컴퓨터가 가지고 있는 숫자와 같은 숫자면서 위치가 다르면 (볼)
	// 4 . 사용자가 입력한 숫자 중 컴퓨터가 가지고 있는 숫자와 같은 숫자면서 위치가 같으면 (스트라이크)
	// 
	// ( 예 ) → 
	// com = { 1 , 2 , 3 } / user = { 1 , 3 , 5 } = [ 스트라이크 : 1 / 볼 : 1 ]
 	// com = { 1 , 2 , 3 } / user = { 4 , 5 , 6 } = [ 스트라이크 : 0 / 볼 : 0 ]
	// com = { 1 , 2 , 3 } / user = { 2 , 3 , 1 } = [ 스트라이크 : 0 / 볼 : 3 ]
 	// com = { 1 , 2 , 3 } / user = { 1 , 2 , 3 } = [ 스트라이크 : 3 / 아웃 게임종료 ]

	// 클래스에 필요한 필드

	int User[] = new int [ 3 ] ;
	
	int Computer[] = new int [ 3 ] ;
	
	int strike = 0 ;
	
	int ball = 0 ;
	
	int gamecout = 0 ;
	
	int com[] = new int [ 3 ] ;
	
	int user[] = new int[ 3 ] ;

		
	public NumBaseball()
	{
//		System.out.println( "클래스 호출" );
	}
	
	public void start()
	{	
		
		while( true )
		{
			++gamecout ;
			
			// ################################################
			
			// com 배열에 저장될 3개의 숫자
			
			// 3스트라이크 아웃이 될때까지 사용자의 입력값 받기
			System.out.println( gamecout + "회 게임을 시작합니다." );
			
			// ################################################
			
			// [ 컴퓨터 ]
			
			System.out.println( "컴퓨터 값을 랜덤으로 생성합니다." );
			
			Random rand = new Random() ;	
			
			System.out.print( "[ 컴퓨터 ] : " );
			
			for( int k = 0 ; k < Computer.length ; k++ )
			{
				
				Computer[ k ] = rand.nextInt( 10 ) ;
				
				System.out.print( Computer[ k ] + " " );
				
			}	
			
			// ################################################	
			
			// [ 사용자 ]
			
			System.out.println( "\n사용자의 숫자 선택해주세요 ( 중복불가능 ): \n"  );
			
			for ( int i = 0 ;  i < User.length ;  i++ )
			{
			
				// ################################################
				
				// [ 사용자 값 입력 ]
				
				Scanner sc = new Scanner( System.in ) ;
				
				User[ i ] = sc.nextInt( ) ; 
			
				System.out.println( "[ 사용자 ] :  " +  User[ i ] );
				
				// ################################################
				
				// [ 사용자의 값 확인 ]
				
				if ( User[ i ] > 9 )
				{
					System.out.println( "값이 너무 큽니다." );					
					System.out.println( "0 ~ 9 까지의 숫자만 입력해주세요." );
					
					i-- ;
					
					continue ;
				}
				
				// ################################################
				
				// [ 중복확인 ]
				
				for ( int j = 0 ; j <= i - 1 ; j++ )
				{
					if ( User[j] == User[ i ] )
					{
						System.out.println( "중복된 값이 있습니다." );
						
						--i;
						
						break ;
					}
				}
				
				// ################################################
		
			}

			// ################################################
			
			// [ 값 비교 ]
	
			for ( int i = 0  ; i < User.length ; i++ )
			{
				for ( int j = 0  ; j < Computer.length ; j++ )
				{
					if ( ( Computer[ j ] == User[ i ] ) && ( i == j )  )
					{
						++strike;
						
						System.out.println( "[ 유저 VS 컴퓨터 ] : ( 데이터 = O / 순서 = O ) "  );
						
						System.out.println( "[ 유저 ] 인덱스 번호 :  " + i  + " / 데이터  : " + User[ i ] );
						
						System.out.println( "[ 컴퓨터 ] 인덱스 번호 :  " + j  + " / 데이터  : " + Computer[ j ] );
						
						System.out.println( "\n=======================\n" );
						
					}
					if ( ( Computer[ j ] == User[ i ] ) && ( i != j )  )
					{
						++ball;
						
						System.out.println( "[ 유저 VS 컴퓨터 ] : ( 데이터 = O / 순서 = X ) "  );
						
						System.out.println( "[ 유저 ] 인덱스 번호 :  " + i  + " / 데이터  : " + User[ i ] );
						
						System.out.println( "[ 컴퓨터 ] 인덱스 번호 :  " + j  + " / 데이터  : " + Computer[ j ] );
						
						System.out.println( "\n=======================\n" );
						
					}				
					else
					{
	
						System.out.println( "[ 유저 VS 컴퓨터 ] : ( 데이터 = X / 순서 = X )"  );
						
						System.out.println( "[ 유저 ] 인덱스 번호 :  " + i  + " / 데이터  : " + User[ i ] );
						
						System.out.println( "[ 컴퓨터 ] 인덱스 번호 :  " + j  + " / 데이터  : " + Computer[ j ] );
						
						System.out.println( "\n=======================\n" );
						
					}
					
					
				}			
			
			}
			
			// ################################################
			
			// [ 스트라이크 : 3회 ] - 종료
			
			if( strike >= 3 )
			{
				System.out.println( "스트라이크 3회 : 게임을 종료합니다." );
				
				break ;
			}
			else
			{
				System.out.println( "[결과]" );
				
				System.out.println( " 스트라이크 :  " + strike  );	
				
				System.out.println( " 볼 :  " + ball  );				
			}
			
			// ################################################
			
		}
			
	}

	
}
