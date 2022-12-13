package com.search.jspsearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class CsvReader {
    public static void recipiemap(HashMap<String,ArrayList<Integer>> map){
        String path = "src/data/food.csv";
        String line ="";

        try  {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line=br.readLine())!=null){

                String [] arr = line.split(",");

                int k= Integer.parseInt(arr[0]);
                String [] arr2= arr[1].split(" ");
                for(String str : arr2){
                    str=str.toLowerCase();
                    if(!map.containsKey(str)) {
                        map.put(str, new ArrayList<Integer>());
                        ArrayList<Integer> li = map.get(str);
                        li.add(k);
                        map.put(str,li);
                    }
                    else
                    {
                        ArrayList<Integer> li = map.get(str);
                        li.add(k);
                        map.put(str,li);
                    }
                }

            }


        }
        catch (IOException e){
            e.printStackTrace();

        }





    }
    public static  void ingredientmap(HashMap<String,ArrayList<Integer>> map){
        String path = "src/data/food.csv";
        String line ="";

        try  {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line=br.readLine())!=null){

                String [] arr = line.split(",");
                // System.out.println("line no "+arr[0]+" size of an array "+ arr.length );
                int i= 3;
                int k= Integer.parseInt(arr[0]);
                while(i< arr.length){
                    String[] arr2 = arr[i++].split(" ");
                    for (String str : arr2) {
                        str = str.toLowerCase();
                        if (!map.containsKey(str)) {
                            map.put(str, new ArrayList<Integer>());
                            ArrayList<Integer> li = map.get(str);
                            li.add(k);
                            map.put(str, li);
                        } else {
                            ArrayList<Integer> li = map.get(str);
                            li.add(k);
                            map.put(str, li);
                        }
                    }
                }

            }


        }
        catch (IOException e){
            e.printStackTrace();

        }

    }
    public static  void displayresult(HashMap<Integer,Integer> result,HashMap<Integer,String>linkmap,ArrayList<String> li){

        for (int i:result.keySet()){
            System.out.println(linkmap.get(i));
            li.add(linkmap.get(i));

        }




    }
    public static HashMap<Integer,Integer> runsearch(HashMap<String,ArrayList<Integer>> Rmap,HashMap<String,ArrayList<Integer>> Imap,String search){

        Scanner in = new Scanner(System.in);
        System.out.println("what would you like to make today");

        search = search.toLowerCase();
        String[] searcharr = search.split(" ");
        HashMap<Integer, Integer> invertedindex = new HashMap<>();

        for (String strsearch : searcharr
        ) {
            if (Imap.containsKey(strsearch)) {
                for (int i : Imap.get(strsearch)
                ) {
                    if (!invertedindex.containsKey(i)) {
                        invertedindex.put(i, 5);
                    } else {
                        invertedindex.put(i, (invertedindex.get(i) + 2));
                    }

                }

            }
            if (Rmap.containsKey(strsearch)) {
                for (int i : Rmap.get(strsearch)
                ) {
                    if (!invertedindex.containsKey(i)) {
                        invertedindex.put(i, 10);
                    } else {
                        invertedindex.put(i, (invertedindex.get(i) + 5));
                    }

                }

            }


        }
        return invertedindex;
    }

    public static HashMap<Integer, Integer> sortByscore(HashMap<Integer, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer> > list =
                new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2)



            {
                if(o2.getValue()==o1.getValue()){
                    return (o1.getKey()).compareTo(o2.getKey());
                }
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public  static void createlinkhashmap(HashMap<Integer,String>map){
        String path = "src/data/food.csv";
        String line ="";

        try  {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line=br.readLine())!=null){

                String [] arr = line.split(",");

                int k= Integer.parseInt(arr[0]);
                String name= arr[1];

                String link= arr[2];
                // System.out.println(link);
                String resultantlis= name+" "+link;
                map.put(k,resultantlis);



            }


        }
        catch (IOException e){
            e.printStackTrace();

        }


    }




    public static ArrayList<String> hitquery(String str) {
        HashMap<String,ArrayList<Integer>> Rmap = new HashMap<>();//an empty map object for recipe name
        HashMap<String,ArrayList<Integer>> Imap = new HashMap<>();//an empty map object for Ingredients


        recipiemap(Rmap); //calling of method to create inverted index for Rmap


        ingredientmap(Imap); //calling of method to create inverted index for Imap

        // Scanner in = new Scanner(System.in);
        System.out.println("what would you like to make today");
        // String str = in.nextLine(); //will take the serach string from the user


        HashMap<Integer,Integer> result; // declaration for result map
        result = runsearch(Rmap,Imap,str);

        System.out.println("result status for query " + str );
        for (int i:result.keySet()
        ) {
            System.out.println(" key = "+ i+" score = " + result.get(i));

        }

        result=sortByscore(result);
        ArrayList<String> li = new ArrayList<>();
        System.out.println("----------------------");
        for (int i:result.keySet()
        ) {
            System.out.println(" key = "+ i+" score = " + result.get(i));


        }
        HashMap<Integer,String>linkmap=new HashMap<>();
        createlinkhashmap(linkmap);

        displayresult(result,linkmap ,li);
        return li;
    }
}
