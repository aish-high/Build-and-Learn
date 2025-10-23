package Coding.Queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer{

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> bq = new LinkedBlockingQueue<>();
        Producer p = new Producer(bq);
        Consumer c = new Consumer(bq);
        Thread t1 = new Thread(() ->{
            try{
                for(int i=0; i<5; i++){
                    Thread.sleep(1000);
                    p.produce(i);}}
            catch(InterruptedException e){
                e.printStackTrace();
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            try{
                for(int i=0; i<5; i++){
                    Thread.sleep(2000);
                    c.consume();
                }
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        });
        t2.start();
    }
}

class Producer{
    BlockingQueue<Integer> bq;

    Producer(BlockingQueue<Integer> bq){
        this.bq = bq;
    }

    public void produce(int value){
        bq.offer(value);
    }
}

class Consumer{
    BlockingQueue<Integer> bq;

    Consumer(BlockingQueue<Integer> bq){
        this.bq = bq;
    }

    public void consume() throws InterruptedException{
        System.out.println(bq.take());
    }
}
