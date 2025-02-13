class MyHashMap {

    private class Entry {
        int key;
        int value;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry[] array;
    private int currSize;
    private int hashSize;

    public MyHashMap() {
        this.hashSize = 2;
        this.array = new Entry[2];
        this.currSize = 0;
    }
    
    public void put(int key, int value) {
        int index = getHashIndex(key);

        while(this.array[index] != null && this.array[index].key != key) {
            index = getHashIndex(index+1);
        }

        if(this.array[index] == null) {
            this.currSize++;
        }

        this.array[index] = new Entry(key, value);

        if(this.currSize > this.hashSize/2){
            rehash();
        }
    }

    private int getHashIndex(int key) {
        return key%this.hashSize;
    }

    private void rehash() {
        Entry[] oldArray = array;
        this.hashSize = getNextPrimeNumber(this.hashSize * 2);
        this.array = new Entry[this.hashSize];
        this.currSize = 0;

        for(Entry entry : oldArray) {
            if(entry != null) {
                put(entry.key, entry.value);
            }
        }

    }

    private int getNextPrimeNumber(int num) {
        while(true) {
            if(isPrime(num)){
                return num;
            }
            num++;
        }
    }

    private boolean isPrime(int num) {
        for(int i=2; i*i <= num; i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }
    
    public int get(int key) {
        int index = getHashIndex(key);
        
        while(this.array[index] != null) {
            if(this.array[index].key == key) {
                return this.array[index].value;
            }

            index = getHashIndex(index+1);
        }

        return -1;
    }
    
    public void remove(int key) {
        int index = getHashIndex(key);

        while(this.array[index] != null){
            if(this.array[index].key == key) {
                this.currSize--;
                array[index] = null;
                rehashAfterRemoval();
                return;
            }

            index = getHashIndex(index+1);
        }
    }

    private void rehashAfterRemoval(){
        Entry[] oldArray = this.array;
        this.array = new Entry[this.hashSize];
        this.currSize = 0;

        for(Entry entry : oldArray) {
            if(entry != null) {
                put(entry.key, entry.value);
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */