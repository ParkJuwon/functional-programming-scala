
(x : Int, y : Int) => x == y

val lessThan = new Function2[Int, Int, Boolean] {
	def apply(a : Int, b : Int) = a < b
}

val a = lessThan.apply(10 , 20)

val b = lessThan(10 , 20)

def partial1[A, B, C](a : A, f : (A, B) => C) : B => C =
	(b : B) => f(a, b)
//	(b : B) => ???

def curry[A, B, C](f : (A, B) => C) : A => (B => C) =
	???


val f = (x : Double) => math.Pi / 2 - x
val cos = f andThen math.sin


