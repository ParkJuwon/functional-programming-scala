package chap3

/**
 * Created by john.p on 15. 4. 20..
 */
object Test extends App{
	import chap3.List

	// 자료 생성자에 용례 몇가지
	val ex1 : List[Double] = Nil
	val ex2 : List[Int] = Cons(1, Nil)
	val ex3 : List[String] = Cons("a", Cons("b", Nil))
}
