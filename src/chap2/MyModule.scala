package chap2

/**
 * Created by john.p on 15. 4. 14..
 */
object MyModule {
	def abs(n : Int) : Int =
		if (n < 0) -n
		else n

	private def formatAbs(x : Int) = {
		val msg = "The absolute value of %d is %d"
		msg.format(x, abs(x))
	}

	/**
	 * 꼬리 재귀 예제
	 * @param n
	 * @return
	 */
	def factorial(n : Int) : Int = {
		@annotation.tailrec
		def go(n : Int, acc : Int) : Int =
			if(n <= 0) acc
			else go(n-1, n*acc)

		go(n, 1)
	}

	private def formatFactorial(n : Int) = {
		val msg = "The factorial of %d is %d."
		msg.format(n, factorial(n))
	}

	/**
	 * 공통적인 함수들을 일반화
	 * @param name
	 * @param n
	 * @param f
	 */
	def formatResult(name : String, n : Int, f : Int => Int )= {
		val msg = "The %s of %d is %d."
		msg.format(name, n, f(n))
	}



	def findFirst(ss : Array[String], key : String) : Int = {
		def loop(n : Int) : Int =
		if(n >= ss.length) -1 // 못찾을 경우
		else if (ss(n) == key) n
		else loop(n + 1)

		loop(0) // 루프의 첫 요소에서 시작
	}

	// 함수의 일반화 : 다형적 함수
	def findFirst[A](as : Array[A], p : A => Boolean) : Int = { // String을 코드에 박아 넣는 대신, 형식 A를 하나의 인수로 받는다 그리고 키와의 상등 판정을 함수를 받는다
	@annotation.tailrec
	def loop(n : Int) : Int =
		if(n >= as.length) -1 // 못찾을 경우
		else if (p(as(n))) n
		else loop(n + 1)

		loop(0) // 루프의 첫 요소에서 시작
	}

	def main(args : Array[String]): Unit = {
		println(formatAbs(-42))
		println(formatResult("absolute value", -42, abs))

		println(formatFactorial(7))
		println(formatResult("factorial", 7, factorial))

		findFirst(Array(7, 9, 13), (x : Int) => x == 9)


	}
}
