package chap3

/**
 * Created by john.p on 15. 4. 20..
 */
object Test extends App{
	import chap3.List._

	// 자료 생성자에 용례 몇가지
	val ex1 : List[Double] = Nil
	val ex2 : List[Int] = Cons(1, Nil)
	val ex3 : List[String] = Cons("a", Cons("b", Nil))

	val x = List(1,2,3,4,5) match {
		case Cons(x, Cons(2, Cons(4, _))) => x
			case Nil => 42
			case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
			case Cons(h, t) => h + sum(t)
			case _ => 101
	}
	println(x)

	//고차 함수를 위한 형식 추론 개선
	val xs : List[Int] = List(1, 2, 3, 4, 5)
	val ex4 = dropWhile(xs)(x => x < 4)
	println(ex4)

	println(foldRight(List(1, 2, 3), Nil : List[Int])(Cons(_, _)))

	def length[A](as : List[A]) : Int = {
		foldRight(as, 0)((_, acc) => acc + 1)
	}

	println(length(List(1,2,3)))
}
