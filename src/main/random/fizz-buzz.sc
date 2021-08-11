def fizzBuzz(n: Int): List[String] = {
  (1 to n).map { num => if (num % 3 == 0 && num % 5 == 0) "FizzBuzz" else if (num % 3 == 0) "Fizz" else if (num % 5 == 0) "Buzz" else num.toString }.toList
}

fizzBuzz(30).zip(1 to 30)