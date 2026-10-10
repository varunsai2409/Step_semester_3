class AssignmentProblem5{
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1; // minimum is in right half
            } else {
                right = mid; // minimum is in left half (including mid)
            }
        }

        return nums[left];
    }
}
