package com.meteor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MagicSquareApplication.class)
public class MagicSquareApplicationTests {

	
	@Test
	public void contextLoads() {
		
		
		for(int i=3;i<=15;i=i+2){
			MasicSquare masicSquare = new MasicSquare(i);
			masicSquare.solve();
			System.out.println( i );
			System.out.println( masicSquare.verification() );
	
		}
		
		
	}

}
