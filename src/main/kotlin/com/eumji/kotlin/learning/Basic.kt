package com.eumji.kotlin.learning


//kotlin 自动生成get和set方法
//对于变量的访问最终会转换成get和set方法的调用（可以反编译字节码）
var a: String = "zhangsan"

// ？ 表示此字符可以为空
var b: String? = null

//val等同于java常量final，可以不声明类型 var和val进行类型推断
val c = "常量"

//重写get和set方法 且方法要跟着变量 且字段为filed
var ova: String = "zzzz"
    get() = field + "ova"
    set(value) {
        field = value + "ova"
    }

val g = """|  //
            .| //
            .|/ \
        """.trimMargin(".")

//保留原有样式
var h = """1
    n
    c
    d
    
"""

/**
关键字 fun 用来声明一个函数。
参数的类型写在它的名称后面。
函数可以定义在文件的最外层，不需要把它放在类中。
数组就是类。
使用 println 代替了 System.out.println。
和许多其他现代语言一样，可以省略每行代码结尾的分号。
 */
fun hello(name: String) {
    println("hello $name")
}

//这里是一个lambda表达式的函数，而且kotlin是没有三目运算符的
fun max(a: Int, b: Int): Int = if (a > b) a else b


//方法参数可以指定默认值
//如果java调用这个方法，那么每个都要赋值
//JvmOverloads表示重载，此时会被重载为
//public static final void max2(int a)
//public static final void max2(int a, int b)
//public static final void max2(int a, int b, int c)
@JvmOverloads
fun max2(a: Int, b: Int = 1,c:Int = 2){
    print(a+b+c)

}

//变长参数
fun changeVar(vararg : String) {

}


class StaticVar {
    //静态变量和方法需要放在companion object中
    companion object {
        var d = "lisi"
        //lateinit表示延迟加载
        lateinit var e: String
    }
}

/**
 * kotlin 可以存在两种构造函数，也就是主构造函数 可以放在类的声明上，且使用var
 * 修饰的变量等同于这个类的成员变量
 *
 * 次构造函数都是由constructor开头的函数，且存在朱构造函数的情况下一定要调用主构造函数
 *
 * 延迟加载的变量一定要加lateinit或者赋值null
 */
class Constructor(var name: String, var age: Int) {
    lateinit var address: String

    constructor(address: String, name: String, age: Int) : this(name, age) {
        this.address = address
    }

    override fun toString(): String {
        return "Constructor(name='$name', age=$age, address='$address')"
    }
}


/**
 * 数组for循环
 * kotlin并没有[]表示数组
 *
 */
fun foreach(array: Array<Int>) {

    //foreach
    for (i in array) {
        print("$i ")
    }

    //with inex
    for ((i,e) in array.withIndex()){
        println("index is $i , value is :$e")
    }

    //range get is index
    for (i in 0..array.lastIndex){
        println("${array[i]} or ${array.get(i)} ")
    }

    println()
    //step 必须要通过下标
    for (i in 0..array.lastIndex step 2){
        println("${array[i]} or ${array.get(i)} ")
    }

}


fun whenCase(name: String): Unit {
    when {
        name.equals("zhangsan") -> {
            //do some thind
        }

        name in setOf<String>("z","b") ->{
            //do other
        }
        else ->{
            //否则
        }
    }
}

//自带lambda
fun listOperator(list: List<String>): Unit {
    val predicate: (Int) -> Boolean = { value -> value > 5 }
    val first = list.filter { value -> value.startsWith("dd") }.map { value -> value.toInt() }.first(predicate)
    println(first)

}

interface HelloA {
}

interface HelloB:HelloA{

}

//抽象类默认都是open的
abstract class HelloC(val a:String) {

}
//对于继承来说，如果没有次级构造函数，则需要在类的定义上调用父类的构造函数
//如果有次级构造函数则可以放在次级构造函数里调用

//如果允许创建一个类的子类，需要使用 open 修饰符来标示这个类
//每一个可以被重写的属性或方法添加 open 修饰符
//默认没有修饰符的都为final
open class HelloD : HelloC {
    constructor(a :String):super(a){

    }
}

/**
 * 修饰符	相关成员	评注
final	不能被重写	类中成员默认使用
open	可以被重写	需要明确地使用
abstract	必须被重写	只能在抽象类中使用：抽象成员不能有实现
override	重写父类或接口中的成员	如果没有使用final 表明，重写的成员默认是开放的
 */
//继承需要调用父类的构造方法，实现接口不用
//且和java一样单继承多实现
class HelloF : HelloD("111"), HelloA,HelloB{

}

fun main() {
    //hello(a)
    // Kotlin: Type mismatch: inferred type is String? but String was expected
    //hello(b)
    //hello(c)
    // Kotlin: Val cannot be reassigned
    //c = "常量2"

    //重写get和set方法
    //println(ova)
    //ova = "mydemo"
    //println(ova)


    //如果不复制elateinit property e has not been initialized
    //println(StaticVar.e)

    //StaticVar.e = "mazi"
    //println(StaticVar.e)


    //构造函数部分
    //var constructor = Constructor("shenzhen","zhangsan",18)
    //println(constructor)


    //foreach(arrayOf(9,8,7,6,5,4,3,1))

    //保留格式
    //println(g)
}
