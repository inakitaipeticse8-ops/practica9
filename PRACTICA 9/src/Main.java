import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static boolean isPalindrome(int number) {
        String str = Integer.toString(number);
        int str_len = str.length();

        for (int i = 0; i < str_len / 2; i++) {
            if (str.charAt(i) != str.charAt(str_len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        //Cada hilo (de los 10 total) se encarga de MAX_RANGE de forma paralela con ThreadPool
        /*
        Cada hilo ejecutará una tarea Callable<List<Integer>> que buscará en su sublista los
        palíndromos, haciendo uso de una función que encontraréis dentro del propio fichero.
         */
        //La sublista de cada hilo sera MAX_RANGE/10

        final int MAX_RANGE = 1000000;
        final int NUM_THREADS = 10;
        long time_ini = System.currentTimeMillis();
        long time_end;
        List<Integer> list = IntStream.rangeClosed(1, MAX_RANGE).boxed().collect(Collectors.toList());
        // Create an executor with NUM_THREADS threads
        ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(NUM_THREADS);

        // Execute each thread with a sublist of integers inside a loop and get the futures
        //La lista que devolvera sera de aquellos que si cumplan la condicion del boolean
        Callable<List<Integer>> task1 = new Callable<List<Integer>>() {
            @Override
            public List<Integer> call() throws Exception {
                List<Integer> listaValores1 = new ArrayList<>();
                for (int i = 1; i <= 100000; i++) {
                    listaValores1.add(i);
                }
                List<Integer> listaResult1 = new ArrayList<Integer>();
                Iterator<Integer> iterator = listaValores1.iterator();
                while(iterator.hasNext()){
                    int number = iterator.next();
                    if(isPalindrome(number)){
                        listaResult1.add(number);
                    }
                }
                return listaResult1;
            }
        };
        Callable<List<Integer>> task2 = new Callable<List<Integer>>() {
            @Override
            public List<Integer> call() throws Exception {
                List<Integer> listaValores2 = new ArrayList<>();
                for (int i = 100000; i <= 200000; i++) {
                    listaValores2.add(i);
                }
                List<Integer> listaResult2 = new ArrayList<Integer>();
                Iterator<Integer> iterator = listaValores2.iterator();
                while(iterator.hasNext()){
                    int number = iterator.next();
                    if(isPalindrome(number)){
                        listaResult2.add(number);
                    }
                }
                return listaResult2;
            }
        };
        Callable<List<Integer>> task3 = new Callable<List<Integer>>() {
            @Override
            public List<Integer> call() throws Exception {
                List<Integer> listaValores3 = new ArrayList<>();
                for (int i = 200000; i <= 300000; i++) {
                    listaValores3.add(i);
                }
                List<Integer> listaResult3 = new ArrayList<Integer>();
                Iterator<Integer> iterator = listaValores3.iterator();
                while(iterator.hasNext()){
                    int number = iterator.next();
                    if(isPalindrome(number)){
                        listaResult3.add(number);
                    }
                }
                return listaResult3;
            }
        };
        Callable<List<Integer>> task4 = new Callable<List<Integer>>() {
            @Override
            public List<Integer> call() throws Exception {
                List<Integer> listaValores4 = new ArrayList<>();
                for (int i = 300000; i <= 400000; i++) {
                    listaValores4.add(i);
                }
                List<Integer> listaResult4 = new ArrayList<Integer>();
                Iterator<Integer> iterator = listaValores4.iterator();
                while(iterator.hasNext()){
                    int number = iterator.next();
                    if(isPalindrome(number)){
                        listaResult4.add(number);
                    }
                }
                return listaResult4;
            }
        };
        Callable<List<Integer>> task5 = new Callable<List<Integer>>() {
            @Override
            public List<Integer> call() throws Exception {
                List<Integer> listaValores5 = new ArrayList<>();
                for (int i = 400000; i <= 500000; i++) {
                    listaValores5.add(i);
                }
                List<Integer> listaResult5 = new ArrayList<Integer>();
                Iterator<Integer> iterator = listaValores5.iterator();
                while(iterator.hasNext()){
                    int number = iterator.next();
                    if(isPalindrome(number)){
                        listaResult5.add(number);
                    }
                }
                return listaResult5;
            }
        };
        Callable<List<Integer>> task6 = new Callable<List<Integer>>() {
            @Override
            public List<Integer> call() throws Exception {
                List<Integer> listaValores6 = new ArrayList<>();
                for (int i = 500000; i <= 600000; i++) {
                    listaValores6.add(i);
                }
                List<Integer> listaResult6 = new ArrayList<Integer>();
                Iterator<Integer> iterator = listaValores6.iterator();
                while(iterator.hasNext()){
                    int number = iterator.next();
                    if(isPalindrome(number)){
                        listaResult6.add(number);
                    }
                }
                return listaResult6;
            }
        };
        Callable<List<Integer>> task7 = new Callable<List<Integer>>() {
            @Override
            public List<Integer> call() throws Exception {
                List<Integer> listaValores7 = new ArrayList<>();
                for (int i = 600000; i <= 700000; i++) {
                    listaValores7.add(i);
                }
                List<Integer> listaResult7 = new ArrayList<Integer>();
                Iterator<Integer> iterator = listaValores7.iterator();
                while(iterator.hasNext()){
                    int number = iterator.next();
                    if(isPalindrome(number)){
                        listaResult7.add(number);
                    }
                }
                return listaResult7;
            }
        };
        Callable<List<Integer>> task8 = new Callable<List<Integer>>() {
            @Override
            public List<Integer> call() throws Exception {
                List<Integer> listaValores8 = new ArrayList<>();
                for (int i = 700000; i <= 800000; i++) {
                    listaValores8.add(i);
                }
                List<Integer> listaResult8 = new ArrayList<Integer>();
                Iterator<Integer> iterator = listaValores8.iterator();
                while(iterator.hasNext()){
                    int number = iterator.next();
                    if(isPalindrome(number)){
                        listaResult8.add(number);
                    }
                }
                return listaResult8;
            }
        };
        Callable<List<Integer>> task9 = new Callable<List<Integer>>() {
            @Override
            public List<Integer> call() throws Exception {
                List<Integer> listaValores9 = new ArrayList<>();
                for (int i = 800000; i <= 900000; i++) {
                    listaValores9.add(i);
                }
                List<Integer> listaResult9 = new ArrayList<Integer>();
                Iterator<Integer> iterator = listaValores9.iterator();
                while(iterator.hasNext()){
                    int number = iterator.next();
                    if(isPalindrome(number)){
                        listaResult9.add(number);
                    }
                }
                return listaResult9;
            }
        };
        Callable<List<Integer>> task10 = new Callable<List<Integer>>() {
            @Override
            public List<Integer> call() throws Exception {
                List<Integer> listaValores10 = new ArrayList<>();
                for (int i = 900000; i <= 1000000; i++) {
                    listaValores10.add(i);
                }
                List<Integer> listaResult10 = new ArrayList<Integer>();
                Iterator<Integer> iterator = listaValores10.iterator();
                while(iterator.hasNext()){
                    int number = iterator.next();
                    if(isPalindrome(number)){
                        listaResult10.add(number);
                    }
                }
                return listaResult10;
            }
        };

        ScheduledFuture<List<Integer>> futuro1 = executor.schedule(task1, 0, TimeUnit.SECONDS);
        ScheduledFuture<List<Integer>> futuro2 = executor.schedule(task2, 0, TimeUnit.SECONDS);
        ScheduledFuture<List<Integer>> futuro3 = executor.schedule(task3, 0, TimeUnit.SECONDS);
        ScheduledFuture<List<Integer>> futuro4 = executor.schedule(task4, 0, TimeUnit.SECONDS);
        ScheduledFuture<List<Integer>> futuro5 = executor.schedule(task5, 0, TimeUnit.SECONDS);
        ScheduledFuture<List<Integer>> futuro6 = executor.schedule(task6, 0, TimeUnit.SECONDS);
        ScheduledFuture<List<Integer>> futuro7 = executor.schedule(task7, 0, TimeUnit.SECONDS);
        ScheduledFuture<List<Integer>> futuro8 = executor.schedule(task8, 0, TimeUnit.SECONDS);
        ScheduledFuture<List<Integer>> futuro9 = executor.schedule(task9, 0, TimeUnit.SECONDS);
        ScheduledFuture<List<Integer>> futuro10 = executor.schedule(task10, 0, TimeUnit.SECONDS);

        // Get the results from the futures and print them

        int num1=0;
        int num2=0;
        int num3=0;
        int num4=0;
        int num5=0;
        int num6=0;
        int num7=0;
        int num8=0;
        int num9=0;
        int num10=0;


        try{
            Iterator<Integer> iterator = futuro1.get().iterator();
            System.out.print("[");
            while(iterator.hasNext()){
                num1++;
                System.out.print(iterator.next()+", ");
            }
        }catch(ExecutionException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        try{
            Iterator<Integer> iterator = futuro2.get().iterator();
            System.out.print("\n[");
            while(iterator.hasNext()){
                num2++;
                System.out.print(iterator.next()+", ");
            }
        }catch(ExecutionException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        try{
            Iterator<Integer> iterator = futuro3.get().iterator();
            System.out.print("\n[");
            while(iterator.hasNext()){
                num3++;
                System.out.print(iterator.next()+", ");
            }
        }catch(ExecutionException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        try{
            Iterator<Integer> iterator = futuro4.get().iterator();
            System.out.print("\n[");
            while(iterator.hasNext()){
                num4++;
                System.out.print(iterator.next()+", ");
            }
        }catch(ExecutionException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        try{
            Iterator<Integer> iterator = futuro5.get().iterator();
            System.out.print("\n[");
            while(iterator.hasNext()){
                num5++;
                System.out.print(iterator.next()+", ");
            }
        }catch(ExecutionException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        try{
            Iterator<Integer> iterator = futuro6.get().iterator();
            System.out.print("\n[");
            while(iterator.hasNext()){
                num6++;
                System.out.print(iterator.next()+", ");
            }
        }catch(ExecutionException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        try{
            Iterator<Integer> iterator = futuro7.get().iterator();
            System.out.print("\n[");
            while(iterator.hasNext()){
                num7++;
                System.out.print(iterator.next()+", ");
            }
        }catch(ExecutionException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        try{
            Iterator<Integer> iterator = futuro8.get().iterator();
            System.out.print("\n[");
            while(iterator.hasNext()){
                num8++;
                System.out.print(iterator.next()+", ");
            }
        }catch(ExecutionException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        try{
            Iterator<Integer> iterator = futuro9.get().iterator();
            System.out.print("\n[");
            while(iterator.hasNext()){
                num9++;
                System.out.print(iterator.next()+", ");
            }
        }catch(ExecutionException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        try{
            Iterator<Integer> iterator = futuro10.get().iterator();
            System.out.print("\n[");
            while(iterator.hasNext()){
                num10++;
                System.out.print(iterator.next()+", ");
            }
            System.out.println();
        }catch(ExecutionException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        // Shutdown the executor
        executor.shutdown();

        time_end = System.currentTimeMillis();
        System.out.println("El tiempo que ha tardado es: "+(time_end-time_ini)+" milisegundos.");
        int numTotal = num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8 + num9 + num10;
        System.out.println("Hay un total de "+numTotal);
    }
}
