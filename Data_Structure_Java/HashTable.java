import java.util.Arrays;

public class HashTable {
   class Entry {
      private String key;
      private int value;
      private Entry next;

      public Entry(String key, int value) {
         this.key = key;
         this.value = value;
         this.next = null;
      }

      public Entry() {
         this.next = null;
      }

      public String getKey() {
         return key;
      }

      public int getValue() {
         return value;
      }
   }

   private Entry[] initHashTable(int size) {
      Entry[] table = new Entry[size];
      for (int i = 0; i < size; i++) {
         table[i] = new Entry();
      }
      return table;
   }

   private int hashStringToInt(String str) {
      int hash = 17;
      for (int i = 0; i < str.length(); i++) {
         hash = (13 * hash * str.codePointAt(i)) % this.table.length;
      }
      return hash;
   }

   private static int getNextPrimeNumber(int num) {
      num++;
      for (int i = 2; i < num; i++) {
         if (num % i == 0) {
            num++;
            i = 2;
         } else {
            continue;
         }
      }
      return num;
   }

   private void expandSize() {
      int newSize = getNextPrimeNumber(this.table.length * 2);
      this.table = Arrays.copyOf(this.table, newSize);
   }

   private void shrinkSize() {
      int newSize = getNextPrimeNumber((this.table.length - 1) / 2);
      this.table = Arrays.copyOf(this.table, newSize);
   }

   private Entry[] table = initHashTable(3);
   private int entryCount = 0;

   public void add(String key, int value) {
      int loadFactor = entryCount / this.table.length;
      if (loadFactor >= 0.75) {
         expandSize();
      } else if (loadFactor <= 0.45) {
         shrinkSize();
      }
      int index = hashStringToInt(key);
      Entry tableValue = table[index];
      Entry newEntry = new Entry(key, value);
      newEntry.next = tableValue.next;
      tableValue.next = newEntry;
   }

   public Entry getValue(String key) {
      Entry foundItem = null;
      int index = hashStringToInt(key);
      Entry tableValue = table[index];
      while (tableValue != null) {
         if (tableValue.getKey() == key) {
            foundItem = new Entry(key, tableValue.getValue());
            break;
         }
      }
      return foundItem;
   }
}