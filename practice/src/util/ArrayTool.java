package util;
/**
 * 数组工具类
 * @author Administrator
 *
 */
public class ArrayTool {

	private ArrayTool(){
		
	}
	public static void main(String[] args) {
		int arr[] = {1,5,6,7,9,0,2};
		printArray(arr);
		sort(arr);
		printArray(arr);
//		System.out.println(getMax(arr));
	}
	//获取整型数组的最大值
	public static int getMax(int arrs[]){
		int num = arrs[0];
		for (int i = 0; i < arrs.length - 1; i++) {
			if(num < arrs[i]){
				num = arrs[i];
			}
		}
		 
		return num;
	}
	
	//对数组进行选择排序
	public static void sort(int[] arrs){
		for (int i = 0; i < arrs.length - 1; i++) {
			int index = i;
			int num = arrs[i];
			for (int j = i + 1; j < arrs.length; j++) {
				if(num > arrs[j]){
					index = j;
					num = arrs[j];		
				}
			}
			if(index != i){
				swap(arrs, i, index);
			}
		}
	}
	
	/**
	 * 数组排序互换位置
	 * @param arrs
	 * @param i
	 * @param index
	 */
	private static void swap(int[] arrs, int i, int index) {
		int temp = arrs[index];
		arrs[index] = arrs[i];
		arrs[i] = temp;
		
	}
	//获得指定的元素在有序数组中的位置
	public static int getLoactionByOrder(int[] arrs, int params){
		int min,max,mid;
		min = 0;
		max = arrs.length - 1;
		mid = (max + min)/2;
		
		while(arrs[mid] != params){
			if(arrs[mid] < params){
				min = mid + 1;
			}else if(arrs[mid] > params){
				max = mid - 1;
			}else{
				return -1;
			}
			mid = (max + min)/2;
		}
		return mid;
	}
	
	//获得指定的元素在无序数组中的位置
	public static int getLoactionByDisOrder(int[] arrs, int key){
		for (int i = 0; i < arrs.length; i++) {
			if(arrs[i] == key){
				return i;
			}
		}
		return -1;
	}
	
	//将int类型的数组转成字符串
	public static void printArray(int[] arrs){
		System.out.print("[");
		for (int i = 0; i < arrs.length; i++) {
			if(i == arrs.length-1){
				System.out.println(arrs[i] + "]");
			}else{
				System.out.print(arrs[i] + " ,");
			}
		}
	}
}
