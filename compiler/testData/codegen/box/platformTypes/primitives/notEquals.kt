fun box(): String {
    val l = java.util.ArrayList<Int>()
    l.add(1)
    val x = l[0] != 1
    if (x != false) return "Fail: $x}"
    return "OK"
}