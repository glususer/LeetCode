

//https://leetcode.com/problems/coin-change-2/
// not exactly same but somewhat on similar lines - https://www.youtube.com/watch?v=Y0ZqKpToTic
//Runtime: 660 ms, faster than 23.08% of Scala online submissions for Coin Change 2.
//Memory Usage: 55.3 MB, less than 38.46% of Scala online submissions for Coin Change 2.
def change(amount: Int, coins: Array[Int]): Int = {
  if (amount == 0) 1
  else if(coins.isEmpty) 0
  else {
    val col = amount
    val row = coins.length - 1
    val arr = Array.fill(coins.length, amount + 1)(0)

    for (i <- 0 to row) arr(i)(0) = 0
    for (j <- 1 to col) arr(0)(j) = if (j % coins(0) == 0) 1 else 0

    for (i <- 1 to row; j <- 1 to col) {
      // go back to coins(i) in the 2d arr and add that value to current sum.
      // If that value is 0, add 1
      val prev = {
        if (j - coins(i) > 0) arr(i)(j - coins(i))
        else if (j - coins(i) == 0) 1
        else 0
      }
      arr(i)(j) = arr(i - 1)(j) + prev
    }
    arr(row)(amount)
  }
}

change(10,Array(2,3,5))