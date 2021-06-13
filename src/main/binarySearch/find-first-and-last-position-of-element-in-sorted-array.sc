//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
//Runtime: 848 ms, faster than 11.29% of Scala online submissions for Find First and Last Position of Element in Sorted Array.
//Memory Usage: 71.1 MB, less than 6.45% of Scala online submissions for Find First and Last Position of Element in Sorted Array.
@scala.annotation.tailrec
def searchRangeHelper(nums:Array[Int], target:Int, left:Int, right:Int, index: String)(fn : Int => Int) :Int={
  if(left < right){
    val mid = left+(right-left)/2
    if(nums(mid) > target) searchRangeHelper(nums, target, left, mid, index)(fn)
    else if(nums(mid) < target) searchRangeHelper(nums, target, mid+1, right, index)(fn)
    else{
      if(index == "LEFT")
        if(mid > 0 && nums(mid-1) != nums(mid))  mid
        else  searchRangeHelper(nums, target, left, fn(mid), index)(fn)
      else {
        if(mid < nums.length && nums(mid) != nums(mid+1)) mid
        else searchRangeHelper(nums, target, fn(mid), right, index)(fn)
      }
    }
  } else {
    if(nums (left) == target) left else -1
  }
}
def searchRange(nums: Array[Int], target: Int): Array[Int] = {
  if(nums.isEmpty)Array(-1,-1)
  else {
    val left = searchRangeHelper(nums, target, 0, nums.length - 1, "LEFT")(x => x - 1)
    val right = searchRangeHelper(nums, target, 0, nums.length - 1, "RIGHT")(x => x + 1)
    Array(left, right)
  }
}