1. **What do you mean by Multithreading? Why is it important?**
   **Ans:** Multithreading refers to the ability of a CPU to execute multiple threads concurrently, sharing the same process resources. It is a significant feature of Java that allows the simultaneous execution of multiple threads, thereby utilizing the CPU time more efficiently. Multithreading enables the subdivision of a program into two or more threads, making execution faster and easier.

2. **What are the benefits of using Multithreading?**
   **Ans:** The benefits of multithreading include:
   - Allows the program to run continuously even if a part is blocked.
   - Improves performance compared to traditional parallel programs that use multiple processes.
   - Facilitates writing effective programs that utilize maximum CPU time.
   - Enhances the responsiveness of complex applications or programs.
   - Increases CPU resource utilization and reduces maintenance costs.
   - Saves time and supports parallel task execution.
   - If an exception occurs in one thread, it does not affect other threads as they are independent.
   - Less resource-intensive than executing multiple processes simultaneously.

3. **What is a Thread in Java?**
   **Ans:** Threads are lightweight and the smallest units of processing that can be managed independently by a scheduler. They allow a program to execute different parts concurrently. Threads share a common address space and are independent of each other, making them an efficient way to take advantage of multiple CPUs in a machine.

4. **What are the two ways of implementing a thread in Java?**
   **Ans:** There are two primary ways to implement a thread in Java:
   
   **Extending the Thread class:**
   ```java
   class MultithreadingDemo extends Thread {
       public void run() {
           System.out.println("My thread is in running state.");
       }

       public static void main(String[] args) {
           MultithreadingDemo obj = new MultithreadingDemo();
           obj.start();
       }
   }
   ```
   **Output:**
   ```
   My thread is in running state.
   ```

   **Implementing the Runnable interface:**
   ```java
   class MultithreadingDemo implements Runnable {
       public void run() {
           System.out.println("My thread is in running state.");
       }

       public static void main(String[] args) {
           MultithreadingDemo obj = new MultithreadingDemo();
           Thread thread = new Thread(obj);
           thread.start();
       }
   }
   ```
   **Output:**
   ```
   My thread is in running state.
   ```

5. **What's the difference between a thread and a process?**
   **Ans:** 
   - **Thread:** It is the smallest unit of a process that can execute different parts of a program simultaneously.
   - **Process:** It refers to a program in execution, i.e., an active program managed by the Process Control Block (PCB).

6. **How can we create daemon threads?**
   **Ans:** Daemon threads in Java can be created using the `setDaemon(true)` method of the `Thread` class. The `isDaemon()` method checks whether the current thread is a daemon. If the thread is a daemon, it returns `true`; otherwise, it returns `false`.

   **Example:**
   ```java
   public class DaemonThread extends Thread {
       public DaemonThread(String name) {
           super(name);
       }

       public void run() {
           if (Thread.currentThread().isDaemon()) {
               System.out.println(getName() + " is a Daemon thread");
           } else {
               System.out.println(getName() + " is a User thread");
           }
       }

       public static void main(String[] args) {
           DaemonThread t1 = new DaemonThread("t1");
           DaemonThread t2 = new DaemonThread("t2");
           DaemonThread t3 = new DaemonThread("t3");

           t1.setDaemon(true);

           t1.start();
           t2.start();

           t3.setDaemon(true);
           t3.start();
       }
   }
   ```
   **Output:**
   ```
   t1 is a Daemon thread
   t3 is a Daemon thread
   t2 is a User thread
   ```

7. **What are the wait() and sleep() methods?**
   **Ans:**
   - **wait():** It is a non-static method that causes the current thread to wait until another thread calls `notify()` or `notifyAll()` on the object's monitor (lock). It releases the lock and is primarily used for inter-thread communication. It is defined in the `Object` class and should be called from a synchronized context.
     **Example:**
     ```java
     synchronized (monitor) {
         monitor.wait(); // Lock is released by the current thread
     }
     ```

   - **sleep():** It is a static method that pauses the execution of the current thread for a specified period. It does not release the lock while waiting and is mainly used to introduce a pause in execution. It is defined in the `Thread` class and does not need to be called from a synchronized context.
     **Example:**
     ```java
     synchronized (monitor) {
         Thread.sleep(1000); // Lock is held by the current thread
     }
     ```
     The current thread will wake up after the specified period or if interrupted by calling the `interrupt()` method.
```