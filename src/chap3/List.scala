package chap3

/**
 * Created by john.p on 15. 4. 20..
 */
sealed trait List[+A]

// 형식 A에 대해 매개변수화된 List 자료 형식
case object Nil extends List[Nothing]

// 빈 목록을 나타내는 List 자료 생성자
case class Cons[+A](head: A, tail: List[A]) extends List[A]

// 비지 않은 목록을 나타내는 또다른 자료 생성자. tail은 또 다른 List[A]로, Nil일 수도 있고 다른 Cons일 수도 있다.

object List {
	// List companion 객체 목록의 생성과 조작을 위한 함수들을 담는다.
	def sum(ints: List[Int]): Int = ints match {
		case Nil => 0
		case Cons(x, xs) => x + sum(xs) // x로 시작하는 목록의 합은 x 더하기 목록 나머지 부분의 합이다.
	}

	def product(ds: List[Double]): Double = ds match {
		case Nil => 1.0
//		case Cons(0.0, _) => 0.0
		case Cons(x, xs) => x * product(xs)
	}

	def append[A](a1 : List[A], a2 : List[A]) : List[A] =
		a1 match {
				case Nil => a2
				case Cons(h, t) => Cons(h, append(t, a2))
		}

	def dropWhile[A](as : List[A])(f : A => Boolean) : List[A] =
	as match {
		case Cons(h, t) if f(h) => dropWhile(t)(f) //
		case _ => as
	}

	//이번에도 f의 인수 형식들을 스칼라가 추론할 수 있도록 f를 as, z 다음의 개별적인 인수 그룹에 넣었다.
	def foldRight[A, B](as : List[A], z : B)(f : (A, B) => B) : B =
	as match {
		case Nil => z
		case Cons(x, xs) => f(x, foldRight(xs, z)(f))
	}

	def sum2(ns : List[Int]) =
	foldRight(ns, 0)((x, y) => x + y)

	def produnct2(ns : List[Double]) =
	foldRight(ns, 1.0)(_ * _) // _ * _은 (x, y) => x * y를 좀 더 간결하게 표기한 것이다

	def apply[A](as : A*) : List[A] = //가변 인수 함수 구문
	if(as.isEmpty) Nil
	else Cons(as.head, apply(as.tail:_*))
}
