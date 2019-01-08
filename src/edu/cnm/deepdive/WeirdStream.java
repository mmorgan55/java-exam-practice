package edu.cnm.deepdive;

import java.util.Comparator;
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class WeirdStream {

  public static void main(String[] args) {
    IntStream.generate(new IntSupplier() {
      private Random rng;

      {
        rng = new Random(-1); // Reproducible sequence
      }

      @Override
      public int getAsInt() {
        return rng.nextInt();
      }
    })
        .limit(1000)
        .boxed()
        .sorted(new Comparator<Integer>() {
          @Override
          public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1, o2);
          }
        })
        .forEach(System.out::println);
  }

}
