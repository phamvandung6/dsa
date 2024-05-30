package thuchanh.tuan8.bai4.bai3;
// TinyURL is a URL shortening service where you enter a URL such as 

import java.util.HashMap;
import java.util.UUID;

//https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk. Design a class to encode a URL and decode a tiny URL.

// There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.

// Implement the Solution class:

// Solution() Initializes the object of the system.
// String encode(String longUrl) Returns a tiny URL for the given longUrl.
// String decode(String shortUrl) Returns the original long URL for the given shortUrl. It is guaranteed that the given shortUrl was encoded by the same object.

// Example 1:

// Input: url = "https://leetcode.com/problems/design-tinyurl"
// Output: "https://leetcode.com/problems/design-tinyurl"

// Explanation:
// Solution obj = new Solution();
// string tiny = obj.encode(url); // returns the encoded tiny url.
// string ans = obj.decode(tiny); // returns the original url after decoding it.
public class Solution {
    HashMap<String, String> map = new HashMap<>();

    public String encode(String longUrl) {
        String uniqueId = getUniqueId();
        map.put(uniqueId, longUrl);
        return "http://tinyurl.com/" + uniqueId;
    }

    public String decode(String shortUrl) {
        int index = shortUrl.indexOf(".com/");

        // last 6 character as unique id
        String uniqueId = shortUrl.substring(index + 5);
        return map.get(uniqueId);
    }

    private String getUniqueId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().substring(6);
    }
}
