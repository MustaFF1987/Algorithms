package Algorithms_lesson4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizeQueue {

    // Class for the home-task
    public class RandomizedQueue<Item> implements Iterable<Item> {

        private Item[] itemArray;
        private int numberOfItems;
        private int realNumberOfItems;

        public RandomizedQueue() {
            this.itemArray = (Item[]) new Object[0];
            this.numberOfItems = 0;
            this.realNumberOfItems = 0;
        }

        public void enqueue(Item item) {
            if (item == null) throw new NullPointerException();
            if (numberOfItems == 0) resize(1);
            else if (numberOfItems == itemArray.length) resize(2 * itemArray.length);
            itemArray[numberOfItems++] = item;
            realNumberOfItems++;
        }

        public Item sample() {
            if (realNumberOfItems > 0) {
                RandomOutput randomOutput = new RandomOutput(itemArray, numberOfItems).get();
                return randomOutput.randomItem;
            } else {
                throw new NoSuchElementException();
            }
        }

        public Item dequeue() {
            if (realNumberOfItems > 0) {
                RandomOutput randomOutput = new RandomOutput(itemArray, numberOfItems).get();
                itemArray[randomOutput.randomIndex] = null;
                if (--realNumberOfItems == itemArray.length / 4) resize(itemArray.length / 2);
                return randomOutput.randomItem;
            } else {
                throw new NoSuchElementException();
            }
        }

        public boolean isEmpty() {
            return realNumberOfItems == 0;
        }

        public int size() {
            return realNumberOfItems;
        }

        public Iterator<Item> iterator() {
            return new Iterator<Item>() {
                private Item[] copy = getRandomCopy(itemArray, numberOfItems, realNumberOfItems);
                private int copyNumberOfItems = copy.length;
                @Override
                public boolean hasNext() {
                    return copyNumberOfItems > 0;
                }
                @Override
                public Item next() {
                    if (copyNumberOfItems == 0) throw new NoSuchElementException();
                    return copy[--copyNumberOfItems];
                }
            };
        }

        private Item[] getRandomCopy(Item[] itemArray, int numberOfItems, int realNumberOfItems) {
            Item[] copy = (Item[]) new Object[realNumberOfItems];
            Item[] tmpCopy = getCopy(itemArray, numberOfItems, realNumberOfItems);
            for (int i = 0; i < realNumberOfItems; i++) {
                RandomOutput randomOutput = new RandomOutput(tmpCopy, tmpCopy.length).get();
                tmpCopy[randomOutput.randomIndex] = null;
                copy[i] = randomOutput.randomItem;
                if (tmpCopy.length - i - 1 == tmpCopy.length / 2) {
                    tmpCopy = getCopy(tmpCopy, tmpCopy.length, tmpCopy.length - i - 1);
                }
            }
            return copy;
        }

        public void main(String[] args) {

            System.out.println("Test 1");
            RandomizedQueue<String> queue = new RandomizedQueue<>();
            int temp = 0;
            for (int i = 0; i < 10; i++) {
                queue.enqueue("a = " + temp++);
                System.out.println("Queue size is " + queue.size());
            }
            System.out.println("First forEach");
            queue.forEach(System.out::println);
            System.out.println("Second forEach");
            queue.forEach(System.out::println);
            System.out.println();

            for (int i = 0; i < 10; i++) {
                queue.dequeue();
                System.out.println("Queue size is " + queue.size());
            }

            System.out.println("Test 2");
            RandomizedQueue<String> queue2 = new RandomizedQueue<>();
            queue2.enqueue("one");
            queue2.forEach(System.out::println);
            queue2.dequeue();
            queue2.forEach(System.out::println);

            System.out.println("Test 3");
            RandomizedQueue<String> queue3 = new RandomizedQueue<>();
            queue3.enqueue("one");
            queue3.forEach(System.out::println);
            queue3.dequeue();
            queue3.forEach(System.out::println);
            queue3.enqueue("new two");
            queue3.enqueue("new tree");
            queue3.enqueue("new four");
            queue3.enqueue("new five");
            queue3.forEach(System.out::println);
        }

        private void resize(int newCapacity) {
            itemArray = getCopy(itemArray, numberOfItems, newCapacity);
            numberOfItems = realNumberOfItems;
        }

        private Item[] getCopy(Item[] itemArray, int numberOfItems, int newCapacity) {
            Item[] copy =  (Item[]) new Object[newCapacity];
            int j = 0;
            for (int i = 0; i < numberOfItems; i++) {
                if (itemArray[i] != null) {
                    copy[j++] = itemArray[i];
                }
            }
            return copy;
        }

        private class RandomOutput {

            private Item[] itemArray;
            private int numberOfItems;
            private Item randomItem;
            private int randomIndex;


            public RandomOutput(Item[] itemArray, int numberOfItems) {
                this.itemArray = itemArray;
                this.numberOfItems = numberOfItems;
            }

            RandomOutput get() {
                Random random = new Random();
                do {
                    randomIndex = random.nextInt(numberOfItems);
                } while (itemArray[randomIndex] == null);
                randomItem = itemArray[randomIndex];
                return this;
            }
        }
    }
}

