public class Codec {

    HashMap<String, String> cache;
    int key;

    public Codec() {
        this.cache = new HashMap<>();
        this.key = 0;
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String encodedKey = this.key + "";
        
        this.cache.put(encodedKey, longUrl);
        this.key++;

        return encodedKey;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return this.cache.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));