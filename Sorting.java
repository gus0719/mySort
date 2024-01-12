package classes;
import java.util.Scanner;
class Sort{
    public void push(int[] arr, int idx1, int idx2){
        arr[idx2] = arr[idx1];
    }
    public void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
    public void bubble(int[] arr){
        System.out.println("-----버블정렬-----");
        for(int idx = 0; idx < arr.length-1; idx++){
            for(int bIdx = idx+1; bIdx < arr.length; bIdx++){
                if(arr[idx] > arr[bIdx]){
                    swap(arr, idx, bIdx);
                }
            }
        }
    }
    public void select(int[] arr){
        System.out.println("-----선택정렬-----");
        for(int outerIdx = 0; outerIdx < arr.length-1; outerIdx++){
            for(int innerIdx = outerIdx+1; innerIdx < arr.length; innerIdx++){
                if(arr[outerIdx] > arr[innerIdx]){
                    swap(arr, outerIdx, innerIdx);
                }
            }
        }
    }
    public void insert(int[] arr){
        System.out.println("-----삽입정렬-----");
        for(int idx = 1; idx < arr.length; idx++){
            int temp = arr[idx];
            int fIdx = idx-1;
            while(fIdx >= 0 && temp < arr[fIdx]){
                push(arr, fIdx, fIdx+1);
                fIdx--;
            }
            arr[fIdx+1] = temp;
        }
    }
    public void show(int[] arr){
        for(int idx = 0; idx < arr.length; idx++){
            System.out.printf("%d\t", arr[idx]);
        }
    }
}
class Sorting{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sort obj = new Sort();
        System.out.println("--원하는 정렬 입력--");
        System.out.print("보기 >> [bubble\tselect\tinsert]\n");
        String sCommand = sc.nextLine();
        boolean name = true;
        System.out.print("배열 길이 입력하세요: ");
        int arrLen = sc.nextInt();
        int[] arr = new int[arrLen];
        for(int idx = 0; idx < arr.length; idx++){
            System.out.printf("%d번째 인덱스: ", idx);
            arr[idx] = sc.nextInt();
        }
        switch(sCommand){
            case "bubble":
                obj.bubble(arr);
                obj.show(arr);
                break;
            case "select":
                obj.select(arr);
                obj.show(arr);
                break;
            case "insert":
                obj.insert(arr);
                obj.show(arr);
                break;
            default:
                System.out.println("그런 정렬은 없음.");
                name = false;
                break;
        }
    }
}