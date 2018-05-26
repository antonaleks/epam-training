double getFunctionValue(double x){
return Math.tan(2*x)-3;
}
double a = 2;
double b = 5;
double h = 0.1;
getTable(a, b, h)
getTable(a, b, h)
(b-a)/h
getTable(a, b, h)
double[][] getTable(double a, double b, double h){
int n = (int)((b-a)/h);
double[][] table = new double[2][n];
double x = a;
for(int i = 0; i < n; i++){
table[0][i] = x;
table[1][i] = getFunctionValue(x);
x+=h;
}
return table;
}
getTable(a, b, h)
void printTable(double[][] table){
System.out.println("x\ty");
for(int i = 0; i < table[0].length; i++){
System.out.println(table[0][i]+"\t"+table[1][i]);
}
}
printTable(getTable(a,b,h))