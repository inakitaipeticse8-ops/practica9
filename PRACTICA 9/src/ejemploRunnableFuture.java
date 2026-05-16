import java.util.concurrent.*;
public class ejemploRunnableFuture {
    public static void main(String[] args) {
        Runnable tarea = () ->{
            try{
                System.out.println(Thread.currentThread().getName()+": ejecutando tarea runnable...");
                Thread.sleep(3000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName()+": ...fin de la tarea runnable");
            }
        };

        // FIRST PART: RunnableFuture with Thread
        //En la primera, vais a ejecutar un FutureTask con un hilo de la clase Thread

        // Create a FutureTask with the previous Runnable task
        FutureTask<String> futureTask1 = new FutureTask<String>(tarea, "fin tarea 1");
        // Create a thread with the previous FutureTask
        Thread hilo1 = new Thread(futureTask1, "Thread-0");
        System.out.println(Thread.currentThread().getName()+": lanzando tarea 1 en hilo");
        // Execute the thread
        hilo1.start();

        // SECOND PART: RunnableFuture with the main thread
        //En la segunda, será el propio hilo principal el que ejecute otro FutureTask mediante el método run.

        // Create a second FutureTask with the Runnable task
        FutureTask<String> futureTask2 = new FutureTask<String>(tarea, "fin tarea 2");
        System.out.println(Thread.currentThread().getName()+": ejecutando tarea 2");
        // Execute the futureTask
        futureTask2.run();
        // print the thread name and the result of the future
        try{
            System.out.println(Thread.currentThread().getName()+": "+futureTask1.get());
        }catch(InterruptedException e){
            e.printStackTrace();
        }catch(ExecutionException e){
            e.printStackTrace();
        }
        try{
            System.out.println(Thread.currentThread().getName()+": "+futureTask2.get());
        }catch(InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }

        // THIRD PART: RunnableFuture with executor
        //Por último, crearéis un ExecutorService para ejecutar un tercer FutureTask.

        // Create an executor with the method Executors.newSingleThreadExecutor()
        // Executes a third futuretask
        // Get the result of the future
        // Don't forget shutdown the executor
        ExecutorService executor = Executors.newSingleThreadExecutor();
        FutureTask<String> futureTask3 = new FutureTask<String>(tarea, "fin tarea 3");
        executor.execute(futureTask3);
        try{
            System.out.println(Thread.currentThread().getName()+": "+futureTask3.get());
        }catch(InterruptedException e){
            e.printStackTrace();
        }catch(ExecutionException e){
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }
    }
}