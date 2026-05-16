import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.time.LocalTime;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.time.LocalTime;

public class ejemploScheduledFuture {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");


        // Create a ScheduledExecutorService object
        ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(2);

        // Create a Callable<String> object task that prints the time and returns the following text "end of task <<name>>"
        Callable<String> task1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                String hora = LocalTime.now().format(dtf);
                return "pool-1-thread-1: Son las "+hora;
            }
        };

        // Create a Callable<String> object task that prints the time and returns the following text "end of delayed task <<name>>"
        Callable<String> task2 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                String hora = LocalTime.now().format(dtf);
                return "pool-1-thread-2: Han pasado 2s, "+hora;
            }
        };

        // Create a list of ScheduledFuture<String>
        // Schedule both tasks with the executor
        ScheduledFuture<String> futuro1 = executor.schedule(task1, 0, TimeUnit.SECONDS);
        ScheduledFuture<String> futuro2 = executor.schedule(task2, 2, TimeUnit.SECONDS);

        // Try to get the futures

        try{
            System.out.println(futuro1.get());
        }catch (ExecutionException e) {
            e.getMessage();
        } catch (InterruptedException e) {
            e.getMessage();
        }catch(CancellationException e){
            e.getMessage();
        }finally {
            System.out.println("Fin de tarea_hora");
            executor.shutdown();
        }

        try{
            System.out.println(futuro2.get());
        }catch (ExecutionException e) {
            e.getMessage();
        } catch (InterruptedException e) {
            e.getMessage();
        }catch(CancellationException e){
            e.getMessage();
        }finally {
            System.out.println("Fin de tarea_retrasada");
            executor.shutdown();
        }

        // Shutdown the executor system
    }
}