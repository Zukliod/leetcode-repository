import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> arr = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), arr);
        return arr;
    }
    private void backtrack(int[] candidates, int r, int start, List<Integer> current, List<List<Integer>> arr) {
        if (r == 0) {
            arr.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > r) {
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            current.add(candidates[i]);
            backtrack(candidates, r - candidates[i], i + 1, current, arr);
            current.remove(current.size() - 1);
        }
    }
}