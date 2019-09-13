package com.eumji.scala.learning

import kotlin.jvm.JvmOverloads

import scala.None
import scala.runtime.Nothing$

//scala比较偏向于java的语言，没有办法定义顶级函数和顶级变量
//
//
class Basic {
  //加入private修饰符，get和set方法也有private修饰符
  //protected只有子类能访问，同一个包里的是无法直接访问的
  // Error:(20, 19) variable name in class Basic cannot be accessed in com.eumji.scala.learning.Basic
  // Access to protected variable name not permitted because
  // enclosing class Basic3 in package learning is not a subclass of
  // class Basic in package learning where target is defined
  //    println(basic.name)
  private var startIndex: Int = 0

  //成员变量必须给默认值，否则使用_表示
  protected var name: String = _
  //生成的方法为public 变量本身为private
  var address: String = "shenzhen"

  val address2: String = "shenzhen.."
  //重写get和set方法有点不同，其实也不属于覆盖，而是新建一个
  var demo: String = _

  def demo2_(demo_ : String): Unit = {
    demo = demo_
  }

  def demo2: String = demo + "aaaa"
}

class Basic3 {

  def hello(): Unit = {
    println(Basic.staticName)
    println(Basic.staticHello())
  }


  //scala也不支持三目运算符
  def max(a: Int, b: Int): Int = if (a > b) a else b

  //方法支持默认值。但是没有类似jvmOverLoad,那么java如何调用呢？、、、、、
  def max2(a: Int, b: Int = 1, c: Int = 2) {
    print(a + b + c)

  }


  //变长参数
  def changeVar(vararg: String) {

  }


  /**
   * 数组for循环
   * scala没用[]表示数组
   *
   * scala数组获取值同股哟的是apply方法
   *
   */
  def foreach(array: Array[Int]) {

    //foreach
    for (i <- array) {
      print(s"$i ")
    }

    //with index
    for (i <- array.indices) {
      println(s"${array.apply(i)} or ${array(i)}")
    }

    println()
    //step 必须要通过下标
    for (i <- 2 until array.length - 1) {
      println(s"${array.apply(i)} or ${array(i)}")
    }

  }


  //参考 https://www.jianshu.com/p/a119230c11b5
  def matchCase(name: String): Unit = {
    name match {
      case "zhangsan" => println("....zhangsan")
      case "lisi" => println("lisi....")
      case _ => println("default ...")
    }
  }


  //自带lambda
  def listOperator(list: List[String]): Unit = {
    val maybeString = list.filter(a => a.startsWith("bb")).map[Int](v => v.substring(2).toInt).collectFirst[String](PartialFunction.fromFunction(a => a + "....."))

    maybeString match {
      case Some(value) => println(s"is string : ${value}")
      case None => println("can not find values")
    }

  }
}


//主构造函数和次构造函数
class Constructor(var name: String, var age: Int) {
  var address: String = _


  def this(address: String, name: String, age: Int) {
    this(name, age)
    this.address = address
  }

  //返回值不一定要写return
  override def toString(): String = {
    "Constructor(name='$name', age=$age, address='$address')"
  }
}


//object和上面class同名的叫做伴生对象，伴生对象能实现类似于java里的静态方法和静态变量的功能
object Basic {
  var staticName: String = "static"
  var staticName2: String = _

  def staticHello(): Unit = {
    println("静态hello 方法")
  }

  def main(args: Array[String]): Unit = {
    //val basic = new Basic()
    //println(s"${basic.address}")
    val basic = new Basic3()
    //basic.foreach(Array[Int](8,7,6,5,4,3,2,1))
    //basic.matchCase("zhangs")
    val value = List("aaaa", "bb123")
    basic.listOperator(value)
  }
}
