package com.example;

public class crypto {
	int[] k1 = {3,1,2,5,4};
	int[] k2 = {4,5,2,1,3};

	char[] encrypt(char[] str){
		char[][] matrix = new char[5][5];
		for(int i = 0; i < 25; i++){
			matrix[i/5][i%5] = str[i];
		}

		int[] k = new int[5];
		for(int i = 0; i < 5; i++){
			k[i] = 1;
			for(int j = 0; k1[j]!=i+1; j++)
			{
				k[i]++;
			}	
		}

		int i_min;
		char tmp;

		for(int i = 0; i < 5; i++){
			i_min = i;
			for(int j = i; j < 5; j++){
				if(k[i_min] > k[j]){
					i_min = j;
				}
			}
			for(int j = 0; j < 5; j++){
				tmp = matrix[i][j];
				matrix[i][j] = matrix[i_min][j];
				matrix[i_min][j] = tmp;
			}
			k[i_min] = k[i];
			k[i] = i;
		}

		for(int i = 0; i < 5; i++){
			k[i] = 1;
			for(int j = 0; k2[j]!=i+1; j++)
			{
				k[i]++;
			}	
		}

		for(int i = 0; i < 5; i++){
			i_min = i;
			for(int j = i; j < 5; j++){
				if(k[i_min] > k[j]){
					i_min = j;
				}
			}
			for(int j = 0; j < 5; j++){
				tmp = matrix[j][i];
				matrix[j][i] = matrix[j][i_min];
				matrix[j][i_min] = tmp;
			}
			k[i_min] = k[i];
			k[i] = i;
		}

		char[] res = new char[25];
		for(int i = 0; i < 25; i++){
			res[i] = matrix[i/5][i%5];
		}
		return res;
	}

	char[] deencrypt(char[] str){
		char[][] matrix = new char[5][5];
		for(int i = 0; i < 25; i++){
			matrix[i/5][i%5] = str[i];
		}

		int i_min;
		char tmp;

		for(int i = 0; i < 5; i++){
			i_min = i;
			for(int j = i; j < 5; j++){
				if(k1[i_min] > k1[j]){
					i_min = j;
				}
			}
			for(int j = 0; j < 5; j++){
				tmp = matrix[i][j];
				matrix[i][j] = matrix[i_min][j];
				matrix[i_min][j] = tmp;
			}
			k1[i_min] = k1[i];
			k1[i] = i;
		}

		for(int i = 0; i < 5; i++){
			i_min = i;
			for(int j = i; j < 5; j++){
				if(k2[i_min] > k2[j]){
					i_min = j;
				}
			}
			for(int j = 0; j < 5; j++){
				tmp = matrix[j][i];
				matrix[j][i] = matrix[j][i_min];
				matrix[j][i_min] = tmp;
			}
			k2[i_min] = k2[i];
			k2[i] = i;
		}

		char[] res = new char[25];
		for(int i = 0; i < 25; i++){
			res[i] = matrix[i/5][i%5];
		}
		return res;
	}
}
