
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        // length -> list of indices
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // Group indices by string length
        for (int i = 0; i < strs.length; i++) {
            int len = strs[i].length();

            if (!map.containsKey(len)) {
                map.put(len, new ArrayList<>());
            }

            map.get(len).add(i);
        }

        // Process each length group
        for (List<Integer> indices : map.values()) {

            boolean[] visited = new boolean[indices.size()];

            for (int i = 0; i < indices.size(); i++) {

                if (visited[i]) continue;

                List<String> group = new ArrayList<>();
                group.add(strs[indices.get(i)]);
                visited[i] = true;

                for (int j = i + 1; j < indices.size(); j++) {

                    if (!visited[j] &&
                        checkAnagram(strs[indices.get(i)], strs[indices.get(j)])) {

                        group.add(strs[indices.get(j)]);
                        visited[j] = true;
                    }
                }

                result.add(group);
            }
        }

        return result;
    }

    public boolean checkAnagram(String s, String t) {

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }
}