// "Create function 'invoke' from usage" "true"

class A<T>(val n: T) {
    fun invoke(arg: T, s: String): B<String> {
        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class B<T>(val m: T)

fun test(): B<String> {
    return A(1)(2, "2")
}