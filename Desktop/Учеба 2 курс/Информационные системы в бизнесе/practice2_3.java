import java.util.ArrayList;
public class practice2_3 {
    public static void main(String[] args){
        int[] array = new int[] {1, 2, 3, 5, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 22, 23, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40};

        ArrayList<String> res = new ArrayList<>();

        int ind1 = 0;
        int ind2 = 1;
        Boolean buildingIsOpen = false;

        while (ind2 < array.length){
            
            if (!buildingIsOpen && (array[ind2] - array[ind1]) == 1){
                res.add(String.valueOf(array[ind1]));
                res.add("-");
                res.add(String.valueOf(array[ind2]));
                buildingIsOpen = true;
            } else if (buildingIsOpen){
                if ((array[ind2] - array[ind1]) == 1){
                    if (res.get(res.size() - 1) == "-"){
                        res.add(String.valueOf(array[ind2]));
                    } else {
                        res.set(res.size() - 1, String.valueOf(array[ind2]));
                    }
                } else{
                    res.set(res.size() - 1, String.valueOf(array[ind1]));
                    res.add(", ");
                    buildingIsOpen = false;
                    
                    if (ind2 == (array.length - 1)){
                        res.add(String.valueOf(array[ind2]));
                    }
                    ind1++;
                    ind2++;
                    continue;
                }   
            }
            if (!buildingIsOpen && (array[ind2] - array[ind1]) > 1){
                System.out.println(res.get(res.size() - 2) + " " + String.valueOf(array[ind1]));
                if (String.valueOf(array[ind1]) != res.get(res.size() - 2)){
                    res.add(String.valueOf(array[ind1]));
                    res.add(", ");
                }
            } 
            

            ind1++;
            ind2++;
        }
        System.out.println(res);

        for (String elem : res){
            System.out.print(elem);
        }
        System.out.println();
    }
}
