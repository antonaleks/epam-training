for(int i = 0; i < n; i++){
for(int j = 0; j < n; j++){
if(i==j || i==(n-j))matrix[i][j]=1;
}
}
matrix[0][n-1]
matrix[0][n-2]
matrix[0][0]
int n = 50;
byte[][] matrix = new byte[n][n];
for(int i = 0; i < n; i++){
for(int j = 0; j < n; j++){
if(i==j || i==(n-j-1))matrix[i][j]=1;
}
}
matrix[0][0]
matrix[0][n-1]
matrix[0][n-2]
matrix[1][n-2]
matrix[n/2][n/2]