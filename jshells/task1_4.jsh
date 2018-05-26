getMax(a)
getMax(b)
getMax(a)
double[] a = {-4, 4, 74.32, -45.7, 22};
getMax(a)
double[] b = {1};
double getMax(double[] array){
double max = Double.MIN_VALUE;
if(array.length>1){
for(int i = 0; i < array.length - 1; i++){
if(max < a[i] + a[i+1]) max = a[i] + a[i+1];
}
}
return max;
}
getMax(b)
getMax(a)
System.out.println(getMax(a))