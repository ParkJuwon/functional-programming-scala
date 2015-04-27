val list = List(1,2,3,4,5,6)

def add(res: Int, x: Int) = {
  println(s"op: $res + $x = ${res + x}")
  res + x
}

println(list.take(2))
println(list.takeWhile(_ < 10))
println(list.takeWhile(_ > 3))
println(list.takeWhile(x => x < 5))
println(list.forall(_ > 3))
println(list.forall(_ < 3))
println(list.forall(_ > 0))
println(list.forall(_ < 10))
println(list.exists(_ == 2))
println(list.exists(_ < 2))
println(list.scanLeft(9)(add))

