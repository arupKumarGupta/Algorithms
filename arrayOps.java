import java.util.Scanner;
class ArrayStructures {
   public int[] theArray = new int[50];
   private int arraySize = 10;
   public void generateRandomArray(){
       for(int i = 0; i < arraySize; i++){
           theArray[i] = (int)(Math.random()*10)+10;
       }
   }

   public void init(){
    for (int i=0; i<6;i++) {
        theArray[i] = new Scanner(System.in).nextInt();
    }
   }

   public void printArray(){
       System.out.println("----------");
       for(int i = 0; i < arraySize; i++){
           System.out.print("| " + i + " | ");
          System.out.println(theArray[i] + " |");
           System.out.println("----------");
       }
   }
public void swapValues(int indexOne, int indexTwo){
            int temp = theArray[indexOne];
            theArray[indexOne] = theArray[indexTwo];
            theArray[indexTwo] = temp;
        }
    public void bubbleSort(){
        for (int i = arraySize - 1; i > 1; --i) {
            for (int j = 0; j<i;++j ) {
                if(theArray[j] > theArray[j+1]){
                    swapValues(j,j+1);
                }
            }
        }
    }

    public void selectionSort(){
        for (int i=0; i<arraySize; i++) {
            int min = i;
            for (int j=i; j<arraySize; j++) {
                if(theArray[min] >= theArray[j]){
                    min = j;
                }

            }
            swapValues(i,min);

        }
    printArray();
    }

    public void insertionSort(){
        for (int i=1; i<arraySize; i++) {
            int j = i;
            int toInsert = theArray[i];
            while((j > 0) && (theArray[j-1] > toInsert)){
                theArray[j] = theArray[j-1];
                j--;
            }
            theArray[j] = toInsert;
        }

        printArray();
    }

    public void partitionArray(int pivot){
        int leftPointer = -1;
        int rightPointer = arraySize;
        while(true){
            while(leftPointer < arraySize-1 && theArray[++leftPointer] < pivot);
            while(rightPointer > 0 && theArray[--rightPointer] > pivot);
            if(leftPointer >= rightPointer)
                break;
            else{
                swapValues(leftPointer,rightPointer);
            }

        }
        printArray();
    }

   public static void main(String[] args) {
       ArrayStructures arr = new ArrayStructures();
        arr.generateRandomArray();
        //arr.bubbleSort();
        arr.init();
        arr.printArray();
        System.out.println();
        System.out.println();
        //arr.selectionSort();
        arr.partitionArray(arr.theArray[0]);
   }
}