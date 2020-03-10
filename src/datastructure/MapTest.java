package datastructure;

public class MapTest {

    public static void main(String[] args){
        Map<String,Integer> map = new HashMap<>();
        map.put("张三",10);


        System.out.println(map.get("张三"));
        System.out.println(map.get("李四"));

    }
}

interface Map<K,V>{
    V put(K k, V v);
    public V get(K k);
    public int size();


    interface Entry<K,V> {
        public K getKey();
        public V getValue();
    }
}

class HashMap<K,V> implements Map<K,V>{

    private Entry<K,V>[] table = null;
    private int size  = 0;
    private static int defaultLength = 16;

    public HashMap(){
        table = new Entry[this.defaultLength];
    }

    @Override
    public V put(K k, V v) {

        int index = hash(k) ;

        Entry<K,V>  entry = table[index];

        if (entry == null){

            table[index] = new Entry(k,v, index, null);

            size ++;
        }else{
            table[index] = new Entry(k,v, index, entry);//insert first
            size ++;
        }

        return table[index].getValue();
    }

    private int hash(K k) {
        int i = k.hashCode()&(defaultLength-1);
        return Math.abs(i);
    }

    @Override
    public V get(K k) {
        if(size == 0){
            return null;
        }

        int index = hash(k);

        for(Entry<K,V> e = table[index]; e!=null;e=e.next){
            if (e.hash == index && (k==e.getKey() || k.equals(e.getKey()))){

                return e.getValue();
            }
        }

        return null;
    }


    @Override
    public int size() {
        return this.size;
    }

    class Entry<K,V> implements Map.Entry<K,V>{
        K k;
        V v;
        int hash;
        Entry<K,V> next;

        public Entry(K k, V v, int index, Entry<K,V> next){
            this.k = k;
            this.v = v;
            this.hash = index;
            this.next = next;
        }
        @Override
        public K getKey() {
            return this.k;
        }

        @Override
        public V getValue() {
            return this.v;
        }
    }
}
