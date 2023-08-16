//import java.util.ArrayList;
//import java.util.List;
//
class HomeWorkAlgoritm {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 2, 4, 5, 5, 1, 4, 3, 6, 7};
         HomeWork.sort(arr);

        printArray(arr);

    }
    private static int binariSearch(int[] array, int search){
        return binariSearch(array, 0,array.length, search);
    }

    /**
     * метод поиска индекса элемента в массиве
     * @param array отсортированный массив
     * @param startPos первый элемент массива
     * @param endPos последний элемент массива
     * @param search элемент индекс которого ищем
     * @return возвращает индекс искомого элемента
     */
    public static int binariSearch(int[] array, int startPos, int endPos, int search){
        int pivot;
        if (startPos > endPos){
            return -1;
        } else {
             pivot = (endPos - startPos) / 2 + startPos;
        }
        if (array[pivot] < search){
           return binariSearch(array,pivot+1, endPos, search);
        } else {
            if (search < array[pivot]) {
                return binariSearch(array, startPos, pivot - 1, search);
            }
            else {
                return pivot;
            }
        }

    }
    public static void quikSort(int[] array){
        quikSort(array,0,array.length - 1);
    }
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }

    /**
     * быстрая сортировка массива
     * @param array исходный массив
     * @param startPos начало массива
     * @param endPos последний элемент массива
     */
    public static void quikSort(int[] array, int startPos, int endPos){
        int pivot = array[(startPos + endPos) / 2];
        int left = startPos;
        int rigth = endPos;
        while (left <= rigth){
            while (array[left] < pivot){
                left++;
            }
            while (array[rigth] > pivot){
                rigth--;
            }
            if (left <= rigth){
                if (left < rigth){
                    int temp = array[left];
                    array[left] = array[rigth];
                    array[rigth] = temp;
                }
                left++;
                rigth--;
            }
        }
        if (left < endPos){
            quikSort(array, left, endPos);
        }
        if (rigth > startPos){
            quikSort(array,startPos, rigth);
        }


  }
}

