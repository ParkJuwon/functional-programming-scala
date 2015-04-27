package chap3

/**
 * Created by Real on 2015-04-27.
 */
trait Tree[+A]
case class Leaf[A](value : A) extends Tree[A]
case class Branch[A](left : Tree[A], right : Tree[A]) extends Tree[A]
