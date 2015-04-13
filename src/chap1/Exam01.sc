// 참조 투명성 : 값을 치환해도 결과가 변하지 않음

val x = "Hello, World"

val r1 = x.reverse

val r2 = x.reverse

val result1 = r1 == r2

val r3 = "Hello, World".reverse

val result2 = r1 == r3

// 참조에 투명하지 않은 함수

val y = new StringBuilder("Hello")

val z = y.append(", World")

val r4 = z.toString

val r5 = z.toString

val result3 = r4 == r5

val a = new StringBuilder("Hello")

val r6 = a.append(", World").toString

val r7ㅊㅗㅁㅔ1  = a.append(", World").toString