/*
Проанализировать класс и провести оценку эффективности методов RandomizedQueue
с ростом числа элементов в очереди
асимптотическим и амортизированный анализ:
// is the randomized queue empty?
public boolean isEmpty()
просто проверяет, пуста ли очередь, и возвращает
соответствующий результат. Этот метод выполняется за постоянное время O(1),
так как не зависит от размера очереди.
// return the number of items on the randomized queue
public int size()
: возвращает текущее количество элементов в очереди.
Аналогично методу isEmpty(), этот метод также выполняется за постоянное время O(1),
так как размер очереди поддерживается внутренней переменной.
// add the item
public void enqueue(Item item)
Метод enqueue(Item item):
Он добавляет элемент в очередь.
Для анализа этого метода, нам нужно рассмотреть два аспекта: добавление элемента в очередь и увеличение размера очереди.
Добавление элемента в очередь выполняется за постоянное время O(1), так как элемент просто добавляется в конец очереди.
Увеличение размера очереди требует некоторых дополнительных операций.
Если внутренний массив, используемый для хранения элементов, заполняется, то требуется создать новый массив
большего размера и скопировать все элементы из старого массива в новый. Создание нового массива и копирование элементов требует линейного времени O(N), где N - текущий размер очереди.
Таким образом, в худшем случае, время выполнения метода enqueue составляет O(N), где N - текущий размер очереди.
Однако, если мы рассматриваем его амортизированную сложность, то добавление каждого элемента займет среднее время O(1), так как создание нового массива и копирование элементов происходит редко. Таким образом, амортизированная сложность метода enqueue будет O(1).
Метод dequeue():
Он удаляет и возвращает случайный элемент из очереди.
По аналогии с методом enqueue, рассмотрим два аспекта: удаление элемента и уменьшение размера очереди.
Удаление элемента из очереди выполняется за постоянное время O(1), так как элемент просто удаляется
из массива и индексы других элементов могут быть обновлены.
Уменьшение размера очереди происходит, когда количество элементов становится значительно меньше, чем размер внутреннего массива.
В таком случае, аналогично методу enqueue, создается новый массив меньшего размера и элементы копируются в него.
Таким образом, время выполнения метода dequeue в худшем случае составляет O(N),
где N - текущий размер очереди. Однако, амортизированная сложность этого метода также будет O(1),
так как уменьшение размера происходит редко.
Заметим, что в некоторых реализациях может быть выбрана более эффективная стратегия для удаления элементов,
например, путем перемещения последнего элемента на место удаленного элемента.
Это позволяет выполнять удаление за постоянное время O(1) без необходимости пере-копирования массива.
В таком случае, амортизированная сложность метода dequeue будет оставаться O(1).

// remove and return a random item
public Item dequeue()
// return a random item (but do not remove it)
public Item sample()
// return an independent iterator over items in random order
public Iterator iterator()

Метод iterator(): Он возвращает итератор, который обеспечивает перебор элементов в случайном порядке.
Создание итератора выполняется за постоянное время O(1). Все операции итератора (например, next() или hasNext()) выполняются за постоянное время O(1) для каждого элемента.
Общее время выполнения итерации по всем элементам будет линейным и зависит от размера очереди.


Метод sample(): Он возвращает случайный элемент из очереди без его удаления.
Аналогично методам enqueue и dequeue, время выполнения метода sample составляет O(1), так как элемент выбирается случайным образом из массива.

Для методов isEmpty(), size(), enqueue(), dequeue(), sample() и iterator(), асимптотический анализ показывает, что каждый из них выполняется за постоянное время O(1),
кроме случаев увеличения/уменьшения размера очереди при добавлении/удалении элементов,
где время выполнения может составлять O(N) в худшем случае. Однако, амортизированный анализ показывает,
что добавление, удаление и выборка случайного элемента выполняются за постоянное время O(1) в среднем случае.*/