double getValueByNumber(int n){
return 1/Math.pow(n+1,2);
}
int n = 10;
double[] array = new double[n];
for(int i = 0; i < n; i++){
array[i] = getValueByNumber(i+1);
}
for(double element : array){
System.out.println(element);
}
double eps = 0.02;
System.out.println(getMinByEps(eps, array))
System.out.println(getMinByEps(eps, array))
int getMinByEps(double eps, double[] array){
for(int i = 0; i < array.length; i++){
if(array[i]<eps)return i;
}
return array.length - 1;
}
System.out.println(getMinByEps(eps, array))