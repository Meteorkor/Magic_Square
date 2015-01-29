package com.meteor;


public class MasicSquare {

	protected int matrix[][];
	
	protected int MasicNumber;
	
	public MasicSquare(int number){
		matrix = new int[number][number];
		MasicNumber = number;
	}
	
	public void printMatrix(){
		
		for (int f1 = 0; f1 < MasicNumber; f1++) {
			for (int f2 = 0; f2 < MasicNumber; f2++) {
				System.out.print(matrix[f1][f2]);
				System.out.print(",");
			}
			System.out.println("");

		}
	}

	/**
	 * 현재는 홀수만 구현
	 */
	public void solve() {

		int maxNumber = (int) Math.pow(MasicNumber, 2);
		int i = 0, j = MasicNumber/2;

		int old_i=0, old_j=0;
		
		for (int putNumber = 1; putNumber <= maxNumber;) {
			
			if( matrix[i][j] == 0 ){
				matrix[i][j] = putNumber;
				old_i = i;
				old_j = j;
				 putNumber++;
			}else{
				i = old_i;
				j = old_j;
				i++;
				matrix[i][j] = putNumber;
				putNumber++;
			}
			
			
			if (i < 1) {
				i = MasicNumber - 1;
			} else {
				i--;
			}
			if (j < 1) {
				j = MasicNumber - 1;
			} else {
				j--;
			}

		}

	}
	/**
	 * 합 검증 및 초기화
	 * @param sumation
	 * @return
	 */
	public boolean sumationVerification(int sumation){
		int sumationValue = MasicNumber*(MasicNumber*MasicNumber+1)/2;
		
		return sumation == sumationValue;
		
	}
	/**
	 * 세로 검증
	 * @param matrix
	 * @return
	 */
	public boolean verticalVerification(int[][] matrix){
		int tempSumcationValue=0;
		
		for( int y=0;y<MasicNumber;y++ ){
			for(int x=0; x<MasicNumber; x++){
				tempSumcationValue += matrix[x][y];
			}
			if( !sumationVerification( tempSumcationValue ) ){
				System.out.println( "세로 검증" );
				return false;
			 }else{
				 tempSumcationValue = 0;
			 }
		}
		return true;
	}
	/**
	 * 가로 검증
	 * @param matrix
	 * @return
	 */
	public boolean horizontalVerification(int[][] matrix){
		int tempSumcationValue=0;
		
		for( int x=0;x<MasicNumber;x++ ){
			for(int y=0; y<MasicNumber; y++){
				tempSumcationValue += matrix[x][y];
			}
			//검증
			 if( !sumationVerification( tempSumcationValue ) ){
				 System.out.println( "가로 검증" );
				 return false; 
			 }else{
				 tempSumcationValue = 0;
			 }
		}
		
		return true;
	}
	/**
	 * 대각선 검증
	 * @return
	 */
	public boolean DiagonalVerification( int[][] matrix ){
		int tempSumcationValue =0;
		for( int x=0;x<MasicNumber;x++ ){
			tempSumcationValue += matrix[x][x];
		}
		
		if( !sumationVerification( tempSumcationValue ) ){
			System.out.println( "대각선1 검증" ); 
			return false; 
		 }else{
			 tempSumcationValue = 0;
		 }
		
		for( int x=0;x<MasicNumber;x++ ){
			tempSumcationValue += matrix[x][x];
		}
		
		if( !sumationVerification( tempSumcationValue ) ){
			System.out.println( "대각선2 검증" ); 
			return false; 
		 }else{
			 tempSumcationValue = 0;
		 }
		
		return true;
	}
	
	
	/**
	 * 검증
	 * @return
	 */
	public boolean verification(){
		
		boolean suc = true;
		
		int sumationValue = MasicNumber*(MasicNumber*MasicNumber+1)/2;
		
		int tempSumcationValue = 0;
		
		//가로
		if( !horizontalVerification(matrix) ){
			return false;
		}
		
		//세로
		if( !verticalVerification(matrix) ){
			return false;
		}
		
		
		//대각선
		if( !DiagonalVerification(matrix) ){
			return false;
		}
		
		return suc;
	}
	
}
