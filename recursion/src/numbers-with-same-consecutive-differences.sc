//https://leetcode.com/problems/numbers-with-same-consecutive-differences/
//Runtime: 524 ms, faster than 100.00% of Scala online submissions for Numbers With Same Consecutive Differences.
//Memory Usage: 51.8 MB, less than 100.00% of Scala online submissions for Numbers With Same Consecutive Differences.
def generateNext(currentInt:Int, remaining:Int, diff: Int):List[Int]={
  if(remaining == 0)List(currentInt)
  else{
    val lastDigit = currentInt%10
    val nextDigit = List(lastDigit+diff, lastDigit-diff).filter(digit => digit >=0 && digit<=9)

    nextDigit.flatMap{d => val newNum = (currentInt.toString+d.toString).toInt
      generateNext(newNum, remaining-1, diff)}
  }
}

def numsSameConsecDiff(n: Int, k: Int): Array[Int] = {
  (1 to 9).flatMap(num => generateNext(num,n-1,k)).distinct.toArray
}

numsSameConsecDiff(3,7)