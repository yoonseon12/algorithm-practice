package greedy.씨름선수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 씨름선수 {
    static BufferedReader br;
    static List<Person> persons;
    static int N, count;
    static int maxWeight = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        persons = new ArrayList<>();
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            persons.add(new Person(height, weight));
        }

        Collections.sort(persons);

        for (Person person : persons) {
            if (person.weight > maxWeight) {
                maxWeight = person.weight;
                count ++;
            }
        }

        System.out.println(count);
    }

    static class Person implements Comparable<Person> {
        public int height;
        public int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Person o) {
            return Integer.compare(o.height, this.height);
        }
    }
}
